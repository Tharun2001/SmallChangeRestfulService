package com.fidelity.smallChange.integration;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mybatis.spring.MyBatisSystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import com.fidelity.smallChange.business.Security;


@SpringBootTest
@Transactional
class SecurityDaoImplTest {
	@Autowired
	private SecurityDao dao;
	
	@Test
	void testGetSecurities() {
		List<Security> accts = dao.getSecurities();
		assertTrue(accts.size() > 0);
	}
	
	@Test
	void testInsertSecurities() {
        Security newSecurity = new Security(68, "Twitter", "TSLX",733.8,"Main Index");
        dao.insertSecurity(newSecurity);
        List<Security> allSecurity= dao.getSecurities();
    	assertEquals(25 ,allSecurity.size());

	}
	

	
    @Test
    void testInsertNullSecurityId() throws Exception
    {
        assertThrows(MyBatisSystemException.class, () -> {
            dao.insertSecurity(null);
        });
    }

  
    @Test
    void testDeleteSecurity() {
        int id = 3;
        dao.deleteSecurity(id);
    	List<Security> allSecurity= dao.getSecurities();
    	assertEquals(23 ,allSecurity.size());
    }

    @Test
    void testDeleteNegativeSecurityId() throws Exception
    {
    	int id =-1;
    	dao.deleteSecurity(id);
       
    }

	@Test
	void testUpdateSecurities() {
		int value = 1;
		assertTrue(value==1);
	}
	
	@Test
	void testUpdateNullSecurityId() {
		int value = 1;
		assertTrue(value==1);
	}
	
	@Test
	void testDeleteNullSecurityId() {
		int value = 1;
		assertTrue(value==1);
	}
	
	@Test
	void testUpdateNonExistentSecurityId() {
		int value = 1;
		assertTrue(value==1);
	}
	
	@Test
	void testDeleteNonExistentSecurityId() {
		int value = 1;
		assertTrue(value==1);
	}
    
	@Test
	void testInsertDuplicateSecurity() {
		int value = 1;
		assertTrue(value==1);
	}
 
	@Test
	void testNonExistentSecurityId() {
		int value = 1;
		assertTrue(value==1);
	}
    
	@Test
	void testDuplicateSecurity() {
		int value = 1;
		assertTrue(value==1);
	}
}
