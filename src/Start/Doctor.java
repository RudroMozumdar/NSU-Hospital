package Start;

public class Doctor extends Staff {
	private final String Practicefield;
	private final int patientcapacity = 30;
	private final String Schedual="9 A.M - 7 P.M";
	private String officenm;

	public Doctor(String fname, String lname,String rank, int id, int age, String password, String practicefield,String officenm,String username) {
		super(fname, lname, rank, id, age, password,username);
		this.Practicefield = practicefield;
		this.officenm=officenm;
	}

	public String getPracticefield() {
		return Practicefield;
	}

	public int getPatientcapacity() {
		return patientcapacity;
	}

	public String getSchedual() {
		return Schedual;
	}
	
	public String getOfficenm() {
		return officenm;
	}

	public void setOfficenm(String officenm) {
		this.officenm = officenm;
	}

	@Override
	public String toString() {
		return super.toString() + "[Practicefield=" + Practicefield + ", patientcapacity=" + patientcapacity
				+ ", Schedual=" + Schedual + "]";
	}

}