package com.emi.app;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.emi.model.EmiCalculator;
import com.emi.service.EmiComputationImpl;

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
	private void buildUI(){
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
		
		final JTextField principalText = new JTextField(20);
		final JTextField rateText = new JTextField(20);
		final JTextField termText = new JTextField(20);
		final JRadioButton year = new JRadioButton("Years");
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
		
		calculate.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				EmiComputationImpl calculator = new EmiComputationImpl();
				mainAppFrame.remove(mainAppPanel);
				JPanel resultPanel = new JPanel(new FlowLayout());
				
				JLabel emiLabel = new JLabel("Monthly Payment(EMI):");
				emiLabel.setFont(new Font("Verdana", 1, 11));
				JLabel totalInterestLabel = new JLabel("Total Interest Payable:");
				totalInterestLabel.setFont(new Font("Verdana",1 ,11));
				JLabel totalPaymentLabel = new JLabel("Total Payment(Principal + Interest)\u20B9:");
				totalPaymentLabel.setFont(new Font("Verdana",1 ,11));
				
				JLabel emiResult = new JLabel();
				JLabel totalInterestResult = new JLabel();
				JLabel totalPaymentResult = new JLabel();
				
				JPanel emiPanel = new JPanel(new FlowLayout());
				JPanel totalInterestPanel = new JPanel(new FlowLayout());
				JPanel totalPaymentPanel = new JPanel(new FlowLayout());
				
				JButton okButton = new JButton();
				
				String principalAmountStr = principalText.getText();
				String rateOfInterestStr = rateText.getText();
				String termStr = termText.getText();
				
				double principalAmount = Double.parseDouble(principalAmountStr);
				double rateOfInterest = Double.parseDouble(rateOfInterestStr);
				long term = Long.parseLong(termStr);
				
				emiCalculation.setPrincipalAmount(principalAmount);
				emiCalculation.setRateOfInterest(rateOfInterest);
				emiCalculation.setTime(term);
				
				if(year.isSelected()){
					emiCalculation.setTimeInYears(true);
				}else{
					emiCalculation.setTimeInYears(false);
				}
				
				Long emi = calculator.calculateEmi(emiCalculation);
				emiCalculation.setEmi(emi);
				Long totalInterest = calculator.calculateTotalInterestPayable(emiCalculation);
				Long totalPayment = calculator.calculateTotalPayment(emiCalculation);
				
				System.out.println(emi);
				System.out.println(totalInterest);
				System.out.println(totalPayment);
			}
		});
		
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
		gui.buildUI();
	}
}
