package Start;

import java.io.File;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;

public class DoctorWorkMenu implements DoctorWork {
	public static ArrayList<Patient> pat = new ArrayList<Patient>();
	public static ArrayList<Doctor> doc = new ArrayList<Doctor>();
	

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
				Patient p1 = new Patient(fname,lname, disease, age, mobilenum, password,username);
				pat.add(p1);
			}
			br.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		try {
			File snn = new File("doctor.txt");
			Scanner brr = new Scanner(snn);
			while (brr.hasNext()) {
				String name1 = brr.next();
				String name2 = brr.next();
				String rank1 = brr.next();
				int id1 = Integer.parseInt(brr.next());
				int age1 = Integer.parseInt(brr.next());
				String pass1 = brr.next();
				String prac1 = brr.next();
				String officenum=brr.next();
				String username=brr.next();
                Doctor d=new Doctor(name1,name2,rank1,id1,age1,pass1,prac1,officenum,username);
                doc.add(d);
			}
			brr.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	@Override
	public void seePatientList(String wel) {
		ArrayList<String> patnames = new ArrayList<String>();
		try {
			File sn = new File("patNdoc.txt");
			Scanner br = new Scanner(sn);
			while (br.hasNext()) {
				String patname = br.next();
				String docname = br.next();
				if (docname.equals(wel)) {
					patnames.add(patname);
				}
			}
			br.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		if (patnames.size() == 0)
			System.out.println("No patient for today!");
		else {
			System.out.println("Patient list for today: ");
			for (int i = 0; i < pat.size(); i++) {
				if (patnames.contains(pat.get(i).getUsername()))
					System.out.printf("Name: %s %s\nAge: %d\nDisease: %s\nContact no: %d\nUsername: %s\n\n", pat.get(i).getFName(),pat.get(i).getLname(),
							pat.get(i).getAge(), pat.get(i).getDisease(), pat.get(i).getMobilenum(),pat.get(i).getUsername());
			}
		}

	}

	@Override
	public void sendNotes(String wel) {
		Scanner s=new Scanner(System.in);
		ArrayList<String> docmsgs = new ArrayList<String>();
		try {
			File snn = new File("docmsg.txt");
			Scanner brr = new Scanner(snn);
			while (brr.hasNext()) {
				String doc=brr.next();
				String pat=brr.next();
				String msg=brr.nextLine();
				docmsgs.add(doc+" "+pat+" "+msg);
			}
			brr.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.print("Enter the username of patient: ");
		String patname=s.next();
		s.nextLine();
		System.out.print("Enter the message: ");
		String msgs=s.nextLine();
		//s.nextLine();
		docmsgs.add(wel+" "+patname+" "+msgs);
		try {
			Formatter docmsg = new Formatter("docmsg.txt");
			for (int x = 0; x < docmsgs.size(); x++) {
				docmsg.format("%s\n", docmsgs.get(x));
			}
			docmsg.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public void resetpass(String wel) {
		Scanner s = new Scanner(System.in);
		for (int i = 0; i < doc.size(); i++) {
			if (doc.get(i).getUsername().equals(wel)) {
				System.out.println("Enter new password: ");
				String passup = s.next();
				doc.get(i).setPassword(passup);
			} else
				continue;
		}

	}

	@Override
	public void writeBeforeExit() {
		try {
			Formatter doctor = new Formatter("doctor.txt");
			for (int x = 0; x < doc.size(); x++) {
				doctor.format("%s %s %s %d %d %s %s %s %s\n", doc.get(x).getFName(),doc.get(x).getLname(), doc.get(x).getRank(), doc.get(x).getId(),
						doc.get(x).getAge(), doc.get(x).getPassword(), doc.get(x).getPracticefield(),doc.get(x).getOfficenm(),doc.get(x).getUsername());
			}
			doctor.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		doc.clear();
		pat.clear();
	}

}
