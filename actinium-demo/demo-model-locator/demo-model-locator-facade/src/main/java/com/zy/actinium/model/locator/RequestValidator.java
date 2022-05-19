package com.zy.actinium.model.locator;

import com.zy.actinium.model.locator.domain.LocatorAction;
import com.zy.actinium.model.locator.domain.OperationRequest;
import java.util.List;

/**
 * @author Neo
 */
public interface RequestValidator {

    /**
     * 定位条件。
     *
     * @return
     */
    String locateCondition();

    /**
     * 定位动作。
     *
     * @return
     */
    LocatorAction locateAction();

    /**
     * 判断是否支持。
     *
     * @return
     */
    boolean support(OperationRequest operationRequest);

    /**
     * 校验。
     *
     * @return
     */
    boolean validate(OperationRequest operationRequest, List<Exception> errors);


}
