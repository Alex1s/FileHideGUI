package org.filehide.filehidegui;

import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

class FileHideJMenuItem extends JMenuItem {
	
	public FileHideJMenuItem(String text, ActionListener ae) {
		super(text);
		this.addActionListener(ae);
	}
}
