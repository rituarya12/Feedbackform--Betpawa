package com.luv2code.springboot.atmApp.entity;

import java.util.Map;

public class AccountDetailAndNotes {
    private ATM atm;
    private Map<Integer,Integer> withdrawNotes;
    int withdrawnAmount;

    public AccountDetailAndNotes(ATM atm, Map<Integer, Integer> withdrawNotes, int withdrawnAmount) {
        this.atm = atm;
        this.withdrawNotes = withdrawNotes;
        this.withdrawnAmount = withdrawnAmount;
    }

    public AccountDetailAndNotes(){

    }

    public int getWithdrawnAmount() {
        return withdrawnAmount;
    }

    public void setWithdrawnAmount(int withdrawnAmount) {
        this.withdrawnAmount = withdrawnAmount;
    }

    public ATM getAtm() {
        return atm;
    }

    public void setAtm(ATM atm) {
        this.atm = atm;
    }

    public Map<Integer, Integer> getWithdrawNotes() {
        return withdrawNotes;
    }

    public void setWithdrawNotes(Map<Integer, Integer> withdrawNotes) {
        this.withdrawNotes = withdrawNotes;
    }

    @Override
    public String toString() {
        return "AccountDetailAndNotes{" +
                "atm=" + atm +
                ", withdrawNotes=" + withdrawNotes +
                ", withdrawnAmount=" + withdrawnAmount +
                '}';
    }
}
