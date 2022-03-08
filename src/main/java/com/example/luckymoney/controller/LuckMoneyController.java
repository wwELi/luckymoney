package com.example.luckymoney.controller;

import com.example.luckymoney.model.LuckMoney;
import com.example.luckymoney.model.Result;
import com.example.luckymoney.repository.LuckMoneyRepository;
import com.example.luckymoney.service.LuckMoneyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/money")
@Slf4j
public class LuckMoneyController {

    @Autowired
    LuckMoneyRepository repository;

    @Autowired
    private LuckMoneyService service;

    @GetMapping
    public List<LuckMoney> getLuckMoney() {
        return repository.findAll();
    }

    @GetMapping("/commit")
    public Optional<List<LuckMoney>> getLuckMoneyByCommit(@RequestParam String commit, @RequestParam(defaultValue = "") String id) {
        return repository.findAllByCommitLikeAndId("%" + commit+ "%", id);
    }

    @PostMapping
    public Result saveLuckMoney(@Valid LuckMoney luckMoney, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.println("Error" + bindingResult.getAllErrors());
        }

        return Result.builder()
                .code(1)
                .data(repository.save(luckMoney))
                .msg("success")
                .build();
    }

//    @GetMapping("/{commit}")
//    public List<LuckMoney> getMoneyByCommit(@PathVariable String commit) throws NotFoundException {
////        Optional<List<LuckMoney>> optional = repository.findAllByCommit(commit);
////
////        if (!optional.isPresent()) {
////            throw new NotFoundException(MessageFormat.format("not find this commit {0}", commit));
////        }
////
////        return optional.get();
//        return service.getLuckListByCommit(commit);
//    }
}
