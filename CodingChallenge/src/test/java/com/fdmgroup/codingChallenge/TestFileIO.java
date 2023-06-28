package com.fdmgroup.codingChallenge;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

class TestFileIO {

	@Test
	void testCreateAllTrades_create104465Trades_WhenCalledOnTestMarketCSV() {
//		String file = "C:\\Users\\YB\\eclipse-workspace\\DeutscheBankCodingChallenge\\src\\main\\resources\\test-market.csv";
		String path = ".\\src\\main\\resources\\test-market.csv";
		FileIO fileIo = new FileIO(path);		
		List<Trade> allTrades = fileIo.createAllTrades();
		assertEquals(104465, allTrades.size());
	}

	@Test
	void testCreateAllTrades_createTheCorrectTrade5_WhenCalledOnTestMarketCSV() {
		String path = ".\\src\\main\\resources\\test-market.csv";
		FileIO fileIo = new FileIO(path);		
		List<Trade> allTrades = fileIo.createAllTrades();
		Trade testTrade = new Trade();
			testTrade.setYear(2023);
			testTrade.setMonth(06);
			testTrade.setDay(01);
			testTrade.setHour(9);
			testTrade.setMinute(00);
			testTrade.setSecond(05);
			testTrade.setCompany("NGL");
			testTrade.setPrice(4995.95);
			testTrade.setNumber_traded(352);
		assertEquals(testTrade, allTrades.get(4));
			
	}
}
