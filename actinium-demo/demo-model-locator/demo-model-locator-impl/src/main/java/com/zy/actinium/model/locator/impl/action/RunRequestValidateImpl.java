package com.zy.actinium.model.locator.impl.action;

import com.zy.actinium.model.locator.AbstractRequestValidateLocator;
import com.zy.actinium.model.locator.domain.LocatorAction;
import com.zy.actinium.model.locator.domain.OperationRequest;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * @author Neo
 */
@Service
public class RunRequestValidateImpl extends AbstractRequestValidateLocator {


    public RunRequestValidateImpl(){
        this.setLocateCondition("action");
        this.setLocatorAction(LocatorAction.RUN);
    }

    @Override
    public boolean support(OperationRequest operationRequest) {
        return false;
    }

    @Override
    public boolean validate(OperationRequest operationRequest, List<Exception> errors) {
        return false;
    }
}
