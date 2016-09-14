package kvn.entity;

import javax.persistence.*;

@Entity
@Table(name="APP_USER")
public class User2 {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="SSO_ID", unique=true, nullable=false)
	private String ssoId;
	
	@Column(name="PASSWORD", nullable=false)
	private String password;
		
	@Column(name="FIRST_NAME", nullable=false)
	private String firstName;

	@Column(name="LAST_NAME", nullable=false)
	private String lastName;

	@Column(name="EMAIL", nullable=false)
	private String email;

	@Column(name="STATE", nullable=false)
	private String state=State.ACTIVE.getState();





	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSsoId() {
		return ssoId;
	}

	public void setSsoId(String ssoId) {
		this.ssoId = ssoId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}


}
