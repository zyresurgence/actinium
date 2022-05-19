package com.zy.actinium.model.locator;


import com.zy.actinium.model.locator.domain.LocatorAction;

/**
 * @author Neo
 */
public interface RequestValidateLocator {

    /**
     * 定位校验器
     *
     * @param locateCondition      定位条件。
     * @param locatorAction        定位动作。
     * @return
     */
    RequestValidator locateValidator(String locateCondition, LocatorAction locatorAction);
}
