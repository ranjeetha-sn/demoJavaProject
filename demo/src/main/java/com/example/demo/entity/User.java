package com.example.demo.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Usr_Tbl")
public class User {
    private String username;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

}
