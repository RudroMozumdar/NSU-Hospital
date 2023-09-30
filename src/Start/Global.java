package Start;

import java.util.Scanner;

public class Global {

	public static void adminwork(String wel) {
		Scanner s = new Scanner(System.in);
		AdminMenuWork admin = new AdminMenuWork();
		admin.initiate();
		while (true) {
			System.out.println("Welcome! " + wel
					+ " what do you want to do: \n1. Add Doctor\n2. Remove Doctor\n3. See Doctors\n4. See Patient\n5. Exit->Log Out");
			System.out.print("Choose an option: ");
			int option = s.nextInt();
			if (option == 1) {
				admin.adddoc();
			} else if (option == 2) {
				admin.removedoc();
			} else if (option == 3) {
				admin.seedoc();
			} else if (option == 4) {
				admin.seepat();
			} else if (option == 5) {
				admin.exit();
				break;
			}
		}
		Login l = new Login();
		l.login();
	}

	public static void doctorwork(String wel) {
		Scanner s = new Scanner(System.in);
		DoctorWorkMenu doctor = new DoctorWorkMenu();
		doctor.initiatepat();
		while (true) {
			System.out.println("Welcome! " + wel
					+ " what do you want to do: \n1. See Patient List\n2. Send notes to Patient\n3. Reset Password\n4. Exit->Log Out");
			System.out.print("Choose an option: ");
			int option = s.nextInt();
			if (option == 1) {
				doctor.seePatientList(wel);
			} else if (option == 2) {
				doctor.sendNotes(wel);
			} else if (option == 3) {
				doctor.resetpass(wel);
			} else if (option == 4) {
				doctor.writeBeforeExit();
				break;
			}
			
		}
		Login l = new Login();
		l.login();
	}

	public static void patientwork(String wel) {
		Scanner s = new Scanner(System.in);
		PatinetMenuWork patient = new PatinetMenuWork();
		patient.initiatepat();
		while (true) {
			System.out.println("Welcome! " + wel
					+ " what do you want to do: \n1. See & Select Doctor\n2. Reset Password\n3. See message\n4. Delete Account. \n5. Exit->Log Out");
			System.out.print("Choose an option: ");
			int option = s.nextInt();
			if (option == 1) {
				patient.selectdoc(wel);
			} else if (option == 2) {
				patient.resetpass(wel);
			} else if (option == 3) {
				patient.seemsg(wel);
			}else if (option == 4) {
				patient.deleteaccount(wel);
			}
			else if (option == 5) {
				patient.WriteBeforeExits();
				break;
			}
		}
		Login login = new Login();
		login.login();
		// s.close();
	}

}
