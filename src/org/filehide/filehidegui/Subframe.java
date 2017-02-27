package org.filehide.filehidegui;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Subframe extends JFrame {
	public Subframe(String name) {
		super(name);
		this.addWindowListener(new WindowAdapter() {
	         public void windowClosing(WindowEvent windowEvent){
	            MainFrame.mainFrame.setEnabled(true);
	         } 
	         
	         public void windowOpened(WindowEvent windoeEvent)
	         {
	        	MainFrame.mainFrame.setEnabled(false); 
	         }
	      });
	}
}
