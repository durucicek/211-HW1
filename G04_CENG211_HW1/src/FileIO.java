import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileIO {
	
	/*Reads a CSV file and returns a two-dimensional array
	* where the rows are a line and the collumns are the comma sperated data
	* Example: if "ID,Name,Email,Country,Address" is first line, ID is [0][0], name is [0][1]...
	* We used a paritally filled array with default vallues, then used the
	* fitArray() method to create an array that fits exactly.
	*/
	public static String[][] readFile(String filename) throws IOException{
		String[][] array = new String[50][10];
		
 
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filename));
			String str;
			int count = 0;
			//Here we use .spilt intead of string tokenizer and create a ragged array,
			//because .split it returns an array, which is more efficient here.
			while ((str = reader.readLine()) != null) {
				array[count] = str.split(",");
				count++;
			}
		
			reader.close();
			array = fitArray(array);
		} 
		
		catch (FileNotFoundException exception) {
			System.out.println("File not found"); 
		}
		
		return array;

	}
	
	/* Find the length of the array without the null elements
	 * Make a new array with no null elements, copy the original
	 */
	public static String[][] fitArray(String[][] firstArray){
		
		int countRow = 0;
		while(firstArray[countRow][0] != null) {
			countRow++;
		}
		
		int countCollumn= firstArray[0].length;
		String[][] newArray = new String[countRow][countCollumn];
		
		for(int i=0; i < countRow; i++) {
			newArray[i] = firstArray[i] ;
		}
			
		return newArray;
		
	}
	
	//Making of necessary arrays for now on -------->
	
	public static Customer[] getCustomers() throws IOException {
		String[][] array = readFile("Customers.csv");
		Customer[] customerArray = Customer.makeCustomerArray(array);
		
		return customerArray;
		
	}
	
	public static Product[] getProductsforSuppilerOne() throws IOException {
		String[][] array = readFile("S1_Products.csv");
		Product[] s1_productArray = Product.makeProductArray(array);
		
		return s1_productArray;
		
	}
	
	public static Product[] getProductsforSuppilerTwo() throws IOException {
		String[][] array = readFile("S2_Products.csv");
		Product[] s2_productArray = Product.makeProductArray(array);
		
		return s2_productArray;
		
	}
	
	public static Product[] getProductsforSuppilerThree() throws IOException {
		String[][] array = readFile("S3_Products.csv");
		Product[] s3_productArray = Product.makeProductArray(array);
		
		return s3_productArray;
		 
	}
	
	/* Firstly reads the sales CSV file and creates a sales array without the sale prices,
	 * using Sales.makeSalesArray. Then calculates the sale prices with Sales.calculateSalesPrices.
	 * Finally, we create the final sales array using Sales.addSalesPriceToArray.
	 */
	public static Sales[] getSalesforSuppilerOne(Product[] s1_productArray) throws IOException {
		String[][] array = readFile("S1_Sales.csv");
		Sales[] s1_salesArray = Sales.makeSalesArray(array);
		double[] salesPrices = Sales.calcualteSalesPrice(s1_productArray);
		s1_salesArray = Sales.addSalesPriceToArray(s1_productArray,s1_salesArray,salesPrices);
		return s1_salesArray;
		
	}
	
	public static Sales[] getSalesforSuppilerTwo(Product[] s2_productArray) throws IOException {
		String[][] array = readFile("S2_Sales.csv");
		Sales[] s2_salesArray = Sales.makeSalesArray(array);
		double[] salesPrices = Sales.calcualteSalesPrice(s2_productArray);
		s2_salesArray = Sales.addSalesPriceToArray(s2_productArray,s2_salesArray,salesPrices);
		return s2_salesArray;
		
	}
	
	public static Sales[] getSalesforSuppilerThree(Product[] s3_productArray) throws IOException {
		String[][] array = readFile("S3_Sales.csv");
		Sales[] s3_salesArray = Sales.makeSalesArray(array);
		double[] salesPrices = Sales.calcualteSalesPrice(s3_productArray);
		s3_salesArray = Sales.addSalesPriceToArray(s3_productArray,s3_salesArray,salesPrices);
		return s3_salesArray;
		
	}
	
}
