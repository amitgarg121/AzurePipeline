package com.Mercury.utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile {

	XSSFWorkbook wb;
	XSSFSheet sheet; 
		
	public ReadExcelFile(String excelPath) 
	{
		try 
		{
			File src = new File (excelPath); 
			FileInputStream fis = new FileInputStream(src);
			wb = new XSSFWorkbook(fis); 
		} 
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
		}
	}
	
	public String getData (int sheetNumber, int row, int column)
	{
		sheet = wb.getSheetAt(sheetNumber);
		String data = sheet.getRow(row).getCell(column).getStringCellValue();
		return data; 
	}
	
	public int getRowCount(String strSheetName)
	{
		int row = wb.getSheet(strSheetName).getLastRowNum();
		row = row + 1;
		return row; 
	}
	public int getColCount(String strSheetName)
	{
		int col = wb.getSheet(strSheetName).getRow(0).getLastCellNum(); 
		return col; 
	}
	
	public String getRowDataBasedOnColumnName (String strSheetName, int rowNum, String colName)
    {
    	//String strData; 
		sheet = wb.getSheet(strSheetName); 
	
		int colNum = 0; 
		XSSFRow row; 
		String strData = null ; 
		
		Iterator<Row> rows = sheet.iterator(); 
		Row headerRow = rows.next(); 
		
		Iterator<Cell> ce = headerRow.iterator(); 
		while(ce.hasNext()) {
			
			Cell c = ce.next(); 	
			
			if (c.getStringCellValue().trim().equalsIgnoreCase(colName)) {
				break;
			}
			colNum ++;
		}
		
		row = sheet.getRow(rowNum);
		Cell c = row.getCell(colNum); 
		if (c.getCellTypeEnum()==CellType.STRING) {
			strData = row.getCell(colNum).getStringCellValue().trim(); 
		}
		else if (c.getCellTypeEnum()==CellType.NUMERIC) {
			strData = NumberToTextConverter.toText((row.getCell(colNum).getNumericCellValue())); 
		}
		else {
			
		}		
		System.out.println(strData);
		
//		row = sheet.getRow(0);
//		for (int i = 0; i < row.getLastCellNum(); i++)
//		{
//			if (row.getCell(i).getStringCellValue().trim().equals(colName.trim()))
//				{
//					colNum = i;
//					break;
//				}
//		}
//		
//		row = sheet.getRow(rowNum);
//		String strData = row.getCell(colNum).getStringCellValue().trim(); 
		
		return strData; 
	}

	
	
}
