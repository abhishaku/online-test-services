package com.epam.online.test.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by Abhishek Mishra
 */
@Configuration
@EnableTransactionManagement
@EntityScan(basePackages = { "com.epam.online.test.dao.entity", "com.epam.online.test.repository" })
public class JPAConfiguration {

}
