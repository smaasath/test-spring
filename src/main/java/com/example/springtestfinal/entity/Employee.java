package com.example.springtestfinal.entity;

import jakarta.persistence.*;

@Entity
@Table
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "name")
    String name ;

    String password ;

//    @OneToOne
//    private Spouse spouse;

    public Employee(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public Employee() {}

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public Spouse getSpouse() {
//        return spouse;
//    }
//
//    public void setSpouse(Spouse spouse) {
//        this.spouse = spouse;
//    }
}
