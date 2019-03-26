package com.prueba.softcaribbean.test.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.test.context.TestPropertySource;

@Configuration
@ComponentScan({ "com.prueba.softcaribbean.dao", "com.prueba.softcaribbean.service", "com.prueba.softcaribbean.web" })
@TestPropertySource(value = { "classpath:softcaribbean.properties" })
@Lazy
public class AppConfig {

}
