package com.cognizant.transactionservice.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import com.cognizant.transactionservice.feign.AccountFeign;
import com.cognizant.transactionservice.feign.RulesFeign;
import com.cognizant.transactionservice.repository.TransactionRepository;
import com.cognizant.transactionservice.util.AccountInput;
import com.cognizant.transactionservice.util.TransactionInput;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class TransactionServiceTest {

	
	
	@InjectMocks
	TransactionService consumerService;
	
	@Mock
	private AccountFeign accountFeign;

	@Mock
	private TransactionRepository transactionRepository;

	@Mock
	private RulesFeign ruleFeign;


	
	@Test
	 public void getConsumerBusinessTest1() throws Exception {
		//Optional<Consumer> consumer=Optional.of(new Consumer(10, "Akash Kumar Soni", new Date(1997,07,01), "ABC123", "akashconsumer@mail.com", true, "akash@mail.com", "New Business"));
		TransactionInput inp=new TransactionInput();
		inp.setSourceAccount(new AccountInput(10054546,1000.0));
		inp.setTargetAccount(new AccountInput(10054546,1000.0));
		inp.setAmount(1000.0);
		inp.setReference("TRANSFER");
	
		
		assertThrows( Exception.class, ()->consumerService.makeTransfer("tokrn", inp));
		
	}

}
