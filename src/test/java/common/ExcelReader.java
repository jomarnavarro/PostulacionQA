package common;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.formula.functions.Column;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

public class ExcelReader {

    public static final String EXCEL_DATA_PATH = "src/test/resources/data/";
    public static final String EXCEL_DATA_FILE_NAME = "productData.xlsx";
    private Workbook workbook;
    private Sheet sheet;

    public ExcelReader() throws IOException {
        FileInputStream file = new FileInputStream(
                new File(
                        EXCEL_DATA_PATH + EXCEL_DATA_FILE_NAME
                )
        );
        workbook = new XSSFWorkbook(file);
        sheet = workbook.getSheet("datos");
    }

    public String getData(String column, int rowNumber) {
        int firstRowNumber = sheet.getFirstRowNum();
        Row firstRow = sheet.getRow(firstRowNumber);
        int columnNumber = findColumnNumber(firstRow, column);
        return sheet.getRow(firstRowNumber + rowNumber)
                .getCell(columnNumber)
                .getStringCellValue();

    }

    public int findColumnNumber(Row row, String columnText) {
        int lastColumn = row.getLastCellNum();
        for(int i = 0; i <= lastColumn; i++)
            if(row.getCell(i).getStringCellValue().equals(columnText))
                return i;
        return -1;
    }


}
