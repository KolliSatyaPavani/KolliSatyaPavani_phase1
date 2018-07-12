package com.cg.mypaymentapp.repo;

import java.util.HashMap;
import java.util.Map;

import com.cg.mypaymentapp.beans.Customer;
import com.cg.mypaymentapp.exception.InvalidInputException;

public class WalletRepoImpl implements WalletRepo{

	private Map<String, Customer> data ; 
	public WalletRepoImpl(Map<String, Customer> data) {
		super();
		this.data = data;
	}
	public WalletRepoImpl()
	{
		data = new HashMap<String, Customer>();
	}

	public boolean save(Customer customer) {
		
		
		//Customer c = findOne(customer.getMobileNo());
		//if(c== null)
		
			data.put(customer.getMobileNo(), customer);
			return true;
		
	}

	public Customer findOne(String mobileNo) {
		Customer customer = data.get(mobileNo);
		if(customer == null)
			throw new InvalidInputException("Customer not found with mobileNo"+mobileNo);
			return customer;
		
	}
}
