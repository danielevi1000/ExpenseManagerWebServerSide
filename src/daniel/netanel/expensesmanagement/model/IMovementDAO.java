package daniel.netanel.expensesmanagement.model;

import java.util.List;

import daniel.netanel.expensesmanagement.MovementPlatformException;

/**
 * This is the IMovementDAO interface
 *
 */
public interface IMovementDAO {
	public void addMovement(Movement movement) throws MovementPlatformException;

	public void deleteMovement(int id) throws MovementPlatformException;

	public Movement getMovement(int id) throws MovementPlatformException;

	public void updateMovement(Movement movement) throws MovementPlatformException;

	public List<Movement> getAllMovements() throws MovementPlatformException;

	public List<Movement> movementsByMonth(String month) throws MovementPlatformException;
}
