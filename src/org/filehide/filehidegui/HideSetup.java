package org.filehide.filehidegui;

import java.awt.Component;
import java.io.File;
import java.io.IOException;

import javax.swing.JOptionPane;

import org.filehide.filehidelibrary.FHFile;
import org.filehide.filehidelibrary.FHFileCreationFailedException;

/**
 * This setup will ask for user for everything necessary to hide a file in another one, creating a {@link FHFile}.
 */
class HideSetup extends Setup {
	
	/**
	 * Creates a new setup to hide a file within a file, finally creating a {@link FHFile}.
	 * @param parent the component to show the dialogs above (MainFrame)
	 */
	HideSetup(Component parent) {
		super(parent);
	}
	
	/**
	 * {@inheritDoc}
	 * <p>
	 * This implemention fulfils the task of hiding a file within a file, creating a new {@link FHFile}.
	 */
	@Override
	void start() {
		File origin = getFile(GetFileTypes.OPEN, "Please select the file you want to hide.");
		if(origin == null) return;
		
		File destination = getFile(GetFileTypes.OPEN, "Please select the file you want to hide the other file in.");
		if(destination == null) return;
		
		String password = getPassword();
		if(password == null) return;
		if(password.equals("")) password = null;
		
		File finalDestination = null;
		switch (getInPlaceChoice()) {
		case JOptionPane.NO_OPTION:
			finalDestination = getFile(GetFileTypes.SAVE, "Please select where you want to save the result.");
			break;
		case JOptionPane.YES_OPTION:
			break;
		default:
			return;
		}

		// FIXME never succeeds but probably because of FileHideLibrary
		try {
			if(password == null) {
				if(finalDestination == null) FHFile.hide(origin, destination);
				else FHFile.hide(origin, destination, finalDestination);
			} else {
				if(finalDestination == null) FHFile.hide(origin, destination, password);
				else FHFile.hide(origin, destination, finalDestination, password);
			}
		} catch (FHFileCreationFailedException | IOException e) {
			showException(e);
			return;
		}
		JOptionPane.showMessageDialog(this.parent, "Success!");
	}
	
	private String getPassword() {
		boolean confirmFailed = false;
		do {
			String password = JOptionPane.showInputDialog(
					this.parent,
					"If you want to encrypt the hidden file, please enter the password below."
					+ "\n If you do not want to encrypt the hidden file, leave this field empty and continue."
					+ (confirmFailed ? "\n The passwords entered are not the same, please try again." : "")
			);
			if(password == null)	return	null;	// user cancel
			if(password.equals(""))	return	"";		// user does not want to encrypt
			
			String passwordConfirm = JOptionPane.showInputDialog(this.parent, "Please confirm the password you entered.");

			if(passwordConfirm == null || !password.equals(passwordConfirm)) {
				confirmFailed = true;
				continue;
			}
			return passwordConfirm;
		} while(confirmFailed);
		return null; // should actually never be reached
	}
	
	private int getInPlaceChoice() {
		return JOptionPane.showConfirmDialog(
				this.parent,
				"Do you want to hide the file in-place?"
				+ "\nDoing so will change the file you are hiding the other file into."
				+ "\nNot doing so will leave the file you are hiding the other file into untouched.",
				"In-place",
				JOptionPane.YES_NO_CANCEL_OPTION
		);
	}
	
}
