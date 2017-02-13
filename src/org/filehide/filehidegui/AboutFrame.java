package org.filehide.filehidegui;
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
	}
}
