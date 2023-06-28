package com.fdmgroup.codingChallenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
	
		Calculator calc = new Calculator();
		
		FileIO fileIo = new FileIO(".\\src\\main\\resources\\test-market.csv");
		List<Trade> allTrades = fileIo.createAllTrades();
	
		/*
		 *  Creation of a Set of dates and companies on which trades were made
		 *  for iteration when printing/calculating the aggregated values
		 */
		Set<String> dates = new TreeSet<>();
		for (Trade trade : allTrades) {
			dates.add(trade.getDate());
		}
		
		Set<String> companys = new TreeSet<>();
		for (Trade trade : allTrades) {
			companys.add(trade.getCompany());
		}
		
		/*
		 * Creation of list for every company to store aggregated values
		 * to use when INDEX is calculated
		 */
		List<Double> abc = new ArrayList<>(Arrays.asList(0.0, 0.0, 0.0, 0.0, 0.0));
		List<Double> mega = new ArrayList<>(Arrays.asList(0.0, 0.0, 0.0, 0.0, 0.0));
		List<Double> ngl = new ArrayList<>(Arrays.asList(0.0, 0.0, 0.0, 0.0, 0.0));
		List<Double> trx = new ArrayList<>(Arrays.asList(0.0, 0.0, 0.0, 0.0, 0.0));
				
		/*
		 * iterating throw the dates and tickers (including the INDEX) to calculate and print out the aggregated values
		 */
		for (String date : dates) {
			System.out.println("##################");
			System.out.println(date);
			System.out.println("##################");
			System.out.println();
			List<Trade> tradePerDate = allTrades.stream().filter(trade -> trade.getDate().equals(date)).toList();
			
			
			for (String company : companys) {
				System.out.println(company);
				System.out.println("------------------");
				List<Trade> tradePerDayAndCompany = tradePerDate.stream().filter(trade -> trade.getCompany().equals(company)).collect(Collectors.toList());
				
				if (tradePerDayAndCompany.size() <= 0) {
					System.out.println("N/A");
					System.out.println();
					continue;
				}
				
				Double open = calc.getOpenPrice(tradePerDayAndCompany);
				Double close = calc.getClosePrice(tradePerDayAndCompany);
				Double lowest = calc.getLowestPrice(tradePerDayAndCompany);
				Double highest = calc.getHighestPrice(tradePerDayAndCompany);
				Double volume = calc.getDailyVolume(tradePerDayAndCompany);
				
				if(company.equals("ABC")) {
					abc.set(0, open);
					abc.set(1, close);
					abc.set(2, lowest);
					abc.set(3, highest);
					abc.set(4, volume);
				}
				if(company.equals("MEGA")) {
					mega.set(0, open);
					mega.set(1, close);
					mega.set(2, lowest);
					mega.set(3, highest);
					mega.set(4, volume);
				}
				if(company.equals("NGL")) {
					ngl.set(0, open);
					ngl.set(1, close);
					ngl.set(2, lowest);
					ngl.set(3, highest);
					ngl.set(4, volume);
				}
				if(company.equals("TRX")) {
					trx.set(0, open);
					trx.set(1, close);
					trx.set(2, lowest);
					trx.set(3, highest);
					trx.set(4, volume);
				}
				
				System.out.println("Open Price: "+open);
				System.out.println("Close Price: "+close);
				System.out.println("Lowest Price: "+lowest);
				System.out.println("Highest Price: "+highest);
				System.out.println("Daily Volume: "+volume);
				System.out.println();
			}
			
			System.out.println("INDEX");
			System.out.println("------------------");
			
			double indexOpen = abc.get(0)*0.1 + mega.get(0)*0.3 + ngl.get(0)*0.4 + trx.get(0)*0.2;
			double indexClose = abc.get(1)*0.1 + mega.get(1)*0.3 + ngl.get(1)*0.4 + trx.get(1)*0.2;
			double indexLowest = abc.get(2)*0.1 + mega.get(2)*0.3 + ngl.get(2)*0.4 + trx.get(2)*0.2;
			double indexHighest = abc.get(3)*0.1 + mega.get(3)*0.3 + ngl.get(3)*0.4 + trx.get(3)*0.2;
			double indexVolume = abc.get(4)*0.1 + mega.get(4)*0.3 + ngl.get(4)*0.4 + trx.get(4)*0.2;
			
			System.out.println("Open Price: "+indexOpen);
			System.out.println("Close Price: "+indexClose);
			System.out.println("Lowest Price: "+indexLowest);
			System.out.println("Highest Price: "+indexHighest);
			System.out.println("Daily Volume: "+indexVolume);
			System.out.println();
		}
		
		
	}

}
