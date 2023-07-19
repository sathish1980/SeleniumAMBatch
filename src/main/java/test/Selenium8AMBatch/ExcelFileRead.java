package test.Selenium8AMBatch;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelFileRead {
	
	//String filepath="C:\\Users\\sathishkumar\\eclipse-workspace\\Selenium8AMBatch\\Input\\Input.xls";
	
	String filepath=System.getProperty("user.dir")+"\\Input\\Input.xls";
	
	public void ReadData() throws IOException
	{
		File F = new File(filepath);
		FileInputStream FS = new FileInputStream(F);
		
		//XSSFWorkbook workbook = new XSSFWorkbook(FS);
		
		HSSFWorkbook workbook = new HSSFWorkbook(FS);
		Sheet sheet = workbook.getSheet("login");
		
		int totalRows = sheet.getPhysicalNumberOfRows();
		for (int i=0;i<totalRows;i++)
		{
			Row inputRow = sheet.getRow(i);
			int totalColumn= inputRow.getLastCellNum();
			for(int j=0;j<totalColumn;j++)
			{
				Cell cellValue = inputRow.getCell(j);
				// String actualValue = cellValue.getStringCellValue();
				System.out.print(GetData(cellValue));
				System.out.print(" ");
			}
			System.out.println("");
		}
	}

	public Object GetData(Cell cellValue)
	{
		if(cellValue.getCellType()==CellType.STRING)
		{
			return cellValue.getStringCellValue();
		}
		else if(cellValue.getCellType()==CellType.NUMERIC)
		{
			DataFormatter dataFormatter = new DataFormatter();
			return dataFormatter.formatCellValue(cellValue);
		
		// return cellValue.getNumericCellValue();
		}
		return null;
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ExcelFileRead E = new ExcelFileRead();
		E.ReadData();
	}

}
