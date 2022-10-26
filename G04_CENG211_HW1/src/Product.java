import java.io.IOException;;

public class Product {
	String ID;
	String title;
	double rate;
	int numberOfReviews;
	int price;
	
	public Product(String ID, String title, String rate, String numberOfReviews, String price) {
		this.ID = ID;
		this.title = title;
		this.rate = Double.parseDouble(rate);
		this.numberOfReviews = Integer.parseInt(numberOfReviews);
		this.price = Integer.parseInt(price);
	}
	public String getID() {
		return ID;
	}
	
	public int getPrice() {
		return price;
	}
	
	public double getRate() {
		return rate;
	}
	
	public int getNumberOfReviews() {
		return numberOfReviews;
	}
	
	
	//Takes an array of product information
	//Create an array of products, length is equal to number of products
	//Creates products and appends to the array 
	
	public static Product[] makeProductArray(String[][] array) {
		Product[] productArray = new Product[array.length];
		for (int i = 1; i < array.length; i++) {
				productArray[i] = new Product(array[i][0],array[i][1],array[i][2],array[i][3],array[i][4]);
		}
		return productArray;
	}
	
	//SalesPrice = price + (rate/5.0 * 100) * number of reviews
	
	public static double[] calcualteSalesPrice(Product[] productArray) {
		double[] salesPrice = new double[productArray.length];
		for (int i = 1; i < productArray.length; i++) {
				salesPrice[i] = productArray[i].getPrice() + (productArray[i].getRate()/5 * 100)* productArray[i].getNumberOfReviews();
		}
		return salesPrice;
	}
	


}

