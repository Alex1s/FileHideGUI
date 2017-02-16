package org.filehide.filehidegui;
import java.awt.event.ActionListener;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JMenuItem;

class AboutJMenuItem extends JMenuItem {

	public AboutJMenuItem(String text,ActionListener ae) {
		super(text);
		this.addActionListener(ae);
		
	}
	
}
