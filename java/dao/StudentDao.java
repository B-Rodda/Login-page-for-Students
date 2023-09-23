package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import dto.Student;

public class StudentDao {
	EntityManagerFactory f = Persistence.createEntityManagerFactory("dev");
	EntityManager m = f.createEntityManager();
	EntityTransaction t = m.getTransaction();

	public void addStudent(Student s) {
		t.begin();
		m.persist(s);
		t.commit();
	}

	public Student fetchAccount(String email, String password) {
		Query s = m.createQuery("select a from Student a");
		List <Student>   student = s.getResultList();
		for(Student q:student)
		{
			if(q.getEmail().equals(email))
			{
				return q;
			}
		}
		return null;
	}
	
	public List<Student> fetchAll() {
		
	 	Query q=m.createQuery("Select d from student d");
	 	List<Student> w=q.getResultList();
	 	return w;
	}
}
