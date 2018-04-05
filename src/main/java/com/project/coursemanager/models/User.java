package com.project.coursemanager.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

    @Entity
    public class User {
        @Id
        @GeneratedValue(strategy=GenerationType.IDENTITY)
        private int id;
        private String username;
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


