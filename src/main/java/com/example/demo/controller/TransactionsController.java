package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.MessageResponse;
import com.example.demo.model.TransactionRequest;
import com.example.demo.model.TransactionResponse;
import com.example.demo.service.TransactionService;

@CrossOrigin
@RestController
@RequestMapping("transactions") //http://localhost:8282/transactions
public class TransactionsController {

	@Autowired
	private TransactionService transserv;
	
	@PostMapping("/billpayments")
	public MessageResponse Logincustomer(@RequestBody TransactionRequest transreq) 
	{
		MessageResponse Response = transserv.BillPayment(transreq);
		
		return Response;

	}
	
	@GetMapping("/gettransactions")
	public List<TransactionResponse> GetTransactions(@RequestBody TransactionRequest req)
	{
		List<TransactionResponse> transrep = transserv.GetAllTransactions(req);
		return transrep;
	}
	
	@PostMapping("/moneytrans")
	public MessageResponse MoneyTransfer(@RequestBody TransactionRequest transreq)
	{

		MessageResponse Response = transserv.MoneyTransfer(transreq);
		
		return Response;
		
	}
	
	
}
