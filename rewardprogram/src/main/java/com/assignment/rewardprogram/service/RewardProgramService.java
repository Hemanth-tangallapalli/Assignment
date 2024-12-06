package com.assignment.rewardprogram.service;

import java.time.Month;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.assignment.rewardprogram.model.Transaction;

@Service
public class RewardProgramService {

	public int calculateRewardPoints(Transaction transaction) {

		int amountSpent = transaction.getAmountSpent();
		int points = 0;

		if (amountSpent > 100) {

			int amountMoreThan100 = amountSpent - 100;
			points += amountMoreThan100 * 2;
			amountSpent = 100;
		}

		if (amountSpent > 50) {
			points += amountSpent - 50;
		}

		return points;
	}

	public Map<String, Map<Month, Integer>> calculateMonthlyRewardPoints(List<Transaction> transactions) {

		Map<String, Map<Month, Integer>> customerMonthlyPoints = new HashMap<>();

		for (Transaction transaction : transactions) {

			String customerId = transaction.getCustomerId();
			Month month = transaction.getTransactionDate().getMonth();
			int points = calculateRewardPoints(transaction);

			Map<Month, Integer> monthPoints = customerMonthlyPoints.get(customerId);

			if (monthPoints == null) {
				monthPoints = new HashMap<>();
				customerMonthlyPoints.put(customerId, monthPoints);

			}

			Integer previousPoints = monthPoints.get(month);
			if (previousPoints != null) {
				monthPoints.put(month, previousPoints + points);
			} else {
				monthPoints.put(month, points);
			}
		}

		return customerMonthlyPoints;

	}

	public Map<String, Integer> calculateTotalPoints(Map<String, Map<Month, Integer>> monthlyPoints) {

		Map<String, Integer> totalPoints = new HashMap<>();
		for (Map.Entry<String, Map<Month, Integer>> customer : monthlyPoints.entrySet()) {
			String customerId = customer.getKey();
			Map<Month, Integer> monthpoints = customer.getValue();
			int totalCustomerPoints = 0;
			for (Map.Entry<Month, Integer> monthpoint : monthpoints.entrySet()) {
				totalCustomerPoints += monthpoint.getValue();
			}
			totalPoints.put(customerId, totalCustomerPoints);
		}
		return totalPoints;

	}
}
