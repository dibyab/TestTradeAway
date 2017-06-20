package com.thoughtworks.assignment.controller.dto;

import com.thoughtworks.assignment.domain.Gender;
import com.thoughtworks.assignment.domain.UserType;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by vrushali on 6/16/17.
 */
public class UserRegistration {

    private int id;

    private UserRegistration(){}

    public UserRegistration(String name, String email, String username, String address, String password, long mobile, UserType type) {
        this.name = name;
        this.email = email;
        this.username = username;
        this.address = address;
        this.password = password;
        this.mobile = mobile;
        this.type = type;
    }

    @NotEmpty(message = "name should not be empty")
    @Min(1)
    @Max(100)
    private String name;

    @NotEmpty(message = "email should not be empty")
    @Min(1)
    @Max(100)
    @Email(message = "email should be valid")
    private String email;

    @NotEmpty(message = "username should not be empty")
    @Min(1)
    @Max(100)
    private String username;

    @NotEmpty(message = "address should not be empty")
    @Min(1)
    private String address;

    @NotEmpty(message = "password should not be empty")
    @Min(1)
    @Max(100)
    private String password;

    @NotEmpty(message = "mobile number should not be empty")
    @Min(10)
    @Max(10)
    private long mobile;

    @NotNull(message = "user type should not be empty")
    private UserType type;

    private Gender gender;
    private Date dateOfBirth;

    @Min(1)
    @Max(20)
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

    public UserType getType() {
        return type;
    }

    public long getMobile() {
        return mobile;
    }

    public void setMobile(long mobile) {
        this.mobile = mobile;
    }
}
