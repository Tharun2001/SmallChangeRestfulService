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
//	
	@Test
	void testInsertSecurities() {
        Security newSecurity = new Security(12, "Spacex", "TSLA",733.8,"Main Index");
        dao.insertSecurity(newSecurity);
        List<Security> allSecurity= dao.getSecurities();
    	assertEquals(11 ,allSecurity.size());

	}
//	
    @Test
    void testInsertNullSecurityId() throws Exception
    {
        assertThrows(MyBatisSystemException.class, () -> {
            dao.insertSecurity(null);
        });
    }
//    


    
    @Test
    void testDeleteSecurity() {
        int id = 3;
        dao.deleteSecurity(id);
    	List<Security> allSecurity= dao.getSecurities();
    	assertEquals(9 ,allSecurity.size());
    }
//    


//    
//
//    @Test
//    void testDeleteNegativeSecurityId() throws Exception
//    {
//    	int id =-1;
//        assertThrows(MyBatisSystemException.class, () -> {
//            dao.deleteSecurity(id);
//        });
//       
//    }
//    
//    @Test
//    void testDeleteZeroSecurityId() throws Exception
//    {
//    	int id =0;
//    	
//        assertThrows(MyBatisSystemException.class, () -> {
//            dao.deleteSecurity(id);
//        });
//      
//    }

}
