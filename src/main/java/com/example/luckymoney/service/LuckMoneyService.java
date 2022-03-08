package com.example.luckymoney.service;

import com.example.luckymoney.model.LuckMoney;
import com.example.luckymoney.repository.LuckMoneyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LuckMoneyService {

    @Autowired
    private LuckMoneyRepository repository;

    public List<LuckMoney> getLuckListByCommit(String commit) {
        return repository.findAllByCommit(commit).get();
    }
}
