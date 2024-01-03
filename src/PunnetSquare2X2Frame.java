import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class PunnetSquare2X2Frame extends JFrame implements ActionListener {

	JLabel titleLabel = new JLabel("Punnet Square");
	JLabel dominantLabel = new JLabel("DOMINANT ALLELE:");
	JLabel recessiveLabel = new JLabel("RECESSIVE ALLELE:");
	JLabel phenotype1Label = new JLabel();
	JLabel phenotype2Label = new JLabel();
	JLabel phenotype3Label = new JLabel();
	JLabel phenotype4Label = new JLabel();
	
	
	JTextArea domAllele = new JTextArea("");
	JTextArea recAllele = new JTextArea("");
	
	JTextArea parent1a1 = new JTextArea("");
	JTextArea parent1a2 = new JTextArea("");
	JTextArea parent2a1 = new JTextArea("");
	JTextArea parent2a2 = new JTextArea("");
	
	JButton calculateButton = new JButton("CALCULATE");
	
	
	
	Font pixelifySans;
	Font pixelifySansTitle;

	
	//constructor method
	public PunnetSquare2X2Frame() {
		
		try {
			pixelifySans = Font.createFont(Font.TRUETYPE_FONT, new File("src/PixelifySans-VariableFont_wght.ttf")).deriveFont(15f);
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("src/PixelifySans-VariableFont_wght.ttf")));
		}
		catch(IOException | FontFormatException e) {
			
		}
		try {
			pixelifySansTitle = Font.createFont(Font.TRUETYPE_FONT, new File("src/PixelifySans-VariableFont_wght.ttf")).deriveFont(50f);
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("src/PixelifySans-VariableFont_wght.ttf")));
		}
		catch(IOException | FontFormatException e) {
			
		}
		
		//setup frame
		setSize(500,500);
		setTitle("Punnet Square");
		getContentPane().setBackground(new Color(194, 180, 187));
		
		setLayout(null);
		
		titleLabel.setBounds(30, 20, 400, 50);
		titleLabel.setFont(pixelifySansTitle);
		add(titleLabel);
		
		// dom vs rec
		dominantLabel.setBounds(50, 80, 400, 50);
		dominantLabel.setFont(pixelifySans);
		add(dominantLabel);
		
		recessiveLabel.setBounds(50, 110, 400, 50);
		recessiveLabel.setFont(pixelifySans);
		add(recessiveLabel);
		
		domAllele.setBounds(200, 95, 50, 20);
		add(domAllele);
		
		recAllele.setBounds(200, 125, 50, 20);
		add(recAllele);
		
		//allele boxes
		parent1a1.setBounds(130, 175, 50, 50);
		add(parent1a1);
		
		parent1a2.setBounds(190, 175, 50, 50);
		add(parent1a2);
		
		parent2a1.setBounds(70, 235, 50, 50);
		add(parent2a1);
		
		parent2a2.setBounds(70, 295, 50, 50);
		add(parent2a2);
		
		//result boxes
		
		phenotype1Label.setBounds(130, 235, 50, 50);
		add(phenotype1Label);
		
		phenotype2Label.setBounds(130, 295, 50, 50);
		add(phenotype2Label);
		
		phenotype3Label.setBounds(190, 235, 50, 50);
		add(phenotype3Label);
		
		phenotype4Label.setBounds(190, 295, 50, 50);
		add(phenotype4Label);
		
		calculateButton.setBounds(300, 100, 125, 40);
		add(calculateButton);
		calculateButton.setFont(pixelifySans);
		calculateButton.setBackground(new Color(252, 245, 249));
		
		calculateButton.addActionListener(this);
		
		//show frame
		setVisible(true);
		
			
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		
		if (event.getSource() == calculateButton) {
			
			//variables
			String allele1, allele2, allele3, allele4;
			String dominantAllele, recessiveAllele;
			String phenotype1, phenotype2, phenotype3, phenotype4;
			
			dominantAllele = String.valueOf(domAllele.getText());
			recessiveAllele = String.valueOf(recAllele.getText());
			
			allele1 = String.valueOf(parent1a1.getText());
			allele2 = String.valueOf(parent1a2.getText());
			allele3 = String.valueOf(parent2a1.getText());
			allele4 = String.valueOf(parent2a2.getText());
			
			if (allele3 == dominantAllele) {
				phenotype1 = new StringBuilder().append(allele3).append(allele1).toString();
				phenotype3 = new StringBuilder().append(allele3).append(allele2).toString();
			} else {
				phenotype1 = new StringBuilder().append(allele1).append(allele3).toString();
				phenotype3 = new StringBuilder().append(allele2).append(allele3).toString();
			}
			if (allele4 == dominantAllele) {
				phenotype2 = new StringBuilder().append(allele4).append(allele1).toString();
				phenotype4 = new StringBuilder().append(allele4).append(allele2).toString();

			} else {
				phenotype2 = new StringBuilder().append(allele1).append(allele4).toString();
				phenotype4 = new StringBuilder().append(allele2).append(allele4).toString();
			}
			if (allele2 == dominantAllele) {
				phenotype1 = new StringBuilder().append(allele1).append(allele3).toString();
				phenotype3 = new StringBuilder().append(allele1).append(allele3).toString();
			} else {
				phenotype1 = new StringBuilder().append(allele3).append(allele1).toString();
				phenotype3 = new StringBuilder().append(allele3).append(allele2).toString();
			}
			if (allele1 == dominantAllele) {
				phenotype2 = new StringBuilder().append(allele1).append(allele4).toString();
				phenotype4 = new StringBuilder().append(allele2).append(allele4).toString();
			} else {
				phenotype2 = new StringBuilder().append(allele4).append(allele1).toString();
				phenotype4 = new StringBuilder().append(allele4).append(allele2).toString();
			}
			
			
			//output
			phenotype1Label.setText(phenotype1);
			phenotype2Label.setText(phenotype2);
			phenotype3Label.setText(phenotype3);
			phenotype4Label.setText(phenotype4);
		}
	}
}
