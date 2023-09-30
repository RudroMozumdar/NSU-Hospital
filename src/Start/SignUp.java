package Start;

import java.io.File;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;

public class SignUp {
	public static ArrayList<Patient> pat = new ArrayList<Patient>();

	public static void initiate() {
		try {
			File sn = new File("patient.txt");
			Scanner br = new Scanner(sn);
			while (br.hasNext()) {
				String fname = br.next();
				String lname = br.next();
				String disease = br.next();
				int age = Integer.parseInt(br.next());
				int mobilenum = Integer.parseInt(br.next());
				String password = br.next();
				String username=br.next();
				Patient p1 = new Patient(fname,lname, disease, age, mobilenum, password,username);
				pat.add(p1);
			}
			br.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void signup() {
		    initiate();
		    Scanner s = new Scanner(System.in);
			System.out.println("Enter the Information below: ");
			System.out.print("First Name: ");
			String fname = s.next();
			System.out.print("Last Name: ");
			String lname = s.next();
			// s.nextLine();
			System.out.print("Disease: ");
			String disease = s.next();
			s.nextLine();
			System.out.print("Age : ");
			int age = s.nextInt();
			System.out.print("Mobile: ");
			int mobilenum = s.nextInt();
			s.nextLine();
			System.out.print("Password: ");
			String password = s.next();
			String username;
			while(true) {
				System.out.print("Username: ");
				username=s.next();
				boolean doer=true;
				for(int i=0;i<pat.size();i++) {
					if(username.equals(pat.get(i).getUsername())) {
						System.out.println("Username already in use try another!");
						doer=false;
					}
				}
				if(doer) break;
			}
			Patient p = new Patient(fname, lname,disease, age, mobilenum, password,username);
			pat.add(p);
			WriteBeforeExits();
			Login l=new Login();
			l.login();
	}
	public static void WriteBeforeExits() {
		try {
			Formatter patient = new Formatter("patient.txt");
			for (int x = 0; x < pat.size(); x++) {
				patient.format("%s %s %s %d %d %s %s\n", pat.get(x).getFName(),pat.get(x).getLname(),pat.get(x).getDisease(), pat.get(x).getAge(),
						pat.get(x).getMobilenum(), pat.get(x).getPassword(),pat.get(x).getUsername());
			}
			patient.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
