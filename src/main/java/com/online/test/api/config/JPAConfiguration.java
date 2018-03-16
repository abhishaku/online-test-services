package com.online.test.api.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by Abhishek Mishra
 */
@Configuration
@EnableTransactionManagement
@EntityScan(basePackages = { "com.online.test.api.dao.entity", "com.online.test.api.repository" })
public class JPAConfiguration {

}
