package com.fidelity.smallChange.restservices;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerErrorException;

import com.fidelity.smallChange.business.Account;
import com.fidelity.smallChange.business.BankAccount;
import com.fidelity.smallChange.business.Holding;
import com.fidelity.smallChange.business.Profile;
import com.fidelity.smallChange.business.Security;
import com.fidelity.smallChange.business.Trade;
import com.fidelity.smallChange.business.TradeFilter;
import com.fidelity.smallChange.business.User;
import com.fidelity.smallChange.dto.AccountDto;
import com.fidelity.smallChange.dto.BankAccountDto;
import com.fidelity.smallChange.dto.FilterDto;
import com.fidelity.smallChange.dto.FundsDto;
import com.fidelity.smallChange.dto.HoldingDto;
import com.fidelity.smallChange.dto.LoginDto;
import com.fidelity.smallChange.dto.TradeDto;
import com.fidelity.smallChange.dto.TradeHistoryDto;
import com.fidelity.smallChange.dto.UserDto;
import com.fidelity.smallChange.dto.UsernameDto;
import com.fidelity.smallChange.exceptions.InsufficientFundsException;
import com.fidelity.smallChange.integration.AccountDao;
import com.fidelity.smallChange.integration.BankAccountDao;
import com.fidelity.smallChange.integration.HoldingDao;
import com.fidelity.smallChange.integration.SecurityDao;
import com.fidelity.smallChange.integration.TradeDao;
import com.fidelity.smallChange.integration.UserDao;
import com.fidelity.smallChange.service.AccountService;
import com.fidelity.smallChange.service.TradeService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class SmallChangeService {
	@Autowired
	AccountService accountService;
	
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
		try {
			User user1 = new User(user.getFirstName(), user.getLastName(), 
					user.getDob(), user.getEmail(), user.getPhone(),
					user.getUsername(),
					user.getPassword());
			int value = accountService.registerUser(user1);
			return value;
		}catch (Exception e) {
			throw new ServerErrorException("Backend issue", e);
		}
	}
	
	@GetMapping(value ="/accounts")
	public ResponseEntity<Account> getAccount(@RequestBody UsernameDto  user){
		Account acct = accountDao.getAccount(user.getUsername());
		return ResponseEntity.ok(acct);
	}

	@PostMapping(value ="/accounts/addFunds")
	public ResponseEntity<String> addFunds(@RequestBody FundsDto fundsDto){
		try {
			accountService.addFunds(fundsDto.getClientId(), fundsDto.getAccount_number(), 
					fundsDto.getAmount());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResponseEntity.ok("Success");
	}
	
	@PostMapping(value ="/accounts/withdrawFunds")
	public ResponseEntity<String> withdrawFunds(@RequestBody FundsDto fundsDto){
		try {
			accountService.withdrawFunds(fundsDto.getClientId(), fundsDto.getAccount_number(), 
					fundsDto.getAmount());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResponseEntity.ok("Success");
	}
	
	@GetMapping("/bankAccounts")
	public ResponseEntity<List<BankAccount>> queryForAllBankAccount(@RequestBody AccountDto  account) {
		List<BankAccount> bankAccounts = bankDao.getBankAccounts(account.getClientId());
		return ResponseEntity.ok(bankAccounts);
	}
	
	@PostMapping("/bankAccounts/addAccount")
	public ResponseEntity<Integer> addBankAccount(@RequestBody BankAccount  bank_account) {
		int value = bankDao.insertBankAccount(bank_account);
		return ResponseEntity.ok(Integer.valueOf(value));
	}
	
	@PostMapping("/bankAccounts/deleteAccount")
	public ResponseEntity<Integer> deleteBankAccount(@RequestBody BankAccountDto  bank_account) {
		int value = bankDao.deleteBankAccount(bank_account.getAccount_number());
		return ResponseEntity.ok(Integer.valueOf(value));
	}
	
	@GetMapping("/holdings")
	public ResponseEntity<List<HoldingDto>> queryAllHoldings(@RequestBody AccountDto account) {
		List<Holding> holdings = holdingDao.getAllHoldings(account.getClientId());
		List<HoldingDto> holdingDtos = new ArrayList<>();
		for(Holding holding: holdings) {
			HoldingDto holdingDto = new HoldingDto();
			holdingDto.setAsset_class(holding.getSecurity().getAssetClass());
			holdingDto.setCode(holding.getSecurity().getScode());
			holdingDto.setName(holding.getSecurity().getSname());
			holdingDto.setInvested_amount(holding.getInvestedAmount());
			holdingDto.setLtp(holding.getSecurity().getLtp());
			holdingDto.setQuantity(holding.getHoldingQuantity());
			holdingDtos.add(holdingDto);
		}
		return ResponseEntity.ok(holdingDtos);
	}
	
	@PostMapping("/trades")
	public ResponseEntity<List<TradeHistoryDto>> queryAlltrades(@RequestBody AccountDto  account) {
		List<Trade> trades = tradeDao.getAllTrades(account.getClientId());
		List<TradeHistoryDto> tradesDto = new ArrayList<>();
		for(Trade trade: trades) {
			TradeHistoryDto tradeHistoryDto = new 
					TradeHistoryDto(trade.getSecurity().getSname(),
							trade.getSecurity().getScode(),
							trade.getQuantity(),
							trade.getPrice(),
							trade.getSecurity().getAssetClass(),
							trade.getTrade_type(),
							trade.getTrade_time());
			tradesDto.add(tradeHistoryDto);
		}
		return ResponseEntity.ok(tradesDto);
	}

	@GetMapping("/trades/filter")
	public ResponseEntity<List<Trade>> queryTradeWithFilter(@RequestBody FilterDto filterDto){
		System.out.println(filterDto);
		TradeFilter tradeFilter = new TradeFilter();
		
		tradeFilter.setSide(filterDto.getSide());
		
		tradeFilter.setStartAmt(filterDto.getStartAmt());
		tradeFilter.setEndAmt(filterDto.getEndAmt());
		if( filterDto.getStartDate() != null && filterDto.getEndDate() != null ) {
			tradeFilter.setStartDate(
					filterDto.getStartDate().atStartOfDay());
			tradeFilter.setEndDate(
					filterDto.getEndDate().atTime(23, 59, 59));
		}
		tradeFilter.setAsset_class(filterDto.getAsset_class());
		tradeFilter.setSymbol(filterDto.getSymbol());
		
		List<Trade> trades = tradeDao.getTradesWithFilter(filterDto.getClientId(), tradeFilter);
		return ResponseEntity.ok(trades);
	}

	
	@PostMapping("/trades/transaction")
	public void transactSecurity(@RequestBody TradeDto trade) {
		String clientId = trade.getClientId();
		String trade_type = trade.getTrade_type();
		double quantity = trade.getQuantity();
		double price = trade.getPrice();
		int sid = trade.getS_id();
		Security security = new Security(sid);
		Trade trade1 = new Trade(trade_type, security, LocalDateTime.now(), quantity, price);
		try {
			tradeService.transactSecurity(clientId, trade1, sid);
		} catch (InsufficientFundsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@GetMapping("/securities")
	public ResponseEntity<List<Security>> queryAllUsers() {
		List<Security> securities = securityDao.getSecurities();
		return ResponseEntity.ok(securities);
	}
}
