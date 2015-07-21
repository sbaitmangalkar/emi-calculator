package com.emi.app;

import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.emi.model.EmiCalculator;

/**
 * Generates Swing based front end which can be used to calculate EMI.
 * 
 * @author Shyam Baitmangalkar | catch.shyambaitmangalkar@gmail.com
 *
 */
public class EmiCalculatorGUI {
	private JFrame mainAppFrame;
	private JPanel mainAppPanel;
	private EmiCalculator emiCalculation;
	
	/**
	 * Generates the initial UI with required fields.
	 */
	private void init(){
		mainAppFrame = new JFrame("EMI Calculator");
		mainAppPanel = new JPanel();
		emiCalculation = new EmiCalculator();
		
		JLabel headerDisplay = new JLabel("Calculate your home, car and personal loan EMIs");
		headerDisplay.setFont(new Font("Verdan", 1, 11));
		
		JLabel principalDisplay = new JLabel("Principal Amount: ");
		principalDisplay.setFont(new Font("Verdan", 1, 11));
		
		JLabel rateDiaplay = new JLabel("Rate of interest(in %): ");
		rateDiaplay.setFont(new Font("Verdan", 1, 11));
		
		JLabel termDiaplay = new JLabel("Term: ");
		termDiaplay.setFont(new Font("Verdan", 1, 11));
		
		JLabel termTypeDiaplay = new JLabel("Is Term in: ");
		termTypeDiaplay.setFont(new Font("Verdan", 1, 11));
		
		JTextField principalText = new JTextField(20);
		JTextField rateText = new JTextField(20);
		JTextField termText = new JTextField(20);
		JRadioButton year = new JRadioButton("Years");
		year.setActionCommand("year");
		JRadioButton month = new JRadioButton("Months");
		month.setActionCommand("months");
		ButtonGroup radioButtonGroup = new ButtonGroup();
		radioButtonGroup.add(year);
		radioButtonGroup.add(month);
		
		JButton calculate = new JButton("Calculate");
		JButton cancel = new JButton("Cancel");
		
		JPanel headerPanel = new JPanel(new FlowLayout());
		headerPanel.add(headerDisplay);
		
		JPanel principalPanel = new JPanel(new FlowLayout());
		principalPanel.add(principalDisplay);
		principalPanel.add(principalText);
		
		JPanel ratePanel = new JPanel(new FlowLayout());
		ratePanel.add(rateDiaplay);
		ratePanel.add(rateText);
		
		JPanel termPanel = new JPanel(new FlowLayout());
		termPanel.add(termDiaplay);
		termPanel.add(termText);
		
		JPanel termTypePanel = new JPanel(new FlowLayout());
		termTypePanel.add(termTypeDiaplay);
		termTypePanel.add(year);
		termTypePanel.add(month);
		
		JPanel buttonPanel = new JPanel(new FlowLayout());
		buttonPanel.add(calculate);
		buttonPanel.add(cancel);
		
		mainAppPanel.add(principalPanel);
		mainAppPanel.add(ratePanel);
		mainAppPanel.add(termPanel);
		mainAppPanel.add(termTypePanel);
		mainAppPanel.add(buttonPanel);
		
		mainAppFrame.getContentPane().add(mainAppPanel);
		mainAppFrame.setSize(400, 250);
		mainAppFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainAppFrame.setVisible(true);
	}
	
	/**
	 * Entry point
	 * 
	 * @param args
	 */
	public static void main(String args[]){
		EmiCalculatorGUI gui = new EmiCalculatorGUI();
		gui.init();
	}
}
