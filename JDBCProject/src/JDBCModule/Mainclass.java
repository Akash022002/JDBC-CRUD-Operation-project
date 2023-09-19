package JDBCModule;
import java.util.*;

public class Mainclass {

	public static void main(String[] args) {
		Student c1 = new Student();
		int choice;
		do {
			System.out.println("Enter your choice:");
			Scanner s = new Scanner(System.in);
			choice = s.nextInt();
		
		switch(choice)
		{
		case 1:
			c1.CreateDatabases();
			break;
		case 2:
			c1.createTable();
			break;
			
		case 3:
			c1.createData();
			break;
		
		case 4:
			c1.readData();
			break;
			
		case 5:
			c1.UpdateData();
			break;
			
		case 6:
			c1.deleteData();
			break;
		default:
			System.out.println("Enter the right choice for perform the operation");
		}
		//c1.CreateDatabases();
		//c1.createTable();
		//c1.createData();
		//c1.readData();
		//c1.UpdateData();
		//c1.deleteData();
		}while(choice<7);
	}

}
