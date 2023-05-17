package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class ReadXLSdata {

	
	@DataProvider(name="bvtdata")
	public String[][] getdata(Method m) throws EncryptedDocumentException, IOException {
		String excelsheetname = m.getName();
		File f ;
		f=new File(System.getProperty("user.dir")+ "\\src\\test\\resources\\testdata\\testdata.xlsx");
		FileInputStream fis;
		fis = new FileInputStream(f);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheetname;
		sheetname = wb.getSheet(excelsheetname);
		
		int totalrows = sheetname.getLastRowNum();
		System.out.println(totalrows);
		Row rowcells = sheetname.getRow(0);
		int totalcols = rowcells.getLastCellNum();
		System.out.println(totalcols);
		
		DataFormatter format = new DataFormatter();
		
		String testdata[][]= new String[totalrows][totalcols];
		for(int i=1;i<=totalrows;i++) {
			for (int j=0;j<totalcols;j++) {
				testdata[i-1][j]=format.formatCellValue(sheetname.getRow(i).getCell(j));
				System.out.println(testdata[i-1][j]);
				
			}
		}
		
		return testdata;
		
	}

}
