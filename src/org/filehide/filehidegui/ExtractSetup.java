package org.filehide.filehidegui;

import java.awt.Component;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import org.filehide.filehidelibrary.FHFile;
import org.filehide.filehidelibrary.FHFileCorruptException;
import org.filehide.filehidelibrary.IncompatibleFHFileVersionException;
import org.filehide.filehidelibrary.NotFHFileException;

/**
 * This setup will ask for user for everything necessary to extract a hidden file out of a FHFile.
 */
class ExtractSetup {
	
	public static void main(String[] args) {
		ExtractSetup setup = new ExtractSetup(null);
		setup.start();
	}
	
	Component parent;
	
	ExtractSetup(Component parent) {
		this.parent = parent;
	}
	
	/**
	 * Starts the setup process.<br>
	 * The user will be asked for:<br>
	 * - the FHfile<br>
	 * - the password to encrypt it´s hidden file (if encrypted)<br>
	 * - the location to save the hidden file to
	 */
	void start() {
		FHFile fileIn = null;
		try {
			fileIn = getInputFile();
			if(fileIn == null) return;
		} catch (NotFHFileException | FHFileCorruptException | IncompatibleFHFileVersionException | IOException e) {
			showException(e);
			return;
		}

		String password = null;
		if(fileIn.encrypted()) {
			password = getPassword(fileIn);
			if(password == null) return;
		}
		
		Path pathOut = getOutputFile().toPath();
		if (pathOut == null) return;
		
		try {
			if (password == null) {
				fileIn.extractHiddenData(pathOut);
			} else {
				fileIn.extractHiddenData(pathOut, password);
			}
		} catch (IOException e) {
			showException(e);
		}
	}
	
	/**
	 * Promts the user to enter his FHFile.
	 * @return the FHFile the user entered or {@code null} if the user cancels
	 * @throws NotFHFileException
	 * @throws FHFileCorruptException
	 * @throws IncompatibleFHFileVersionException
	 * @throws IOException
	 */
	private FHFile getInputFile() throws NotFHFileException, FHFileCorruptException, IncompatibleFHFileVersionException, IOException {
		JFileChooser inputFileChooser = new JFileChooser();
		inputFileChooser.setDialogTitle("Select a FHFile.");
		int response = inputFileChooser.showOpenDialog(this.parent);
		if (response == JFileChooser.APPROVE_OPTION) {
			File selectedFile = inputFileChooser.getSelectedFile();
			return new FHFile(selectedFile);
		}
		return null;
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
	
	/**
	 * Asks the user where to save the hidden file to.
	 * @return the users choice or null of the user cancels
	 */
	private File getOutputFile() {
		JFileChooser outputFileChooser = new JFileChooser();
		outputFileChooser.setDialogTitle("Select where to save the hidden file to.");
		
		int response = outputFileChooser.showSaveDialog(this.parent);
		if (response == JFileChooser.APPROVE_OPTION) {
			File file = outputFileChooser.getSelectedFile();
			return file;
		}
		return null;
	}
	
	/**
	 * Shows the message of the given exception to the user.
	 * @param e the exception to show its message
	 */
	private void showException(Exception e) {
		JOptionPane.showMessageDialog(this.parent, e.getMessage());
	}
	
}
