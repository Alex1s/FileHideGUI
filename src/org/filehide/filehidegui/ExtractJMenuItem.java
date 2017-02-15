package org.filehide.filehidegui;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

class ExtractJMenuItem extends JMenuItem {

	public ExtractJMenuItem() throws HeadlessException {
		this.setText("Extract");
		this.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("extract clicked");
			}
		});
	}
}
