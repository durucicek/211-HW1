
public class Customer {
	String ID;
	String name;
	String email;
	String country;
	String address;
	
	public Customer(String ID, String name, String email, String country, String address) {
		this.ID = ID;
		this.name = name;
		this.email = email;
		this.country = country;
		this.address = address;
	}
	public static Customer[] customerArrayMaker(String[][] array) {
		Customer[] costumerArray = new Customer[array.length];
		for (int i = 1; i < array.length; i++) {
			costumerArray[i] = new Customer(array[i][0],array[i][1],array[i][2],array[i][3],array[i][4]);
		}
		return costumerArray;
	}
	
	
	
}


