package com.example.ssvlvotings;

public class register {
  public  String  email, firstname, lastname, rollno, password;


    public register() {

    }


    public register(String email, String firstname, String lastname, String rollno,  String password) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.rollno = rollno;
        this.email = email;
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getRollno() {
        return rollno;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}

