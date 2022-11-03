package com.fidelity.smallChange.restservices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fidelity.smallChange.business.Account;
import com.fidelity.smallChange.business.BankAccount;
import com.fidelity.smallChange.business.Profile;
import com.fidelity.smallChange.business.Security;
import com.fidelity.smallChange.business.Trade;
import com.fidelity.smallChange.business.User;
import com.fidelity.smallChange.dto.LoginDto;
import com.fidelity.smallChange.dto.UsernameDto;
import com.fidelity.smallChange.integration.AccountDao;
import com.fidelity.smallChange.integration.BankAccountDao;
import com.fidelity.smallChange.integration.HoldingDao;
import com.fidelity.smallChange.integration.SecurityDao;
import com.fidelity.smallChange.integration.TradeDao;
import com.fidelity.smallChange.integration.UserDao;

@RestController
@RequestMapping("/api")
public class SmallChangeService {
	@Autowired 
	AccountDao accountDao;
	
	@Autowired
	SecurityDao securityDao;
	
	@Autowired
	HoldingDao holdingDao;
	
	@Autowired
	BankAccountDao bankDao;
	
	@Autowired
	TradeDao tradeDao;
	
	@Autowired
	UserDao userDao;
	
	@GetMapping( value ="/login",
			consumes = {MediaType.APPLICATION_JSON_VALUE })
	public int userLogin(@RequestBody LoginDto loginDto) {
		int value = userDao.loginUser(loginDto.getUsername(),loginDto.getPassword());
		return value;
	}
	
	@GetMapping(value ="/accounts")
	public ResponseEntity<Account> getAccount(@RequestBody UsernameDto  user){
		Account acct = accountDao.getAccount(user.getUsername());
		return ResponseEntity.ok(acct);
	}

	@GetMapping("/bankAccounts")
	public ResponseEntity<List<BankAccount>> queryForAllBankAccount() {
		List<BankAccount> bankAccounts = bankDao.getBankAccounts("ABC123");
		return ResponseEntity.ok(bankAccounts);
	}
		
	@GetMapping("/trades")
	public ResponseEntity<List<Trade>> queryAlltrades() {
		List<Trade> trades = tradeDao.getAllTrades("ABC123");
		return ResponseEntity.ok(trades);
	}
	
	@GetMapping("/securities")
	public ResponseEntity<List<Security>> queryAllUsers() {
		List<Security> securities = securityDao.getSecurities();
		return ResponseEntity.ok(securities);
	}
}
