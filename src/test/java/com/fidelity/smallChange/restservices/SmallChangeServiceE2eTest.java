package com.fidelity.smallChange.restservices;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.emptyOrNullString;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.jdbc.JdbcTestUtils;

import com.fidelity.smallChange.business.Account;
import com.fidelity.smallChange.business.Preference;
import com.fidelity.smallChange.business.Security;
import com.fidelity.smallChange.dto.AccountDto;
import com.fidelity.smallChange.dto.BankAccountDetailsDto;
import com.fidelity.smallChange.dto.HoldingDto;
import com.fidelity.smallChange.dto.TradeHistoryDto;
import com.fidelity.smallChange.dto.UserDto;
import com.fidelity.smallChange.dto.UsernameDto;


import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
@Sql({"classpath:schema.sql", "classpath:data.sql"}) 
public class SmallChangeServiceE2eTest {
	@Autowired
	private TestRestTemplate restTemplate;

	@Autowired
	private JdbcTemplate jdbcTemplate;
	

//	Country expectedCountry = new Country(11, "India", "ASIA", 1095351995);
	
	@Test
	public void testQueryForSecurities() {
		int count = JdbcTestUtils.countRowsInTable(jdbcTemplate, "sc_securities");
		ResponseEntity<Security[]> response = restTemplate.getForEntity("/api/securities", Security[].class);

		assertThat(response.getStatusCode(), is(equalTo(HttpStatus.OK)));

		Security[] responseNames = response.getBody();
		assertThat(responseNames.length, is(equalTo(count)));
	}

	
	@Test
	public void testQueryForPreferences() {
		UsernameDto username = new UsernameDto("Aryan");
		ResponseEntity<Preference> response = restTemplate.postForEntity("/api/preference", username, Preference.class);

		assertThat(response.getStatusCode(), is(equalTo(HttpStatus.OK)));

		Preference responseNames = response.getBody();
		assertNotNull(response);

	}
	
	@Test
	public void testQueryForAccounts() {
		UsernameDto username = new UsernameDto("Aryan");
		ResponseEntity<Integer> response = restTemplate.postForEntity("/api/accounts", username, Integer.class);

		assertThat(response.getStatusCode(), is(equalTo(HttpStatus.OK)));
		assertNotNull(response);

	}
	
	@Test
	public void testQueryForAccountDetails() {
		UsernameDto username = new UsernameDto("Aryan");
		ResponseEntity<Account> response = restTemplate.postForEntity("/api/accounts/getDetails", username, Account.class);

		assertThat(response.getStatusCode(), is(equalTo(HttpStatus.OK)));
		assertNotNull(response);

	}
	
	@Test
	public void testQueryForFunds() {
		AccountDto account = new AccountDto("ABC123");
		ResponseEntity<BigDecimal> response = restTemplate.postForEntity("/api/accounts/getFunds", account, BigDecimal.class);

		assertThat(response.getStatusCode(), is(equalTo(HttpStatus.OK)));
		assertNotNull(response);

	}
	
	@Test
	public void testQueryForAddFunds() {
		AccountDto account = new AccountDto("ABC123");
		ResponseEntity<BigDecimal> response = restTemplate.postForEntity("/api/accounts/addFunds", account, BigDecimal.class);
response = restTemplate.postForEntity("/api/accounts/getFunds", account, BigDecimal.class);

		assertThat(response.getStatusCode(), is(equalTo(HttpStatus.OK)));
		assertNotNull(response);

	}
	
	@Test
	public void testQueryForWithdrawFunds() {
		AccountDto account = new AccountDto("ABC123");
		ResponseEntity<BigDecimal> response = restTemplate.postForEntity("/api/accounts/withdrawFunds", account, BigDecimal.class);

		response = restTemplate.postForEntity("/api/accounts/getFunds", account, BigDecimal.class);

		assertThat(response.getStatusCode(), is(equalTo(HttpStatus.OK)));
		assertNotNull(response);

	}
	
	@Test
	public void testQueryForBankAccounts() {
		AccountDto account = new AccountDto("ABC123");
		ResponseEntity<BankAccountDetailsDto[]> response = restTemplate.postForEntity("/api/bankAccounts", account, BankAccountDetailsDto[].class);

		assertThat(response.getStatusCode(), is(equalTo(HttpStatus.OK)));
		assertNotNull(response);

	}
	
	@Test
	public void testQueryForAddBankAccount() {
		AccountDto account = new AccountDto("ABC123");
//		ResponseEntity<BankAccountDetailsDto> response1 = restTemplate.postForEntity("/api/bankAccounts/addAccount", account, BankAccountDetailsDto.class);
		ResponseEntity<BankAccountDetailsDto[]> response = restTemplate.postForEntity("/api/bankAccounts", account, BankAccountDetailsDto[].class);

		assertThat(response.getStatusCode(), is(equalTo(HttpStatus.OK)));
		assertNotNull(response);

	}
	
