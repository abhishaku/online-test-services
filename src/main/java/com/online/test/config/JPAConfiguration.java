package com.online.test.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by Abhishek Mishra
 */
@Configuration
@EnableTransactionManagement
@EntityScan(basePackages = { "com.online.test.dao.entity", "com.online.test.repository" })
public class JPAConfiguration {

}
