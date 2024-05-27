package product;

public abstract class Product {
	private int id;
	private double price;
	private double discountRate;
	private int stockAmount;
	private String name;
	private Brand brand;
	private int storage;
	private int screenSize;
	private int ram;

	public Product (int id, double price, double discountRate, int stockAmount, String name, Brand brand, int storage, int screenSize, int ram) {
		this.id = id;
		this.price = price;
		this.discountRate = discountRate;
		this.stockAmount = stockAmount;
		this.name = name;
		this.brand = brand;
		this.storage = storage;
		this.screenSize = screenSize;
		this.ram = ram;
	}

	public Product () {
	}

	public int getId () {
		return id;
	}

	public double getPrice () {
		return price;
	}

	public double getDiscountRate () {
		return discountRate;
	}

	public int getStockAmount () {
		return stockAmount;
	}

	public String getName () {
		return name;
	}

	public Brand getBrand () {
		return brand;
	}

	public int getStorage () {
		return storage;
	}

	public int getScreenSize () {
		return screenSize;
	}

	public int getRam () {
		return ram;
	}

	@Override
	public String toString() {
		return String.format("| %2d | %-20s | %-8.1f USD | %-8s | %-2d GB | %-2d inches | %-2d GB |",
				id, name, price, brand.getName(), storage, screenSize, ram);
	}
}
