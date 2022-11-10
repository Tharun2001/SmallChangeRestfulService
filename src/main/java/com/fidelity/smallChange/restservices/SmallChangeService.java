package com.fidelity.smallChange.restservices;

import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
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
import com.fidelity.smallChange.business.Preference;
import com.fidelity.smallChange.business.Profile;
import com.fidelity.smallChange.business.Security;
import com.fidelity.smallChange.business.Trade;
import com.fidelity.smallChange.business.TradeFilter;
import com.fidelity.smallChange.business.User;
import com.fidelity.smallChange.dto.AccountDto;
import com.fidelity.smallChange.dto.BankAccountDetailsDto;
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
import com.fidelity.smallChange.integration.PreferenceDao;
import com.fidelity.smallChange.integration.SecurityDao;
import com.fidelity.smallChange.integration.TradeDao;
import com.fidelity.smallChange.integration.UserDao;
import com.fidelity.smallChange.service.AccountService;
import com.fidelity.smallChange.service.TradeService;

import ch.qos.logback.classic.Logger;

@RestController
@EnableScheduling
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
	
	@Autowired
	PreferenceDao preferenceDao;
	
	@PostMapping( value ="/login",
			consumes = {MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<User> userLogin(@RequestBody LoginDto loginDto) {
		
		byte[] decodedBytes = Base64.getDecoder().decode(loginDto.getUsername());
		String username = new String(decodedBytes, Charset.defaultCharset());
		
		decodedBytes = Base64.getDecoder().decode(loginDto.getPassword());
		String password = new String(decodedBytes, Charset.defaultCharset());
		
		System.out.println(username);
		System.out.println(password);
		User user = userDao.loginUser(username, password);

		System.out.println(user);
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
			Preference preference = new Preference(user.getUsername(), "", 0, "", "");
			preferenceDao.insertPreference(preference);

			return value;
		}catch (Exception e) {
			throw new ServerErrorException("Backend issue", e);
		}
	}
	
	@PostMapping(value ="/accounts")
	public ResponseEntity<Integer> getAccount(@RequestBody UsernameDto  user){
		int acct = accountDao.checkIfAccountExists(user.getUsername());
		return ResponseEntity.ok(acct);
	}

	@PostMapping(value ="/accounts/getDetails")
	public ResponseEntity<Account> getAccountDetails(@RequestBody UsernameDto  user){
		Account account = accountDao.getAccount(user.getUsername());
		return ResponseEntity.ok(account);
	}
	
	@PostMapping(value ="/accounts/getFunds")
	public ResponseEntity<BigDecimal> getAccountFunds(@RequestBody AccountDto  accountDto){
		BigDecimal funds = accountDao.getAccountFunds(accountDto.getClientId());
		return ResponseEntity.ok(funds);
	}
	
	@PostMapping(value ="/accounts/addFunds")
	public ResponseEntity<Integer> addFunds(@RequestBody FundsDto fundsDto){
		try {
			accountService.addFunds(fundsDto.getClientId(), fundsDto.getAccount_number(), 
					fundsDto.getAmount());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResponseEntity.ok(0);
		}
		return ResponseEntity.ok(1);
	}
	
	@PostMapping(value ="/accounts/withdrawFunds")
	public ResponseEntity<Integer> withdrawFunds(@RequestBody FundsDto fundsDto){
		try {
			accountService.withdrawFunds(fundsDto.getClientId(), fundsDto.getAccount_number(), 
					fundsDto.getAmount());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResponseEntity.ok(0);
		}
		return ResponseEntity.ok(1);
	}
	
	@PostMapping("/bankAccounts")
	public ResponseEntity<List<BankAccountDetailsDto>> queryForAllBankAccount(@RequestBody AccountDto  account) {
		List<BankAccount> bankAccounts = bankDao.getBankAccounts(account.getClientId());
		List<BankAccountDetailsDto> bankAccountsDetailsDtos = new ArrayList<>();
		for(BankAccount ele: bankAccounts) {
			BankAccountDetailsDto bankDetails = new BankAccountDetailsDto();
			bankDetails.setAccount_number(ele.getAccount_number());
			bankDetails.setBalance(ele.getBalance());
			bankDetails.setBank_name(ele.getBank_name());
			bankAccountsDetailsDtos.add(bankDetails);
		}
		return ResponseEntity.ok(bankAccountsDetailsDtos);
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
	
	@PostMapping("/holdings")
	public ResponseEntity<List<HoldingDto>> queryAllHoldings(@RequestBody AccountDto account) {
		List<Holding> holdings = holdingDao.getAllHoldings(account.getClientId());
		List<HoldingDto> holdingDtos = new ArrayList<>();
		for(Holding holding: holdings) {
			HoldingDto holdingDto = new HoldingDto();
			holdingDto.setSid(holding.getSecurity().getSid());
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
	public ResponseEntity<Integer> transactSecurity(@RequestBody TradeDto trade) {
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
			e.printStackTrace();
			return ResponseEntity.ok(0);
		}
		return ResponseEntity.ok(1);
	}
	
	@GetMapping("/securities")
	public ResponseEntity<List<Security>> getSecurities() {
		List<Security> securities = securityDao.getSecurities();
		return ResponseEntity.ok(securities);
	}
	
	@PostMapping("/preference")
	public ResponseEntity<Preference> getPreference(@RequestBody UsernameDto username) {
		Preference preference = preferenceDao.getPreference(username.getUsername());
		return ResponseEntity.ok(preference);
	}
	
	@PostMapping("/addPreference")
	public ResponseEntity<Integer> addPreference(@RequestBody Preference preference) {
		try {
		preferenceDao.insertPreference(preference);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServerErrorException("Backend issue", e) ;
		}
		return ResponseEntity.ok(1);
	}
	
	@PostMapping("/updatePreference")
	public ResponseEntity<Integer> updatePreference(@RequestBody Preference preference) {
		try {
		preferenceDao.updatePreference(preference);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServerErrorException("Backend issue", e) ;
		}
		return ResponseEntity.ok(1);
	}
	
	Random randomNum = new Random();
	
    @Scheduled(fixedRate = 2000)
    public void changeltp() {
    	List<Security> securities = securityDao.getSecurities();
    	for(Security security: securities) {
    		double ltp = 111;
    		int percent = -20 + randomNum.nextInt(20);
    		security.setLtp(ltp + (ltp*percent)/100);
    		securityDao.updateSecurity(security);
    	}
    }
}
