# Deutsche Bank Coding Challenge
Deutsche Bank Coding Challenge is a project that was created in preparation for an job interview.
The aim of the project is to generate and display aggregated values from historical market logs. 
This programme will display the open and close price along with the lowest and highest price and the corresponding daily traded volume for every day and every ticker from the provided sample market log.

Notes on the market log:

The sample provides the following format:
	date time;companyTicker;price;numberOfSecuritiesTraded
where the date is yyyy-mm-dd and the time is hh:mm:ss

As long as the weights used to calculate the index and the company ticker remain the same, this code can easily be adapted to other logs as long as they have the same format.

## Installation
To get started, clone the repository.
In src/main/resources there should be the provided sample named "test-market.csv"

The project has been built created as a JavaSE-1.8 Maven project.

### Usage
To display the aggregated values, the Main class in src/main/java should be run.
Be aware of the path providing the sample.

#### Output
The output will be to the console and will look like this

###############
date
###############

ticker
-------------------
Open Price: 
Close Price:
Lowest Price: 
Highest Price: 
Daily Volume: 

ticker
-----------
.
.
.

#### How does it work
Inside the main-method of the Main class an object of the FileIO class is created with the path to the sample. By calling the FileIO's createAllTrades() method the csv file will be read and Trade objects will be created from it. To complete the setup a set of dates and companies is created along with a list of initial default values for the aggregates for each company. Now a forEach loop will iterate through the Dates set and another through the Companies set to calculate the values by calling the appropriate methods from the Calculator object. These are used to calculate and display the index.

