package org.filehide.filehidegui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import javax.swing.JLabel;
import javax.swing.JTextPane;



public class Oberflaeche extends JFrame implements ActionListener {

	public static void main(String[] args) {
	//Erstellt ein Objekt der Klasse Oberflaeche	
	Oberflaeche fr = new Oberflaeche ();
	fr.setVisible(true);
	}
	
	// Array mit allen MenuItems 
	JMenuItem[] mI = {
			new FileHideJMenuItem("Extract", new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
				}
			}),
			new JMenuItem("refrieve"),
			new JMenuItem("quit"),
			new JMenuItem("about")
	};
	ArrayList<Integer> seperators = new ArrayList<Integer>() {{
	    add(1);
	}};
	
	JLabel lblDragDrop;
	JTextPane txtpnAboutAlexisUnd;
	JFrame frame = new JFrame("FileHide");
	
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
		
		for(int i = 0; i < mI.length ; i++)
		{
			fileMenu.add(mI[i]);
			if(seperators.contains(i)) {
				fileMenu.addSeparator();
				mI[i].addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						
					}
				});
			}
		}
		
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
		
		if(ae.getSource() == mI[0]){
	           new FHOpenFile();
	     }
		else if(ae.getSource() == mI[1])
		{
			new FHSaveFile();
		}
		
		else if (ae.getSource() == this.mI[2]){
			System.out.println("hide file");
		}
		else if (ae.getSource() == this.mI[3])
			{
				System.out.println("extract file");
			}
		else if(ae.getSource()== this.mI[4])
		{
			System.out.println("refrieve file");	
		}
		else if(ae.getSource()== this.mI[5])
		{
			System.out.println("quit");
		}
		/*
		 * About Fenster
		 */
		
		else if (ae.getSource()== this.mI[6])
		{
			new AboutFrame();
		}
		
		
	}
	
	
	
	
}
