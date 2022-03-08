package com.example.luckymoney.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "money_rule")
public class MoneyRule {

    @Id
    private String id;

    private String expression;

    private String description;

    private String warningmessage;
}
