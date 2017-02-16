package org.filehide.filehidegui;
import javax.swing.JFileChooser;

public class FHExtractFile {
	//JFileChooser-Objekt wird erstellt.
	JFileChooser openFile = new JFileChooser();
	
	public FHExtractFile()
	{
		// Dialog zum �ffnen von Dateien anzeigen.
		this.openFile.showOpenDialog(null);
	}

}
 