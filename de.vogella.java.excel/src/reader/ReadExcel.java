package reader;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.omg.CORBA.PUBLIC_MEMBER;


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
	  Sheet sheet = excselinhalt();
      String ZINT_BINARY="zint\\zint.exe";
      String dir_name = "Barcodes\\";
      File dir= new File(dir_name);
      dir.mkdir();
      String image_filename= dir_name + "Barcodes";
      String ZINT_RSS_EXPANDED_CODE = "31"; 
      Cell temp;
      String barcode = "";
      System.out.println(image_filename);
      for (int y = 2; y < 22; y++) {
     	 System.out.println("");
       for (int x = 1; x < 6; x++) {
    	   temp = sheet.getCell(x, y);
    	   barcode = barcode + temp.getContents(); 
    	   //System.out.println(barcode);
       }
       String test = ZINT_BINARY+ " -o "+ image_filename+y+".png" + " -b "+ZINT_RSS_EXPANDED_CODE+ " -d \"" +barcode+ "\"";        	  
       Runtime.getRuntime().exec(test);
       barcode = "";
       }
  }
  
  public int getExcelTabelleCount(Sheet sheet) {
	  String barcode = "";
	  int count = 0;
	  Cell temp;
	  for (int y = 2; y < 22; y++) {
			System.out.println("");
			for (int x = 1; x < 3; x++) {
				temp = sheet.getCell(x, y);
				barcode = barcode + temp.getContents();
				//System.out.println(barcode);
			}
			count += 1;
		}
	  return count;
  }
  
  public String getExcelTabelleEinEintrag(Sheet sheet, int x, int y) {
	  Cell temp = sheet.getCell(x, y);
	  String content = temp.getContents(); 
	  return content;
  }

 
	public List<String> getExcselTabelleList(Sheet sheet) {
		 String barcode = "";
		 Cell temp;
		 List<String> headers = new ArrayList<String>();
		 for (int y = 2; y < 22; y++) {
			System.out.println("");
			for (int x = 1; x < 6; x++) {
				temp = sheet.getCell(x, y);
				barcode = barcode + temp.getContents() + ";";
				
			
			}
			headers.add(barcode);
			barcode = "";
		}
		 return headers;
	}
 
 public List<String> getProductHeader(Sheet sheet) {
	 String barcode = "";
	 Cell temp;
	 List<String> headers = new ArrayList<String>();
	 for (int y = 0; y < 22; y++) {
		System.out.println("");
		for (int x = 0; x < 1; x++) {
			temp = sheet.getCell(x, y);
			barcode = barcode + temp.getContents() + ";";
		}
		headers.add(barcode);
		barcode = "";
	}
	 return headers;
 }
  
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
  
