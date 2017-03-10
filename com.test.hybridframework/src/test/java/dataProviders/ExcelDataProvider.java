package dataProviders;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import net.sourceforge.htmlunit.corejs.javascript.ObjArray;

public class ExcelDataProvider {
	
	XSSFWorkbook wb;
	 String excelPath="./ApplicationTestData/AppData.xlsx";
	public ExcelDataProvider()  
	{
		File src=new File(excelPath);
		
		try
		{
			FileInputStream fis=new FileInputStream(src);
			wb=new XSSFWorkbook(fis);
			
		}
		catch(Exception e) //can throw NullPointer exception,IOException
		{
			System.out.println("Exception is:" +e.getMessage());
		}
		
	}
	
	public String getData(int sheetIndex,int row,int column)
	{
		String data = wb.getSheetAt(sheetIndex).getRow(row).getCell(column).getStringCellValue();
		return data;
	}
	
	public String getData(String sheetName,int row,int column)
	{
		String data = wb.getSheet(sheetName).getRow(row).getCell(column).getStringCellValue();
		return data;
	}
	
	public int getRowCount(int sheetIndex)
	{
	
		int row = wb.getSheetAt(sheetIndex).getLastRowNum();
		row=row+1;
		return row;
				
	}
	
	public int getRowCount(String sheetName)
	{
	
		int row = wb.getSheet(sheetName).getLastRowNum();
		row=row+1;
		return row;
				
	}
}
