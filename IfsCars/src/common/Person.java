package common;
public class Person {
	
	private String name;
	private int ID;
	private boolean isEmployee;
	
	
	public Person(String name, int iD, boolean isEmployee) {
		this.name = name;
		this.ID = iD;
		this.isEmployee = isEmployee;
	}

	public String getName() {
		return name;
	}

	public int getID() {
		return ID;
	}

	public boolean isEmployee() {
		return isEmployee;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setID(int iD) {
		this.ID = iD;
	}

	public void setEmployee(boolean isEmployee) {
		this.isEmployee = isEmployee;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", ID=" + ID + ", isEmployee=" + isEmployee + "]";
	}	
}
