package com.company;

public class Client {private String accountNumber;
    private String pin;
    private String name;
    private String surname;
    private double amount;
    private String currency;

    public Client(String accountNumber, String pin, String name, String surname, double amount, String currency) {
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.name = name;
        this.surname = surname;
        this.amount = amount;
        this.currency = currency;
    }

    public String getAccountNumber() {
        return this.accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getPin() {
        return this.pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public double getAmount() {
        return this.amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return this.currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}



