package com.just_pay.reward_service.repository;

import com.just_pay.reward_service.model.Reward;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RewardRepository extends JpaRepository<Reward,Long> {
    List<Reward> findByUserId(Long userId);

    Boolean existByTransactionId(Long transactionId);
}
