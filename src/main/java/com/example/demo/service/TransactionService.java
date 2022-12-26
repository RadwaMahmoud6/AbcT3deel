package com.example.demo.service;


import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entities.AccountsEntity;
import com.example.demo.entities.TransactionsEntity;
import com.example.demo.model.MessageResponse;
import com.example.demo.model.TransactionRequest;
import com.example.demo.model.TransactionResponse;
import com.example.demo.repository.AccountsRepo;
import com.example.demo.repository.TransactionsRepo;

@Service
public class TransactionService {
	
	@Autowired
	private TransactionsRepo transrepo;
	
	@Autowired
	private AccountsRepo accrepo;
	
	public MessageResponse BillPayment(TransactionRequest transreq) 
	{
		MessageResponse response = new MessageResponse();
		
		TransactionsEntity transentity = new TransactionsEntity();
		
		AccountsEntity accent = accrepo.findById(transreq.getAccountNum()).get();
		
		if(accent.getCurrentBalance() >= transreq.getBalanceTransferred())
		{
			transentity.setBalanceTransferred(transreq.getBalanceTransferred());
			accent.setCurrentBalance(accent.getCurrentBalance() - transreq.getBalanceTransferred());
			transentity.setTransactionType("Bill Payments");
			transentity.setAccountNum(accent.getAccountNumber());
			transentity.setBalanceAdded((float) 0);
			accrepo.save(accent);
			transrepo.save(transentity);
			
			response.setResponseMessage("Transaction Done");
			response.setResponseStatus(1);
			return response;

		}
		else
		{

			response.setResponseMessage("insufficient  balance in account");
			response.setResponseStatus(0);
			return response;
		}
		
		//return response;
		
		
	}
	
	public List<TransactionResponse> GetAllTransactions(TransactionRequest req)
	{

		//AccountsEntity accent = accrepo.findById(req.getAccountNum()).get();
		List<TransactionResponse> resp = new ArrayList<>();
		List<TransactionsEntity> accountlist = transrepo.findByAccountNum(req.getAccountNum());
		
		for (TransactionsEntity en : accountlist)
		{
			
			TransactionResponse res = new TransactionResponse();
			BeanUtils.copyProperties(en, res);
			resp.add(res);
		}
		
		return resp;
	}

	public MessageResponse MoneyTransfer(TransactionRequest transreq) 
	{
		
		Float USDRate = (float) 25.0;
		
		MessageResponse response = new MessageResponse();
		AccountsEntity accent1 = accrepo.findById(transreq.getAccountNum()).get();

		AccountsEntity accent2 = accrepo.findById(transreq.getAccountTransferedTo()).get();

		TransactionsEntity transent1 = new TransactionsEntity();
		TransactionsEntity transent2 = new TransactionsEntity();


		if(accent1.getCurrency().equals(accent2.getCurrency()))
		{
			if(accent1.getCurrentBalance() >= transreq.getBalanceTransferred())
			{
				accent1.setCurrentBalance(accent1.getCurrentBalance() - transreq.getBalanceTransferred());
				accent2.setCurrentBalance(accent2.getCurrentBalance() + transreq.getBalanceTransferred());

				transent1.setBalanceTransferred(transreq.getBalanceTransferred());
				transent1.setTransactionType("MoneyTransfer");
				transent1.setAccountNum(accent1.getAccountNumber());
				transent1.setBalanceAdded((float) 0);
				transent1.setAccountTransferedTo(transreq.getAccountTransferedTo());
				
				transent2.setBalanceAdded(transreq.getBalanceTransferred());
				transent2.setTransactionType("MoneyTransfer");
				transent2.setAccountNum(accent2.getAccountNumber());
				transent2.setBalanceTransferred((float) 0);
				transent2.setAccountTransferedTo(transreq.getAccountTransferedTo());
				
				accrepo.save(accent1);
				accrepo.save(accent2);
				transrepo.save(transent1);
				transrepo.save(transent2);
				
				response.setResponseMessage("Money Transfered Successfully");
				response.setResponseStatus(1);
				return response;
			}
			else
			{
				response.setResponseMessage("insufficient  balance in account");
				response.setResponseStatus(0);
				return response;
				
				
			}
			
			
		}
		//MFROOD H CHECK ANHY ACCOUN AL BL US DOLLAR ABL M3ML AL TRANSFER 
		//W B3DAHA A CHECK AL BALANCE YKAFY WALLA LAA
		else 
		{ 
			if("EGP".equals(accent1.getCurrency()))
			{
				Float newAmount = transreq.getBalanceTransferred() / USDRate;

				if(accent1.getCurrentBalance() >= transreq.getBalanceTransferred())
				{
					accent1.setCurrentBalance(accent1.getCurrentBalance() - transreq.getBalanceTransferred());
					accent2.setCurrentBalance(accent2.getCurrentBalance() + newAmount);
					
					transent1.setBalanceTransferred(transreq.getBalanceTransferred());
					transent1.setTransactionType("MoneyTransfer");
					transent1.setAccountNum(accent1.getAccountNumber());
					transent1.setBalanceAdded((float) 0);
					transent1.setAccountTransferedTo(transreq.getAccountTransferedTo());
					
					transent2.setBalanceAdded(newAmount);
					transent2.setTransactionType("MoneyTransfer");
					transent2.setAccountNum(accent2.getAccountNumber());
					transent2.setBalanceTransferred((float) 0);
					transent2.setAccountTransferedTo(transreq.getAccountTransferedTo());
					

					accrepo.save(accent1);
					accrepo.save(accent2);
					transrepo.save(transent1);
					transrepo.save(transent2);
					
					response.setResponseMessage("Money Transfered Successfully");
					response.setResponseStatus(1);
					return response;
				}
				else
				{
					response.setResponseMessage("insufficient  balance in account");
					response.setResponseStatus(0);
					return response;
					
					
				}
			}
			else 
			{
				Float newAmount = transreq.getBalanceTransferred()  * USDRate;

				if(accent1.getCurrentBalance() >= transreq.getBalanceTransferred())
				{
					accent1.setCurrentBalance(accent1.getCurrentBalance() - newAmount);
					accent2.setCurrentBalance(accent2.getCurrentBalance() + transreq.getBalanceTransferred());

					
					transent1.setBalanceTransferred(newAmount);
					transent1.setTransactionType("MoneyTransfer");
					transent1.setAccountNum(accent1.getAccountNumber());
					transent1.setBalanceAdded((float) 0);
					transent1.setAccountTransferedTo(transreq.getAccountTransferedTo());
					
					transent2.setBalanceAdded(transreq.getBalanceTransferred() + transreq.getBalanceTransferred());
					transent2.setTransactionType("MoneyTransfer");
					transent2.setAccountNum(accent2.getAccountNumber());
					transent2.setBalanceAdded((float) 0);
					transent2.setAccountTransferedTo(transreq.getAccountTransferedTo());
					
					response.setResponseMessage("Money Transfered Successfully");
					response.setResponseStatus(1);
					
					accrepo.save(accent1);
					accrepo.save(accent2);
					transrepo.save(transent1);
					transrepo.save(transent2);
					return response;
				}
				else
				{
					response.setResponseMessage("insufficient  balance in account");
					response.setResponseStatus(0);
					return response;
					
					
				}
			}
			
			
			
			
		}
		
		
	}
}
