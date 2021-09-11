package com.Mercury.utility;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {

	XSSFWorkbook wb;
	XSSFSheet sheet; 
		
	public ExcelDataProvider() 
	{
		try 
		{
			File src = new File ("./TestData/Data.xlsx"); 
			FileInputStream fis = new FileInputStream(src);
			wb = new XSSFWorkbook(fis); 
		} 
		catch (Exception e) 
		{
			System.out.println("Unable to read Excel File. " + e.getMessage());
		}
	}
	
	public ExcelDataProvider(String excelPath) 
	{
		try 
		{
			File src = new File (excelPath); 
			FileInputStream fis = new FileInputStream(src);
			wb = new XSSFWorkbook(fis); 
		} 
		catch (Exception e) 
		{
			System.out.println("Unable to read Excel File. " + e.getMessage());
		}
	}
	
	public String getStringData(String strSheetName, int rowNum, String colName) {
		
		sheet = wb.getSheet(strSheetName); 
		int colNum = -1; 
		XSSFRow row; 
		
		row = sheet.getRow(0);
		for (int i = 0; i < row.getLastCellNum(); i++)
		{
			if (row.getCell(i).getStringCellValue().trim().equals(colName.trim()))
				{
					colNum = i;
					break;
				}
		}
		
		row = sheet.getRow(rowNum);
		return row.getCell(colNum).getStringCellValue().trim(); 

	}
	
	public String getStringData(int sheetIndex, int rowNum, String colName) {
			
			sheet = wb.getSheetAt(sheetIndex); 
			int colNum = -1; 
			XSSFRow row; 
			
			row = sheet.getRow(0);
			for (int i = 0; i < row.getLastCellNum(); i++)
			{
				if (row.getCell(i).getStringCellValue().trim().equals(colName.trim()))
					{
						colNum = i;
						break;
					}
			}
			
			row = sheet.getRow(rowNum);
			return row.getCell(colNum).getStringCellValue().trim(); 
	
		}
	
	public double getNumericData(String strSheetName, int rowNum, String colName) {
		sheet = wb.getSheet(strSheetName); 
		int colNum = -1; 
		XSSFRow row; 
		
		row = sheet.getRow(0);
		for (int i = 0; i < row.getLastCellNum(); i++)
		{
			if (row.getCell(i).getStringCellValue().trim().equals(colName.trim()))
				{
					colNum = i;
					break;
				}
		}
		
		row = sheet.getRow(rowNum);
		return row.getCell(colNum).getNumericCellValue();

	}
	
	public double getNumericData(int sheetIndex, int rowNum, String colName) {
		sheet = wb.getSheetAt(sheetIndex); 
		int colNum = -1; 
		XSSFRow row; 
		
		row = sheet.getRow(0);
		for (int i = 0; i < row.getLastCellNum(); i++)
		{
			if (row.getCell(i).getStringCellValue().trim().equals(colName.trim()))
				{
					colNum = i;
					break;
				}
		}
		
		row = sheet.getRow(rowNum);
		return row.getCell(colNum).getNumericCellValue();

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
		int colNum = -1; 
		XSSFRow row; 
		
		row = sheet.getRow(0);
		for (int i = 0; i < row.getLastCellNum(); i++)
		{
			if (row.getCell(i).getStringCellValue().trim().equals(colName.trim()))
				{
					colNum = i;
					break;
				}
		}
		
		row = sheet.getRow(rowNum);
		String strData = row.getCell(colNum).getStringCellValue().trim(); 
		
		return strData; 
	}
	
	
}
