package Start;


public class Admin extends Staff {
	private String officenum;

	public Admin(String fname,String lname ,String rank, int id, int age, String password, String officenum,String username) {
		super(fname, lname,rank, id, age, password,username);
		this.officenum = officenum;
	}

	public String getOfficenum() {
		return officenum;
	}

	public void setOfficenum(String officenum) {
		this.officenum = officenum;
	}
	public String toString() {
		return super.toString() + "[officenum=" + officenum + "]";
	}

}