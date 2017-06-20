package com.thoughtworks.assignment.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by vrushali on 6/16/17.
 */
@Entity(name = "app_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "custom_sequence")
    @SequenceGenerator(name = "custom_sequence",sequenceName = "user_sequence")
    private int id;

    private User(){}

    public User(String name, String email, String username, String address, String password, long mobile, UserType type) {
        this.name = name;
        this.email = email;
        this.username = username;
        this.address = address;
        this.password = password;
        this.mobile = mobile;
        this.type = type;
    }

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "email",nullable = false)
    private String email;

    @Column(name = "username",nullable = false)
    private String username;

    @Column(name = "address",nullable = false)
    private String address;

    @Column(name = "password",nullable = false)
    private String password;

    @Column(name = "mobile",nullable = false)
    private long mobile;

    @Enumerated(EnumType.STRING)
    private UserType type;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @Column(name = "pan_number")
    private String panNumber;

    @Column(name = "year_experience")
    private int yearExperience;

    @Column(name = "month_experience")
    private int monthExperience;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getMobile() {
        return mobile;
    }

    public void setMobile(long mobile) {
        this.mobile = mobile;
    }

    public UserType getType() {
        return type;
    }

    public void setType(UserType type) {
        this.type = type;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPanNumber() {
        return panNumber;
    }

    public void setPanNumber(String panNumber) {
        this.panNumber = panNumber;
    }

    public int getYearExperience() {
        return yearExperience;
    }

    public void setYearExperience(int yearExperience) {
        this.yearExperience = yearExperience;
    }

    public int getMonthExperience() {
        return monthExperience;
    }

    public void setMonthExperience(int monthExperience) {
        this.monthExperience = monthExperience;
    }
}
