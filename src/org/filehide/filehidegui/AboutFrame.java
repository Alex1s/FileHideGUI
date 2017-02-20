package org.filehide.filehidegui;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;

public class AboutFrame extends JFrame  {
	
	// Fields
	
	JLabel mainLabel = new JLabel (AboutText.text);
	 
	public AboutFrame() {
		this.setSize(300, 100);
		this.getContentPane().add(mainLabel);
		this.setTitle("About");
		this.setResizable(false);
		this.setVisible(true);
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