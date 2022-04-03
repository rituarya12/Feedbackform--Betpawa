package com.luv2code.springboot.atmApp.rest;

import com.luv2code.springboot.atmApp.entity.ATM;
import com.luv2code.springboot.atmApp.entity.AccountDetailAndNotes;
import com.luv2code.springboot.atmApp.service.atmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/atm")
public class atmRestController {

    @Autowired
    private atmService atmService;

    @GetMapping("/getAccountDetails/{accountNumber}/{pin}")
    public ResponseEntity<ATM> getAccountDetails(@PathVariable Integer accountNumber, @PathVariable Integer pin) {
        ResponseEntity<ATM> responseEntity=null;
        ATM account = atmService.findByAccountNumberAndPin(accountNumber,pin);
        responseEntity = new ResponseEntity<>(account, HttpStatus.OK);

        if (account == null) {
            throw new RuntimeException("Invalid Account Number or Pin");
        }

        return responseEntity;
    }

    @GetMapping("/getBalance/{accountNumber}/{pin}")
    public ResponseEntity<String> getBalance(@PathVariable Integer accountNumber, @PathVariable Integer pin) {
        ResponseEntity<String> responseEntity=null;
        ATM account = atmService.findByAccountNumberAndPin(accountNumber,pin);
        responseEntity = new ResponseEntity<String>("Available Balance in your account is " +account.getBalance(), HttpStatus.OK);
        if (account == null) {
            responseEntity = new ResponseEntity<String>("Invalid Account Number or Incorrect Pin", HttpStatus.BAD_REQUEST );
            return responseEntity;
        }

        return responseEntity;
    }
    @PostMapping("/withdrawMoney/{accountNumber}/{pin}")
    public ResponseEntity<AccountDetailAndNotes> withdrawMoney(@PathVariable Integer accountNumber, @PathVariable Integer pin,
                                             @RequestParam Integer amount) {
        ResponseEntity<AccountDetailAndNotes> responseEntity = null;
        ATM account = atmService.findByAccountNumberAndPin(accountNumber, pin);
        if (amount > account.getBalance()) {
            throw new RuntimeException("Insufficient Balance, please enter lower amount");
        } else {
            AccountDetailAndNotes accountDetailAndNotes = atmService.save(account, amount);

            responseEntity = new ResponseEntity<>(accountDetailAndNotes, HttpStatus.OK);
            if (account == null) {
                throw new RuntimeException("Invalid Account Number or Pin");
            }

            return responseEntity;
        }
    }

    @GetMapping("/accounts")
    public List<ATM> findAll() {
        return atmService.findAll();
    }

    @PostMapping("/addNewAccount")
    public ATM addNewAccount(@RequestBody ATM atm) {


        atmService.save(atm);

        return atm;
    }

    @DeleteMapping("/deleteAccount/{accountNumber}")
    public String deleteAccount(@PathVariable int accountNumber) {

        ATM tempAccount = atmService.findByAccountNumber(accountNumber);

        // throw exception if null

        if (tempAccount == null) {
            throw new RuntimeException("Account Number not found - " + accountNumber);
        }

        atmService.deleteByAccountNumber(accountNumber);

        return "Deleted Account Number - " + accountNumber;
    }
}
