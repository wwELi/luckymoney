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
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name="group", schema = "luck_service")
public class Group {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    private String GroupName;

    @JsonIgnoreProperties(value = {"groups"})
    @ManyToMany(mappedBy = "groups")
//    @JoinTable(name = "user_group", joinColumns = { @JoinColumn(name = "grou_id", referencedColumnName="id") }, inverseJoinColumns = {
//            @JoinColumn(name = "user_id", referencedColumnName="id") })
    private List<User> users;
}
