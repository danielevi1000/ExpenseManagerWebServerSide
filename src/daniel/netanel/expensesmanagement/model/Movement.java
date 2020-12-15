package daniel.netanel.expensesmanagement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This is a model class that represents an Movement entity
 *
 */

@Entity
@Table(name = "movements")
public class Movement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	protected int id;

	@Column(name = "type")
	protected String type;

	@Column(name = "category")
	protected String category;

	@Column(name = "details")
	protected String details;

	@Column(name = "amount")
	protected double amount;

	@Column(name = "month")
	protected String month;

	public Movement() {
	}

	/**
	 * Movement Constructor
	 * 
	 * @param type
	 * @param category
	 * @param details
	 * @param amount
	 * @param month
	 */
	public Movement(String type, String category, String details, double amount, String month) {
		super();
		this.setType(type);
		this.setCategory(category);
		this.setDetails(details);
		this.setAmount(amount);
		this.setMonth(month);
	}

	/**
	 * Movement Constructor
	 * 
	 * @param id
	 * @param type
	 * @param category
	 * @param details
	 * @param amount
	 * @param month
	 */
	public Movement(int id, String type, String category, String details, double amount, String month) {
		super();
		this.setId(id);
		this.setType(type);
		this.setCategory(category);
		this.setDetails(details);
		this.setAmount(amount);
		this.setMonth(month);
	}

	/**
	 * ID Getter
	 */
	public int getId() {
		return id;
	}

	/**
	 * ID Setter
	 * 
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Type Getter
	 * 
	 * @return
	 */
	public String getType() {
		return type;
	}

	/**
	 * Type Setter
	 * 
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Category Getter
	 * 
	 * @return
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * Category Setter
	 * 
	 * @param category
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * Details Getter
	 * 
	 * @return
	 */
	public String getDetails() {
		return details;
	}

	/**
	 * Details Setter
	 * 
	 * @param details
	 */
	public void setDetails(String details) {
		this.details = details;
	}

	/**
	 * Amount Getter
	 * 
	 * @return
	 */
	public double getAmount() {
		return amount;
	}

	/**
	 * Amount Setter
	 * 
	 * @param amount
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	}

	/**
	 * Month Getter
	 * 
	 * @return
	 */
	public String getMonth() {
		return month;
	}

	/**
	 * Month Setter
	 * 
	 * @param month
	 */
	public void setMonth(String month) {
		this.month = month;
	}

}
