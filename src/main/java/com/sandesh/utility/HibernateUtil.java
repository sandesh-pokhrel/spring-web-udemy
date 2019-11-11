package com.sandesh.utility;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sandesh.model.Student;
import com.sandesh.model.StudentCS;

@SuppressWarnings("unused")
public class HibernateUtil {
	
	public static SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Student.class)
			.addAnnotatedClass(StudentCS.class).buildSessionFactory();
}