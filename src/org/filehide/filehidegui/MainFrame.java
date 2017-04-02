package org.filehide.filehidegui;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDropEvent;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

import org.filehide.filehidelibrary.FHFile;
import org.filehide.filehidelibrary.FHFileCorruptException;
import org.filehide.filehidelibrary.IncompatibleFHFileVersionException;
import org.filehide.filehidelibrary.NotFHFileException;

import javax.swing.JLabel;

@SuppressWarnings("serial")
class MainFrame extends JFrame  {
	
	public static void main(String[] args) {
		MainFrame mainFrame = new MainFrame ();
		mainFrame.setVisible(true);
	}
	
	
	// Fields

	private JMenu[] menues = {
			new JMenu("File"),
			new JMenu("Help")
	};
	
	private JMenuItem[][] menuItems = {
			{
				new JMenuItem("Hide") {{
					addActionListener((e) -> new HideSetup(MainFrame.this).start());
				}},
				new JMenuItem("Extract") {{
					addActionListener(e -> new ExtractSetup(MainFrame.this).start());
				}},
				new JMenuItem("Quit") {{
					addActionListener(e -> System.exit(0));
				}}
			},
			{
				new JMenuItem("About") {{
					addActionListener(e -> {
						JOptionPane.showMessageDialog(
								MainFrame.this,
								"Entwickler:\tAlexis und Robert\nVersion:\t1.0",
								"About", JOptionPane.INFORMATION_MESSAGE
							);
					});
				}}
			}
	};
	
	JLabel dragAndDrapLabel = new JLabel("drag and drop the file here to hide or retrieve") {{
		setEnabled(true);
		setBounds(10, 11, 484, 441);
		setDropTarget(new DropTarget() {
	        public synchronized void drop(DropTargetDropEvent evt) {
	        	
                evt.acceptDrop(DnDConstants.ACTION_COPY);
				List<File> droppedFiles;
				try {
					droppedFiles = (List<File>) evt.getTransferable().getTransferData(DataFlavor.javaFileListFlavor);
	                if (droppedFiles.size() > 1) {
	                	System.err.println("hi");
						JOptionPane.showMessageDialog(MainFrame.this, "You are only allowed to hide one file.", "Error", JOptionPane.INFORMATION_MESSAGE);
						return;
					}
	                File file = droppedFiles.get(0);
	                try {
						new ExtractSetup(MainFrame.this, new FHFile(file)).start();
					} catch (NotFHFileException | FHFileCorruptException | IncompatibleFHFileVersionException e) {
						new HideSetup(MainFrame.this, file).start();
					}
				} catch (UnsupportedFlavorException | IOException ignored) {}
	        }
	    });
	}};
	
	private List<Collection<Integer>> seperators = Arrays.asList(
			new HashSet<Integer>(Arrays.asList(1)),
			new HashSet<Integer>()
	);
	
	private int[][] seperatorsAsArrays = {
			{1},
			{}
	};
	
	private MainFrame() {
		super("FileHide");
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setSize(500, 500);
		this.setResizable(false);
		
		JMenuBar menuBar = new JMenuBar();

		for(int i = 0; i < this.menues.length; i++) {
			menuBar.add(this.menues[i]);
			for(int j = 0; j < this.menuItems[i].length; j++) {
				this.menues[i].add(this.menuItems[i][j]);
				if(this.seperators.get(i).contains(j)) {
//				if(Arrays.asList(this.seperatorsAsArrays[i]).contains(j)) {
					this.menues[i].addSeparator();
				}
			}
		}
		
		this.setJMenuBar(menuBar);

		this.getContentPane().add(dragAndDrapLabel);
	}

}
