package com.luv2code.springboot.atmApp.service;

import com.luv2code.springboot.atmApp.entity.ATM;
import com.luv2code.springboot.atmApp.entity.AccountDetailAndNotes;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface atmService {



    @Transactional
    ATM findByAccountNumber(int account_number);

    @Transactional
    ATM findByAccountNumberAndPin(Integer accountNumber, Integer pin);

    @Transactional
    void updatePin(Integer accountNumber, Integer pin);

    public List<ATM> findAll();


    @Transactional
    AccountDetailAndNotes save(ATM atm, Integer amount);

    @Transactional
    ATM save(ATM atm);

    public void deleteByAccountNumber(int account_number);
}
