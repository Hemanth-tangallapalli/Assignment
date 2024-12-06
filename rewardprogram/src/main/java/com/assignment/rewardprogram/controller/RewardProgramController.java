package com.assignment.rewardprogram.controller;

import java.time.Month;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.rewardprogram.model.Transaction;
import com.assignment.rewardprogram.service.RewardProgramService;

@RestController
@RequestMapping("/assignment/rewardprogram")
public class RewardProgramController {

	@Autowired
	private RewardProgramService rewardProgramService;

	@PostMapping("/monthlyRewards")
	public Map<String, Map<String, Integer>> calculateMonthlyRewards(@RequestBody List<Transaction> transactions) {
		Map<String, Map<Month, Integer>> monthlyPoints = rewardProgramService
				.calculateMonthlyRewardPoints(transactions);

		Map<String, Map<String, Integer>> customerMonthlyPoints = new HashMap<>();

		for (Map.Entry<String, Map<Month, Integer>> entry : monthlyPoints.entrySet()) {

			Map<String, Integer> monthPoints = new HashMap<>();

			for (Map.Entry<Month, Integer> month : entry.getValue().entrySet()) {
				monthPoints.put(month.getKey().name(), month.getValue());
			}
			customerMonthlyPoints.put(entry.getKey(), monthPoints);
		}

		return customerMonthlyPoints;

	}

	@PostMapping("/totalRewards")
	public Map<String, Integer> calculateTotalRewards(@RequestBody List<Transaction> transactions) {

		Map<String, Map<Month, Integer>> monthlyPoints = rewardProgramService
				.calculateMonthlyRewardPoints(transactions);
		return rewardProgramService.calculateTotalPoints(monthlyPoints);

	}

}
