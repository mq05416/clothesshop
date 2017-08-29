package com.spring.helper;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

public class ExcelHelper {
	public static ArrayList readExcelFile(String fileName) {
		/**
		 * --Define a ArrayList --Holds ArrayList Of Cells
		 */
		ArrayList cellArrayLisstHolder = new ArrayList();

		try {
			/** Creating Input Stream **/
			FileInputStream myInput = new FileInputStream(fileName);

			/** Create a POIFSFileSystem object **/
			POIFSFileSystem myFileSystem = new POIFSFileSystem(myInput);

			/** Create a workbook using the File System **/
			HSSFWorkbook myWorkBook = new HSSFWorkbook(myFileSystem);

			/** Get the first sheet from workbook **/
			HSSFSheet mySheet = myWorkBook.getSheetAt(0);

			/** We now need something to iterate through the cells. **/
			Iterator rowIter = mySheet.rowIterator();
			while (rowIter.hasNext()) {
				HSSFRow myRow = (HSSFRow) rowIter.next();
				Iterator cellIter = myRow.cellIterator();
				ArrayList cellStoreArrayList = new ArrayList();
				while (cellIter.hasNext()) {
					HSSFCell myCell = (HSSFCell) cellIter.next();
					cellStoreArrayList.add(myCell);
				}
				cellArrayLisstHolder.add(cellStoreArrayList);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cellArrayLisstHolder;
	}
}
