package product;

public class Notebook extends Product {
	public Notebook (int id, double price, double discountRate, int stock, String name, Brand brand, int storage, int screenSize, int ram) {
		super(id, price, discountRate, stock, name, brand, storage, screenSize, ram);
	}

	public String toString() {
		return super.toString();
	}
}
