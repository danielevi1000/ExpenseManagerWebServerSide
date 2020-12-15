package daniel.netanel.expensesmanagement.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This is a model class that represents a User entity
 *
 */
@Entity
@Table(name = "users")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "first_name")
	private String firstname;

	@Column(name = "last_name")
	private String lastname;

	@Column(name = "user_name")
	private String username;

	@Column(name = "password")
	private String password;

	/**
	 * FirstName Getter
	 * 
	 * @return
	 */
	public String getFirstName() {
		return firstname;
	}

	/**
	 * FirstName Setter
	 * 
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
		this.firstname = firstName;
	}

	/**
	 * LastName Getter
	 * 
	 * @return
	 */
	public String getLastName() {
		return lastname;
	}

	/**
	 * LastName Setter
	 * 
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		this.lastname = lastName;
	}

	/**
	 * Username Getter
	 * 
	 * @return
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Username Setter
	 * 
	 * @param username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Password Getter
	 * 
	 * @return
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Password Setter
	 * 
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
}
