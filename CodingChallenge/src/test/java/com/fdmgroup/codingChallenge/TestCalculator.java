package com.fdmgroup.codingChallenge;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestCalculator {
	
	Calculator calc;
	Trade trade1, trade2, trade3, trade4, trade5;
	List<Trade> trades;
	
	@BeforeEach
	void setUp() {
		calc = new Calculator();
		trade1 = new Trade();
		trade2 = new Trade();
		trade3 = new Trade();
		trade4 = new Trade();
		trade5 = new Trade();
		
		trade1.setYear(2023);
		trade1.setMonth(06);
		trade1.setDay(01);
		trade1.setHour(9);
		trade1.setMinute(00);
		trade1.setSecond(05);
		trade1.setCompany("NGL");
		trade1.setPrice(1);
		trade1.setNumber_traded(2);
		
		trade2.setYear(2023);
		trade2.setMonth(06);
		trade2.setDay(01);
		trade2.setHour(9);
		trade2.setMinute(00);
		trade2.setSecond(04);
		trade2.setCompany("NGL");
		trade2.setPrice(2.9);
		trade2.setNumber_traded(2);
		
		trade3.setYear(2023);
		trade3.setMonth(06);
		trade3.setDay(01);
		trade3.setHour(9);
		trade3.setMinute(00);
		trade3.setSecond(03);
		trade3.setCompany("NGL");
		trade3.setPrice(3.7);
		trade3.setNumber_traded(2);
		
		trade4.setYear(2023);
		trade4.setMonth(06);
		trade4.setDay(01);
		trade4.setHour(9);
		trade4.setMinute(00);
		trade4.setSecond(02);
		trade4.setCompany("NGL");
		trade4.setPrice(4.5);
		trade4.setNumber_traded(2);
		
		trade5.setYear(2023);
		trade5.setMonth(06);
		trade5.setDay(01);
		trade5.setHour(9);
		trade5.setMinute(00);
		trade5.setSecond(01);
		trade5.setCompany("NGL");
		trade5.setPrice(5);
		trade5.setNumber_traded(2);
		
		trades = new ArrayList<>();
		trades.add(trade1);
		trades.add(trade2);
		trades.add(trade3);
		trades.add(trade4);
		trades.add(trade5);
	}

	@Test
	void testGetOpenPrice_return5_whenCalledWithTrades() {
		double openPrice = calc.getOpenPrice(trades);
		assertEquals(5, openPrice);
	}
	
	@Test
	void testGetClosePrice_return1_whenCalledWithTrades() {
		double closePrice = calc.getClosePrice(trades);
		assertEquals(1, closePrice);
	}
	
	@Test
	void testGetHighestPrice_return5_whenCalledWithTrades() {
		double highestPrice = calc.getHighestPrice(trades);
		assertEquals(5, highestPrice);
	}
	
	@Test
	void testGetLowestPrice_return1_whenCalledWithTrades() {
		double lowestPrice = calc.getLowestPrice(trades);
		assertEquals(1, lowestPrice);
	}
	
	@Test
	void testGetDailyVolume_return34Point2_whenCalledWithTrades() {
		double dailyVolume = calc.getDailyVolume(trades);
		assertEquals(34.2, dailyVolume);
	}

}
