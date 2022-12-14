package gr.aueb.sev.dto;

public class StudentDTO 
{
	private int id;
	private String firstname;
	private String lastname;
	
	//default constructor
	public StudentDTO () {}
	
	public StudentDTO (int id, String firstname, String lastname) {
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@Override
	public String toString() {
		return "StudentDTO [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + "]";
	}
	
}
