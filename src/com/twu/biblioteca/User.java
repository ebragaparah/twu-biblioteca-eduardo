package com.twu.biblioteca;

import java.util.regex.*;

public class User {
    private String username, password, name, email, phone;

    public User(String username, String password, String name, String email, String phone) throws Exception {
        if(validateUsername(username)) {
            this.username = username;
        } else { throw new Exception("Invalid username format."); }
        this.password = password;
        this.name = name;
        this.email = email;
        if(validatePhone(phone)) {
            this.phone = phone;
        } else { throw new Exception("Invalid phone format."); }
    }

    private boolean validateUsername(String username) {
        Pattern pattern = Pattern.compile("^\\w{3}-\\w{4}$");
        Matcher matcher = pattern.matcher(username);
        return matcher.matches();
    }

    private boolean validatePhone(String phone) {
        Pattern pattern = Pattern.compile("^\\d{4}-\\d{4}$");
        Matcher matcher = pattern.matcher(phone);
        return matcher.matches();
    }

    public String getUsername() {
        return this.username;
    }

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPhone() {
        return this.phone;
    }
}
