package com.zy.actinium.model.locator;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.transaction.TransactionAutoConfiguration;

@SpringBootApplication(exclude = { TransactionAutoConfiguration.class })
public class UnitTestApplication {
}