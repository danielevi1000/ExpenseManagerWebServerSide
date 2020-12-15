package daniel.netanel.expensesmanagement.model;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

import daniel.netanel.expensesmanagement.MovementPlatformException;
import daniel.netanel.expensesmanagement.hibernate.HibernateUtil;

/**
 * Database operations
 *
 */
public class MovementDAO implements IMovementDAO {

	/**
	 * Save Movement
	 * 
	 * @param movement
	 */
	@Override
	public void addMovement(Movement movement) throws MovementPlatformException {

		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the movement object
			session.save(movement);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	/**
	 * Delete Movement
	 * 
	 * @param id
	 */
	@Override
	public void deleteMovement(int id) throws MovementPlatformException {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// Delete an movement object
			Movement movement = (Movement) session.get(Movement.class, id);
			if (movement != null) {
				session.delete(movement);
				// commit transaction
				transaction.commit();
			}

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	/**
	 * Get Movement By ID
	 * 
	 * @param id
	 * @return
	 */
	@Override
	public Movement getMovement(int id) throws MovementPlatformException {
		Transaction transaction = null;
		Movement movement = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an movement object
			movement = (Movement) session.get(Movement.class, id);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return movement;
	}

	/**
	 * Update Movement
	 * 
	 * @param movement
	 */
	@Override
	public void updateMovement(Movement movement) throws MovementPlatformException {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the movement object
			session.update(movement);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	/**
	 * Get all Expenses
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Movement> getAllMovements() throws MovementPlatformException {
		Transaction transaction = null;
		List<Movement> expensesList = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an movement object
			expensesList = session.createQuery("from Movement").list();
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return expensesList;
	}

	/**
	 * Get all movements by month
	 * 
	 * @param month
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Movement> movementsByMonth(String month) throws MovementPlatformException {
		Transaction transaction = null;
		List<Movement> movementsList = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an movement object
			String hql = "from Movement where month=" + "'" + month + "'";
			movementsList = session.createQuery(hql).list();
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return movementsList;
	}
}
