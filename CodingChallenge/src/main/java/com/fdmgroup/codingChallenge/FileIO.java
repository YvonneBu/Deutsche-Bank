package com.fdmgroup.codingChallenge;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/**
 * 
 * @author Yvonne Bussmann
 *
 */
public class FileIO {
	/**
	 * has a path as a String as an argument
	 */
	private String path;

	public FileIO() {}
	
	public FileIO(String path) {
		this.path = path;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	/**
	 * read the file provided at the path and create Trade-Objects out of it (see README for more informations about the expected format of the file)
	 * @return an ArrayList of Trade-Objects
	 */
	public List<Trade> createAllTrades() {
		List<Trade> allTrades = new ArrayList<>();
		try(
				FileReader fileReader = new FileReader(path);
				BufferedReader bufferedReader = new BufferedReader(fileReader);
			){
				String currentLine = null;
				while((currentLine = bufferedReader.readLine()) != null) {
					Trade readTrade = new Trade();
					
					String[] splitLine = currentLine.split(";");
					String[] dateTime = splitLine[0].split(" ");
					String[] date = dateTime[0].split("-");
					String[] time = dateTime[1].split(":");
					
					readTrade.setYear(Integer.parseInt(date[0]));
					readTrade.setMonth(Integer.parseInt(date[1]));
					readTrade.setDay(Integer.parseInt(date[2]));
					readTrade.setHour(Integer.parseInt(time[0]));
					readTrade.setMinute(Integer.parseInt(time[1]));
					readTrade.setSecond(Integer.parseInt(time[2]));
					readTrade.setCompany(splitLine[1]);
					readTrade.setPrice(Double.parseDouble((splitLine[2].replace(',', '.'))));
					readTrade.setNumber_traded(Integer.parseInt(splitLine[3]));
					
					readTrade.setDate(dateTime[0]);
					readTrade.setTime(dateTime[1]);
					
					allTrades.add(readTrade);
				}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return allTrades;
	}
	

}
