package fileio;

import java.util.ArrayList;
import java.util.Scanner;



public class CountriesApp {

	public static void main(String[] args) {
		
		
		Scanner scan=new Scanner(System.in);
		int menuOption=0;
		ArrayList<Country> cou=new ArrayList<>();
		System.out.println("Welcome to the countries Maintenance Application!");
		do {
		System.out.println("1.See the list of countries");
		System.out.println("2.Add a country");
		System.out.println("3.Exit");
		System.out.println(" ");
		System.out.println("Enter menu number..");
		menuOption = scan.nextInt();

		switch (menuOption) {

		case 1:CountriesTextFile.readFromFile("countries.txt");
				 break;
		case 2:
				CountriesTextFile.createOurFile("countries.txt");
				String name;
				long population;
				
				System.out.println("Enter Country");
				name=scan.next();
				System.out.println("Enter Population");
				population=scan.nextLong();
				cou.add(new Country(name,population));
				CountriesTextFile.writeToFile(cou,"countries.txt");
				break;
		case 3:System.out.println("Buh-bye!");
				break;
		default:
				System.out.println("Sorry, please enter valid Option");
			}
		}while(menuOption!=3);
		scan.close();
	}

}
