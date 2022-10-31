import java.io.IOException;

public class SalesQuery {
	Customer[] customers;
	static Supplier supplier1;
	static Supplier supplier2;
	static Supplier supplier3;
	static SalesManagement sales;
	
	
	
	//Initializes everything
	public SalesQuery() throws IOException {
		Customer [] customers = FileIO.getCustomers();
		this.customers = customers;
		Product[] s1_productArray = FileIO.getProductsforSuppilerOne();
		Product[] s2_productArray = FileIO.getProductsforSuppilerTwo();
		Product[] s3_productArray = FileIO.getProductsforSuppilerThree();
		supplier1 = new Supplier(s1_productArray);
		supplier2 = new Supplier(s2_productArray);
		supplier3 = new Supplier(s3_productArray);
		Sales[] s1_salesArray = FileIO.getSalesforSuppilerOne(s1_productArray);
		Sales[] s2_salesArray = FileIO.getSalesforSuppilerTwo(s2_productArray);
		Sales[] s3_salesArray = FileIO.getSalesforSuppilerThree(s3_productArray);
		sales = new SalesManagement(s1_salesArray, s2_salesArray, s3_salesArray);
	
	}
		
	//Compares 3 suppliers' products' sale prices and get the most expensive one with a nested for loop 
	
	public static void getMostExpensiveProduct() {
	Sales maxSalesPrice = sales.getSales()[0][1];				//indexte problem olabilir
    for(int s = 0; s<3; s++) {
    	for(int i=2; i<sales.getSales()[s].length; i++) {
        if(sales.getSales()[s][i].getSalesPrice()>=maxSalesPrice.getSalesPrice()) 
            maxSalesPrice=sales.getSales()[s][i];
    	}
    }
    
    System.out.println(supplier1.getProducts()[Integer.parseInt(maxSalesPrice.getProduct().substring(1))].ID);
    System.out.println(supplier1.getProducts()[Integer.parseInt(maxSalesPrice.getProduct().substring(1))].title);
    System.out.println(supplier1.getProducts()[Integer.parseInt(maxSalesPrice.getProduct().substring(1))].rate);
    System.out.println(supplier1.getProducts()[Integer.parseInt(maxSalesPrice.getProduct().substring(1))].numberOfReviews);
    System.out.println(supplier1.getProducts()[Integer.parseInt(maxSalesPrice.getProduct().substring(1))].price);
    System.out.println("----->" + " with sales price: " + maxSalesPrice.salesPrice);
    // 
    
   
    System.out.println();
    System.out.println();
    
	}
	    
	
	
    // max profit
	public static void getMostProfitableProduct() {
    Sales maxProfit = sales.getSales()[0][1];    
    for(int s = 0; s<3; s++) {
	    for(int i=1; i<sales.getSales()[s].length; i++) {
	    	if(sales.getSales()[s][i].getSalesPrice() - supplier1.getProducts()[Integer.parseInt(sales.getSales()[s][i].getProduct().substring(1))].getPrice() > 
	    					maxProfit.getSalesPrice() - supplier1.getProducts()[Integer.parseInt(maxProfit.getProduct().substring(1))].getPrice())
	    		maxProfit = sales.getSales()[s][i];
	    }
    }
   
    System.out.println(supplier1.getProducts()[Integer.parseInt(maxProfit.getProduct().substring(1))].ID);
    System.out.println(supplier1.getProducts()[Integer.parseInt(maxProfit.getProduct().substring(1))].title);
    System.out.println(supplier1.getProducts()[Integer.parseInt(maxProfit.getProduct().substring(1))].rate);
    System.out.println(supplier1.getProducts()[Integer.parseInt(maxProfit.getProduct().substring(1))].numberOfReviews);
    System.out.println(supplier1.getProducts()[Integer.parseInt(maxProfit.getProduct().substring(1))].price);
    System.out.println("----->" + " most profit: " + (maxProfit.getSalesPrice() - supplier1.getProducts()[Integer.parseInt(maxProfit.getProduct().substring(1))].price));

    
    System.out.println();
	}
    
    // least profitable product for supplier one
	public static void getLeastProfitableProduct() {
	    Sales leastProfit = sales.getSales()[0][1];			
	    for(int i=1; i<sales.getSales()[0].length; i++) {
	    	if(sales.getSales()[0][i].getSalesPrice() - supplier1.getProducts()[Integer.parseInt(sales.getSales()[0][i].getProduct().substring(1))].getPrice() < 
	    				leastProfit.getSalesPrice() - supplier1.getProducts()[Integer.parseInt(leastProfit.getProduct().substring(1))].getPrice()) {
	    		leastProfit = sales.getSales()[0][i];
	    	}
	    }
	   
   
	    System.out.println(supplier1.getProducts()[Integer.parseInt(leastProfit.getProduct().substring(1))].ID);
	    System.out.println(supplier1.getProducts()[Integer.parseInt(leastProfit.getProduct().substring(1))].title);
	    System.out.println(supplier1.getProducts()[Integer.parseInt(leastProfit.getProduct().substring(1))].rate);
	    System.out.println(supplier1.getProducts()[Integer.parseInt(leastProfit.getProduct().substring(1))].numberOfReviews);
	    System.out.println(supplier1.getProducts()[Integer.parseInt(leastProfit.getProduct().substring(1))].price);
	    System.out.println("----->" + " least profit: " + (leastProfit.getSalesPrice() - supplier1.getProducts()[Integer.parseInt(leastProfit.getProduct().substring(1))].getPrice()));
    //


    System.out.println();
    
	}
	
	
    // total profit    
	public static void getTotalProfit() {
    long total_profit = 0;
    Supplier[] suppliers = {supplier1, supplier2, supplier3};
    for(int s = 0; s<3; s++){
	    for(int i=1; i<sales.getSales()[s].length; i++) {
	    	total_profit += sales.getSales()[s][i].getSalesPrice() - suppliers[s].getProducts()[Integer.parseInt(sales.getSales()[s][i].getProduct().substring(1))].getPrice();
	    	

	    	
	    }
    }
    System.out.println("-----> total profit: " + total_profit);
	
	    
	}
	
	
	    

}