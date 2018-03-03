package com.pgs.dao.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by Anand Sadawarte
 */
@Configuration
@EnableTransactionManagement
@EntityScan(basePackages = { "com.pgs.dao.entity", "com.pgs.repository" })
public class JPAConfig {

}
