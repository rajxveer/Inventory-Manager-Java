import java.util.InputMismatchException;
import java.util.Scanner;

public class ProductTester {

	public static void main(String[] args) {
		
		Product p1, p2, p3, p4, p5, p6;
		Scanner in = new Scanner(System.in);
		/* part 1 */
		
		p1 = new Product();
		p2 = new Product();
		p3 = new Product(7, "myPhone X", 45, 123.99);
		p4 = new Product(1, "Zhilips M8", 10, 95.99);
		p5 = new Product(2, "Shiaomi Mi 9", 20, 90.0);
		p6 = new Product(3, "Stuntsung G15", 50, 142.99);
		/*
		System.out.println(String.format("Product 1: #%d. %s. %d pc. $%.2f", p1.getId(), p1.getName(), p1.getQuantity(), p1.getPrice()));
		System.out.println(String.format("Product 2: #%d. %s. %d pc. $%.2f", p2.getId(), p2.getName(), p2.getQuantity(), p2.getPrice()));
		System.out.println(String.format("Product 3: #%d. %s. %d pc. $%.2f", p3.getId(), p3.getName(), p3.getQuantity(), p3.getPrice()));
		System.out.println(String.format("Product 4: #%d. %s. %d pc. $%.2f", p4.getId(), p4.getName(), p4.getQuantity(), p4.getPrice()));
		System.out.println(String.format("Product 5: #%d. %s. %d pc. $%.2f", p5.getId(), p5.getName(), p5.getQuantity(), p5.getPrice()));
		System.out.println(String.format("Product 6: #%d. %s. %d pc. $%.2f", p6.getId(), p6.getName(), p6.getQuantity(), p6.getPrice()));
		*/
		
		/* part 2 */
		
		
		/*
		System.out.println("\nProduct p1");
		System.out.print("Please enter item number: ");
		tempNumber = in.nextInt();
		in.nextLine();
		System.out.print("Please enter name: ");
		tempName = in.nextLine();
		System.out.print("Please enter quantity in stock: ");
		tempQty = in.nextInt();
		System.out.print("Please enter price: ");
		tempPrice = in.nextDouble();
		p1 = new Product(tempNumber, tempName, tempQty, tempPrice);
		
		in.nextLine();
		
		System.out.println("Product p2");
		System.out.print("Please enter item number: ");
		tempNumber = in.nextInt();
		in.nextLine();
		System.out.print("Please enter name: ");
		tempName = in.nextLine();
		System.out.print("Please enter quantity in stock: ");
		tempQty = in.nextInt();
		System.out.print("Please enter price: ");
		tempPrice = in.nextDouble();
		p2 = new Product(tempNumber, tempName, tempQty, tempPrice);
		
		in.close();
		
		
		p6.setActive(false);
		System.out.println("\nProduct 1\n" + p1.toString());
		System.out.println("\nProduct 2\n" + p2.toString());
		System.out.println("\nProduct 3\n" + p3.toString());
		System.out.println("\nProduct 4\n" + p4.toString());
		System.out.println("\nProduct 5\n" + p5.toString());
		System.out.println("\nProduct 6\n" + p6.toString());
		*/
		
		/* part 3-4-5 */
		int maxSize = getNumProducts(in);
		int menuChoice;
		
		if (maxSize == 0) {
			System.out.println("No products required!");
		}
		else {
			Product[] products = new Product[maxSize];
			addToInventory(products, in);
			do {
				menuChoice = getMenuOption(in);
				executeMenuChoice(menuChoice, products, in);
			} while (menuChoice != 4);
		}
	}
	
	static void executeMenuChoice(int menuChoice, Product[] prds, Scanner in) {
		switch (menuChoice) {
			case 0: {
				System.out.println("View Product List");
				displayInventory(prds);
				break;
			}
			case 1: {
				System.out.println("Add stock");
				addInventory(prds, in);
				break;
			}
			case 2: {
				System.out.println("Deduct stock");
				deductInventory(prds, in);
				break;
			}
			case 3: {
				System.out.println("Discontinue stock");
				discontinueInventory(prds, in);
				break;
			}
			case 4: {
				break;
			}
		}
	}
	
	static void discontinueInventory(Product[] prds, Scanner in) {
		int productChoice;
		productChoice = getProductNumber(prds, in);
		prds[productChoice].setActive(false);
	}
	
	static void deductInventory(Product[] prds, Scanner in) {
		int productChoice, updateValue = -1;
		productChoice = getProductNumber(prds, in);
		while (updateValue < 0) {
			System.out.print("How many products do you want to deduct? Please enter a valid (>= 0) number: ");
			try {
				updateValue = in.nextInt();
			}
			catch (InputMismatchException e) {
				System.out.println("Incorrect data type entered!");
				in.nextLine();
			}
		}
		prds[productChoice].deductFormInventory(updateValue);
	}
	
