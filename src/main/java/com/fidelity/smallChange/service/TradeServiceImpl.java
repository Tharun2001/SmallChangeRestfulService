package com.fidelity.smallChange.service;

import java.math.BigDecimal;
import java.util.Random;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fidelity.smallChange.business.Holding;
import com.fidelity.smallChange.business.Security;
import com.fidelity.smallChange.business.Trade;
import com.fidelity.smallChange.exceptions.InsufficientFundsException;
import com.fidelity.smallChange.integration.AccountDao;
import com.fidelity.smallChange.integration.HoldingDao;
import com.fidelity.smallChange.integration.TradeDao;



@Service
public class TradeServiceImpl implements TradeService{
	@Autowired 
	Logger logger;
	
	@Autowired
	AccountDao accountDao;
	
	@Autowired 
	HoldingDao holdingDao;
	
	@Autowired
	TradeDao tradeDao;

	@Override
	public void transactSecurity(String clientId, Trade trade, int s_id) throws InsufficientFundsException  {
		if(trade.getTrade_type().equals("B")) {
			this.logger.debug(trade.getTrade_type());
			buySecurity(clientId, trade, s_id);
		}
		else if(trade.getTrade_type().equals("S")) {
			this.logger.debug(trade.getTrade_type());
			sellSecurity(clientId, trade, s_id);
		}
		
		
	}
	
	protected void buySecurity(String clientId, Trade trade, int s_id) throws InsufficientFundsException {
		this.logger.debug("ClientId "+clientId+" buying stock with id "+s_id);
		
		double tradeAmt = trade.getQuantity()*trade.getPrice();
		BigDecimal funds = accountDao.getAccountFunds(clientId);
		
		if(funds.compareTo(BigDecimal.valueOf(tradeAmt)) == -1) {
			throw new InsufficientFundsException("Insufficient funds, transaction cannot be completed.");
		}
		Holding holding = holdingDao.getHoldingBySecurityId(clientId, s_id);
		if(holding == null) {
			double qty = trade.getQuantity();
			double amount = tradeAmt;
			Holding newHolding = new Holding(s_id, qty, amount);
			holdingDao.addHolding(clientId, newHolding);
		}
		else {
			double qty = holding.getHoldingQuantity() + trade.getQuantity();
			double amount = holding.getInvestedAmount() + tradeAmt;
			Holding updateHolding = new Holding(s_id, qty, amount);
			holdingDao.updateHolding(clientId, updateHolding);
		}
		tradeDao.transactSecurity(clientId, trade, s_id);
		
		BigDecimal current_funds = funds.subtract(BigDecimal.valueOf(tradeAmt));
		accountDao.updateFunds(clientId, current_funds);
	}
	
	protected void sellSecurity(String clientId, Trade trade, int s_id) {
		this.logger.debug("ClientId "+clientId+" selling stock with id "+s_id);
		
		Holding holding = holdingDao.getHoldingBySecurityId(clientId, s_id);
		BigDecimal funds = accountDao.getAccountFunds(clientId);
		double tradeAmt = trade.getQuantity()*trade.getPrice();
		
		if(holding.getHoldingQuantity() == trade.getQuantity()) {
			this.logger.debug("ClientId "+clientId+" deleting stock with id "+s_id);
			holdingDao.deleteHolding(clientId, holding);
		}
		else {
			this.logger.debug("updating holding of clientid"+clientId+" for sid "+holding.getsId());
			double qty = holding.getHoldingQuantity() - trade.getQuantity();
			double amount = holding.getInvestedAmount() - trade.getQuantity()*trade.getPrice();
			if(amount < 0) {
				amount = 0;
			}
			Holding updateHolding = new Holding(s_id, qty, amount);
			holdingDao.updateHolding(clientId, updateHolding);
		}
		tradeDao.transactSecurity(clientId, trade, s_id);
		
		BigDecimal current_funds = funds.add(BigDecimal.valueOf(tradeAmt));
		accountDao.updateFunds(clientId,current_funds);
	}
}
