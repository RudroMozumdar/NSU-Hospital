package Start;
public class Patient {
	private String fname;
	private String lname;
	private String disease;
	private int age;
	private int mobilenum;
	private String password;
	private String username; 
	private String messageFromDoc;

	public Patient(String fname,String lname, String disease, int age, int mobilenum,String password,String username) {
		this.fname = fname;
		this.lname = lname;
		this.disease = disease;
		this.age = age;
		this.mobilenum = mobilenum;
		this.password=password;
		this.username=username;
		
	}

	public String getFName() {
		return fname;
	}

	public void setfName(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	public String getDisease() {
		return disease;
	}

	public void setDisease(String disease) {
		this.disease = disease;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getMobilenum() {
		return mobilenum;
	}

	public void setMobilenum(int mobilenum) {
		this.mobilenum = mobilenum;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getMessageFromDoc() {
		return messageFromDoc;
	}

	public void setMessageFromDoc(String messageFromDoc) {
		this.messageFromDoc = messageFromDoc;
	}

	@Override
	public String toString() {
		return "Patient [name=" + fname+" "+lname + ", disease=" + disease + ", age=" + age + ", mobilenum=" + mobilenum + ","+ "]";
	}

}
