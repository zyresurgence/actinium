package com.zy.actinium.model.locator.spring.boot.autoconfiguration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource({ "classpath*:META-INF/spring/*.xml" })
public class UnitTestAutoConfiguration {
}