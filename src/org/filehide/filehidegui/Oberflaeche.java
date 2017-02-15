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



public class Oberflaeche extends JFrame  {

	public static void main(String[] args) {
	//Erstellt ein Objekt der Klasse Oberflaeche	
	Oberflaeche fr = new Oberflaeche ();
	
	}
	
	// Array mit allen MenuItems 
	JMenuItem[] mI = {
			new FileHideJMenuItem("Extract", new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.out.println("Extract");
				}
			}),
			new ExtractJMenuItem("Refrieve", new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					System.out.println("Refrieve");
				}
			}),
			new QuitJMenuItem("Quit", new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
				
			}),
			new AboutJMenuItem("About", new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					new AboutFrame();
					frame.setEnabled(false);
				}
				
			}),
			
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
		frame.setResizable(false);
		
		//Erstelle die Menubar
		JMenuBar menuBar = new JMenuBar();

		//Erstelle die beiden Men�s: File und Help und f�ge diese zur Menubar hinzu
		JMenu fileMenu = new JMenu("File");
		JMenu helpMenu = new JMenu("Help");
		menuBar.add(fileMenu);
		menuBar.add(helpMenu);
		
		//F�gt alle MenuItem zu dem Men�s hinzu
		
		for(int i = 0; i < 3 ; i++)
		{
			fileMenu.add(mI[i]);
			if(seperators.contains(i)) {
				fileMenu.addSeparator();
			}
		}
		helpMenu.add(mI[3]);
		
		frame.setJMenuBar(menuBar);
		frame.getContentPane().setLayout(null);
		
		lblDragDrop = new JLabel("drag & drop file here to hide or extract");
		lblDragDrop.setBounds(10, 11, 484, 441);
		frame.getContentPane().add(lblDragDrop);
		
		/* es ist moeglich mit Tastenkombinationen die gewaenschte Aktion,
		 * die von den MenuItems beschrieben wird, schneller auszufuehren.
		 */
		mI[1].setAccelerator(KeyStroke.getKeyStroke(
		      KeyEvent.VK_1, ActionEvent.ALT_MASK));
		mI[2].setAccelerator(KeyStroke.getKeyStroke(
			  KeyEvent.VK_2, ActionEvent.ALT_MASK));
		frame.setVisible(true);
	}
	
	

	
	
	
		
	}
	
	
	
	

