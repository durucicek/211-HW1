import java.io.IOException;

public class SalesQuery {
	Customer[] customers;
	Supplier supplier1;
	Supplier supplier2;
	Supplier supplier3;
	SalesManagement sales;
	
	
	
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
		Sales[] s2_salesArray = FileIO.getSalesforSuppilerOne(s2_productArray);
		Sales[] s3_salesArray = FileIO.getSalesforSuppilerOne(s3_productArray);
		sales = new SalesManagement(s1_salesArray, s2_salesArray, s3_salesArray);
	
	    
		
		// max product price 
		Sales maxSalesPrice = s1_salesArray[1];				//indexte problem olabilir
	    for(int i=2; i<s1_salesArray.length; i++) {
	        if(s1_salesArray[i].getSalesPrice()>=maxSalesPrice.getSalesPrice()) 
	            maxSalesPrice=s1_salesArray[i];
	    }
	    
	    System.out.println(s1_productArray[Integer.parseInt(maxSalesPrice.product.substring(1))].ID);
	    System.out.println(s1_productArray[Integer.parseInt(maxSalesPrice.product.substring(1))].title);
	    System.out.println(s1_productArray[Integer.parseInt(maxSalesPrice.product.substring(1))].rate);
	    System.out.println(s1_productArray[Integer.parseInt(maxSalesPrice.product.substring(1))].numberOfReviews);
	    System.out.println(s1_productArray[Integer.parseInt(maxSalesPrice.product.substring(1))].price);
	    System.out.println("----->" + " with sales price: " + maxSalesPrice.salesPrice);
	    // 
	    
	   
	    System.out.println();
	    
	    
	    
	    // max profit
	    Sales maxProfit = s1_salesArray[1];    
	    for(int m=1; m<s1_salesArray.length; m++) {
	    	if(s1_salesArray[m].getSalesPrice() - s1_productArray[Integer.parseInt(s1_salesArray[m].getProduct().substring(1))].getPrice() > 
	    					maxProfit.getSalesPrice() - s1_productArray[Integer.parseInt(maxProfit.getProduct().substring(1))].getPrice())
	    		maxProfit = s1_salesArray[m];
	    	

	    }
	   
	    System.out.println(s1_productArray[Integer.parseInt(maxProfit.product.substring(1))].ID);
	    System.out.println(s1_productArray[Integer.parseInt(maxProfit.product.substring(1))].title);
	    System.out.println(s1_productArray[Integer.parseInt(maxProfit.product.substring(1))].rate);
	    System.out.println(s1_productArray[Integer.parseInt(maxProfit.product.substring(1))].numberOfReviews);
	    System.out.println(s1_productArray[Integer.parseInt(maxProfit.product.substring(1))].price);
	    System.out.println("----->" + " most profit: " + (maxProfit.getSalesPrice() - s1_productArray[Integer.parseInt(maxProfit.product.substring(1))].price));
		//
	
	    
	    System.out.println();
	    
	    
	    // least profit product
	    Sales leastProfit = s1_salesArray[1];			
	    for(int n=1; n<s1_salesArray.length; n++) {
	    	if(s1_salesArray[n].getSalesPrice() - s1_productArray[Integer.parseInt(s1_salesArray[n].getProduct().substring(1))].getPrice() < 
	    				leastProfit.getSalesPrice() - s1_productArray[Integer.parseInt(leastProfit.getProduct().substring(1))].getPrice()) {
	    		leastProfit = s1_salesArray[n];
	    	}
	    }
	   
   
	    System.out.println(s1_productArray[Integer.parseInt(leastProfit.product.substring(1))].ID);
	    System.out.println(s1_productArray[Integer.parseInt(leastProfit.product.substring(1))].title);
	    System.out.println(s1_productArray[Integer.parseInt(leastProfit.product.substring(1))].rate);
	    System.out.println(s1_productArray[Integer.parseInt(leastProfit.product.substring(1))].numberOfReviews);
	    System.out.println(s1_productArray[Integer.parseInt(leastProfit.product.substring(1))].price);
	    System.out.println("----->" + " least profit: " + (leastProfit.getSalesPrice() - s1_productArray[Integer.parseInt(leastProfit.getProduct().substring(1))].getPrice()));
	    //
	
	
	    System.out.println();
	    
	    
	    // total profit    
	    long total_profit = 0;
	    for(int k=1; k<s1_salesArray.length; k++) {
	    	total_profit += s1_salesArray[k].getSalesPrice() - s1_productArray[Integer.parseInt(s1_salesArray[k].getProduct().substring(1))].getPrice();
	    }
	    
	    System.out.println("-----> total profit: " + total_profit);
	    //
	
	    
	}
	    

}