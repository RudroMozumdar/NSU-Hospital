package Start;

import java.io.File;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;

public class PatinetMenuWork implements PatientMenu {
	public static ArrayList<Patient> pat = new ArrayList<Patient>();
	public static ArrayList<String> patndoc = new ArrayList<String>();


	@Override
	public void initiatepat() {
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
				String username = br.next();
				Patient p1 = new Patient(fname, lname, disease, age, mobilenum, password,username);
				pat.add(p1);
			}
			br.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		try {
			File snn = new File("patNdoc.txt");
			Scanner brr = new Scanner(snn);
			while (brr.hasNext()) {
				String patfname = brr.next();
				String docfname = brr.next();
				patndoc.add(patfname+" "+docfname);
			}
			brr.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

	@Override
	public void selectdoc(String wel) {
		Scanner s = new Scanner(System.in);
		try {
			File sn = new File("doctor.txt");
			Scanner br = new Scanner(sn);
			if (br.hasNext()) {
				System.out.println("Available doctors: \n-_-_-_-_-_-_-_-_-_-_-_-_-_-_\n");
				while (br.hasNext()) {
					String name1 = br.next();
					String name2 = br.next();
					String rank1 = br.next();
					int id1 = Integer.parseInt(br.next());
					int age1 = Integer.parseInt(br.next());
					String pass1 = br.next();
					String prac1 = br.next();
					String officenum = br.next();
					String username = br.next();
					System.out.println("Name: " + name1 +" "+name2+"\nUsername: "+username+"\nRank: " + rank1 + "\nID: " + id1 + "\nAge: " + age1
							+ "\nPracticioner at: " + prac1 +"\nOfiice No: "+ officenum+"\nAvailable From: 9 A.M-7 P.M"+"\n\n");
				}
			} else
				System.out.println("No Doctors in database!Try later!");
			br.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		System.out.print("Choosed doctor (Please write in the format (Username of doctor)): ");
		String namedoc = s.next();
		String padoc=wel+" "+namedoc;
		patndoc.add(padoc);
		
	}
	@Override
	public void resetpass(String wel) {
		Scanner s = new Scanner(System.in);
		for (int i = 0; i < pat.size(); i++) {
			if (pat.get(i).getUsername().equals(wel)) {
				System.out.println("Enter new password: ");
				String passup = s.next();
				pat.get(i).setPassword(passup);
			} else
				continue;
		}
	}
	
	@Override
	public void seemsg(String wel) {
		try {
			File sn = new File("docmsg.txt");
			Scanner br = new Scanner(sn);
			while (br.hasNext()) {
				String docfname = br.next();
				String patlname = br.next();
				String msg = br.nextLine();
				if(patlname.equals(wel)) {
					System.out.printf("From doctor %s,\n%s.\n\n",docfname,msg);
					break;
				}
				else {
					System.out.println("No message!\n\n");
				}
			}
			br.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	@Override
	public void deleteaccount(String wel) {
		Scanner s=new Scanner(System.in);
		System.out.println("Are you sure you want to delete this account: \n1. Yes.\n2. No.");
		System.out.print("Choose an option: ");
		int op=s.nextInt();
		if(op==1) {
			for(int i=0;i<pat.size();i++) {
				if(pat.get(i).getUsername().equals(wel)) {
					pat.remove(i);
				    break;
				}
			}
			for(int j=0;j<patndoc.size();j++) {
				if(patndoc.get(j).contains(wel)) {
					patndoc.remove(j);
				}
			}
			System.out.println("Account deleted successfully!");
			WriteBeforeExits();
			Login l=new Login();
			l.login();
		}
		else if(op==2) {
			Global.patientwork(wel);
		}
		
	}

	@Override
	public void WriteBeforeExits() {
		try {
			Formatter patient = new Formatter("patient.txt");
			for (int x = 0; x < pat.size(); x++) {
				patient.format("%s %s %s %d %d %s %s\n", pat.get(x).getFName(),pat.get(x).getLname(), pat.get(x).getDisease(), pat.get(x).getAge(),
						pat.get(x).getMobilenum(), pat.get(x).getPassword(),pat.get(x).getUsername());
			}
			patient.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		try {
			Formatter patNdoc = new Formatter("patNdoc.txt");
			for(int i=0;i<patndoc.size();i++) {
				patNdoc.format("%s\n", patndoc.get(i));
			}
			patNdoc.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		pat.clear();
		patndoc.clear();
		
	}


}
