import java.util.*;
import java.io.File;
import java.io.FileWriter;
public class Supplier extends Company{
	Scanner sc=new Scanner(System.in);
	protected String Name,Proname;
	protected double Proprice,profits,Shippingcost;
	protected int Procount;
	int check;
	ArrayList<String> name = new ArrayList<String>();
	ArrayList<String> pname = new ArrayList<String>();
	ArrayList<Double> price = new ArrayList<Double>();
	ArrayList<Integer> Count = new ArrayList<Integer>();
	ArrayList<Integer> ProId = new ArrayList<Integer>();
	ArrayList<Double> Shipcost = new ArrayList<Double>();
	ArrayList<Double> Profits = new ArrayList<Double>();
	void getInput(int Id) {
		try {
			System.out.println("Enter Suppliers Name");
			Name=sc.nextLine();
			name.add(Name);
			System.out.println("Enter Products Name");
			Proname=sc.nextLine();
			pname.add(Proname);
			System.out.println("Enter the Price of Single Product");
			Proprice=sc.nextDouble();
			price.add(Proprice);
			System.out.println("Enter the Count ");
			Procount=sc.nextInt();
			Count.add(Procount);
			System.out.println("Enter the shipping cost ");
			Shippingcost=sc.nextDouble();
			Shipcost.add(Shippingcost);
			System.out.println("Your Product Id is :"+Id);
			ProId.add(Id);
			Profits.add(null);
		}
		catch(Exception e) {
			System.out.println("Enter details In order");
		}
		}
	void display(int Position) {
		System.out.println("=========================================================================");
		System.out.println("Product Id : "+ProId.get(Position));
		System.out.println("Name : "+name.get(Position));
		System.out.println("Prodcts Name : "+pname.get(Position));
		System.out.println("Price Per Piece : "+price.get(Position));
		System.out.println("Number Of Products In Stalk : "+Count.get(Position));
		System.out.println("Shipping cost per piece : "+Shipcost.get(Position));
		System.out.println("=========================================================================");
		}
	boolean search(int id) {
		for(int i=0;i<ProId.size();i++) {
			if(ProId.get(i)==id) {
				display(i);
				return (true);
			}
		}
		return false;
	}
	
	//=============================================================================================
	//=============================================================================================
	boolean searchbuy(int id) {
		boolean get;
		for(int i=0;i<ProId.size();i++) {
			if(ProId.get(i)==id) {
				get=displaybuy(i);
				return get;
			}
		}
		return false;
		
	}
	boolean displaybuy(int pos) {
		System.out.println("===============================================================================");
		System.out.println("Product Id : "+ProId.get(pos));
		System.out.println("Name : "+name.get(pos));
		System.out.println("Prodcts Name : "+pname.get(pos));
		System.out.println("Price Per Piece : "+price.get(pos));
		System.out.println("Number Of Products In Stalk : "+Count.get(pos));
		System.out.println("Shipping cost per piece : "+Shipcost.get(pos));
		System.out.println("================================================================================");
		try {
			System.out.println("Enter the Number of Stock you want");
			Buycount=sc.nextInt();
			if(Buycount>Count.get(pos)) {
				System.out.println("You Cant buy More Than the Stock");
				return false;
			}
		}
		catch(Exception e){
			System.out.println("Enter Integer value ");
		}
		Buyprice=(Buycount*price.get(pos)+(Shipcost.get(pos)*(Count.get(pos)/5)));
		System.out.println("\nThe Total Price would be : "+Buyprice);
		System.out.println("Would you Like to buy\n1)YES\n2)NO");
		 Buychoice=sc.nextInt();
		if(Buychoice==1) {
			System.out.println("=====================You have Succesfully Bought the Product=================");
			c=Count.get(pos)-Buycount;
			Count.set(pos,c);	
			return (true);
		}
		else{
			return false;
		}
	}

	//=============================================================================================
	//=============================================================================================
	boolean searchSuppProfit(int id) {
		for(int i=0;i<ProId.size();i++) {
			if(ProId.get(i)==id) {
				displaySuppProfit(i);
				return (true);
			}
		}
		return false;
	}
	void displaySuppProfit(int pos) {
		profits=profits+Buyprice-(Shipcost.get(pos)*(Count.get(pos)/5));
		if(profits>0) {
			Profits.set(pos,profits);
			
			System.out.println("===============IN PROFIT=================================================================");
			System.out.println("Product Id : "+ProId.get(pos));
			System.out.println("Name : "+name.get(pos));
			System.out.println("Prodcts Name : "+pname.get(pos));
			System.out.println("Your Profit is : "+Profits.get(pos));
			System.out.println("================================================================================");
		
		}
		else {
			Profits.set(pos,profits);
			
			System.out.println("===============IN LOSS=================================================================");
			System.out.println("Product Id : "+ProId.get(pos));
			System.out.println("Name : "+name.get(pos));
			System.out.println("Prodcts Name : "+pname.get(pos));
			System.out.println("Your Loss is : "+Profits.get(pos));
			System.out.println("================================================================================");
		
		}
	}
	//=============================================================================================
	//=============================================================================================
	void addSFileDetails(int i) {
		
		try{
			FileWriter fw=new FileWriter("Supplier.txt",true);
			fw.write(fileSwrite(i));
			fw.close();
			
		}catch(Exception e) {
			System.out.println("Cant create over and Over");
		}
	}
	boolean searchSWriteFile(int id) {
		for(int i=0;i<ProId.size();i++) {
			if(ProId.get(i)==id) {
				addSFileDetails(i);
				return (true);
			}
		}
		return false;
	}
	String fileSwrite(int Position) {
		String s="=========================================================================\nProduct Id : "+ProId.get(Position)+"\nName : "+name.get(Position)+"\nProdcts Name : "+pname.get(Position)+"\nPrice Per Piece : "+price.get(Position)+"Shipping cost per piece : "+Shipcost.get(Position)+"\n=========================================================================";
		return s;
	}
	//=============================================================================================
	//=============================================================================================
	boolean searchSFile(int id) {
		for(int i=0;i<ProId.size();i++) {
			if(ProId.get(i)==id) {
				DisplaySFile();
				return (true);
			}
		}
		return false;
	}
	void DisplaySFile() {
		File myFile=new File("Supplier.txt");
		try {
			Scanner sc=new Scanner(myFile);
			while(sc.hasNextLine()) {
				String line=sc.nextLine();
				System.out.println(line);
			}
			sc.close();
		}
		catch(Exception e) {
			System.out.println("File not found");
		}
	}
	//=============================================================================================
	//=============================================================================================
	void deleteSfile() {
		File myFile1=new File("Supplier.txt");
		if(myFile1.delete()) {
			System.out.println("I have deleted: "+myFile1.getName());
		}
		else {
			System.out.println("Some error has occured");
		}
	}
}


























