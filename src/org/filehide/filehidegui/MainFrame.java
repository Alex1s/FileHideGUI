package org.filehide.filehidegui;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
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
		
		JLabel lblDragDrop = new JLabel("drag & drop a file here to hide or retrieve");
		lblDragDrop.setBounds(10, 11, 484, 441);
		this.getContentPane().add(lblDragDrop);
	}

}
