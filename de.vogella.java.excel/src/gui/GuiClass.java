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
	private static String excelfile = "C:\\Users\\Olgun\\git\\read_excel\\de.vogella.java.excel\\BarcodeLi.xls";

	public GuiClass() {
        initUI();
    }

    public final void initUI() {

       JPanel panel = new JPanel();
       getContentPane().add(panel);

       panel.setLayout(null);
 
       JButton quitButton = new JButton("Barcode Liste");
       quitButton.setBounds(160, 80, 120, 80);
       quitButton.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent event) {
        	   String programm = "C:\\Program Files (x86)\\OpenOffice.org 3\\program\\scalc.exe";
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
       generateButton.setBounds(30, 80, 120, 80);
       generateButton.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent event) {
        	   createpdf crpdf = new createpdf();
        	   crpdf.main(null);
        	   }
       });
       
       panel.add(quitButton);
       panel.add(generateButton);
       setTitle("Generate Barcodes");
       setSize(300, 200);
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