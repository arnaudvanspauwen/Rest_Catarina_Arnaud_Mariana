package common;

import java.io.Serializable;

public interface IPersonObserver extends Serializable{
	
	public String getName();
	public int getID();
	public boolean isEmployee();
	public void setName(String name);
	public void setID(int iD);
	public void setEmployee(boolean isEmployee);

}