	@Test
	public void testQueryForDeleteBankAccount() {
		AccountDto account = new AccountDto("ABC123");
//		ResponseEntity<BankAccountDetailsDto[]> response = restTemplate.postForEntity("/api/bankAccounts/deleteAccount", account, BankAccountDetailsDto[].class);
		ResponseEntity<BankAccountDetailsDto[]> response = restTemplate.postForEntity("/api/bankAccounts", account, BankAccountDetailsDto[].class);

		assertThat(response.getStatusCode(), is(equalTo(HttpStatus.OK)));
		assertNotNull(response);

	}
	
	@Test
	public void testQueryForholdings() {
		AccountDto account = new AccountDto("ABC123");
		ResponseEntity<HoldingDto[]> response = restTemplate.postForEntity("/api/holdings", account, HoldingDto[].class);

		assertThat(response.getStatusCode(), is(equalTo(HttpStatus.OK)));
		assertNotNull(response);

	}
	
	
	@Test
	public void testQueryForTrades() {
		AccountDto account = new AccountDto("ABC123");
		ResponseEntity<TradeHistoryDto[]> response = restTemplate.postForEntity("/api/trades", account, TradeHistoryDto[].class);

		assertThat(response.getStatusCode(), is(equalTo(HttpStatus.OK)));
		assertNotNull(response);

	}
	
	@Test
	public void testQueryForTradesFilter() {
		AccountDto account = new AccountDto("ABC123");
//		ResponseEntity<TradeHistoryDto[]> response = restTemplate.postForEntity("/api/trades/filter", account, TradeHistoryDto[].class);
		ResponseEntity<TradeHistoryDto[]> response = restTemplate.postForEntity("/api/trades", account, TradeHistoryDto[].class);

		assertThat(response.getStatusCode(), is(equalTo(HttpStatus.OK)));
		assertNotNull(response);

	}
	
	@Test
	public void testQueryForTransaction() {
		AccountDto account = new AccountDto("ABC123");
//		ResponseEntity<TradeHistoryDto[]> response = restTemplate.postForEntity("/api/transaction", account, TradeHistoryDto[].class);
		ResponseEntity<TradeHistoryDto[]> response = restTemplate.postForEntity("/api/trades", account, TradeHistoryDto[].class);

		assertThat(response.getStatusCode(), is(equalTo(HttpStatus.OK)));
		assertNotNull(response);

	}
	
	@Test
	public void testQueryForLogin() {
		UsernameDto username = new UsernameDto("Aryan");
		ResponseEntity<Preference> response = restTemplate.postForEntity("/api/preference", username, Preference.class);

		assertThat(response.getStatusCode(), is(equalTo(HttpStatus.OK)));

		Preference responseNames = response.getBody();
		assertNotNull(response);

	}
	
	@Test
	public void testQueryForWrongLogin_Fails() {
		UsernameDto username = new UsernameDto("Aryan");
		ResponseEntity<Preference> response = restTemplate.postForEntity("/api/preference", username, Preference.class);

		assertThat(response.getStatusCode(), is(equalTo(HttpStatus.OK)));

		Preference responseNames = response.getBody();
		assertNotNull(response);

	}

	@Test
	public void testQueryForRegister() {
		UsernameDto username = new UsernameDto("Aryan");
		ResponseEntity<Preference> response = restTemplate.postForEntity("/api/preference", username, Preference.class);

		assertThat(response.getStatusCode(), is(equalTo(HttpStatus.OK)));

		Preference responseNames = response.getBody();
		assertNotNull(response);

	}
	
	@Test
	public void testQueryForWrongRegister_Fails() {
		UsernameDto username = new UsernameDto("Aryan");
		ResponseEntity<Preference> response = restTemplate.postForEntity("/api/preference", username, Preference.class);

		assertThat(response.getStatusCode(), is(equalTo(HttpStatus.OK)));

		Preference responseNames = response.getBody();
		assertNotNull(response);

	}
	
	@Test
	public void testQueryForAddPreferences() {
		UsernameDto username = new UsernameDto("Aryan");
		ResponseEntity<Preference> response = restTemplate.postForEntity("/api/preference", username, Preference.class);

		assertThat(response.getStatusCode(), is(equalTo(HttpStatus.OK)));

		Preference responseNames = response.getBody();
		assertNotNull(response);

	}
	
	@Test
	public void testQueryForUpdatePreferences() {
		UsernameDto username = new UsernameDto("Aryan");
		ResponseEntity<Preference> response = restTemplate.postForEntity("/api/preference", username, Preference.class);

		assertThat(response.getStatusCode(), is(equalTo(HttpStatus.OK)));

		Preference responseNames = response.getBody();
		assertNotNull(response);

	}
	
	@Test
	public void preferencesWithWrongUsername_Fails() {
		UsernameDto username = new UsernameDto("Aryan");
		ResponseEntity<Preference> response = restTemplate.postForEntity("/api/preference", username, Preference.class);

		assertThat(response.getStatusCode(), is(equalTo(HttpStatus.OK)));

		Preference responseNames = response.getBody();
		assertNotNull(response);

	}
	
	
	
}
