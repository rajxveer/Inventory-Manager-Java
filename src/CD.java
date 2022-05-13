
public class CD extends Product {

	private String artist;
	private int numOfSongs;
	private String label;

	public CD(int number, String name, int qty, double price, String artist, int songs, String lbl) {
		super(number, name, qty, price);
		this.artist = artist;
		this.numOfSongs = songs;
		this.label = label;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public int getNumOfSongs() {
		return numOfSongs;
	}

	public void setNumOfSongs(int numOfSongs) {
		this.numOfSongs = numOfSongs;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Item number: " + Integer.toString(this.getId()));
		sb.append("\nName: " + this.getName());
		sb.append("\nArtist: " + this.getArtist());
		sb.append("\nSongs on Album: " + Integer.toString(this.getNumOfSongs()));
		sb.append("\nRecord label: " + this.getLabel());
		sb.append("\nQuantity in stock: " + Integer.toString(this.getQuantity()));
		sb.append(String.format("\nPrice: %.2f", this.getPrice()));
		sb.append(String.format("\nStock value: %.2f", this.getInventoryValue()));
		sb.append("\nProduct status: ");
		String status = this.isActive() ? "Active" : "Discountinued";
		sb.append(status);
		return sb.toString();
	}
	
}
