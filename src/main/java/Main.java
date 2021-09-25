import java.util.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.util.Random;
public class Main {

	
	
	public static void main(String[] args) {
		
		ArrayList <BankAccounts> account = new ArrayList();
		int key;
		
	while (true){
		System.out.println("******Welcome to Main Menu******");
		System.out.println("1. Open New Account: "+"\n");
		System.out.println("2. Close An Account: "+"\n");
		System.out.println("3. Login To Account: "+"\n");
		System.out.println("4. View Accounts: "+"\n");
		System.out.println("5. Exit: "+"\n");
		
		
		System.out.println("Enter your choice: ");
		Scanner input=new Scanner(System.in);
		key=input.nextInt();
		
		BankAccounts BA;
		BankAccounts bankacc;
		Checking check;
		Savings save;
		
		
		switch(key)
		{
		case 1:
			Scanner scan=new Scanner(System.in);
			System.out.println("Enter your First Name");
			String fn=scan.next();
			System.out.println("Enter your Last Name");
			String ln=scan.next();
			System.out.println("Enter your Address");
			String add=scan.next();
			System.out.println("Enter your Phone No");
			String pno=scan.next();
			
			Random rand=new Random();
			int upperbound=1000;
			int accno=rand.nextInt(upperbound);
			//int accno=BA.generateRandNo();
			System.out.println("Enter Balance: ");
			int bal=scan.nextInt();
			System.out.println("Select Type of your Account: "+"\n");
			System.out.println("1. Checking Accounts");
			System.out.println("2. Saving Accounts");
			int type=scan.nextInt();
			System.out.println("\n");
		//	System.out.println("Date(day-month-year) Creation: ");
			//LocalDateTime date=LocalDateTime.now();
			//String date=scan.next();
			
			BA= new BankAccounts(fn,ln,add,accno,bal,pno,type);
		account.add(BA);
		System.out.println("Opening Bank Account");	
		
			BA.DisplayDetails();
			
			break;
		case 2:
			
			
			Scanner delete=new Scanner(System.in);
			System.out.println("Enter your Account Number: ");
			int accnumber=delete.nextInt();
			
			for(int i=0;i<account.size();i++)
			{
				if(account.get(i).getAccNo()==accnumber)
				{
				//	System.out.println("AfD");
					account.remove(i);
					System.out.println("Account Closed!");
				}
			}
			break;
			
		case 3:
			int option;
			Scanner var=new Scanner(System.in);
			System.out.println("Enter your Account Number: ");
			int var1=var.nextInt();
			
			
			for(int i=0;i<account.size();i++)
			{
				
				if(account.get(i).getAccNo()==var1)
				{
					
					if(account.get(i).getType()==1)
					{
						System.out.println("Welcome to your Checking Account");
						System.out.println("1. Deposit Cash "+"\n");
						System.out.println("2. Withdraw Cash "+"\n");
						System.out.println("3. Display Balance "+"\n");
						System.out.println("4. Deduction History" +"\n");
						System.out.println("5. Transfer Amount "+"\n");
						
					
						
				check= new Checking(account.get(i).getFName(),account.get(i).getLName(),account.get(i).getAddress(),
						account.get(i).getAccNo(),account.get(i).getBalance(),
						account.get(i).getPhoneNo(),account.get(i).getType());
				System.out.println("Enter your choice: ");
				//Scanner input2=new Scanner(System.in);
				option=var.nextInt();
				
				switch(option)
				{
				case 1:
			//		check.makeDeposit();
					account.set(i, check);
					break;
					
				case 2:
				//	check.makeWithdrawl();
					account.set(i, check);
					break;
					
				case 3:
					check.DisplayBalance();
					break;
					
				case 4:
					check.AllDeductions();
					break;
					
				case 5:
				
				 check.TransferAmount();
					break;
			}
					}
					
					else if(account.get(i).getType()==2)
					{
						System.out.println("Welcome to your Savings Account");
						System.out.println("1. Deposit Cash "+"\n");
						System.out.println("2. Withdraw Cash "+"\n");
						System.out.println("3. Display Balance "+"\n");
						System.out.println("4. Deduction History" +"\n");
						System.out.println("5. Transfer Amount "+"\n");
						System.out.println("6. Zakaat Calucate "+"\n");
						System.out.println("7. Interest Rate "+"\n");
						
						int option1=var.nextInt();
						
						save= new Savings (account.get(i).getFName(),account.get(i).getLName(),account.get(i).getAddress(),
								account.get(i).getAccNo(),account.get(i).getBalance(),
								account.get(i).getPhoneNo(),account.get(i).getType());
						
						switch(option1)
						{
						case 1:
						//	save.makeDeposit();
							account.set(i, save);
							break;
							
						case 2:
						//	save.makeWithdrawl();
							account.set(i, save);
							break;
							
						case 3:
							save.DisplayBalance();
							break;
							
						case 4:
							save.AllDeductions();
							break;
						
						case 5:	
							save.TransferAmount();
							break;
							
						
						case 6:
						//	save.calculateZakat();
							account.set(i, save);
							break;
							
						case 7:
						//	save.calculateInterest();
							account.set(i,save);
							break;
						
						}
					}
				}
			}
			break;
		
		case 4:
			System.out.println("Accounts in Bank: ");
			for(int l=0;l<account.size();l++)
			{
				
				account.get(l).DisplayDetails();
			}
			break;
		
		
			
		case 5:
			System.exit(0);
			
		
			
		}
		
		
		}
	}

}