	static void addInventory(Product[] prds, Scanner in) {
		int productChoice, updateValue = -1;
		productChoice = getProductNumber(prds, in);
		while (updateValue < 0) {
			System.out.print("How many products do you want to add? Please enter a valid (>= 0) number: ");
			try {
				updateValue = in.nextInt();
			}
			catch (InputMismatchException e) {
				System.out.println("Incorrect data type entered!");
				in.nextLine();
			}
		}
		prds[productChoice].addToInventory(updateValue);
	}
	
	static int getProductNumber(Product[] prds, Scanner in) {
		int productChoice = -1;
		for (int i = 0; i < prds.length; i++) {
			System.out.println(String.format("%d. %s", i, prds[i].getName()));
		}
		while (productChoice < 0 || productChoice > prds.length - 1) {
			System.out.print("Please enter a valid product number: ");
			try {
				productChoice = in.nextInt();
			}
			catch (InputMismatchException e) {
				System.out.println("Incorrect data type entered!");
				in.nextLine();
			}
		}
		return productChoice;
	}
	
	static int getMenuOption(Scanner in) {
		System.out.println("0. View inventory");
		System.out.println("1. Add stock");
		System.out.println("2. Deduct stock");
		System.out.println("3. Discontinue Product");
		System.out.println("4. Exit");
		
		int opt = -1;
		while (opt < 0 || opt > 4) {
			System.out.print("Please enter a menu option (number between 0 and 4): ");
			try {
				opt = in.nextInt();
			}
			catch (InputMismatchException e) {
				System.out.println("Incorrect data type entered!");
				in.nextLine();
			}
		}
		return opt;
	}
	
	static int getNumProducts(Scanner in) {
		int maxSize = -1;
		while (maxSize < 0) {
			try {
				System.out.println("\nIncorrect value entered");
				System.out.print("Enter the number of products you would like to add\r\nEnter 0 (zero) if you do not wish to add products: ");
				maxSize = in.nextInt();
			}
			catch (InputMismatchException e) {
				System.out.println("Incorrect data type entered!");
				in.nextLine();
			}
		}
		return maxSize;
	}
	
	static void addToInventory(Product[] prds, Scanner in) {
		for (int i = 0; i < prds.length; i++) {
			int stockChoice = -1;
			System.out.println("\n1. CD");
			System.out.println("2. DVD");
			while (stockChoice < 1 || stockChoice > 2) {
				System.out.print("Please enter the product type (Only numbers 1 or 2 allowed!): ");
				try {
					stockChoice = in.nextInt();
				}
				catch (InputMismatchException e) {
					System.out.println("Incorrect data type entered!");
					in.nextLine();
				}
			}
			switch (stockChoice) {
				case 1: {
					addCDToInventory(prds, in, i);
					break;
				}
				case 2: {
					addDVDToInventory(prds, in, i);
					break;
				}
			}
		}
		
	}
	
	static void addCDToInventory(Product[] prds, Scanner in, int i) {
		int tempNumber, tempQty, tempNumOfSongs;
		String tempName, tempArtist, tempLabel;
		double tempPrice;
		
		in.nextLine();
		System.out.print("Please enter the CD name: ");
		tempName = in.nextLine();
		System.out.print("Please enter the artist name: ");
		tempArtist = in.nextLine();
		System.out.print("Please enter the record label name: ");
		tempLabel = in.nextLine();
		System.out.print("Please enter the number of songs: ");
		tempNumOfSongs = in.nextInt();
		System.out.print("Please enter the quantity in stock: ");
		tempQty = in.nextInt();
		System.out.print("Please enter the price: ");
		tempPrice = in.nextDouble();
		System.out.print("Please enter the item number: ");
		tempNumber = in.nextInt();
		prds[i] = new CD(tempNumber, tempName, tempQty, tempPrice, tempArtist, tempNumOfSongs, tempLabel);
	}
	
	static void addDVDToInventory(Product[] prds, Scanner in, int i) {
		int tempNumber, tempQty, tempLength, tempAgeRating;
		String tempName,tempStudio;
		double tempPrice;
		
		in.nextLine();
		System.out.print("Please enter the DVD name: ");
		tempName = in.nextLine();
		System.out.print("Please enter the film studio name: ");
		tempStudio = in.nextLine();
		System.out.print("Please enter the age rating: ");
		tempAgeRating = in.nextInt();
		System.out.print("Please enter the length in minutes: ");
		tempLength = in.nextInt();
		System.out.print("Please enter the quantity in stock: ");
		tempQty = in.nextInt();
		System.out.print("Please enter the price: ");
		tempPrice = in.nextDouble();
		System.out.print("Please enter the item number: ");
		tempNumber = in.nextInt();
		prds[i] = new DVD(tempNumber, tempName, tempQty, tempPrice, tempLength, tempAgeRating, tempStudio);
	}
	
	static void displayInventory(Product[] prds) {
		System.out.println("\nProducts:\n");
		for (int i = 0; i < prds.length; i++) {
			System.out.println(prds[i].toString() + "\n");
		}
	}
}
