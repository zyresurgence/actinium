package com.zy.util.poi;

import com.zy.util.reflection.CastUtils;
import java.math.BigDecimal;
import org.apache.poi.ss.usermodel.Cell;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CellUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(CellUtils.class);

    public static void setCellValue(Cell cell, Object value) {
        if (value == null) {
            LOGGER.warn("\"value\" is null.");
            return;
        }

        if (value instanceof String) {
            String cellValue = CastUtils.cast(value);
            cell.setCellValue(cellValue);
        } else if (value instanceof BigDecimal) {
            BigDecimal cellValue = CastUtils.cast(value);
            cell.setCellValue(cellValue.doubleValue());
        } else {
            String msgFormat = "The type of \"fieldValue\" is %s.";
            String msg = String.format(msgFormat, value.getClass().getCanonicalName());
            LOGGER.warn(msg);

            cell.setCellValue(value.toString());
        }
    }
}
