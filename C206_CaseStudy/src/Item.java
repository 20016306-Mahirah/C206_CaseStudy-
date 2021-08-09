
public class Item {
	
	private int id;
	private String itemname;
	private String description;
	private String price;
	private Boolean availability;
	
	
	
	public Item(int id, String itemname, String description, String price, Boolean availability) {
		super();
		this.id = id;
		this.itemname = itemname;
		this.description = description;
		this.price = price;
		this.availability = availability;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getItemname() {
		return itemname;
	}
	public void setItemname(String itemname) {
		this.itemname = itemname;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice() {
		this.price = price;
	}
	public Boolean getAvailability() {
		return availability;
	}
	public void setAvailability(Boolean availability) {
		this.availability = availability;
	}


	@Override
	public String toString() {
		return itemname + "\nDescription: " + description + "\nPrice: "+ price + "\nAvailability:"
				+ availability ;
	}

	
}
