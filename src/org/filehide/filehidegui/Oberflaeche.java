package org.filehide.filehidegui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import javax.swing.JLabel;
import javax.swing.JTextPane;



public class Oberflaeche implements ActionListener {

	

	public static void main(String[] args) {
	//Erstellt ein Objekt der Klasse Oberflaeche	
	Oberflaeche fr = new Oberflaeche ();
	fr.setVisible(true);
		
		
		// TODO Auto-generated method stub

	}
	
	private void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
	// Array mit allen MenuItems 
	static JMenuItem[] mI = {new JMenuItem ("OpenFile"),new JMenuItem ("SaveFile"), new JMenuItem("Hide"), new JMenuItem("extract"),
			new JMenuItem("refrieve"), new JMenuItem("quit"), new JMenuItem("about")};
	static JLabel lblDragDrop;
	static JTextPane txtpnAboutAlexisUnd;
	static JFrame frame = new JFrame("FileHide");
	
	public Oberflaeche()
	{
		
		frame.setSize(500, 500);
		
		//Erstelle die Menubar
		JMenuBar menuBar = new JMenuBar();

		//Erstelle die beiden Men�s: File und Help und f�ge diese zur Menubar hinzu
		JMenu fileMenu = new JMenu("File");
		JMenu helpMenu = new JMenu("Help");
		menuBar.add(fileMenu);
		menuBar.add(helpMenu);
		
		//F�gt alle MenuItem zu dem Men�s hinzu
		
		for(int i = 0; i < 2; i++)
		{
			fileMenu.add(mI[i]);
			mI[i].addActionListener(this);
		}
		/*
		 * Seperator = wagerechter Strich. Seperator wurde eingef�hrt um
		 * die verschiedenen JMEnuItems oprisch zu unterscheiden.
		 */
		fileMenu.addSeparator();
		
	    for( int i = 2; i < 5;i++)
	    {
	    	fileMenu.add(mI[i]);
	    	mI[i].addActionListener(this);
	    }
	    
		fileMenu.addSeparator();
		
		fileMenu.add(mI[5]);
		mI[5].addActionListener(this);
		
		helpMenu.add(mI[6]);
		mI[6].addActionListener(this);
		
		frame.setJMenuBar(menuBar);
		frame.getContentPane().setLayout(null);
		
		lblDragDrop = new JLabel("drag & drop file here to hide or extract");
		lblDragDrop.setBounds(10, 11, 484, 441);
		frame.getContentPane().add(lblDragDrop);
		
		
		
		
		/* es ist m�glich mit Tastenkombinationen die gew�nschte Aktion,
		 * die von den MenuItems beschrieben wird, schneller auszuf�hren.
		 */
		mI[1].setAccelerator(KeyStroke.getKeyStroke(
		      KeyEvent.VK_1, ActionEvent.ALT_MASK));
		
		
		mI[2].setAccelerator(KeyStroke.getKeyStroke(
			  KeyEvent.VK_2, ActionEvent.ALT_MASK));
		
	
		
		frame.setVisible(true);
		
		
		
	
	}
	
	/*
	 * �berpr�ft ob die MenuItems zu dem ActionListener hinzugef�gt worden ist.
	 * Ist dies der Fall werden die unten gennanten Funktionen ausgef�hrt.
	 */
	public void actionPerformed(ActionEvent ae) {
		
		if(ae.getSource() == Oberflaeche.mI[0]){
	           new FHOpenFile();
	     }
		else if(ae.getSource() == Oberflaeche.mI[1])
		{
			new FHSaveFile();
		}
		
		else if (ae.getSource() == Oberflaeche.mI[2]){
			System.out.println("hide file");
		}
		else if (ae.getSource() == Oberflaeche.mI[3])
			{
				System.out.println("extract file");
			}
		else if(ae.getSource()== Oberflaeche.mI[4])
		{
			System.out.println("refrieve file");	
		}
		else if(ae.getSource()== Oberflaeche.mI[5])
		{
			System.out.println("quit");
		}
		/*
		 * About Fenster
		 */
		
		else if (ae.getSource()== Oberflaeche.mI[6])
		{
			new AboutFrame();
		}
		
		
	}
	
	
	
	
}
