package com.fdmgroup.codingChallenge;

import java.util.Comparator;
import java.util.List;

/**
 * 
 * @author Yvonne Bussmann
 *
 */
public class Calculator {

	Comparator<Trade> sortByHour = (trade1, trade2) -> trade1.getHour()-trade2.getHour();
	Comparator<Trade> sortByMinute = (trade1, trade2) -> trade1.getMinute()-trade2.getMinute();
	Comparator<Trade> sortBySecond = (trade1, trade2) -> trade1.getSecond()-trade2.getSecond();
	
	Comparator<Trade> sortByTime = sortByHour.thenComparing(sortByMinute).thenComparing(sortBySecond);
	
	Comparator<Trade> sortByPrice = Comparator.comparingDouble(trade -> trade.getPrice());
	
	/**
	 * find the price of the earliest trade from a given list of trades
	 * @param trades List of trades on which the opening price is to be found
	 * @return opening price
	 */
	public double getOpenPrice(List<Trade> trades) {
		trades.sort(sortByTime);
		Trade firstTrade = trades.get(0);
		return firstTrade.getPrice();
	}
	
	/**
	 * find the price of the latest trade from a given list of trades
	 * @param trades list of trades from which the closing price is to be found
	 * @return closing price
	 */
	public double getClosePrice(List<Trade> trades) {
		trades.sort(sortByTime);
		Trade lastTrade = trades.get(trades.size()-1);
		return lastTrade.getPrice();
	}
	
	/**
	 * find the highest price from a given list of trades
	 * @param trades list of trades from which the highest price is to be found
	 * @return highest price
	 */
	public double getHighestPrice(List<Trade> trades) {
		trades.sort(sortByPrice);
		return trades.get(trades.size()-1).getPrice();
	}
	
	/**
	 * find the lowest price from a given list of trades
	 * @param trades list of trades from which the lowest price is to be found
	 * @return lowest price
	 */
	public double getLowestPrice(List<Trade> trades) {
		trades.sort(sortByPrice);
		return trades.get(0).getPrice();
	}
	
	/**
	 * calculate traded volume by summing up the product of the price and the number of traded securities
	 * @param trades list of trades from which the volume is to be calculated
	 * @return traded volume
	 */
	public double getDailyVolume(List<Trade> trades) {
		double dailyVolume =0;
		for (Trade trade : trades) {
			dailyVolume += (trade.getPrice()*trade.getNumber_traded());
		}
		return dailyVolume;
	}

}
