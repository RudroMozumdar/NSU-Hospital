package Start;

import java.io.File;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;

public class AdminMenuWork implements AdminMenu {
	public ArrayList<Doctor> doc = new ArrayList<Doctor>();
	public ArrayList<Patient> pat = new ArrayList<Patient>();

	@Override
	public void initiate() {
		try {
			File sn = new File("doctor.txt");
			Scanner br = new Scanner(sn);
			while (br.hasNext()) {
				String name1 = br.next();
				String name2 = br.next();
				String rank1 = br.next();
				int id1 = Integer.parseInt(br.next());
				int age1 = Integer.parseInt(br.next());
				String pass1 = br.next();
				String prac1 = br.next();
				String officenm=br.next();
				String username=br.next();
				Doctor d2 = new Doctor(name1,name2, rank1, id1, age1, pass1, prac1,officenm,username);
				doc.add(d2);

			}
			br.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		try {
			File snn = new File("patient.txt");
			Scanner brr = new Scanner(snn);
			while (brr.hasNext()) {
				String fname = brr.next();
				String lname = brr.next();
				String disease = brr.next();
				int age = Integer.parseInt(brr.next());
				int mobilenum = Integer.parseInt(brr.next());
				String password = brr.next();
				String username = brr.next();
				Patient p1 = new Patient(fname, lname, disease, age, mobilenum, password,username);
				pat.add(p1);
			}
			brr.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	@Override
	public void adddoc() {
		// this.initiate();
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the Information below: ");
		System.out.print("First Name: ");
		String fname = s.next();
		System.out.print("Last Name: ");
		String lname = s.next();
		// s.nextLine();
		System.out.print("Rank: ");
		String rank = s.next();
		s.nextLine();
		System.out.print("Id  : ");
		int id = s.nextInt();
		System.out.print("Age: ");
		int age = s.nextInt();
		s.nextLine();
		System.out.print("Password: ");
		String password = s.next();
		s.nextLine();
		System.out.print("Practitionier at: ");
		String practice = s.next();
		System.out.print("Office No: ");
		String officenm=s.next();
		System.out.print("Username: ");
		String username=s.next();
		// s.nextLine();
		Doctor d = new Doctor(fname,lname, rank, id, age, password, practice,officenm,username);
		doc.add(d);

	}

	@Override
	public void removedoc() {
		Scanner s = new Scanner(System.in);
		// this.initiate();
		for (int i = 0; i < doc.size(); i++) {
			System.out.println((i+1) + "-" + doc.get(i).getFName()+" "+doc.get(i).getLname());
		}
		System.out.println("Which doctor You want to remove: ");
		int option = s.nextInt();
		doc.remove(option-1);

	}

	@Override
	public void seedoc() {
		if (doc.size() > 0) {
			for (int i = 0; i < doc.size(); i++) {
				System.out.println("Name: " + doc.get(i).getFName()+" "+doc.get(i).getLname() + "\nRank: " + doc.get(i).getRank() + "\nID: "
						+ doc.get(i).getId() + "\nAge: " + doc.get(i).getAge() + "\nPracticioner at: "
						+ doc.get(i).getPracticefield() + "\nSchedual: " + doc.get(i).getSchedual() +"\nOffice No: "+doc.get(i).getOfficenm()+ "\n\n");
			}
		} else
			System.out.println("No Doctors in database!Add please");

	}
	public void seepat() {
		if (pat.size() > 0) {
			System.out.println("All Patient List: \n-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_\n");
			for (int i = 0; i < pat.size(); i++) {
				System.out.println("Name: "+pat.get(i).getFName()+" "+pat.get(i).getLname()+"\nDisease: "+pat.get(i).getDisease()+"\nAge: "+pat.get(i).getAge()+"\nContact no: "+pat.get(i).getMobilenum()+"\nUsername: "+pat.get(i).getUsername()+"\n\n");
			}
		} else
			System.out.println("No patients in database for today!");
	}

	@Override
	public void writeBeforeExit() {
		// this.initiate();
		try {
			Formatter doctor = new Formatter("doctor.txt");
			for (int x = 0; x < doc.size(); x++) {
				doctor.format("%s %s %s %d %d %s %s %s %s\n", doc.get(x).getFName(), doc.get(x).getLname(), doc.get(x).getRank(), doc.get(x).getId(),
						doc.get(x).getAge(), doc.get(x).getPassword(), doc.get(x).getPracticefield(),doc.get(x).getOfficenm(),doc.get(x).getUsername());
			}
			doctor.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		doc.clear();

	}

	@Override
	public void exit() {
		writeBeforeExit();
	}

}
