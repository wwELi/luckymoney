package com.example.luckymoney.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name="user", schema = "luck_service")
public class User {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    private String userName;

    @JsonIgnoreProperties(value = {"users"})
    @ManyToMany
    @JoinTable(name = "user_group", joinColumns = {
            @JoinColumn(name = "user_id", referencedColumnName="id") }, inverseJoinColumns = {
            @JoinColumn(name = "grou_id", referencedColumnName="id") })
    private List<Group> groups;

}
