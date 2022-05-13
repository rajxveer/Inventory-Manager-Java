
public class DVD extends Product {

	private int length;
	private int ageRating;
	private String filmStudio;

	public DVD(int number, String name, int qty, double price, int l, int age, String studio) {
		super(number, name, qty, price);
		this.length = l;
		this.ageRating = age;
		this.filmStudio = studio;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getAgeRating() {
		return ageRating;
	}

	public void setAgeRating(int ageRating) {
		this.ageRating = ageRating;
	}

	public String getFilmStudio() {
		return filmStudio;
	}

	public void setFilmStudio(String filmStudio) {
		this.filmStudio = filmStudio;
	}
	
	public double getInventoryValue() {
		return quantity * (1.05 * price); //5% restocking fee
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Item number: " + Integer.toString(this.getId()));
		sb.append("\nName: " + this.getName());
		sb.append("\nMovie length: " + Integer.toString(this.getLength()));
		sb.append("\nAge rating: " + Integer.toString(this.getAgeRating()));
		sb.append("\nFilm studio: " + this.getFilmStudio());
		sb.append("\nQuantity in stock: " + Integer.toString(this.getQuantity()));
		sb.append(String.format("\nPrice: %.2f", this.getPrice()));
		sb.append(String.format("\nStock value: %.2f", this.getInventoryValue()));
		sb.append("\nProduct status: ");
		String status = this.isActive() ? "Active" : "Discountinued";
		sb.append(status);
		return sb.toString();
	}
}
