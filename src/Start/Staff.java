package Start;

public class Staff {
	private String fname;
	private String lname;
	private int id;
	private String rank;
	private int age;
	private String username;
	private String password;

	public Staff(String fname,String lname, String rank, int id, int age, String password,String username) {
		this.fname = fname;
		this.lname = lname;
		this.id = id;
		this.rank = rank;
		this.age = age;
		this.password = password;
		this.username=username;
	}

	public String getFName() {
		return fname;
	}

	public void setFName(String fname) {
		this.fname = fname;
	}
    
	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "[name=" + fname +" "+ lname+", id=" + id + ", rank=" + rank + ", age=" + age + ", username=" + username
				+ ", password=" + password + "]";
	}

}
