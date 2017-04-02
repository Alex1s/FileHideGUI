package org.filehide.filehidegui;

import java.awt.Component;
import java.io.File;
import java.io.IOException;

import javax.swing.JOptionPane;

import org.filehide.filehidelibrary.FHFile;
import org.filehide.filehidelibrary.FHFileCorruptException;
import org.filehide.filehidelibrary.IncompatibleFHFileVersionException;
import org.filehide.filehidelibrary.NotFHFileException;

/**
 * This setup will ask for user for everything necessary to extract a hidden file out of a FHFile.
 */
class ExtractSetup extends Setup {
	
	private FHFile droppedFile;
	
	ExtractSetup(Component parent) {
		super(parent);
	}
	
	public ExtractSetup(Component parent, FHFile droppedFile) {
		this(parent);
		this.droppedFile = droppedFile;
	}
	
	/**
	 * Starts the setup process.<br>
	 * The user will be asked for:<br>
	 * - the FHfile<br>
	 * - the password to encrypt it´s hidden file (if encrypted)<br>
	 * - the location to save the hidden file to
	 */
	void start() {
		FHFile origin = null;
		if(this.droppedFile == null) {
			try {
				File selectedFile = getFile(GetFileTypes.OPEN, "Select a FHFile.");
				if(selectedFile == null) return;
				origin = new FHFile(selectedFile);
			} catch (NotFHFileException | FHFileCorruptException | IncompatibleFHFileVersionException | IOException e) {
				showException(e);
				return;
			}
		} else {
			origin = droppedFile;
		}


		String password = null;
		if(origin.encrypted()) {
			password = getPassword(origin);
			if(password == null) return;
		}
		
		File destination = getFile(GetFileTypes.SAVE, "Select where to save the hidden file to.");
		if (destination == null) return;
		
		try {
			if (password == null) {
				origin.extractHiddenData(destination);
			} else {
				origin.extractHiddenData(destination, password);
			}
		} catch (IOException e) {
			showException(e);
			return;
		}
		JOptionPane.showMessageDialog(this.parent, "Success!");
	}
	
	/**
	 * Ask the user for the password of the FHFile.<br>
	 * Keeps asking until a valid password was entered.
	 * @param file
	 * @param askAgain
	 * @return the correct password, or null if the user cancels
	 */
	private String getPassword(FHFile file) {
		String password = null;
		boolean askAgain = false;
		do {
			String message = askAgain ? "Password incorrect, please try again." : "Please enter the password to extract the hidden contents.";
			// TODO have a password textfield instead of a normal one
//			JPanel pane = new JPanel();
//			pane.add(new JLabel(message));
//			pane.add(new JPasswordField());

			password = JOptionPane.showInputDialog(this.parent, message, null);
			if (password == null)
				return null;
			askAgain = true;
		} while (!file.checkPassword(password));
		return password;
	}
	
}
