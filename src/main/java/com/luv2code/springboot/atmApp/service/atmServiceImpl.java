package com.luv2code.springboot.atmApp.service;

import com.luv2code.springboot.atmApp.dao.atmDAO;
import com.luv2code.springboot.atmApp.entity.ATM;
import com.luv2code.springboot.atmApp.entity.AccountDetailAndNotes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class atmServiceImpl implements atmService {
    private atmDAO atmDAO;
    @Autowired
    public atmServiceImpl(atmDAO atmDAO) {
        this.atmDAO = atmDAO;
    }
    public atmServiceImpl(){

    }

    @Override
    @Transactional
    public ATM findByAccountNumber(int account_number) {

        return atmDAO.findByAccountNumber(account_number);
    }
    @Override
    @Transactional
    public ATM findByAccountNumberAndPin(Integer accountNumber, Integer pin) {
        return atmDAO.findByAccountNumberAndPin(accountNumber,pin);
    }

    @Override
    @Transactional
    public void updatePin(Integer accountNumber, Integer pin) {
      atmDAO.updatePin(accountNumber,pin);
    }

    @Override
    @Transactional
    public List<ATM> findAll() {
        return atmDAO.findAll();
    }

    @Override
    @Transactional
    public AccountDetailAndNotes save(ATM atm, Integer amount) {
        AccountDetailAndNotes accountDetailAndNotes = new AccountDetailAndNotes();
        Integer availableAmountInBank = 1500;
        Map<Integer, Integer> notesMap = new HashMap<Integer, Integer>();
        notesMap.put(50, 10);
        notesMap.put(20, 30);
        notesMap.put(10, 30);
        notesMap.put(5, 20);
        Map<Integer, Integer> withdrawNotes = new HashMap<>();
         //Map<Integer, Integer> notes =notesMap;
        if (amount > availableAmountInBank) {
            throw new RuntimeException("Amount exceeded, current available amount in ATM is " + availableAmountInBank + "please select amount less than this.");
        }
        else{
            withdrawNotes= withdrawAmt(amount,notesMap);
        }

        atm.setBalance(atm.getBalance() - amount);
        atmDAO.save(atm);
        accountDetailAndNotes.setAtm(atm);
        accountDetailAndNotes.setWithdrawNotes(withdrawNotes);
        accountDetailAndNotes.setWithdrawnAmount(amount);
        return accountDetailAndNotes;
    }
    public Map<Integer, Integer> withdrawAmt(int amt, Map<Integer, Integer> notesMap){
        Map<Integer, Integer> returnedMap = new HashMap<Integer, Integer>();
        Map<Integer, Integer> notes =notesMap;

        //get sorted denominations
        TreeSet<Integer> denominations = new TreeSet<Integer>(notes.keySet());
        Iterator<Integer> iter = denominations.descendingIterator();

        while(amt > 0 ){
            int denomination = iter.next();
            int noOfNotes = amt< denomination ? 0 : amt/denomination;
            returnedMap.put(denomination, noOfNotes);
            amt = amt - (denomination * noOfNotes);
            reduceBalance(denomination, noOfNotes,notes);
        }
        return returnedMap;
    }
    private void reduceBalance(int denomination, int noToReduce, Map<Integer, Integer> notes){
        int amt = notes.get(denomination);
        notes.remove(denomination);
        notes.put(denomination, amt-noToReduce);
    }
    @Override
    @Transactional
    public ATM save(ATM atm) {
    atmDAO.save(atm);
    return atm;
    }
    @Override
    @Transactional
    public void deleteByAccountNumber(int account_number) {
        atmDAO.deleteByAccountNumber(account_number);
    }
}
