package com.project.coursemanager.models;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;

/*
 * @Entity : Used to Mark as Table for JPA
 *
 * @JsonTypeInfo : Tells the superClass User to AutoCast to Student or Faculty depending upon type property
 * [https://stackoverflow.com/questions/27170298/spring-reponsebody-requestbody-with-abstract-class  ]
 *
 * @Inheritance(strategy = "") : Tells the Inheritance Strategy to use, see below link
 * https://www.thoughts-on-java.org/complete-guide-inheritance-strategies-jpa-hibernate/
 * */


    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = As.PROPERTY, property = "type")
    @JsonSubTypes({
        @JsonSubTypes.Type(value = Faculty.class, name = "FACULTY"),
        @JsonSubTypes.Type(value = Student.class, name = "STUDENT") })
    @Entity
    @Inheritance(strategy = InheritanceType.JOINED)
    public abstract class User {
        @Id
        @GeneratedValue(strategy=GenerationType.IDENTITY)
         int id;
        @Column(nullable = false)
        private String username;
        @Column(nullable = false)
        private String password;
        private String firstName;
        private String lastName;


        public int getId() {
            return id;
        }
        public void setId(int id) {
            this.id = id;
        }
        public String getUsername() {
            return username;
        }
        public void setUsername(String username) {
            this.username = username;
        }
        public String getPassword() {
            return password;
        }
        public void setPassword(String password) {
            this.password = password;
        }
        public String getFirstName() {
            return firstName;
        }
        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }
        public String getLastName() {
            return lastName;
        }
        public void setLastName(String lastName) {
            this.lastName = lastName;
        }
        public User() {
            super();
        }
        public User(int id, String username, String password, String firstName, String lastName) {
            super();
            this.id = id;
            this.username = username;
            this.password = password;
            this.firstName = firstName;
            this.lastName = lastName;
        }
        public User(String username, String password, String firstName, String lastName) {
            super();
            this.username = username;
            this.password = password;
            this.firstName = firstName;
            this.lastName = lastName;
        }
        public void set(User newUser) {
            this.username = newUser.username != null ? newUser.username : this.username;
            this.password = newUser.password != null ? newUser.password : this.password;
            this.firstName = newUser.firstName != null ? newUser.firstName : this.firstName;
            this.lastName = newUser.lastName != null ? newUser.lastName : this.lastName;
        }
    }


