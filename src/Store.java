import product.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Store {
	Scanner input = new Scanner(System.in);
	ArrayList<Product> notebooks;
	ArrayList<Product> phones;
	Brand[] brands;

	public void stockInventory () {
		String[] brandNames = {"Samsung", "Lenovo", "Apple", "Huawei", "Casper", "Asus", "HP", "Xiaomi", "Monster"};
		Arrays.sort(brandNames);

		brands = new Brand[brandNames.length];

		for (int i = 0; i < brandNames.length; i++) {
			brands[i] = new Brand(i + 1, brandNames[i]); // Assigning id starting from 1
		}

		notebooks = new ArrayList<>();
		notebooks.add(new Notebook(1, 999.99, 10.0, 50, "MacBook Pro", brands[0], 512, 16, 16));
		notebooks.add(new Notebook(2, 799.99, 15.0, 30, "Dell XPS 13", brands[5], 256, 13, 8));
		notebooks.add(new Notebook(3, 649.99, 5.0, 40, "HP Spectre x360", brands[3], 512, 14, 8));

		phones = new ArrayList<>();
		phones.add(new Phone(1, 999.99, 20.0, 100, "iPhone 13 Pro", brands[0], 256, 6, 6, 3095, "Graphite"));
		phones.add(new Phone(2, 799.99, 25.0, 80, "Samsung Galaxy S21", brands[7], 128, 6, 8, 4000, "Phantom Gray"));
		phones.add(new Phone(3, 699.99, 10.0, 60, "Xiaomi note 9", brands[8], 128, 6, 8, 4614, "Stormy Black"));

		printNotebooks();
		printPhones();
	}

	public void run () {
		while (true) {
			printMenu();
			System.out.print("Choose an option: ");
			int choice = input.nextInt();

			switch (choice) {
				case 1:
					notebookOperations();
					break;
				case 2:
					phoneOperations();
					break;
				case 3:
					printBrands();
					break;
				case 4:
					return;
				default:
					System.out.println("Wrong choice. Enter again!");
					break;
			}
		}
	}

	public void notebookOperations () {
		while (true) {
			printSubMenu();
			System.out.print("Choose an option: ");
			int choice = input.nextInt();

			switch (choice) {
				case 1:
					addNotebook();
					break;
				case 2:
					deleteNotebook();
					break;
				case 3:
					printNotebooks();
					break;
				case 4:
					return;
				default:
					System.out.println("Wrong choice. Enter again!");
			}
		}
	}

	public void phoneOperations () {
		while (true) {
			printSubMenu();
			System.out.print("Choose an option: ");
			int choice = input.nextInt();

			switch (choice) {
				case 1:
					addPhone();
					break;
				case 2:
					deletePhone();
					break;
				case 3:
					printPhones();
					break;
				case 4:
					return;
				default:
					System.out.println("Wong choice. Enter again!");
			}
		}
	}

	public void addNotebook () {
		System.out.print("Enter Notebook ID: ");
		int id = input.nextInt();
		System.out.print("Enter Notebook price: ");
		double price = input.nextDouble();
		System.out.print("Enter discount rate: ");
		double discountRate = input.nextDouble();
		System.out.print("Enter stock amount: ");
		int stockAmount = input.nextInt();
		input.nextLine(); // consume newline
		System.out.print("Enter Notebook name: ");
		String name = input.nextLine();
		System.out.println("Enter brand ID: ");
		for (Brand brand : brands) {
			System.out.println(brand.getId() + " - " + brand.getName());
		}
		int brandId = input.nextInt();
		System.out.print("Enter storage: ");
		int storage = input.nextInt();
		System.out.print("Enter screen size: ");
		int screenSize = input.nextInt();
		System.out.print("Enter RAM: ");
		int ram = input.nextInt();

		Product newProduct = new Notebook(id, price, discountRate, stockAmount, name, brands[brandId - 1], storage, screenSize, ram);
		notebooks.add(newProduct);
		System.out.println(newProduct + " added successfully.");
	}

	public void addPhone () {
		System.out.print("Enter Phone ID: ");
		int id = input.nextInt();
		System.out.print("Enter Phone price: ");
		double price = input.nextDouble();
		System.out.print("Enter discount rate: ");
		double discountRate = input.nextDouble();
		System.out.print("Enter stock amount: ");
		int stockAmount = input.nextInt();
		System.out.print("Enter Phone name: ");
		String name = input.nextLine();
		System.out.println("Enter brand ID: ");
		for (Brand brand : brands) {
			System.out.println(brand.getId() + " - " + brand.getName());
		}
		int brandId = input.nextInt();
		System.out.print("Enter storage: ");
		int storage = input.nextInt();
		System.out.print("Enter screen size: ");
		int screenSize = input.nextInt();
		System.out.print("Enter RAM: ");
		int ram = input.nextInt();
		System.out.println("Enter battery capacity in Mah: ");
		int batteryCapacity = input.nextInt();
		System.out.print("Enter phone color");
		String color = input.nextLine();

		Product newProduct = new Phone(id, price, discountRate, stockAmount, name, brands[brandId - 1], storage, screenSize, ram, batteryCapacity, color);
		phones.add(newProduct);
		System.out.println(newProduct + " added successfully.");
	}

	public void deletePhone () {
		printPhones();
		System.out.println("Enter the id of the phone you want to remove:");
		int removeId = input.nextInt();
		Product toRemove = null;

		for (Product phone : phones) {
			if (phone.getId() == removeId) {
				toRemove = phone;
			}
		}
		phones.remove(toRemove);
		System.out.println(toRemove + " is successfully removed!");
	}

	public void deleteNotebook () {
		printNotebooks();
		System.out.println("Enter the id of the notebook you want to remove:");
		int removeId = input.nextInt();
		Product toRemove = null;

		for (Product notebook : notebooks) {
			if (notebook.getId() == removeId) {
				toRemove = notebook;
			}
		}
		notebooks.remove(toRemove);
		System.out.println(toRemove + " is successfully removed!");
	}

	public void printNotebooks () {
		notebooks.forEach(System.out::println);
	}

	public void printPhones () {
		phones.forEach(System.out::println);
	}

	public void printBrands () {
		for (Brand brand : brands) {
			System.out.println(brand);
		}
	}

	public void printMenu () {
		System.out.println("""
				\nPatika Store Stock System
				1. Notebooks
				2. Phones
				3. List all brands
				4. Exit
				""");
	}

	public void printSubMenu () {
		System.out.println("""
				\n1. Add
				2. Delete
				3. List all
				4. Exit
				""");
	}
}
