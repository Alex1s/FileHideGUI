package org.filehide.filehidegui;

import java.awt.Component;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 * General class for all setups.
 * @author alex1s
 */
abstract class Setup {
	
	/**
	 * Describes the different types of files a setup process can ask a user to select.
	 * @author alex1s
	 */
	enum GetFileTypes  {
		OPEN,
		SAVE;
	}
	
	/**
	 * The parent component to show the dialogs above.
	 */
	Component parent;
	
	Setup(Component parent) {
		this.parent = parent;
	}
	
	/**
	 * Starts the setup process and asks the user for everythig necessary to finally complete its task.
	 */
	abstract void start();
	
	File getFile(GetFileTypes getFileType, String dialogTitle) {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle(dialogTitle);
		
		int option;
		switch (getFileType) {
		case OPEN:
			option = fileChooser.showOpenDialog(this.parent);
			break;
		case SAVE:
			option = fileChooser.showSaveDialog(this.parent);
			break;
		default:
			option = JFileChooser.CANCEL_OPTION;
		}
		
		if (option == JFileChooser.APPROVE_OPTION) {
			return fileChooser.getSelectedFile();
		}
		return null;
	}
	
	/**
	 * Shows the message of the given exception to the user.
	 * @param e the exception to show its message
	 */
	void showException(Exception e) {
		JOptionPane.showMessageDialog(this.parent, e.getMessage());
	}
}
