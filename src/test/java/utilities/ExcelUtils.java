package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	private XSSFSheet workSheet;
	private XSSFWorkbook workBook;
	private String path;

//	public static void main(String[] args) throws Exception {
//		ExcelUtils data = new ExcelUtils();
//		List<List<String>> myData = data.getAllSheetData("users.xlsx", "data");
//		System.out.println(myData);
//	}

	public ExcelUtils() {

	}

	public ExcelUtils(String path, String sheetName) {
		this.path = path;
		try {
			// Open the Excel file
			FileInputStream ExcelFile = new FileInputStream(path);
			// Access the required test data sheet
			workBook = new XSSFWorkbook(ExcelFile);
			workSheet = workBook.getSheet(sheetName);

		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public List<List<String>> getAllSheetData(String fileName, String sheetName) throws Exception {
		List<List<String>> rows = new ArrayList<>();
		FileInputStream ExcelFile = new FileInputStream(fileName);
		workBook = new XSSFWorkbook(ExcelFile);
		workSheet = workBook.getSheet(sheetName);
		for (int i = 0; i <= workSheet.getLastRowNum(); i++) {
			Row rowi = workSheet.getRow(i);
			List<String> row = new ArrayList<>();
			for (int j = 0; j < rowi.getLastCellNum(); j++) {
				Cell cdata = rowi.getCell(j);
				row.add(cdata.toString());
			}
			rows.add(row);
		}
		ExcelFile.close();
		workBook.close();
		return rows;
	}

	public String getCellData(int rowNum, int colNum) {
		XSSFCell cell;
		try {
			cell = workSheet.getRow(rowNum).getCell(colNum);
			String cellData = cell.toString();
			return cellData;
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}

	public String[][] getDataArray() {

		String[][] data = new String[rowCount()][columnCount()];

		for (int i = 0; i < rowCount(); i++) {
			for (int j = 0; j < columnCount(); j++) {
				String value = getCellData(i, j);
				data[i][j] = value;
			}
		}
		return data;

	}

	public List<Map<String, String>> getDataList() {
		// get all columns
		List<String> columns = getColumnsNames();
		// this will be returned
		List<Map<String, String>> data = new ArrayList<>();

		for (int i = 1; i < rowCount(); i++) {
			// get each row
			Row row = workSheet.getRow(i);
			// create map of the row using the column and value
			// column map key, cell value --> map bvalue
			Map<String, String> rowMap = new HashMap<String, String>();
			for (Cell cell : row) {
				int columnIndex = cell.getColumnIndex();
				rowMap.put(columns.get(columnIndex), cell.toString());
			}

			data.add(rowMap);
		}

		return data;
	}

	public List<String> getColumnsNames() {
		List<String> columns = new ArrayList<>();

		for (Cell cell : workSheet.getRow(0)) {
			columns.add(cell.toString());
		}
		return columns;
	}

	public void setCellData(String value, int rowNum, int colNum) {
		XSSFCell cell;
		XSSFRow row;

		try {
			row = workSheet.getRow(rowNum);
			cell = row.getCell(colNum);

			if (cell == null) {
				cell = row.createCell(colNum);
				cell.setCellValue(value);
			} else {
				cell.setCellValue(value);
			}
			FileOutputStream fileOut = new FileOutputStream(path);
			workBook.write(fileOut);

			fileOut.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setCellData(String value, String columnName, int row) {
		int column = getColumnsNames().indexOf(columnName);
		setCellData(value, row, column);
	}

	public int columnCount() {
		return workSheet.getRow(0).getLastCellNum();
	}

	public int rowCount() {
		return workSheet.getPhysicalNumberOfRows();
	}

}
