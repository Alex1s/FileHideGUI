package org.filehide.filehidegui;
import javax.swing.JFileChooser;

public class FHRetrieveFile {
	// JFileChooser-Objekt wird erstellt
	JFileChooser closeFile = new JFileChooser();
	
	public FHRetrieveFile(){
		// Dialog zum Speichern von Dateien anzeigen
		this.closeFile.showSaveDialog(null);
		
	}

}
