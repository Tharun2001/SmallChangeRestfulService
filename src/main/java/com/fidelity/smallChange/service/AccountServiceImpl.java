package com.fidelity.smallChange.service;

import java.math.BigDecimal;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fidelity.smallChange.business.Account;
import com.fidelity.smallChange.business.User;
import com.fidelity.smallChange.exceptions.InsufficientFundsException;
import com.fidelity.smallChange.integration.AccountDao;
import com.fidelity.smallChange.integration.BankAccountDao;
import com.fidelity.smallChange.integration.UserDao;

@Service
public class AccountServiceImpl implements AccountService{
	
	@Autowired
	AccountDao accountDao;
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	BankAccountDao bankAccountDao;
	
	@Override
	public int registerUser(User user) {
		String clientId = generateClientId();
		while(checkIfAccountExists(clientId)) {
			clientId = generateClientId();
		}
		Account account = new Account(user.getUsername(), clientId, BigDecimal.valueOf(0));
		
		if( userDao.signupUser(user) == 1 && accountDao.createAccount(account) == 1) {
			return 1;
		}
		return 0;
	}

	@Override
	public boolean checkIfAccountExists(String clientId) {
		if(accountDao.checkIfAccountExists(clientId) == 0) {
			return false;
		}
		return true;
	}

	protected String generateClientId() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder salt = new StringBuilder();
        int randomNum = ThreadLocalRandom.current().nextInt(100, 1000);
        while (salt.length() < 3) { 
            int index = ThreadLocalRandom.current().nextInt(0, 26);
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString().concat(Integer.toString(randomNum));
        return saltStr;
    }

	@Override
	public void addFunds(String clientId, String acct_num, BigDecimal amount) throws Exception {
		BigDecimal bank_balance = bankAccountDao.getBankBalance(acct_num);
		if(bank_balance.compareTo(amount) < 0) {
			throw new InsufficientFundsException("Insufficient balance");
		}
		else {
			BigDecimal funds = accountDao.getAccountFunds(clientId);
			funds = funds.add(amount);
			bank_balance = bank_balance.subtract(amount);
			
			accountDao.updateFunds(clientId, funds);
			bankAccountDao.updateBankBalance(acct_num, bank_balance);
		}
	}

	@Override
	public void withdrawFunds(String clientId, String acct_num, BigDecimal amount) throws Exception {
		BigDecimal funds = accountDao.getAccountFunds(clientId);
		if(funds.compareTo(amount) < 0) {
			throw new InsufficientFundsException("Insufficient funds");
		}
		else {
			BigDecimal bank_balance = bankAccountDao.getBankBalance(acct_num);
			funds = funds.subtract(amount);
			bank_balance = bank_balance.add(amount);
			
			accountDao.updateFunds(clientId, funds);
			bankAccountDao.updateBankBalance(acct_num, bank_balance);
		}
		
	}
}
