package com.example.luckymoney.repository;

import com.example.luckymoney.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
