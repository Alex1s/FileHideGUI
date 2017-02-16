package org.filehide.filehidegui;
import javax.swing.JFileChooser;

public class FHRefrieveFile {
	// JFileChooser-Objekt wird erstellt
	JFileChooser closeFile = new JFileChooser();
	
	public FHRefrieveFile(){
		// Dialog zum Speichern von Dateien anzeigen
		this.closeFile.showSaveDialog(null);
		
	}

}
