package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import pdf.createpdf;


public class GuiClass extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static String excelfile = "BarcodeLi.xls";

	public GuiClass() {
        initUI();
    }

    public final void initUI() {
    	
       JPanel panel = new JPanel();
       getContentPane().add(panel);

       panel.setLayout(null);
 
       JButton editButton = new JButton("Barcode Liste");
       editButton.setBounds(160, 35, 130, 80);
       editButton.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent event) {
        	   String programm = "C:\\Programme\\OpenOffice.org 3\\program\\scalc.exe";
        	   String file = excelfile;
        	   try {
				Runtime.getRuntime().exec(programm+ " " +file);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
          }
       });
       
       

       JButton generateButton = new JButton("Generate");
       generateButton.setBounds(10, 35, 130, 80);
       generateButton.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent event) {
        	   createpdf crpdf = new createpdf();
        	   crpdf.main(null);
        	   }
       });
       
       JButton quitButton = new JButton("Quit");
       quitButton.setBounds(110, 140, 80, 30);
       quitButton.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent event) {
               System.exit(0);
          }
       });

      
       
       panel.add(editButton);
       panel.add(generateButton);
       panel.add(quitButton);
       setTitle("Generate Barcodes");
       setSize(320, 220);
       setLocationRelativeTo(null);
       setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                GuiClass ex = new GuiClass();
                ex.setVisible(true);
            }
        });
    }

}