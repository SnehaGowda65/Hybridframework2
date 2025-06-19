package com.genericlib.demoblazeweb;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileLib {

	public String getDataFromProperties(String path, String key) {
		FileInputStream ip = null;
		try {
			ip = new FileInputStream(path);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Properties prop = new Properties();
		try {
			prop.load(ip);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop.getProperty(key);
	}
	
	public String getDataFromExcel(String path, String sheet, int row, int cell) {
		FileInputStream ip=null;
		try {
			ip=new FileInputStream(path);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Workbook wb = null;
		try {
			wb = WorkbookFactory.create(ip);
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Sheet sh = wb.getSheet(sheet);
		return sh.getRow(row).getCell(cell).toString();
		
	}
}
