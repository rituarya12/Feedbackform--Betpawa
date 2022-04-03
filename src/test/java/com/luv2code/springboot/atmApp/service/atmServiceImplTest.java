package com.luv2code.springboot.atmApp.service;

import com.luv2code.springboot.atmApp.dao.atmDAO;
import com.luv2code.springboot.atmApp.entity.ATM;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
public class atmServiceImplTest {

atmServiceImpl atmService;

@Mock
atmDAO atmDAO;

	ATM account = new ATM();

@BeforeEach
public void setup(){


	account.setAccountNumber("987654321");
	account.setBalance(1200);
	account.setPin(4321);
	account.setName("John");
	account.setOverdraft_balance(150);
	atmService = new atmServiceImpl();
}
	@Test
	public void findByAccountNumber() {
		int account_number=987654321;

		Mockito.when(atmDAO.findByAccountNumber(Mockito.any())).thenReturn(account);
		assertNotNull(atmService.findByAccountNumber(account_number));

	}

	@Test
	void findByAccountNumberAndPin() {
	}

	@Test
	void updatePin() {
	}

	@Test
	void findAll() {
	}

	@Test
	void save() {
	}

	@Test
	void withdrawAmt() {
	}

	@Test
	void testSave() {
	}

	@Test
	void deleteByAccountNumber() {
	}
}
