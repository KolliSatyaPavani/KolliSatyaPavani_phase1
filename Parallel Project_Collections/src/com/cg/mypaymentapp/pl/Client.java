package com.cg.mypaymentapp.pl;

import java.math.BigDecimal;
import java.util.Scanner;

import com.cg.mypaymentapp.beans.Customer;
import com.cg.mypaymentapp.beans.Wallet;
import com.cg.mypaymentapp.service.WalletService;
import com.cg.mypaymentapp.service.WalletServiceImpl;



public class Client 
{
	private WalletService walletService;

	public Client() 
	{
		walletService = new WalletServiceImpl();
	}

	public void menu()
	{
		Scanner console = new Scanner( System.in );

		System.out.println("1) Create Account"); 
		System.out.println("2) Show Balance");
		System.out.println("3) Fund Transfer");
		System.out.println("4) Deposit Amount");
		System.out.println("5) Withdraw Amount");

		System.out.print("\nEnter Your Choice: ");
		int choice = console.nextInt();
	switch (choice) {
	case 1:
	
		
			System.out.println("Enter Name of the Customer: ");
			String cName = console.next();

			System.out.println("Enter Phone Number: ");
		String cMobileno = console.next();

			System.out.println("Enter amount ");
			BigDecimal cAmount= console.nextBigDecimal();
			Wallet wallet = new Wallet();
			wallet.setBalance(cAmount);
			
			Customer customer = new Customer();
			customer.setName(cName);
			customer.setMobileNo(cMobileno);
			customer.setWallet(wallet);
			customer = walletService.createAccount(cName, cMobileno, cAmount);
		 System.out.println("Your Account is successfully created");
	
				
		break;
	case 2: System.out.println("Enter mobile number");
	String mobileno = console.next();
	Customer c = walletService.showBalance(mobileno);
	System.out.println("Name:"+c.getName());
	System.out.println("Mobile Number:"+c.getMobileNo());
	System.out.println("Amount:"+c.getWallet().getBalance());
	break;
	case 3: System.out.println("Enter source mobile no.");
	String source = console.next();
	System.out.println("Enter target mobile no.");
	String target = console.next();
	System.out.println("Enter amount to transfer");
	BigDecimal amt = console.nextBigDecimal();
	customer = walletService.fundTransfer(source, target, amt);
	 System.out.println("Amount is transferred succesfully");
	 break;
	case 4:
		System.out.println("Enter mobile no.");
		String mob = console.next();
		System.out.println("Enter amount to deposit");
		BigDecimal amount = console.nextBigDecimal();
		customer = walletService.depositAmount(mob, amount);
		 System.out.println("Amount "+amount+ "is deposited succesfully");
		 break;
	case 5:
		System.out.println("Enter mobile no.");
		String mobile = console.next();
		System.out.println("Enter amount to withdraw");
		BigDecimal amnt = console.nextBigDecimal();
		customer = walletService.withdrawAmount(mobile, amnt);
		 System.out.println("Amount "+amnt+ "is withdrawn succesfully");
		 break;
	
	default: System.out.println("invalid option");
		break;
	}}	
		
	public static void main(String[] args) {
		Client client = new Client();
		//makes sure application runs forever unless you close it
		while(true)
			client.menu();
		
		
		
	}
	

	
	
	
	
	
	

}
