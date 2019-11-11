package com.sandesh.service;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Service;

import com.sandesh.model.Student;
import com.sandesh.model.StudentCS;
import com.sandesh.utility.HibernateUtil;

@Service
public class StudentService {

	public void addStudent(Student student) {
		Session session = HibernateUtil.sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.save(student);
		session.getTransaction().commit();
	}
	
	public Student getStudent(Integer rollNo) {
		Session session = HibernateUtil.sessionFactory.getCurrentSession();
		session.beginTransaction();
		Student student = session.get(Student.class, rollNo);
		session.getTransaction().commit();
		return student;
	}
	
	public List<Student> getAllStudent() {
		Session session = HibernateUtil.sessionFactory.getCurrentSession();
		session.beginTransaction();
		List<Student> students = session.createQuery("From Student", Student.class).list();
		session.getTransaction().commit();
		return students;
	}
	
	public void updateStudent(Student student) {
		Session session = HibernateUtil.sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.saveOrUpdate(student);
		session.getTransaction().commit();
	}
	
	public List<Student> getStudentByGender(String gender) {
		Session session = HibernateUtil.sessionFactory.getCurrentSession();
		session.beginTransaction();
		List<Student> students = session.createQuery(String.format("From Student Where gender='%s'", gender), Student.class).list();
		session.getTransaction().commit();
		return students;
	}
	
	public void addStudentCS(StudentCS studentCS) {
		Session session = HibernateUtil.sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.save(studentCS);
		session.getTransaction().commit();
	}
}
