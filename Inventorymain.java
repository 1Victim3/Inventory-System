import java.util.*;
import java.io.File;
public class Inventorymain {

	public static void main(String[] args) {
		
		int ch,Id=1,ProId,bId=1,sn=0,sn1=0,ch2,ch3;
		int buyid;
		Supplier[] b=new Supplier[1000];
		Company[] c=new Company[10000];
		Supplier b1=new Supplier();
		Scanner sc=new Scanner(System.in);
		File SuppliersFile=new File("Supplier.txt");
		File CompanyFile=new File("Company.txt");
		  try{
			  SuppliersFile.createNewFile();
			  CompanyFile.createNewFile();
		  }catch(Exception e) {
			  //IO Exception occurs
			  System.out.println("Enable to create a file");
		  }
		System.out.println("..................Welcome To Inventory...................");
		try {
			do {
				  System.out.println("================================================================================");
				  System.out.println("\nEnter Following Choices \n0)Exit\n1)Supplier\n2)Company\n");
				  System.out.println("================================================================================");
				  ch=sc.nextInt();
				  
				  switch(ch) {
				//=====================================================================================================================================
				  case 0:{
					  System.out.println("Exit");
					  break;
				  }
				//=====================================================================================================================================
				  case 1:
				  { 
					  try{
					  System.out.println("================================================================================");
					  System.out.println("Enter \n1: Add Supplies\n2: Display details\n3: Profit And Loss\n4: Add Details to File\n5:Read a File\n6:To Delete contents in file");
					  System.out.println("================================================================================");
					  ch2=sc.nextInt();
					  switch(ch2){
					//--------------------------------------------------------------------------------------------------------------------------------------
					  case 1:
					  {
						  b[sn]=new Supplier();
						  b[sn].getInput(Id);
						  Id++;
						  sn++;
						  break;
					  }
					//--------------------------------------------------------------------------------------------------------------------------------------
					  case 2:{
						  System.out.println("Enter the Product Id you want to search");
						  ProId=sc.nextInt();
						  boolean got=false;
						  for(int i=0;i<=b.length;i++) {
							  got=b[i].search(ProId);	
							  if(got) {
								  break;
							  }
						  }
						  if(!got) {
							  System.out.println("We cant Find The Product");
						  	}
					  
					  	break;
					  	}
					  //--------------------------------------------------------------------------------------------------------------------------------------
					  case 3:{
						  System.out.println("Enter the Product Id you want to search the Profit And Loss for");
						  ProId=sc.nextInt();
						  boolean got=false;
						  for(int i=0;i<=b.length;i++) {
							  got=b[i].searchSuppProfit(ProId);	
							  if(got) {
								  break;
							  }
						  }
						  if(!got) {
							  System.out.println("We can not Find The Product");
						  	}
					  	
					  break;}
					//--------------------------------------------------------------------------------------------------------------------------------------
					  case 4:{
						 System.out.println("Enter the Product Id you want write im file");
						  ProId=sc.nextInt();
						  boolean got=false;
						  for(int i=0;i<=b.length;i++) {
							  got=b[i].searchSWriteFile(ProId);	
							  if(got) {
								  break;
							  }
						  }
						  if(!got) {
							  System.out.println("We can not Find The Product");
						  	}
					  break;
					  }
					//--------------------------------------------------------------------------------------------------------------------------------------
					  case 5:{
						  System.out.println("Enter the Product Id you want read in file");
						  ProId=sc.nextInt();
						  boolean got=false;
						  for(int i=0;i<=b.length;i++) {
							  got=b[i].searchSFile(ProId);	
							  if(got) {
								  break;
							  }
						  }
						  if(!got) {
							  System.out.println("We can not Find The Product");
						  	}
						  
						  break;
						  }
					  case 6:{
						  		  b1.deleteSfile();
						  	  
						  break;
					  }
						  
					  }//end of Suppliers Switch
					  
					  }//end of tryblock
				  
				  catch(Exception e) {
					  System.out.println("There is no Stock in Invetory to Check");
				  }
				  break;
				  }
				  //=====================================================================================================================================
				  case 2:{
					  try {
						  System.out.println("================================================================================");
						  System.out.println("Enter \n1: To Buy Products \n2: Display Bought Product Details\n3: Profit and Loss\n4: Add Details to File\\n5:Read a File\\n6:To Delete contents in file");
						  System.out.println("================================================================================");
						  ch3=sc.nextInt();
						  switch(ch3) {
						  case 1:{
							  System.out.println("Enter the Product Id you want to Buy");
							  ProId=sc.nextInt();
							  boolean got=false;
							  for(int i=0;i<=b.length;i++) {
								  got=b[i].searchbuy(ProId);	
								  if(got) {
									  c[sn1]=new Company();
									  c[sn1].buy(bId);
									  sn1++;
									  bId++;
									  break;
								  }
							  }
							  if(!got) {
								  System.out.println("Transaction Failed");
							  	}
						  	break;
						  	}//end of inner case 1
						  case 2:{
							  System.out.println("Enter the Bought Id you want to search");
							  buyid=sc.nextInt();
							  boolean got=false;
							  for(int i=0;i<=b.length;i++) {
								  got=c[i].searchboughtDetails(buyid);	
								  if(got) {
									  break;
								  }
							  }
							  if(!got) {
								  System.out.println("We cant Find The Product");
							  	}
							break;  
						  }//end of inner Case 2
						  case 3:{
							  System.out.println("Enter the Bought Id you want to search Profit and Loss for");
							  buyid=sc.nextInt();
							  boolean got=false;
							  for(int i=0;i<=b.length;i++) {
								  got=c[i].searchboughtloss(buyid);	
								  if(got) {
									  break;
								  }
							  }
							  if(!got) {
								  System.out.println("We cant Find The Product");
							  	}
							break; 
						  	}//End of Inner Case 3
						//--------------------------------------------------------------------------------------------------------------------------------------
						  case 4:{
							 System.out.println("Enter the Bought Id you want write im file");
							  buyid=sc.nextInt();
							  boolean got=false;
							  for(int i=0;i<=b.length;i++) {
								  got=b[i].searchCWriteFile(buyid);	
								  if(got) {
									  break;
								  }
							  }
							  if(!got) {
								  System.out.println("We can not Find The Product");
							  	}
						  break;
						  }
						//--------------------------------------------------------------------------------------------------------------------------------------
						  case 5:{
							  System.out.println("Enter the Bought Id you want read in file");
							  buyid=sc.nextInt();
							  boolean got=false;
							  for(int i=0;i<=b.length;i++) {
								  got=b[i].searchCFile(buyid);	
								  if(got) {
									  break;
								  }
							  }
							  if(!got) {
								  System.out.println("We can not Find The Product");
							  	}
							  
							  break;
							  }
						  case 6:{
							  	  for(int i=0;i<=b.length;i++) {
							  		  b[i].deleteCfile();
							  	  }
							  break;
						  }
						  }//End of Inner Switch 1
					  break;
					  
					  }
					  catch(Exception e) {
						  System.out.println("Yo havnt Bought Anything from invetory");
					  }
				  break;
				  
				  }//End of case 2
				//=====================================================================================================================================
				  default:{
					  System.out.println("Wrong Choice Try Again");
					  break;
				  	}
				  }
			  }while(ch!=0);
		}catch(Exception e) {
			System.out.println("Enter Integers only (That is 0,1 and 2) and not special cases");
		}
		
	}

}
