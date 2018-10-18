package com.java;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.java.dto.Passport;
import com.java.dto.Student;

public class Main {

	static SessionFactory sf;
	static {
		Configuration cfg = new Configuration().addPackage("com.java.dto");
		cfg.configure("hibernate.cfg.xml");
		sf = cfg.buildSessionFactory();
	}

	public static void main(String args[]) {
		Main obj = new Main();
		obj.insertRecords();
		obj.fetchData();
		sf.close();
		
	}

	public void insertRecords() {
		Passport p = new Passport("166shd");
		p.setBaseLocation("ghaziabad");
		Student st = new Student(1, "payal", null);
		//p.setStudent(st);
		Session s = sf.openSession();
		s.beginTransaction();
		s.save(p);
		st.setPassport(p);
		s.save(st);
		s.getTransaction().commit();
		s.close();
	}

	public void fetchData() {
		Session s=sf.openSession();
		Passport p=s.get(Passport.class, "166shd");
		p.getStudent();
		//From passport i cannot get the student info but from student i can get the passport info: unidirectional mapping
		Student st= s.get(Student.class, 1);
		System.out.println(st.getPassport());
		s.close();
	}
}
