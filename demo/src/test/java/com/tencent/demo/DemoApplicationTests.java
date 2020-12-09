package com.tencent.demo;

import com.tencent.demo.bean.Person;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class DemoApplicationTests {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    Person person;

    @Autowired
    ApplicationContext ioc;

    @Test
    void sayHello(){
        boolean b = ioc.containsBean("helloServices");
        System.out.println(b);
    }

    @Test
    void contextLoads() {
        logger.info("s");
        System.out.println(person);
    }

}
