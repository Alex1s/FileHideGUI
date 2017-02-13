package org.filehide.filehidegui;
import javax.swing.JFileChooser;

public class FHOpenFile {
	//JFileChooser-Objekt wird erstellt.
	JFileChooser openFile = new JFileChooser();
	
	public FHOpenFile()
	{
		// Dialog zum �ffnen von Dateien anzeigen.
		this.openFile.showOpenDialog(null);
	}

}
 