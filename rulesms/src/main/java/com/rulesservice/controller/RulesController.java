package com.rulesservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.rulesservice.exception.MinimumBalanceException;
import com.rulesservice.feign.AccountFeign;
import com.rulesservice.model.Account;
import com.rulesservice.model.AccountInput;
import com.rulesservice.model.RulesInput;
import com.rulesservice.service.RulesService;

@RestController
public class RulesController {

	private static final String INVALID = "Send Valid Details.";
	@Autowired
	public RulesService rulesService;
	@Autowired
	AccountFeign accountFeign;

	@PostMapping("/evaluateMinBal")
	public ResponseEntity<?> evaluate(@RequestBody RulesInput account)
			throws MinimumBalanceException {
	
		if (account.getCurrentBalance()== 0) {
			throw new MinimumBalanceException(INVALID);
		} else {
			boolean status = rulesService.evaluate(account);

			return new ResponseEntity<Boolean>(status,HttpStatus.OK);
		}
	}

	
	@PostMapping("/serviceCharges")
	public ResponseEntity<?> serviceCharges(@RequestHeader("Authorization") String token) {
		
		rulesService.hasPermission(token);
		

		try {
			List<Account> body = accountFeign.getAllacc(token).getBody();
			for(Account acc:body) {
				double detected=acc.getCurrentBalance()/10;
				if(acc.getCurrentBalance()<1000 && (acc.getCurrentBalance()-detected)>0)
					accountFeign.servicecharge(token, new AccountInput(acc.getAccountId(),detected));
				
			}
			
		} catch (Exception e) {
			
		}

		return ResponseEntity.ok(accountFeign.getAllacc(token).getBody());
	}

	
	public ResponseEntity<String> evalMinimumBalanceFallback(){//@RequestHeader("Authorization") String token@RequestBody RulesInput account)
	return new ResponseEntity<String>("Minimum balance criteria fail", HttpStatus.BAD_GATEWAY);
	}

}
