package com.javacourse.hibernateIntro;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

	public static void main(String[] args) {
		
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			//select * from student;	
			List<Student> students = session.createQuery("from Student").getResultList();
			for(Student student:students) {
				System.out.println(student.getName());
			}		
			
			//insert
		/*	Student student = new Student(0, "Serafet", "Sahin", "Ceng");
			session.save(student); */
			
			
			//update
		/*	Student student = session.get(Student.class, 2);
			student.setFaculty("medicine");
			session.save(student); */
			
			//delete
		/*	Student student = session.get(Student.class, 3);
			session.delete(student); */
			
			
	
			session.getTransaction().commit();
			
		}finally {
			factory.close();
		}
		
	}

}
