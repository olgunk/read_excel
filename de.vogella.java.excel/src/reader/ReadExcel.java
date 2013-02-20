package reader;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ReadExcel {
  private String inputFile;
  private String[] barcodeliste;
  public void setInputFile(String inputFile) { 
    this.inputFile = inputFile;
  }

  public void read() throws IOException  {
//    File inputWorkbook = new File(inputFile);
//    Workbook w;
//    try {
//      w = Workbook.getWorkbook(inputWorkbook);
//      // Get the first sheet
//      Sheet sheet = w.getSheet(0);
//      // Loop over first 10 column and lines 
//
	  
	  Sheet sheet = excselinhalt();
      String ZINT_BINARY="C:\\Programme\\Zint\\zint.exe";
      String dir_name = "C:\\Barcodes\\";
      File dir= new File(dir_name);
      dir.mkdir();
      String image_filename= dir_name + "Barcodes";
      String ZINT_RSS_EXPANDED_CODE = "31"; //laaan\\ hayirli sayi, rss_expanded code
      Cell temp;
      String barcode = "";
     System.out.println(image_filename);
      for (int y = 2; y < 22; y++) {
     	 System.out.println("");
       for (int x = 1; x < 6; x++) {
    	   temp = sheet.getCell(x, y);
    	   barcode = barcode + temp.getContents();     
       }
       
  	    	   
       String test = ZINT_BINARY+ " -o "+ image_filename+y+".png" + " -b "+ZINT_RSS_EXPANDED_CODE+ " -d \"" +barcode+ "\"";        	  
       Runtime.getRuntime().exec(test);
       barcode = "";
       }
      
//	  
//   } catch (BiffException e) {
//      e.printStackTrace();
//    }
  }

//  public static void main(String[] args) throws IOException {
//    ReadExcel test = new ReadExcel();
//    test.setInputFile("C:\\Dokumente und Einstellungen\\okutrag\\Desktop\\Barcode\\BarcodeLi.xls");
//    test.read();
//  }
  
  public Sheet excselinhalt() throws IOException {
	  Sheet sheet = null;
	    File inputWorkbook = new File(inputFile);
	    Workbook w;
	    try {
	      w = Workbook.getWorkbook(inputWorkbook);
	      // Get the first sheet
	      sheet = w.getSheet(0);
	      // Loop over first 10 column and lines 
	      
	    } catch (BiffException e) {
	        e.printStackTrace();
	      }
    return sheet;
  }
	
}
  
