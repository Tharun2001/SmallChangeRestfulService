package com.fidelity.smallChange.restservices;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
@Sql({"classpath:schema.sql", "classpath:data.sql"}) 
public class SmallChangeServiceE2eTest {

}
