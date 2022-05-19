package com.zy.actinium.model.locator.impl;

import com.zy.actinium.model.locator.RequestValidateLocator;
import com.zy.actinium.model.locator.RequestValidator;
import com.zy.actinium.model.locator.domain.LocatorAction;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class LocatorImplTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(LocatorImplTest.class);

    @Autowired
    private RequestValidateLocator validateLocator;

    @Test
    public void test(){

        String locateCondition = "action";
        LocatorAction run = LocatorAction.FLY;

        RequestValidator requestValidator = validateLocator.locateValidator(locateCondition, run);
        LocatorAction locatorAction = requestValidator.locateAction();
        LOGGER.info("locatorAction: {}",locatorAction.name());
    }
}
