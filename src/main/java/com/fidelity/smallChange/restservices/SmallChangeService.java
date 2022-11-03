package com.fidelity.smallChange.restservices;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.apache.ibatis.javassist.Loader.Simple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fidelity.smallChange.business.Account;
import com.fidelity.smallChange.business.BankAccount;
import com.fidelity.smallChange.business.Holding;
import com.fidelity.smallChange.business.Profile;
import com.fidelity.smallChange.business.Security;
import com.fidelity.smallChange.business.Trade;
import com.fidelity.smallChange.business.User;
import com.fidelity.smallChange.dto.AccountDto;
import com.fidelity.smallChange.dto.AmountFilterDto;
import com.fidelity.smallChange.dto.LoginDto;
import com.fidelity.smallChange.dto.SymbolFilterDto;
import com.fidelity.smallChange.dto.TradeDto;
import com.fidelity.smallChange.dto.UserDto;
import com.fidelity.smallChange.dto.UsernameDto;
import com.fidelity.smallChange.integration.AccountDao;
import com.fidelity.smallChange.integration.BankAccountDao;
import com.fidelity.smallChange.integration.HoldingDao;
import com.fidelity.smallChange.integration.SecurityDao;
import com.fidelity.smallChange.integration.TradeDao;
import com.fidelity.smallChange.integration.UserDao;
import com.fidelity.smallChange.service.TradeService;

@RestController
@RequestMapping("/api")
public class SmallChangeService {
	@Autowired 
	TradeService tradeService;
	
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
	public ResponseEntity<User> userLogin(@RequestBody LoginDto loginDto) {
		User user = userDao.loginUser(loginDto.getUsername(),loginDto.getPassword());
		return ResponseEntity.ok(user);
	}
	
	@PostMapping( value ="/register",
			consumes = {MediaType.APPLICATION_JSON_VALUE })
	public int registerUser(@RequestBody UserDto user) {		
		User user1 = new User(user.getFirstName(), user.getLastName(), 
				LocalDate.now(), user.getEmail(), user.getPhone(),
				user.getUsername(),
				user.getPassword());
		
		int value = userDao.signupUser(user1);
		return value;
	}
	
	@GetMapping(value ="/accounts")
	public ResponseEntity<Account> getAccount(@RequestBody UsernameDto  user){
		Account acct = accountDao.getAccount(user.getUsername());
		return ResponseEntity.ok(acct);
	}

	@GetMapping("/bankAccounts")
	public ResponseEntity<List<BankAccount>> queryForAllBankAccount(@RequestBody AccountDto  account) {
		List<BankAccount> bankAccounts = bankDao.getBankAccounts(account.getAcctNum());
		return ResponseEntity.ok(bankAccounts);
	}
	
	
	@GetMapping("/holdings")
	public ResponseEntity<List<Holding>> queryAllHoldings(@RequestBody AccountDto account) {
		List<Holding> holdings = holdingDao.getAllHoldings(account.getAcctNum());
		return ResponseEntity.ok(holdings);
	}
	
	@GetMapping("/trades")
	public ResponseEntity<List<Trade>> queryAlltrades(@RequestBody AccountDto  account) {
		List<Trade> trades = tradeDao.getAllTrades(account.getAcctNum());
		return ResponseEntity.ok(trades);
	}

	@GetMapping("/trades/filterByAmount")
	public ResponseEntity<List<Trade>> queryTradeFilterbyAmount(@RequestBody AmountFilterDto filterDto){
		List<Trade> trades = tradeDao.getTradesFilterbyAmount(filterDto.getAcctNum(), filterDto.getStartAmt(),
				filterDto.getEndAmt());
		System.out.println(filterDto);
		return ResponseEntity.ok(trades);
	}

	@GetMapping("/trades/filterBySymbol")
	public ResponseEntity<List<Trade>> queryTradeFilterbySymbol(@RequestBody SymbolFilterDto filterDto){
		List<Trade> trades = tradeDao.getTradesFilterbySymbol(filterDto.getAcctNum(), filterDto.getSymbol());
		//System.out.println(filterDto);
		return ResponseEntity.ok(trades);
	}
	
	@PostMapping("/trades/transaction")
	public void buySecurity(@RequestBody TradeDto trade) {
		String accNum = trade.getAcct_num();
		String trade_type = trade.getTrade_type();
		double quantity = trade.getQuantity();
		double amount = trade.getAmount();
		int sid = trade.getS_id();
		
		Trade trade1 = new Trade(trade_type, LocalDateTime.now(), quantity, amount);
		tradeService.transactSecurity(accNum, trade1, sid);
	}
	
	@GetMapping("/securities")
	public ResponseEntity<List<Security>> queryAllUsers() {
		List<Security> securities = securityDao.getSecurities();
		return ResponseEntity.ok(securities);
	}
}
