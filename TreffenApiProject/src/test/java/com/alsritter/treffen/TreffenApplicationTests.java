package com.alsritter.treffen;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Slf4j
@SpringBootTest
class TreffenApplicationTests {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Test
    void contextLoads() {
        String encode = bCryptPasswordEncoder.encode("123");
        log.info(encode);
        assert bCryptPasswordEncoder.matches("123", "$2a$10$2jUojQkN9IXmJ/oT1JDwFOfn/PgnRVZ9OmLT5bJE1b19i7w9vtNfa");

    }

}
