
public class Customer {
	//privatelancak
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
	
	//Takes an array of customer information
	//Create an array of customers, length is equal to number of customers
	//Creates customers and appends to the array

	public static Customer[] makeCustomerArray(String[][] array) {
		Customer[] customerArray = new Customer[array.length];
		for (int i = 1; i < array.length; i++) {
			customerArray[i] = new Customer(array[i][0],array[i][1],array[i][2],array[i][3],array[i][4]);
		}
		return customerArray;
	}
	
	
	
}


