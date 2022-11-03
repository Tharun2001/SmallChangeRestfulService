package com.fidelity.smallChange.restservices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fidelity.smallChange.business.BankAccount;
import com.fidelity.smallChange.business.Profile;
import com.fidelity.smallChange.business.User;
import com.fidelity.smallChange.integration.BankAccountDao;
import com.fidelity.smallChange.integration.HoldingDao;
import com.fidelity.smallChange.integration.UserDao;

@RestController
@RequestMapping("/api")
public class SmallChangeService {
	@Autowired
	HoldingDao holdingDao;
	
	@Autowired
	BankAccountDao bankDao;
	
	@Autowired
	UserDao userDao;
	
	@GetMapping("/bankAccounts")
	public ResponseEntity<List<BankAccount>> queryForAllBankAccount() {
		List<BankAccount> bankAccounts = bankDao.getBankAccounts("ABC123");
		return ResponseEntity.ok(bankAccounts);
	}
	
	@GetMapping("/users")
	public ResponseEntity<List<Profile>> queryAllUsers() {
		List<Profile> users = userDao.getAllUsers();
		return ResponseEntity.ok(users);
	}
	
}
