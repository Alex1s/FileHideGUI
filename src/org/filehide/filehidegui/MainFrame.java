package org.filehide.filehidegui;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class MainFrame extends JFrame  {
	
	// TODO remove this var
	static MainFrame mainFrame;
	
	public static void main(String[] args) {
		mainFrame = new MainFrame ();
	}
	
	
	// Fields

	private JMenu[] menues = {
			new JMenu("File"),
			new JMenu("Help")
	};
	
	private JMenuItem[][] menuItems = {
			{
				new JMenuItem("Extract") {{
					addActionListener(e -> new FHExtractFile());
				}},
				new JMenuItem("Retrieve") {{
					addActionListener(e -> new FHRetrieveFile());
				}},
				new JMenuItem("Quit") {{
					addActionListener(e -> System.exit(0));
				}}
			},
			{
				new JMenuItem("About") {{
					addActionListener(e -> new AboutFrame());
				}}
			}
	};
	
	private List<Collection<Integer>> seperators = Arrays.asList(
			new HashSet<Integer>(Arrays.asList(1)),
			new HashSet<Integer>()
	);
	
	private MainFrame() {
		super("FileHide");
		this.setSize(500, 500);
		this.setResizable(false);
		
		JMenuBar menuBar = new JMenuBar();

		for(int i = 0; i < this.menues.length; i++) {
			menuBar.add(this.menues[i]);
			for(int j = 0; j < this.menuItems[i].length; j++) {
				this.menues[i].add(this.menuItems[i][j]);
				if(this.seperators.get(i).contains(j)) {
					this.menues[i].addSeparator();
				}
			}
		}
		
		this.setJMenuBar(menuBar);
		
		JLabel lblDragDrop = new JLabel("drag & drop a file here to hide or retrieve");
		lblDragDrop.setBounds(10, 11, 484, 441);
		this.getContentPane().add(lblDragDrop);
		
		this.setVisible(true);
	}

}
