
public class Product {
	protected int id; //item number
	protected String name;
	protected double price;
	protected int quantity;
	protected boolean active = true;
	
	//default constructor
	public Product() {
		this.id = -1;
		this.name = "NoName";
		this.price = 0.0;
		this.quantity = 0;
	}
	
	public Product(int number, String name,	int qty, double price) {
		this.id = number;
		this.name = name;
		this.price = price;
		this.quantity = qty;
	}
	
	public void addToInventory(int units) {
		if (this.isActive())
			this.quantity += units;
	}
	
	public void deductFormInventory(int units) {
		if (units <= this.quantity) {
			this.quantity -= units;
		}
		else {
			this.quantity = 0;
		}
	}
	
	//Getter and setter methods for private fields
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
	//inventory	value of item
	public double getInventoryValue() {
		return quantity * price;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Item number: " + Integer.toString(id));
		sb.append("\nName: " + name);
		sb.append("\nQuantity in stock: " + Integer.toString(quantity));
		sb.append(String.format("\nPrice: %.2f", price));
		sb.append(String.format("\nStock value: %.2f", this.getInventoryValue()));
		sb.append("\nProduct status: ");
		String status = active ? "Active" : "Discountinued";
		sb.append(status);
		return sb.toString();
	}
}
