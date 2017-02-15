package org.filehide.filehidegui;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;

class ExtractJMenuItem extends JMenuItem {

	public ExtractJMenuItem(String text, ActionListener ae) {
		super(text);
		this.addActionListener(ae);
	}
}
