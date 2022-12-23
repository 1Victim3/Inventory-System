import java.util.*;
import java.io.File;
import java.io.FileWriter;
public class Company extends Inventorymain  {
	public static int Buycount,changecount;
	public static double loss,Buyprice;
	public static int Buychoice;
	public int c;
	ArrayList<Double> bPrice = new ArrayList<Double>();
	ArrayList<Integer> bCount = new ArrayList<Integer>();
	ArrayList<Integer> buyId = new ArrayList<Integer>();
	ArrayList<Double> Losses = new ArrayList<Double>();
	Scanner sc=new Scanner (System.in);
	void buy(int BuyID) {
		buyId.add(BuyID);
		System.out.println("Your Brought ID Would be : "+BuyID);
		bPrice.add(Buyprice);
		bCount.add(Buycount);
		Losses.add(null);
		BuyID++;
	}
	boolean searchboughtDetails(int id) {
		for(int i=0;i<buyId.size();i++) {
			if(buyId.get(i)==id) {
				BoughtDisplay(i);
				return true;
			}
		}
		System.out.println("Product Not found");
		return false;
	}
	void BoughtDisplay(int i) {
		System.out.println("============Bought Details=====================================================");
		System.out.println("Your Bought Id : "+buyId.get(i));
		System.out.println("The Total Price You Bought it for : "+bPrice.get(i));
		System.out.println("The Total Stock You Bought : "+bCount.get(i));
		System.out.println("================================================================================");
	}
	
	boolean searchboughtloss(int id) {
		for(int i=0;i<buyId.size();i++) {
			if(buyId.get(i)==id) {
				lossDisplay(i);
				return true;
			}
		}
		System.out.println("Product Not found");
		return false;
	}
	void lossDisplay(int i) {
		System.out.println("============In LOSS=====================================================");
		System.out.println("Your Bought Id : "+buyId.get(i));
		System.out.println("The Total Price You Bought it for : "+bPrice.get(i));
		System.out.println("The Total Stock You Bought : "+bCount.get(i));
		loss=loss+bPrice.get(i);
		Losses.set(i,loss);
		System.out.println("Your LOSS is : "+Losses.get(i));
		System.out.println("================================================================================");
	}
	//=============================================================================================
	//=============================================================================================
	void addCFileDetails(int i) {
		
		try{
			FileWriter fw=new FileWriter("Company.txt",true);
			fw.write(fileCwrite(i));
			fw.close();
			
		}catch(Exception e) {
			System.out.println("Cant create over and Over");
		}
	}
	boolean searchCWriteFile(int id) {
		for(int i=0;i<buyId.size();i++) {
			if(buyId.get(i)==id) {
				addCFileDetails(i);
				return (true);
			}
		}
		return false;
	}
	String fileCwrite(int i) {
		String s="=========================================================================\nBought Id : "+buyId.get(i)+"\nThe Total Price You Bought it for : "+bPrice.get(i)+"\nThe Total Stock You Bought : "+bCount.get(i)+"Your LOSS is : "+Losses.get(i)+"\n=========================================================================";
		return s;
	}
	//=============================================================================================
	//=============================================================================================
	boolean searchCFile(int id) {
		for(int i=0;i<buyId.size();i++) {
			if(buyId.get(i)==id) {
				DisplayCFile();
				return (true);
			}
		}
		return false;
	}
	void DisplayCFile() {
		File myFile=new File("Company.txt");
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
	void deleteCfile() {
		File myFile2=new File("Company.txt");
		if(myFile2.delete()) {
			System.out.println("I have deleted: "+myFile2.getName());
		}
		else {
			System.out.println("Some error has occured");
		}
	
	}
}
