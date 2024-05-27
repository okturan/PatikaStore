package product;

public class Brand {
	private final int id;
	private final String name;

	public int getId () {
		return id;
	}

	public String getName () {
		return name;
	}

	public Brand (int id, String name) {
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return id + ". " + name;
	}
}
