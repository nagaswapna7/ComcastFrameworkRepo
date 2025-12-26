package practice1;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class DataFromExcel {

	@Test
	public void dataFromExcel() throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./testdata/ExcelData.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sh = book.getSheet("sheet1");
		int rowcount = sh.getLastRowNum();
		for(int i=1;i<=rowcount;i++)
		{
			String data = sh.getRow(i).getCell(2).toString();
			System.out.println(data);
		}
		
		
		

	}

}
