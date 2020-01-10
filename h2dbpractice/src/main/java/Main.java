import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import h2dbpractice.model.Student;
import h2dbpractice.util.HibernateUtil;

public class Main {

	public static void main(String[] args) {
		 Student student = new Student("Ramesh", "Fadatare", "rameshfadatare@javaguides.com");
	        Student student1 = new Student("John", "Cena", "john@javaguides.com");
	        Transaction transaction = null;
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            // start a transaction
	            transaction = session.beginTransaction();
	            // save the student objects
	            session.save(student);
	            session.save(student1);
	            // commit transaction
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }

	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            List < Student > students = session.createQuery("from studenth2", Student.class).list();
	            students.forEach(s -> System.out.println(s.getFirstName()));
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
	    }
	}


