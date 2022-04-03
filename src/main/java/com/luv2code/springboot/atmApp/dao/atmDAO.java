package com.luv2code.springboot.atmApp.dao;

import com.luv2code.springboot.atmApp.entity.ATM;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface atmDAO extends Repository<ATM, Integer>{
        @Query(value ="SELECT * FROM atm_service where account_number = :account_number",nativeQuery = true)
        public  ATM findByAccountNumber(int account_number);
        public List<ATM> findAll();
        @Query(value ="SELECT * FROM atm_service where account_number = :accountNumber and pin = :pin",nativeQuery = true)
        public ATM findByAccountNumberAndPin(@Param("accountNumber") Integer accountNumber, @Param("pin") Integer pin);

        @Query(value ="UPDATE atm_service set pin =:pin where account_number = :accountNumber",nativeQuery = true)
        public ATM updatePin(@Param("accountNumber") Integer accountNumber,@Param("pin") Integer pin);

        public void save(ATM atm);
        @Modifying
        @Query(value ="DELETE FROM atm_service where account_number = :account_number",nativeQuery = true)
        public void deleteByAccountNumber(int account_number);
}
