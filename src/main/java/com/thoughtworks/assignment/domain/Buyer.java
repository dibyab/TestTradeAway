package com.thoughtworks.assignment.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by vrushali on 6/21/17.
 */
@Entity
@DiscriminatorValue(value = "B")
public class Buyer extends User{

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    protected Buyer(){}

    public Buyer(String name, String email, String username, String address, String password, long mobile) {
        super(name,email,username,address,password,mobile,UserType.BUYER);
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
