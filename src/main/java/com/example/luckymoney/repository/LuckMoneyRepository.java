package com.example.luckymoney.repository;

import com.example.luckymoney.model.LuckMoney;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LuckMoneyRepository extends JpaRepository<LuckMoney, String> {
    Optional<List<LuckMoney>> findAllByCommit(String commit);
    Optional<LuckMoney> findByCommit(String commit);
    Optional<List<LuckMoney>> findAllByCommitLikeAndId(String commit, String id);
}
