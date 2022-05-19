package com.zy.actinium.model.locator.impl;

import com.zy.actinium.model.locator.RequestValidateLocator;
import com.zy.actinium.model.locator.RequestValidator;
import com.zy.actinium.model.locator.domain.LocatorAction;
import com.zy.util.reflection.CastUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Neo
 */
@Component
public class ActionRequestValidateLocatorImpl implements RequestValidateLocator {
    private static final Logger LOGGER = LoggerFactory.getLogger(ActionRequestValidateLocatorImpl.class);

    public static final String DEFAULT_SEPARATOR = ":";
    private Map<String, RequestValidator> requestValidatorMap = new HashMap<>();

    @Autowired
    private List<RequestValidator> requestValidators;

    @Override
    public RequestValidator locateValidator(String locateCondition, LocatorAction locatorAction) {

        locateCondition = StringUtils.trimToEmpty(locateCondition);
        if (StringUtils.isBlank(locateCondition)) {
            String msg = "locateCondition is empty";
            throw new IllegalArgumentException(msg);
        }

        if (null == locatorAction) {
            String msg = "locationAction is null";
            throw new IllegalArgumentException(msg);
        }

        // Locate validator.

        String validatorKey = this.buildValidatorKey(locateCondition, locatorAction);

        LOGGER.info("validatorKey = {}", validatorKey);

        return CastUtils.cast(this.requestValidatorMap.get(validatorKey));
    }


    @PostConstruct
    private void initialize() {
        this.initRequestValidatorMap();
    }

    private String buildValidatorKey(RequestValidator requestValidator) {
        // Normalize parameters.

        String locateCondition = StringUtils.trimToEmpty(requestValidator.locateCondition());
        if (StringUtils.isBlank(locateCondition)) {
            String msg = "locateCondition is empty";
            throw new IllegalArgumentException(msg);
        }

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(locateCondition);


        LocatorAction locatorAction = requestValidator.locateAction();
        if (null == locatorAction) {
            String msg = "locationAction is null";
            throw new IllegalArgumentException(msg);
        }
        stringBuffer.append(DEFAULT_SEPARATOR)
                .append(locatorAction);
        return stringBuffer.toString();
    }

    private String buildValidatorKey(String locateCondition, LocatorAction locatorAction) {
        // Normalize parameters.

        locateCondition = StringUtils.trimToEmpty(locateCondition);
        if (StringUtils.isBlank(locateCondition)) {
            String msg = "locateCondition is empty";
            throw new IllegalArgumentException(msg);
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(locateCondition);

        if (null == locatorAction) {
            String msg = "locationAction is null";
            throw new IllegalArgumentException(msg);
        }
        stringBuffer.append(DEFAULT_SEPARATOR)
                .append(locatorAction);
        return stringBuffer.toString();
    }

    /**
     * 初始化操作请求参数校验器映射。
     */
    private void initRequestValidatorMap() {
        for (RequestValidator requestValidator : this.requestValidators) {
            String key = this.buildValidatorKey(requestValidator);
            this.requestValidatorMap.put(key, requestValidator);
        }
    }
}
