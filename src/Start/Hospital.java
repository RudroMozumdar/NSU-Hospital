package Start;
import java.util.Formatter;
import java.util.Scanner;

public class Hospital {
	

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Admin a = new Admin("Nihal","Azman", "O1", 211, 22, "menihal", "s1","Nihal211");
		Admin b = new Admin("Soikot","Ghosh", "O2", 201, 22, "soikotme", "s2","soikot201");
		Admin c = new Admin("Kaniz","Fatema" ,"O3", 193, 22, "mekaniz", "s3","kaniz193");
		try{
			Formatter admin=new Formatter("admin.txt");
			admin.format("%s %s\n",a.getUsername(),a.getPassword());
			admin.format("%s %s\n",b.getUsername(),b.getPassword());
			admin.format("%s %s\n",c.getUsername(),c.getPassword());
			admin.close();
		}catch(Exception e) {
			System.out.println(e);
		}
		Login l=new Login();
		l.login();
	}

}
