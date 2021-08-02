
public class Buyer {

	private String name;
	private String phone;
	private String email;
	private String houseInfo;
	
	public Buyer(String name, String phone, String email, String houseInfo) {
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.houseInfo = houseInfo;
	}

	public String getName() {
		return name;
	}

	public String getPhone() {
		return phone;
	}

	public String getEmail() {
		return email;
	}

	public String getHouseInfo() {
		return houseInfo;
	}
	
	public void display() {
		System.out.println("Name: " + getName());
		System.out.println("Phone: " + getPhone());
		System.out.println("Email: " + getEmail());
		System.out.println("Address: " + getHouseInfo());
	}
}
