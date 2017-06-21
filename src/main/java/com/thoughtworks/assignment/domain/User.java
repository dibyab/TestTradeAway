package com.thoughtworks.assignment.domain;

import javax.persistence.*;

/**
 * Created by vrushali on 6/16/17.
 */
@Entity
@Table(name = "app_user")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "discriminator",discriminatorType = DiscriminatorType.CHAR)
@DiscriminatorValue(value = "U")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "custom_sequence")
    @SequenceGenerator(name = "custom_sequence",sequenceName = "user_sequence")
    private int id;

    protected User(){}

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

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    private void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    private void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    private void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    private void setPassword(String password) {
        this.password = password;
    }

    public long getMobile() {
        return mobile;
    }

    private void setMobile(long mobile) {
        this.mobile = mobile;
    }

    public UserType getType() {
        return type;
    }

    private void setType(UserType type) {
        this.type = type;
    }
}
