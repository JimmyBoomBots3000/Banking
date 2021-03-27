package test;

import static org.junit.jupiter.api.Assertions.fail;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import io.github.jimmyboombots3000.banking.BankClient;


class TestBankingClass {
	
	static Map<Integer, BankClient> clientMap = new HashMap<Integer, BankClient>();;


	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		clientMap.put(1, new BankClient("Bob Jones", 1));
		clientMap.put(2, new BankClient("Sarah Davis", 2));
		clientMap.put(3, new BankClient("Amy Friendly", 1));
		clientMap.put(4, new BankClient("Johnny Smith", 1));
		clientMap.put(5, new BankClient("Carol Spears", 2));
	}

	@AfterEach
	void tearDown() throws Exception {
		clientMap.clear();
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}

//	@Test
//	void test() {
//		fail("Not yet implemented");
//	}
//	
//	@Test
//	void test() {
//		fail("Not yet implemented");
//	}
//	
//	@Test
//	void test() {
//		fail("Not yet implemented");
//	}
}
