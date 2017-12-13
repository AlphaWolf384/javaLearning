

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.swing.table.TableModel;

import  org.apache.poi.hssf.usermodel.HSSFSheet;
import  org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import  org.apache.poi.hssf.usermodel.HSSFRow;
import  org.apache.poi.hssf.usermodel.HSSFCell;
 
public class ExcelFunction extends MainScreen {
 
    public static void xlExport() throws IOException {
    	// Export JTable data to Excel
        //  OLD CODE FOR REFERENCE
    	/*
    	System.out.println("Opening Excel");
    	XSSFWorkbook workbook = new XSSFWorkbook();
    	FileOutputStream out = new FileOutputStream(new File("Example.xlsx"));
    	
        XSSFSheet spreadsheet = workbook.createSheet("Page1");
    	XSSFRow row;
    	
    	String[][] list = new String[1][2];
    	
		for(int i = 0; i < table.getRowCount(); i++) {
			
		}
		
    	workbook.write(out);
    	out.close();
    	System.out.println("Generated!");
    	*/

        // Creating new Excel file and put data in it to be saved as Example.xls
        // TODO Ability to create it's own title on Excel spreadsheet and location on computer
        try{
        	System.out.println("Generating");
            TableModel model = table.getModel();
            FileWriter excel = new FileWriter(new File("Example.xls"));

            for(int i = 0; i < model.getColumnCount(); i++){
                excel.write(model.getColumnName(i) + "\t");
            }

            excel.write("\n");

            for(int i=0; i< model.getRowCount(); i++) {
                for(int j=0; j < model.getColumnCount(); j++) {
                    excel.write(model.getValueAt(i,j).toString()+"\t");
                }
                excel.write("\n");
            }

            excel.close();
            System.out.println("Done!");

        }catch(IOException e){ System.out.println(e); }
    }
    
    // ISSUE: THIS IS STILL WIP AND NOT COMPLETED
    // TODO Ability to import exising excel file to list and add/delete lines on scanned lists.
    public static void xlImport() throws IOException {
    	// Import Excel data to JTable
    	System.out.println("Opening existing Excel");
    	File file = new File("Example.xlsx");
    	FileInputStream fis = new FileInputStream(file);
    	XSSFWorkbook workbook = new XSSFWorkbook(fis);
    	
    	if(file.isFile() && file.exists()) {
    		System.out.println("Existing Excel opened successfully");
    	}
    	else {
    		System.out.println("Error to open");
    	}

    }
 
}