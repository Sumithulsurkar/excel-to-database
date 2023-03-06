package com.dailycodework.excel2database.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    private Integer customerId;
    private String firstName;
    private String country;
    private Integer telephone;
}
