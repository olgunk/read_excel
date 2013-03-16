/*
 * 
 */
package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import pdf.createpdf;




// TODO: Auto-generated Javadoc
/**
 * The Class GuiClass.
 */
public class GuiClass extends JFrame {

    /** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The excelfile. */
	private static String excelfile = "BarcodeLi.xls";
	
	/** The scroll pane. */
	private Object scrollPane;

	/**
	 * Instantiates a new gui class.
	 */
	public GuiClass() {
        initUI();
    }

    /**
     * Inits the ui.
     */
    public final void initUI() {
    	
       JPanel panel = new JPanel();
       getContentPane().add(panel);
       panel.setLayout(null);
       
       JOptionPane.showMessageDialog(null, "Bevor Sie die Barcodes erstellen," + "\n" +
       		"Excel Datei öffnen und Makro ausführen", "Vorsicht!", JOptionPane.WARNING_MESSAGE);
       
       
       
       JButton openExcelButton = new JButton("<html><center>Excel Liste<br>öffnen</center></html>");
       openExcelButton.setToolTipText("Öffnet die Ecxel Liste mit den Barcodes");
       openExcelButton.setBounds(10, 25, 100, 80);
       ///                 posX posY sizeX sizeY
       openExcelButton.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent event) {
        	   String programm = "C:/Program Files (x86)/Microsoft Office/Office14/EXCEL.EXE";
        	   String file = excelfile;
        	   try {
				Runtime.getRuntime().exec(programm+ " " +file);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
          }
       });
       
       
       JButton generateButton = new JButton("<html><center>Barcodes<br>erstellen</center></html>");
       generateButton.setToolTipText("Button zum erstellen der Barcodes");
       generateButton.setBounds(180, 25, 100, 80);
       generateButton.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent event) {
        	   createpdf crpdf = new createpdf();
        	   crpdf.main(null);
        	   
        	   EntscheidungsfensterClass.main(null);
           }
       });
       
       JButton quitButton = new JButton("Quit");
       quitButton.setBounds(5, 140, 280, 30);
       quitButton.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent event) {
               System.exit(0);
          }
       });

      
       
       panel.add(openExcelButton);
       panel.add(generateButton);
       panel.add(quitButton);
       setTitle("Generate Barcodes");
       setSize(300, 220);
       setLocationRelativeTo(null);
       setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                GuiClass ex = new GuiClass();
                ex.setVisible(true);
            }
        });
    }

	/**
	 * Gets the scroll pane.
	 *
	 * @return the scroll pane
	 */
	public Object getScrollPane() {
		return scrollPane;
	}

	/**
	 * Sets the scroll pane.
	 *
	 * @param scrollPane the new scroll pane
	 */
	public void setScrollPane(Object scrollPane) {
		this.scrollPane = scrollPane;
	}

}