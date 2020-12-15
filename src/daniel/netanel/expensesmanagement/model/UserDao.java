package daniel.netanel.expensesmanagement.model;

import org.hibernate.Session;
import org.hibernate.Transaction;

import daniel.netanel.expensesmanagement.model.User;
import daniel.netanel.expensesmanagement.hibernate.HibernateUtil;

/**
 * Database operations
 *
 */
public class UserDao {

	/**
	 * Save User
	 * 
	 * @param user
	 */
	public static boolean saveUser(User user) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an user object
			User userTemp = (User) session.createQuery("FROM User U WHERE U.username = :userName")
					.setParameter("userName", user.getUsername()).uniqueResult();

			if (userTemp == null) {
				// save the user object
				session.save(user);
				// commit transaction
				transaction.commit();
				return true;
			}

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * Validate User
	 * 
	 * @param userName
	 * @param password
	 * @return
	 */
	public static boolean validate(String userName, String password) {

		Transaction transaction = null;
		User user = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an user object
			user = (User) session.createQuery("FROM User U WHERE U.username = :userName")
					.setParameter("userName", userName).uniqueResult();

			if (user != null && user.getPassword().equals(password)) {
				return true;
			}
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return false;
	}

}
