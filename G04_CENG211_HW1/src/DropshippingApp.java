import java.io.IOException;
//import java.util.Arrays;
public class DropshippingApp {

	public static void main(String[] args) throws IOException {
		//Testing FileIO class---------------->
		//String[][] array = FileIO.readFile("Customers.csv");
		//System.out.println(Arrays.deepToString(array).replace("], ", "]\n"));
		//System.out.println(array[1][1]);
		//System.out.println(array.length);
		//System.out.println(array[40].length);
		
		
		//String[][] array1 = FileIO.readFile("S1_Products.csv");
		//Product[] productArray = Product.productArrayMaker(array1);
		//String[][] array2 = FileIO.readFile("S1_Sales.csv");
		//Sales[] salesArray = Sales.salesArrayMaker(array2);
		//double[] costArray = Product.calcSalesPrice(productArray);
		//Sales[] salesArrayEnd = Sales.setSalesPriceArray(productArray, salesArray, costArray);
		
		 SalesQuery query = new SalesQuery();
		 Sales[][] a = query.sales.getSales();
		 
		 //00 null döndürüyo imdat
		 System.out.println(a[0][0]);
		 
		 System.out.println(a[0][2]);
	}

}
