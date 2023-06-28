package com.fdmgroup.codingChallenge;

import java.util.Objects;
/**
 * 
 * @author Yvonne Bussmann
 *
 */
public class Trade {
	
	/*
	 * for better use especially in sorting the time and date attribute is also available as split up attributes
	 */
	private int year;
	private int month;
	private int day;
	private int hour;
	private int minute;
	private int second;
	private String company;
	private double price;
	private int number_traded;
	
	private String date;
	private String time;
	
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public int getHour() {
		return hour;
	}
	public void setHour(int hour) {
		this.hour = hour;
	}
	public int getMinute() {
		return minute;
	}
	public void setMinute(int minute) {
		this.minute = minute;
	}
	public int getSecond() {
		return second;
	}
	public void setSecond(int second) {
		this.second = second;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getNumber_traded() {
		return number_traded;
	}
	public void setNumber_traded(int number_traded) {
		this.number_traded = number_traded;
	}
	@Override
	public int hashCode() {
		return Objects.hash(company, day, hour, minute, month, number_traded, price, second, year);
	}
	/**
	 * Trade-Objects are equal if all their attributes are equal
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Trade other = (Trade) obj;
		return Objects.equals(company, other.company) && day == other.day && hour == other.hour
				&& minute == other.minute && month == other.month && number_traded == other.number_traded
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price) && second == other.second
				&& year == other.year;
	}
	@Override
	public String toString() {
		return "Trade [year=" + year + ", month=" + month + ", day=" + day + ", hour=" + hour + ", minute=" + minute
				+ ", second=" + second + ", company=" + company + ", price=" + price + ", number_traded="
				+ number_traded + "]";
	}
	
	
	
	
	

}
