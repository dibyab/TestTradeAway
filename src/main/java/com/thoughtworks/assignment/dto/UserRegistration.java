package com.thoughtworks.assignment.dto;

import com.thoughtworks.assignment.domain.Gender;
import com.thoughtworks.assignment.domain.UserType;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by vrushali on 6/16/17.
 */
public class UserRegistration {

    private int id;

    public UserRegistration(String name, String email, String username, String address, String password, int mobile, UserType type) {
        this.name = name;
        this.email = email;
        this.username = username;
        this.address = address;
        this.password = password;
        this.mobile = mobile;
        this.type = type;
    }

    private String name;
    private String email;
    private String username;
    private String address;
    private String password;
    private int mobile;
    private UserType type;
    private Gender gender;
    private Date dateOfBirth;
    private String panNumber;
    private int yearExperience;
    private int monthExperience;

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

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getAddress() {
        return address;
    }

    public String getPassword() {
        return password;
    }

    public int getMobile() {
        return mobile;
    }

    public UserType getType() {
        return type;
    }
}
