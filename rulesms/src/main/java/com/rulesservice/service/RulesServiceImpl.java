package com.rulesservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.rulesservice.feign.AccountFeign;
import com.rulesservice.feign.AuthorizationFeign;
import com.rulesservice.exception.AccessDeniedException;
//import com.rulesservice.model.AccountInput;
import com.rulesservice.model.AuthenticationResponse;
import com.rulesservice.model.RulesInput;
import com.rulesservice.model.ServiceResponse;

@Service
public class RulesServiceImpl implements RulesService {
	
	@Autowired
	AuthorizationFeign authorizationFeign;

	 
 
	public boolean evaluate(RulesInput account) {
		int min=1000;
	  
		double check = account.getCurrentBalance() - account.getAmount();
	    	if(check >= min)
	    		return true;
	    	else
	    		return false;
	}
	
	public AuthenticationResponse hasPermission(String token) {
		
		AuthenticationResponse validity = authorizationFeign.getValidity(token);
		if (!authorizationFeign.getRole(validity.getUserid()).equals("EMPLOYEE"))
			throw new AccessDeniedException("NOT ALLOWED");
		else
			return validity;
	}

	public ServiceResponse serviceCharges(RulesInput account) {
		ServiceResponse response=new ServiceResponse();
		response.setAccountId(account.getAccountId());
				if(account.getCurrentBalance()<1000)
		{
		
			double deduction=account.getCurrentBalance()/10;
			response.setMessage("Your Balance is lesser than the minimum balance so "+deduction+" is detected from your account");
			response.setBalance(account.getCurrentBalance()- deduction);
		}
		else
		{
						response.setMessage("No Deduction");
			response.setBalance(account.getCurrentBalance());
		}
		return response;
	}


	
}
