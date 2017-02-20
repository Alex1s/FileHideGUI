package org.filehide.filehidegui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import javax.swing.JLabel;
import javax.swing.JTextPane;

public class MainFrame extends JFrame  {
	// TODO remove this var
	static MainFrame mainFrame;
	
	public static void main(String[] args) {
		mainFrame = new MainFrame ();
	}
	
	
	// Fields
	
	JMenuItem[][] menuItems = {
			{
			new JMenuItem("Extract") {{
				addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						new FHExtractFile();
					}
				});
			}},
			new JMenuItem("Retrieve") {{
				addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						new FHRetrieveFile();
					}
				});
			}},
			new JMenuItem("Quit") {{
				addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						System.exit(0);
					}
				});
			}}
			},
			{
			new JMenuItem("About") {{
				addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						new AboutFrame();
					}
				});
			}}
			}
	};
	
	JMenu[] menues = {
			new JMenu("File"),
			new JMenu("Help")
	};
	
	List<List<Integer>> seperators = Arrays.asList(Arrays.asList(1), Arrays.asList());

	
	JTextPane txtpnAboutAlexisUnd;
	
	public MainFrame()
	{
		this.setSize(500, 500);
		this.setResizable(false);
		this.setTitle("FileHide");
		
		JMenuBar menuBar = new JMenuBar();

		for(int i = 0; i < menues.length; i++) {
			menuBar.add(menues[i]);
			for(int j = 0; j < menuItems[i].length; j++) {
				menues[i].add(menuItems[i][j]);
				if(seperators.get(i).contains(j)) {
					menues[i].addSeparator();
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