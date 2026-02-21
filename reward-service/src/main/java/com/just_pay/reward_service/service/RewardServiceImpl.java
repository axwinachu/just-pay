package com.just_pay.reward_service.service;

import com.just_pay.reward_service.model.Reward;
import com.just_pay.reward_service.repository.RewardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RewardServiceImpl implements RewardService{
    private final RewardRepository rewardRepository;
    @Override
    public List<Reward> getRewardByUserId(Long userId) {
        return rewardRepository.findByUserId(userId);
    }

    @Override
    public Boolean rewardExistByTransactionId(Long transactionId) {
        return rewardRepository.existByTransactionId(transactionId);
    }

    @Override
    public Reward save(Reward reward) {
        return rewardRepository.save(reward);
    }
}
