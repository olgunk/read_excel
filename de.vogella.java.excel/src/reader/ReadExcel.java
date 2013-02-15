package reader;

import java.io.File;
import java.io.IOException;

import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ReadExcel {

  private String inputFile;

  public void setInputFile(String inputFile) {
    this.inputFile = inputFile;
  }

  public void read() throws IOException  {
    File inputWorkbook = new File(inputFile);
    Workbook w;
    try {
      w = Workbook.getWorkbook(inputWorkbook);
      // Get the first sheet
      Sheet sheet = w.getSheet(0);
      // Loop over first 10 column and lines 

	  Cell Typ = sheet.getCell(0,0);
	  CellType type = Typ.getType();
	  if (type == CellType.LABEL) {
	     System.out.println("" + Typ.getContents());    
	  }
	  
	  Cell EAN14 = sheet.getCell(0,0);
	  if (type == CellType.LABEL) {
	     System.out.println("" + EAN14.getContents());    
	  }
	  
	  Cell MHDxVFD = sheet.getCell(2,0);
	  if (type == CellType.LABEL) {
	     System.out.println("" + MHDxVFD.getContents());    
	  }
	  
	  Cell ean = sheet.getCell(1,2);
	  Cell mhd = sheet.getCell(2,2);
	  Cell datum = sheet.getCell(3,2);
	  if (type == CellType.LABEL) {
	     System.out.println("" + ean.getContents()+ mhd.getContents()+datum.getContents());    
	  }
	  

	  String ZINT_BINARY="C:\\Programme\\Zint\\zint.exe";
	  String image_filename="olgun_beste_gaymis.png";
	  String ZINT_RSS_EXPANDED_CODE = "31"; //laaan hayirli sayi, rss_expanded code
	  String barcode = ean.getContents()+ mhd.getContents()+datum.getContents();
	//  String kommando = ZINT_BINARY + " -o " + image_filename + " -b " + ZINT_RSS_EXPANDED_CODE + " -d \"" + barcode +"\""; //1min
	  
	  //System.out.println(kommando);
	  String test = ZINT_BINARY+ " -o "+image_filename+ " -b "+ZINT_RSS_EXPANDED_CODE+ " -d \"" +barcode+ "\"";
	  System.out.println(test);
	  
	  Runtime.getRuntime().exec(test);
	  
	  
//	  ProcessBuilder pb =  new ProcessBuilder("cmd", ZINT_BINARY, "-o "+image_filename, "-b "+ZINT_RSS_EXPANDED_CODE, "-d \"" +barcode+ "\"");
//	  Process process = pb.start();
    
      
//      for (int j = 0; j < sheet.getColumns(); j++) {
//        for (int i = 0; i < sheet.getRows(); i++) {
//          Cell cell = sheet.getCell(j, i);
//          CellType type = cell.getType();
//          if (type == CellType.LABEL) {
//            System.out.println("" + cell.getContents());
//          }
//      
//        }
//      }
    } catch (BiffException e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) throws IOException {
    ReadExcel test = new ReadExcel();
    test.setInputFile("C:\\Dokumente und Einstellungen\\okutrag\\Desktop\\Barcode\\BarcodeLi.xls");
    test.read();
  }

} 