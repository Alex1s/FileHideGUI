package org.filehide.filehidegui;
import javax.swing.*;

@SuppressWarnings("serial")
public class AboutFrame extends Subframe  {
	
	// Fields
	
	JLabel mainLabel = new JLabel (AboutText.text);
	 
	public AboutFrame() {
		super("About");
		this.setSize(300, 100);
		this.getContentPane().add(mainLabel);
		this.setTitle("About");
		this.setResizable(false);
		this.setVisible(true);
	}
}