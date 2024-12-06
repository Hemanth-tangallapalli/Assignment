# Assignment
About Project:
Reward Program
===================================
A retailer offers a rewards program to its customers, awarding points based on each recorded purchase.  
  
A customer receives 2 points for every dollar spent over $100 in each transaction, plus 1 point for every dollar spent between $50 and $100 in each transaction. 
(e.g. a $120 purchase = 2x$20 + 1x$50 = 90 points). 
  
Given a record of every transaction during a three month period, calculate the reward points earned for each customer per month and total. 

Approach
==========================
1. Created a Transaction class to model the data required for the transaction Details.
	Transaction class contains three parameter namely, 
		1. customerId
		2. amountSpent
		3. transactionDate
2. Created a RewardProgramService class for the business logic. It contains 3 methods to perform the business logic for calculating the reward points.

3. Created a RewardProgramController class for the restcontroller logic and created two rest api's using the POST call.
	Rest API end point to calculate the Monthly Rewards: http://localhost:8080/assignment/rewardprogram/monthlyRewards used to calculate the monthly rewards for the customer
	Rest API end point to calculate the Total Rewards: http://localhost:8080/assignment/rewardprogram/totalRewards used to calculate the total rewards

RestAPI endpoints:
================================
Rest API end point to calculate the Monthly Rewards: http://localhost:8080/assignment/rewardprogram/monthlyRewards

Rest API end point to calculate the Total Rewards: http://localhost:8080/assignment/rewardprogram/totalRewards

Sample Test Data used:
==================================
[
{"customerId":"INFY001","amountSpent":120,"transactionDate":"2024-12-06"},
{"customerId":"INFY002","amountSpent":140,"transactionDate":"2024-11-06"},
{"customerId":"INFY003","amountSpent":100,"transactionDate":"2024-12-09"},
{"customerId":"INFY001","amountSpent":190,"transactionDate":"2024-12-06"},
{"customerId":"INFY001","amountSpent":85,"transactionDate":"2024-09-06"}
]

Sample Test Results:
=====================================
Monthly:
{
    "INFY001": {
        "DECEMBER": 320,
        "SEPTEMBER": 35
    },
    "INFY002": {
        "NOVEMBER": 130
    },
    "INFY003": {
        "DECEMBER": 50
    }
}

Total:
{
    "INFY001": 355,
    "INFY002": 130,
    "INFY003": 50
}
