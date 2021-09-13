import java.util.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class Checking extends BankAccounts {

	static ArrayList <Integer> record = new ArrayList();
	int Transfee=10;
	
	public Checking(String fn,String ln,String address,int accno,int balance,String phoneno,int type)
	{
		
	super(fn,ln,address,accno,balance,phoneno,type);
	}

	static int count=0;
	public int makeDeposit()
	{
	   Scanner deposit=new Scanner(System.in);
	   System.out.println("Enter Amount to Deposit");
	   int cash= deposit.nextInt();
	   balance=(getBalance()+cash)-Transfee;
	   setBalance(balance);
	   record.add(balance);
	   System.out.println("Balance: "+getBalance());
	   count++;
	   return getBalance();
	   
	}
	
	public int makeWithdrawl()
	{
		Scanner withdrawl= new Scanner(System.in);
		System.out.println("Enter Amount to Withdraw");
		int withcash=withdrawl.nextInt();
		
		if((getBalance()+5000)>=withcash)
		{
			balance=(balance-withcash)-Transfee;
			setBalance(balance);
			record.add(balance);
			System.out.println("Balance: "+getBalance());
			count++;
			return getBalance();
			
		}
		
		else
		{
			System.out.println("Amount Exceeded from 5000");
		}
	return getBalance();
	}
	
	public void DisplayBalance()
	{
		System.out.println("First Name: " +fname);
		System.out.println("Last Name: "+lname);
		System.out.println("Address: "+address);
		System.out.println("Phone No: "+phoneno);
		System.out.println("Account No: "+accno);
		LocalDateTime date=LocalDateTime.now();
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MMM-yyyy HH:mm:ss"); 
		String formatdate=date.format(myFormatObj);
		System.out.println("Creation Date: "+formatdate);
		System.out.println("Current Balance: "+balance);
	}
	
	public void AllDeductions()
	{
		System.out.println("Your Account History: ");
		
		for (int i=0;i<record.size();i++)
		{
			System.out.println("New Amount is: "+record.get(i));
		}
		System.out.println("--------------------");
		System.out.println("Transactions Made: "+count);
		System.out.println("Deduction made upon your transactions is 10Rs: "+(10*count));
		System.out.println("--------------------");
	}
}

