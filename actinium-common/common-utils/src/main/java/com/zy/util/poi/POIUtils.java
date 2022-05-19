package com.zy.util.poi;

import com.zy.annotation.ExcelColumn;
import com.zy.annotation.ExcelSheet;
import com.zy.util.reflection.CastUtils;
import com.zy.util.reflection.ReflectionUtils;
import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellUtil;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class POIUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(POIUtils.class);

    private static final String XLS = ".xls";

    private static final String XLSX = ".xlsx";

    public void fill(Workbook batchFileWorkbook, List<?> dataList) {

    }

    /**
     * 指定单元格填充数据。
     *
     * @param file        需要操作的file文件
     * @param sheetIndex  sheet索引
     * @param rowIndex    行索引
     * @param columnIndex 列索引
     * @param value       插入的值
     * @return workbook对象用于后续操作，最终可用于数据导出。
     */
    public static Workbook fillSpecificColumnValue(File file, int sheetIndex, int rowIndex, int columnIndex, String value) {
        Workbook workbook = getWorkBook(file);
        Sheet sheet = workbook.getSheetAt(sheetIndex);
        Row row = CellUtil.getRow(rowIndex, sheet);
        Cell cell = CellUtil.getCell(row, columnIndex);
        cell.setCellValue(value);
        return workbook;
    }

    /**
     * 导出excel，需要准备模板excel 根据model注解向对应的行列插入数据。
     *
     * @param obj          obj对象，用于操作excel 仅支持 File 或者 HSSFWorkbook XSSFWorkbook。
     * @param dataList     数据集合。
     * @param clazz        数据对象class，用于确定对应属性。
     * @param outputStream 输出流。
     * @param <T>          方法泛型。
     */
    public static <T> void fillExcel(Object obj, List<T> dataList, Class<T> clazz, OutputStream outputStream, String... ignoreParams) {
        Workbook workbook = null;
        if (obj instanceof File) {
            workbook = getWorkBook(CastUtils.cast(obj));
        } else if (obj instanceof HSSFWorkbook) {
            workbook = CastUtils.cast(obj);
        } else if (obj instanceof XSSFWorkbook) {
            workbook = CastUtils.cast(obj);
        } else {
            String msg = "object type only support File, HSSFWorkbook, XSSFWorkbook please check.";
            throw new IllegalArgumentException(msg);
        }

        ExcelSheet excelSheet = clazz.getAnnotation(ExcelSheet.class);
        int rowFrom = excelSheet.rowFrom();
        Sheet sheet = workbook.getSheetAt(0);
        Field[] fields = clazz.getDeclaredFields();
        for (T data : dataList) {
            int reduceNum = 0;
            outer:
            for (Field field : fields) {
                ExcelColumn excelColumn = field.getAnnotation(ExcelColumn.class);
                if (excelColumn == null) {
                    continue;
                }

                for (String ignoreParam : ignoreParams) {
                    if (field.getName().equals(ignoreParam)) {
                        reduceNum++;
                        continue outer;
                    }
                }

                int columnIndex = excelColumn.value() - reduceNum;
                Object fieldValue = null;
                try {
                    fieldValue = ReflectionUtils.getFieldValue(data, field);
                } catch (IllegalArgumentException e) {
                    throw new IllegalArgumentException(e);
                } catch (IllegalAccessException e) {
                    throw new IllegalArgumentException(e);
                }

                Row row = CellUtil.getRow(rowFrom, sheet);
                Cell cell = CellUtil.getCell(row, columnIndex);
                CellUtils.setCellValue(cell, fieldValue);
            }
            rowFrom++;
        }

        try {
            workbook.write(outputStream);
            workbook.close();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 读取指定单元格数据
     *
     * @param file
     * @param sheetIndex
     * @param rowIndex
     * @param columnIndex
     * @return
     */
    public static String readSpecificCellValue(File file, int sheetIndex, int rowIndex, int columnIndex) {
        if (file == null) {
            String msg = "\"file\" is null.";
            throw new IllegalArgumentException(msg);
        }

        if (!file.exists()) {
            String msg = "\"file\" does not exist.";
            throw new IllegalArgumentException(msg);
        }

        if (sheetIndex < 0) {
            String msg = "\"sheetIndex\" is less than 0.";
            throw new IllegalArgumentException(msg);
        }
        if (rowIndex < 0) {
            String msg = "\"rowIndex\" is less than 0.";
            throw new IllegalArgumentException(msg);
        }
        if (columnIndex < 0) {
            String msg = "\"columnIndex\" is less than 0.";
            throw new IllegalArgumentException(msg);
        }

        // 获取Excel工作簿。
        Workbook workbook = getWorkBook(file);
        if (workbook == null) {
            String msg = "\"workbook\" is null.";
            throw new IllegalArgumentException(msg);
        }

        // 获取工作簿中的工作表。
        Sheet sheet = workbook.getSheetAt(sheetIndex);
        if (sheet == null) {
            String msg = "\"sheet\" is null.";
            throw new IllegalArgumentException(msg);
        }

        // 获取工作表中的行。
        Row row = sheet.getRow(rowIndex);
        if (row == null) {
            String msg = "\"row\" is null.";
            throw new IllegalArgumentException(msg);
        }

        // 获取行中的列。
        Cell cell = row.getCell(columnIndex);
        if (cell == null) {
            String msg = "\"cell\" is null.";
            throw new IllegalArgumentException(msg);
        }

        return convertCellValueToString(cell);
    }

    /**
     * 读取 excel文件
     *
     * @param file
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> List<T> read(File file, Class<T> clazz) {
        Workbook workbook = getWorkBook(file);

        List<T> list = new ArrayList<>();

        for (int sheetNum = 0; sheetNum < workbook.getNumberOfSheets(); sheetNum++) {
            Sheet sheet = workbook.getSheetAt(sheetNum);

            // 校验sheet是否合法
            if (sheet == null) {
                continue;
            }

            ExcelSheet excelSheet = clazz.getAnnotation(ExcelSheet.class);

            // 与excelSheet注解标记的sheet不匹配
            int i = excelSheet.sheetIndex();
            if (sheetNum != i){
                continue;
            }

            int rowFrom = excelSheet.rowFrom();

            // 解析每一行的数据，构造数据对象
            int rowEnd = sheet.getPhysicalNumberOfRows();
            for (int rowNum = rowFrom; rowNum < rowEnd; rowNum++) {
                Row row = sheet.getRow(rowNum);

                if (null == row) {
                    continue;
                }
                list.add(convertRowToData(row, clazz));
            }
        }
        return list;
    }


    /**
     * 读取 行数据
     *
     * @param row
     * @param clazz
     * @param <T>
     * @return
     */
    private static <T> T convertRowToData(Row row, Class<T> clazz) {
        T t = null;
        try {
            t = clazz.getDeclaredConstructor().newInstance();
            Field[] fields = clazz.getDeclaredFields();

            for (Field field : fields) {
                ExcelColumn excelColumn = field.getAnnotation(ExcelColumn.class);
                if (excelColumn == null) {
                    LOGGER.warn("excelColumn is null.");
                    continue;
                }

                int value = excelColumn.value();
                Cell cell;
                cell = row.getCell(value);
                String cellValue = convertCellValueToString(cell);
                PropertyDescriptor pd = new PropertyDescriptor(field.getName(), clazz);
                Method setMethod = pd.getWriteMethod();
                if (cellValue == null) {
                    continue;
                }
                setMethod.invoke(t, cellValue);
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IntrospectionException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return t;
    }


    /**
     * 根据文件后缀确定 excel poi对象
     *
     * @param file
     * @return
     */
    private static Workbook getWorkBook(File file) {
        Workbook workbook = null;

        if (file == null) {
            String msg = "\"file\" is null.";
            throw new IllegalArgumentException(msg);
        }

        if (!file.exists()) {
            String msg = "\"file\" is not exists.";
            throw new IllegalArgumentException(msg);
        }

        if (file.getName().endsWith(XLS)) {
            try {
                workbook = new HSSFWorkbook(new FileInputStream(file));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (file.getName().endsWith(XLSX)) {
            try {
                workbook = new XSSFWorkbook(new FileInputStream(file));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            String msg = "The format is incorrect, please confirm the file.";
            throw new IllegalArgumentException(msg);
        }
        return workbook;
    }

    /**
     * 将单元格内容转换为字符串。
     *
     * @param cell
     * @return
     */
    private static String convertCellValueToString(Cell cell) {
        if (cell == null) {
            return null;
        }

        String returnValue = null;
        switch (cell.getCellType()) {

            // 数字。
            case NUMERIC:
                Double doubleValue = cell.getNumericCellValue();

                // 格式化科学计数法，取一位整数。
                DecimalFormat df = new DecimalFormat("#");
                returnValue = df.format(doubleValue);
                break;

            // 字符串。
            case STRING:
                returnValue = cell.getStringCellValue();
                break;

            // 布尔。
            case BOOLEAN:
                Boolean booleanValue = cell.getBooleanCellValue();
                returnValue = booleanValue.toString();
                break;

            // 空值。
            case BLANK:
                break;

            // 公式。
            case FORMULA:
                returnValue = cell.getCellFormula();
                break;

            // 故障。
            case ERROR:
                break;
            default:
                break;
        }
        return returnValue;
    }
}
