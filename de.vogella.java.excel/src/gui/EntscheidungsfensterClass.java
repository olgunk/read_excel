package gui;

import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class EntscheidungsfensterClass {
    
	public static void main(String[] args) {

        ImageIcon icon = new ImageIcon("bild.jpg");
        String pfad = System.getProperty("user.dir");
        int antwort = JOptionPane.showConfirmDialog(null, "Möchten Sie die Datei öffnen?",
        		"PDF Datei wurde erstellt", JOptionPane.YES_NO_OPTION,
                JOptionPane.INFORMATION_MESSAGE, icon);

        if (antwort == JOptionPane.OK_OPTION) {
        	try {
        		Runtime.getRuntime().exec(
                        new String[] {
                                "C:/Program Files (x86)/Nuance/PDF Reader/bin/PDFReader.exe",
                                pfad+"\\storeMate_Rossmann_GS1-MHD-Verfall_Codes.pdf" });
    
            } catch (IOException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
            }   
        } 
        else if (antwort == JOptionPane.NO_OPTION) {
        	
        	JOptionPane.showMessageDialog(null, "storeMate_Rossmann_GS1-MHD-Verfall_Codes" + "\n" +
               		"wurde unter folgenden Pfad erstellt:" +
               		"\n" + 
               		"C:/Users/Olgun/git/read_excel/de.vogella.java.excel", "Vorsicht!", JOptionPane.WARNING_MESSAGE);
               
        } 
    }
} 