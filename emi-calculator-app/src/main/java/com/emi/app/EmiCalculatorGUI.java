package com.emi.app;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

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
	private void buildUI() {
		mainAppFrame = new JFrame("EMI Calculator v1.0");
		mainAppPanel = new JPanel();
		emiCalculation = new EmiCalculator();
		/*
		 * Heading of the application
		 */
		JLabel headerDisplay = new JLabel(
				"Calculate your home loan, car loan, personal loan");
		headerDisplay.setFont(new Font("Verdana", 1, 12));
		
		JLabel headerDisplay2 = new JLabel("and education loan EMIs");
		headerDisplay2.setFont(new Font("Verdana", 1, 12));
		
		JLabel footerDisplay = new JLabel("Powered by Shyam");
		footerDisplay.setFont(new Font("Verdana", 1, 8));
		/*
		 * Text fields for entering principal amount, rate of interest and term
		 * is provided below.
		 */
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
		year.setSelected(true);
		JRadioButton month = new JRadioButton("Months");
		month.setActionCommand("months");
		ButtonGroup radioButtonGroup = new ButtonGroup();
		radioButtonGroup.add(year);
		radioButtonGroup.add(month);

		JButton calculate = new JButton("Calculate");
		JButton cancel = new JButton("Cancel");

		JPanel headerPanel = new JPanel(new FlowLayout());
		headerPanel.add(headerDisplay);
		headerPanel.add(headerDisplay2);
		
		JPanel footerPanel = new JPanel(new FlowLayout());
		footerPanel.add(footerDisplay);

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
		/*
		 * START: ActionListener for calculate button
		 */
		calculate.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				/*
				 * Service level object EmiComputationImpl
				 */
				EmiComputationImpl calculator = new EmiComputationImpl();
				
				//mainAppPanel.setVisible(false);
				mainAppFrame.getContentPane().removeAll();
				/*
				 * New panel to show the result is created.
				 */
				JPanel resultPanel = new JPanel(new FlowLayout());

				JLabel emiLabel = new JLabel("Monthly Payment(EMI):");
				emiLabel.setFont(new Font("Verdana", 1, 11));
				JLabel totalInterestLabel = new JLabel(
						"Total Interest Payable:");
				totalInterestLabel.setFont(new Font("Verdana", 1, 11));
				JLabel totalPaymentLabel = new JLabel(
						"Total Payment(Principal + Interest) in rupees:");
				totalPaymentLabel.setFont(new Font("Verdana", 1, 11));

				JLabel emiResult = new JLabel();
				JLabel totalInterestResult = new JLabel();
				JLabel totalPaymentResult = new JLabel();

				JPanel emiPanel = new JPanel(new FlowLayout());
				JPanel totalInterestPanel = new JPanel(new FlowLayout());
				JPanel totalPaymentPanel = new JPanel(new FlowLayout());

				JButton okButton = new JButton("Ok");
				/*
				 * START: ActionListener for OK button.
				 */
				okButton.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {
						mainAppFrame.getContentPane().removeAll();
						mainAppFrame.getContentPane().add(mainAppPanel);
						mainAppFrame.setSize(380, 255);
					}
				});
				/*
				 * END: ActionListener for OK button.
				 */

				String principalAmountStr = principalText.getText();
				String rateOfInterestStr = rateText.getText();
				String termStr = termText.getText();
				
				/*
				 * Validate the input fields to ensure that there are no
				 * null or empty inputs.
				 */
				if (principalAmountStr == null
						|| principalAmountStr.equalsIgnoreCase("")
						|| rateOfInterestStr == null
						|| rateOfInterestStr.equalsIgnoreCase("")
						|| termStr == null || termStr.equalsIgnoreCase("")) {
					JPanel errorPanel = new JPanel();
					JLabel errorLabel1 = new JLabel("Oops!! Error occured due to inconsistant inputs.");
					JLabel errorLabel2 = new JLabel("Please close the application and start over.");
					errorLabel1.setFont(new Font("Verdana", 1, 12));
					errorLabel2.setFont(new Font("Verdana", 1, 12));
					
					errorPanel.add(errorLabel1);
					errorPanel.add(errorLabel2);
					
					mainAppFrame.getContentPane().removeAll();
					mainAppFrame.getContentPane().add(errorPanel);
					mainAppFrame.setSize(400, 200);
				}
				/*
				 * End of validation
				 */
				
				double principalAmount = Double.parseDouble(principalAmountStr);
				double rateOfInterest = Double.parseDouble(rateOfInterestStr);
				long term = Long.parseLong(termStr);

				emiCalculation.setPrincipalAmount(principalAmount);
				emiCalculation.setRateOfInterest(rateOfInterest);
				emiCalculation.setTime(term);

				if (year.isSelected()) {
					emiCalculation.setTimeInYears(true);
				} else {
					emiCalculation.setTimeInYears(false);
				}

				Long emi = calculator.calculateEmi(emiCalculation);
				emiCalculation.setEmi(emi);
				Long totalInterest = calculator
						.calculateTotalInterestPayable(emiCalculation);
				Long totalPayment = calculator
						.calculateTotalPayment(emiCalculation);

				System.out.println(emi);
				System.out.println(totalInterest);
				System.out.println(totalPayment);

				PieChart chart = new PieChart(totalInterest, principalAmount);
				JPanel chartPanel = chart.getChartPlot();
				chartPanel.setLayout(new GridLayout());
				
				DecimalFormat formatter = new DecimalFormat("##,##,###");
				String finalEmi = formatter.format(emi);
				String finalTotalInterest = formatter.format(totalInterest);
				String finalTotalPayment = formatter.format(totalPayment);
				
				emiResult.setText(finalEmi);
				emiResult.setFont(new Font("Verdana", 1, 12));
				totalInterestResult.setText(finalTotalInterest);
				totalInterestResult.setFont(new Font("Verdana", 1, 12));
				totalPaymentResult.setText(finalTotalPayment);
				totalPaymentResult.setFont(new Font("Verdana", 1, 12));

				emiPanel.add(emiLabel);
				emiPanel.add(emiResult);
				totalInterestPanel.add(totalInterestLabel);
				totalInterestPanel.add(totalInterestResult);
				totalPaymentPanel.add(totalPaymentLabel);
				totalPaymentPanel.add(totalPaymentResult);
				JPanel buttonPanel = new JPanel(new FlowLayout());
				buttonPanel.add(okButton);

				resultPanel.add(emiPanel);
				resultPanel.add(totalInterestPanel);
				resultPanel.add(totalPaymentPanel);
				resultPanel.add(chartPanel);
				resultPanel.add(buttonPanel);
				/*
				 * New result panel is added to the mainAppFrame.
				 */
				mainAppFrame.getContentPane().add(resultPanel);
				mainAppFrame.setSize(650, 600);
				mainAppFrame.setResizable(false);
			}
		});
		/*
		 * END: ActionListener for calculate button
		 */

		mainAppPanel.add(headerDisplay);
		mainAppPanel.add(headerDisplay2);
		mainAppPanel.add(principalPanel);
		mainAppPanel.add(ratePanel);
		mainAppPanel.add(termPanel);
		mainAppPanel.add(termTypePanel);
		mainAppPanel.add(buttonPanel);
		//mainAppPanel.add(footerDisplay);

		mainAppFrame.getContentPane().add(mainAppPanel);
		mainAppFrame.setSize(400, 270);
		mainAppFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainAppFrame.setVisible(true);
	}

	/**
	 * Entry point
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		EmiCalculatorGUI gui = new EmiCalculatorGUI();
		gui.buildUI();
	}
}
