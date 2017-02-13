package org.filehide.filehidegui;
import javax.swing.JFileChooser;

public class FHSaveFile {
	// JFileChooser-Objekt wird erstellt
	JFileChooser closeFile = new JFileChooser();
	
	public FHSaveFile(){
		// Dialog zum Speichern von Dateien anzeigen
		this.closeFile.showSaveDialog(null);
		
	}

}
