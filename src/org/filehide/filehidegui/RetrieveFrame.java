package org.filehide.filehidegui;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
class RetrieveFrame extends Subframe {
	
	public static void main(String[] args) {
		RetrieveFrame retrieveFrame = new RetrieveFrame();
		retrieveFrame.setVisible(true);
	}
	
	JTextField inputTextField = new JTextField();
	JTextField passwordTextField = new JTextField();
	JTextField outputTextField = new JTextField();
	
	JButton inputButton = new JButton("select input file") {{
		addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser inputFileChooser = new JFileChooser();
				int response = inputFileChooser.showOpenDialog(null);
				if (response == JFileChooser.APPROVE_OPTION) {
					File selectedFile = inputFileChooser.getSelectedFile();
					RetrieveFrame.this.inputTextField.setText(selectedFile.toPath().toString());
				}
			}
		});
	}};
	JButton passwordButton = new JButton("password incorrect") {{
		// FIXME fix backgrund color
		this.setBackground(Color.RED);
		this.setOpaque(true);
		this.setEnabled(false);
	}};
	JButton outputButton = new JButton("select output file");
	
	JButton retrieveButton = new JButton("retieve hidden file");
	
	public RetrieveFrame() {
		super("Retrieve Hidden File");
		this.setSize(500, 700);
		JPanel contentPane = new JPanel(new GridBagLayout());
		this.setContentPane(contentPane);
		
		contentPane.add(inputTextField, textFieldConstraint(0));
		contentPane.add(inputButton, buttonConstraint(0));
		
		contentPane.add(passwordTextField, textFieldConstraint(1));
		contentPane.add(passwordButton, buttonConstraint(1));
		
		contentPane.add(outputTextField, textFieldConstraint(2));
		contentPane.add(outputButton, buttonConstraint(2));
		
		contentPane.add(retrieveButton, buttonConstraint(3));
		this.addWindowListener(new WindowAdapter() {
	         public void windowClosing(WindowEvent windowEvent){
	            MainFrame.mainFrame.setEnabled(true);
	         } 
	         
	         public void windowOpened(WindowEvent windoeEvent)
	         {
	        	MainFrame.mainFrame.setEnabled(false); 
	         }
	      });
	}
	
	private GridBagConstraints buttonConstraint(int y) {
		GridBagConstraints c = new GridBagConstraints();
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridy = y;
		c.gridx = 2;
		c.weighty = 1;
		c.weightx = 0.1;
		
		return c;
	}
	
	private GridBagConstraints textFieldConstraint(int y) {
		GridBagConstraints c = new GridBagConstraints();
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridy = y;
		c.gridx = 0;
		c.gridwidth = 2;
		c.weightx = 1;
		
		return c;
		
	}

}
