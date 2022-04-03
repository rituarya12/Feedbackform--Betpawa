package com.luv2code.springboot.atmApp.entity;

import javax.persistence.*;

@Entity
@Table(name="atm_service")
public class ATM {

    @Column(name="name")
    private String name;
    @Id
    @Column(name="account_number")
    private String accountNumber;

    @Column(name="balance")
    private int balance;

    @Column(name="pin")
    private int pin;

    @Column(name="overdraft_balance")
    private int overdraft_balance;

    public ATM(String name, String account_number, int balance, int pin, int overdraft_balance) {
        this.name = name;
        this.accountNumber = account_number;
        this.balance = balance;
        this.pin = pin;
        this.overdraft_balance = overdraft_balance;
    }
    public ATM() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public int getOverdraft_balance() {
        return overdraft_balance;
    }

    public void setOverdraft_balance(int overdraft_balance) {
        this.overdraft_balance = overdraft_balance;
    }

    @Override
    public String toString() {
        return "ATM{" +
                ", name='" + name + '\'' +
                ", account_number='" + accountNumber + '\'' +
                ", balance=" + balance +
                ", pin=" + pin +
                ", overdraft_balance=" + overdraft_balance +
                '}';
    }
}
