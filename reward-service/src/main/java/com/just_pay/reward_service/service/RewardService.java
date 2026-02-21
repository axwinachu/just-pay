package com.just_pay.reward_service.service;

import com.just_pay.reward_service.model.Reward;

import java.util.List;

public interface RewardService {
    List<Reward> getRewardByUserId(Long userId);

    Boolean rewardExistByTransactionId(Long transactionId);

    Reward save(Reward reward);
}
