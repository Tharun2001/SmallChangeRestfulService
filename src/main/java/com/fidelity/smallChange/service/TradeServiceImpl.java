package com.fidelity.smallChange.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fidelity.smallChange.business.Holding;
import com.fidelity.smallChange.business.Security;
import com.fidelity.smallChange.business.Trade;
import com.fidelity.smallChange.integration.HoldingDao;
import com.fidelity.smallChange.integration.TradeDao;

@Service
public class TradeServiceImpl implements TradeService{
	@Autowired 
	HoldingDao holdingDao;
	
	@Autowired
	TradeDao tradeDao;

	@Override
	public void transactSecurity(String accNum, Trade trade, int s_id) {
		if(trade.getTrade_type().equals("B")) {
			Holding holding = holdingDao.getHoldingBySecurityId(accNum, s_id);
			if(holding == null) {
				Random random = new Random();    
				int hId = random.nextInt(10000);  
				double qty = trade.getQuantity();
				double amount = trade.getAmount();
				Holding newHolding = new Holding(hId,s_id, qty, amount);
				holdingDao.addHolding(accNum, newHolding);
			}
			else {
				double qty = holding.getHoldingQuantity() + trade.getQuantity();
				double amount = holding.getInvestedAmount() + trade.getAmount();
				Holding updateHolding = new Holding(holding.getHoldingId(),s_id, qty, amount);
				holdingDao.updateHolding(accNum, updateHolding);
			}
		}
		
		if(trade.getTrade_type().equals("S")) {
			Holding holding = holdingDao.getHoldingBySecurityId(accNum, s_id);
			double qty = holding.getHoldingQuantity() - trade.getQuantity();
			double amount = holding.getInvestedAmount() - trade.getAmount();
			Holding updateHolding = new Holding(holding.getHoldingId(),s_id, qty, amount);
			holdingDao.updateHolding(accNum, updateHolding);
		}
		Random random = new Random();    
		int t_id = random.nextInt(10000); 
		tradeDao.transactSecurity(t_id, accNum, trade, s_id);
	}
	
}
