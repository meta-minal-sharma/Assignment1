import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;


public class Cart {

	static HashMap<Integer, Product> hm; 
	static ArrayList<Product> a1;
	static Scanner s1;
	static int num;
	
	public Cart() 
	{
		 s1=new Scanner(System.in);	
		 hm=new HashMap<Integer, Product>();
	}

	void addToCart()
	{
		String pName;
		int found=0;
	
		System.out.println("Enter Product/Item Name :: ");
			pName=s1.next();
			
			Iterator<Product> i=a1.iterator();
			
			Set s=hm.entrySet();
			Iterator i1=s.iterator();
			
			
			while(i.hasNext())
			{
				Product p=(Product)i.next();
				if(p.productName.equals(pName))
				{	
				
					while(i1.hasNext())	
						{
							Map.Entry e=(Map.Entry)i1.next();
							Integer k =(Integer)e.getKey();
							Product p1 =(Product)e.getValue();
							
							if(p1==p)
							{
								p.quantity++;
								hm.put(k,p);
								found=1;
							}
						}
					if(found==0)
					{
						found=1;
						p.quantity++;
						num++;
						hm.put(num,p);
					}
				}
			}
			if(found==0)
				System.out.println(" No such product found please enter valid product name");
			else
				System.out.println(" item added to cart successfully");
			
		
	}
	
	
	void displayCart()
	{
		int n=0,found=0,t=0,k;
		String pName;
		Set s=hm.entrySet();
		Iterator i=s.iterator();
		boolean status = false;
		Integer k1= null;
		Product p1 = null;
		if(i.hasNext())
		{
			while(i.hasNext())
		
			{
				Map.Entry e=(Map.Entry)i.next();
				 Product p =(Product)e.getValue();
				System.out.println(p.productName+"  "+p.price+"  "+p.quantity);
			
			}
			System.out.println(" ");
			System.out.println(" ");
			
			System.out.println("1. Update");
			System.out.println("2. billing");
			System.out.println("Enter your choice :: ");
			
			n=s1.nextInt();
			switch(n)
			{
				case 1:
					System.out.println(" ");
					System.out.println(" ");
					System.out.println("Enter Product/Item Name :: ");
					pName=s1.next();
					Iterator i1=s.iterator();
					while(i1.hasNext())
						
					{
						Map.Entry e=(Map.Entry)i1.next();
						 k1 =(Integer)e.getKey();
						 p1 =(Product)e.getValue();
						if(p1.productName.equals(pName))
						{	
							found=1; 
							break;
						}
					
					}
					
					if(found==0)
						System.out.println(" No such product found please enter valid product name");
					else
					{
						System.out.println("1. Update Quantity");
						System.out.println("2. remove");
						System.out.println("Enter your choice :: ");
						t=s1.nextInt();
						switch(t)
						{
							case 1: 
									    updateQuantity(k1);
										System.out.println("updated item successfully");
									break;
							case 2: 
									deleteFromCart(k1);
										System.out.println("Deleted item successfully");
									break;
							
							default: 
								System.out.println(" You did not entered a valid Choice");	
						}
						
					}
						break;
				case 2: 
						billing();
						break;
				default: 
					System.out.println(" You did not entered a valid Choice");
			}
		}
		else
			System.out.println("Cart is empty");
	}
	
	
	
	void deleteFromCart(Integer k1)
	{
		Product returned_value = (Product)hm.remove(k1); 
	}

	
	
	void  billing ()
	{
		Set s=hm.entrySet();
		Iterator i=s.iterator();
		double total=0.0;
		if(i.hasNext())
		{
			while(i.hasNext())
		
			{
				Map.Entry e=(Map.Entry)i.next();
				 Product p =(Product)e.getValue();
				total += p.quantity * p.price;
			
			}
		}
		System.out.println("  TOTAL BILL =  "+total);
	}
	
	
	void viewProducts()
	{
		Iterator<Product> i=a1.iterator();
		while(i.hasNext())
		{
			Product p=(Product)i.next();
			System.out.println(p.productName+"     "+p.price);
		}
	}
	
	
	
	void updateQuantity(Integer k1)
	{
		int t=0;
		Product val = (Product)hm.get(k1);
		System.out.println("Enter total quantity :: ");
		t=s1.nextInt();
		val.quantity=t;
	}
	
	
	public static void main(String arg[])
	{
		int choice=0, exit=0;
		Product p1=new Product("watch",250.50);
		Product p2=new Product("shoes",700);
		Product p3=new Product("jacket",300);
		
		a1=new ArrayList<Product>(); 
		a1.add(p1);
		a1.add(p2);
		a1.add(p3);

		
		Cart c=new Cart();
		while(exit==0)
		{
			System.out.println("1. Add items to cart");
			System.out.println("2. Display cart");
			System.out.println("3. View all items");
			System.out.println("4. Exit");
			System.out.println("Enter your Choice");
			choice=s1.nextInt();
			
			switch (choice)
			{
				case 1:
						c.addToCart();
						break;

				case 2:
						c.displayCart();
						break;

				case 3:
						c.viewProducts();
						break;

				case 4:
						exit=1;
						break;

				default:
					System.out.println(" You did not entered a valid Choice");
						
			}
			
			
		}
	}

}

