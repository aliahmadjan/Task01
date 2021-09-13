import java.util.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Savings extends BankAccounts{
	

	static ArrayList <Integer> record = new ArrayList();
	
	
	public Savings(String fn,String ln,String address,int accno,int balance,String phoneno,int type)
	{
		
	super(fn,ln,address,accno,balance,phoneno,type);
	}
	
	public int makeDeposit()
	{
	   Scanner deposit=new Scanner(System.in);
	   System.out.println("Enter Amount to Deposit");
	   int cash= deposit.nextInt();
	   balance=(getBalance()+cash);
	   setBalance(balance);
	   record.add(balance);
	   System.out.println("Balance: "+getBalance());
	   return getBalance();
	   
	}
	
	public int makeWithdrawl()
	{
		Scanner withdrawl= new Scanner(System.in);
		System.out.println("Enter Amount to Withdrawl");
		int withcash=withdrawl.nextInt();
		balance=(balance-withcash);
		setBalance(balance);
		record.add(balance);
		System.out.println("Balance: "+getBalance());
		return getBalance();
	}
	
	public void DisplayBalance()
	{
		System.out.println("First Name: " +fname);
		System.out.println("Last Name: "+lname);
		System.out.println("Address: "+address);
		System.out.println("Phone No: "+phoneno);
		System.out.println("Account No: "+accno);
		LocalDateTime date=LocalDateTime.now()	;
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MMM-yyyy HH:mm:ss"); 
		String formatdate=date.format(myFormatObj);
		System.out.println("Creation Date: "+formatdate);
		System.out.println("Current Balance: "+balance);
	}
	
	public void AllDeductions()
	{
		System.out.println("--------------------");
		System.out.println("Your Account History: ");
		
		for (int i=0;i<record.size();i++)
		{
			System.out.println("New Amount was: "+record.get(i));
		}
			System.out.println("--------------------");
	}

	int zakat;
	
	public void calculateZakat()
	{
		zakat=(int)(balance*0.25);
		if(getBalance()>=20000)
		{
			balance -= zakat;
			setBalance(balance);
			System.out.println("Zakat has been deducted");
			System.out.println("Now balance left: "+getBalance());
			
		}
		
		else if(getBalance()<20000)
		{
			System.out.println("Insufficent Balance for Zakat");
		}
	}
	
	public void calculateInterest()
	{
		if(getBalance()>=5000)
		{
			Random rand= new Random();
			int upperlimit=3000;
			int interest=rand.nextInt(upperlimit);
			int interestrate=(int)((interest*5.50)/2);
			int balance=getBalance()+interestrate;
			setBalance(balance);
			System.out.println("Current Interest Rate: "+interestrate);
			System.out.println("Balance after interest rate: "+balance);
		}
	}
	
}

