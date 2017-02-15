package org.filehide.filehidegui;
import java.awt.event.ActionListener;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JMenuItem;

class QuitJMenuItem extends JMenuItem {


	public QuitJMenuItem(String text, ActionListener ae) {
		super(text);
		this.addActionListener(ae);
	}


}
