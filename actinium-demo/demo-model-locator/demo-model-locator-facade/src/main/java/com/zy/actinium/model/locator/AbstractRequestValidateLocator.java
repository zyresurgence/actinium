package com.zy.actinium.model.locator;


import com.zy.actinium.model.locator.domain.LocatorAction;
import com.zy.actinium.model.locator.domain.OperationRequest;

/**
 * @author Neo
 */
public abstract class AbstractRequestValidateLocator implements RequestValidator {

    public LocatorAction locatorAction;
    private String locateCondition = "";

    public AbstractRequestValidateLocator() {
    }

    @Override
    public String locateCondition() {
        return this.locateCondition;
    }

    @Override
    public LocatorAction locateAction() {
        return this.locatorAction;
    }

    public void setLocateCondition(String locateCondition) {
        this.locateCondition = locateCondition;
    }

    public void setLocatorAction(LocatorAction locatorAction) {
        this.locatorAction = locatorAction;
    }

    @Override
    public boolean support(OperationRequest operationRequest) {
        throw new UnsupportedOperationException();
    }
}
