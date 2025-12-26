package practice1;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class ReadMultipleData {

	@Test
	public void Data() throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./testdata/ExcelData.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sh = book.getSheet("sheet1");
		Row row = sh.getRow(2);

		String data = row.getCell(3).toString();
		System.out.println(data);

	}

}
