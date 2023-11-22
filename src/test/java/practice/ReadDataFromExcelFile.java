package practice;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class ReadDataFromExcelFile {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		//step-1: open the doc in java readable format
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		
		//step-2: create workbook
		Workbook wb =WorkbookFactory.create(fis);
		
		//step-3: navigate to required sheet
		Sheet sheet = wb.getSheet("Contacts");
		
		//step-4: navigate to required row
		Row row = sheet.getRow(1);
		
		//step-5: navigate to required cell
		Cell cel = row.getCell(2);
		
		//step-6: capture the value and print
		String value = cel.getStringCellValue();
		System.out.println(value);

	}

}
