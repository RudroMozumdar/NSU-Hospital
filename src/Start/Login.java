package Start;

import java.io.File;
import java.util.Formatter;
import java.util.Scanner;

public class Login {
	Scanner s = new Scanner(System.in);

	public void login() {
		System.out.println("You want to login as:\n1. Admin.\n2. Doctor.\n3. Patient\n4. Exit Programme");
		System.out.print("Choose an option: ");
		int option = s.nextInt();
		if (option == 1) {
			System.out.print("Enter Username: ");
			String usernm = s.next();
			s.nextLine();
			boolean doer = false;
			try {
				File sn = new File("admin.txt");
				Scanner br = new Scanner(sn);
				while (br.hasNext()) {
					String user = br.next();
					String pass = br.next();
					if (user.equals(usernm)) {
						System.out.print("Enter Password: ");
						String passw = s.next();
						if (pass.equals(passw)) {
							doer = true;
							break;
						} else
							System.out.println("Wrong Pass!");
					}
				}
				br.close();
			} catch (Exception e) {
				System.out.println(e);
			}
			if (doer) {
				Global.adminwork(usernm);
			}else {
				System.out.println("No matching Admin!");
				this.login();
			}
			
		} else if (option == 2) {
			System.out.println("Enter Username: ");
			String usernm = s.next();
			s.nextLine();
			boolean doer = false;
			try {
				File sn = new File("doctor.txt");
				Scanner br = new Scanner(sn);
				while (br.hasNext()) {
					String p = br.nextLine();
					String[] pp = p.split(" ");
					if (pp[8].equals(usernm)) {
						System.out.println("Enter Password: ");
						String pass = s.next();
						if (pp[5].equals(pass)) {
							doer = true;
							break;
						} else
							System.out.println("Wrong Pass!");
					}
				}
				br.close();
			} catch (Exception e) {
				System.out.println(e);
			}

			if (doer) {
				Global.doctorwork(usernm);
			} else {
				System.out.println("Try Again!No matching Doctor!");
				this.login();
			}
		} else if (option == 3) {
			System.out.println("Do you want to: \n1. Log-in\n2. Sign-up");
			System.out.print("Choose an option: ");
			int optn = s.nextInt();
			if (optn == 1) {
				System.out.print("Enter Username: ");
				String usernm = s.next();
				s.nextLine();
				boolean doer = false;
				try {
					File sn = new File("patient.txt");
					Scanner br = new Scanner(sn);
					while (br.hasNext()) {
						String p = br.nextLine();
						String[] pp = p.split(" ");
						if (pp[6].equals(usernm)) {
							System.out.print("Enter Password: ");
							String pass = s.next();
							if (pp[5].equals(pass)) {
								doer = true;
								break;
							} else
								System.out.println("Wrong Pass!");
						}
					}
					br.close();
				} catch (Exception e) {
					System.out.println(e);
				}

				if (doer) {
					Global.patientwork(usernm);
				} else {
					System.out.println("Try Again!No matching Patient!");
					this.login();
				}
			} else if (optn == 2) {
				SignUp sup = new SignUp();
				sup.signup();
			}
		} else if (option == 4)
			System.exit(0);
	}
}
