package com.emi.service;

import com.emi.model.EmiCalculator;

/**
 * Implementation class of EmiComputation.
 * 
 * @author Shyam Baitmangalkar | catch.shyambaitmangalkar@gmail.com
 *
 */
public class EmiComputationImpl implements EmiComputation{
	/**
	 * Calculates the EMI
	 */
	public long calculateEmi(EmiCalculator calculator) {
		boolean isTimeInYears = calculator.isTimeInYears();
		long time = calculator.getTime();
		double principal = calculator.getPrincipalAmount();
		double rate = calculator.getRateOfInterest();
		
		if(isTimeInYears){
			//convert years to months
			time = time * 12;
		}
		double convertedRate = (rate / 12)/100;
		double timeFactor = Math.pow((1 + convertedRate), time);
		double emi = (principal * convertedRate * timeFactor)/(timeFactor - 1);
		long finalEmi = Math.round(emi * 100)/100;
		return finalEmi;
	}

	/**
	 * Calculates Total Payable Interest.
	 */
	public long calculateTotalInterestPayable(EmiCalculator calculator) {
		boolean isTimeInYears = calculator.isTimeInYears();
		long time = calculator.getTime();
		double principal = calculator.getPrincipalAmount();
		double emi = calculator.getEmi();
		
		if(isTimeInYears){
			time = time * 12;
		}
		double totalInterest = (time * emi) - principal;
		long finalTotalInterest = Math.round(totalInterest * 100)/100;
		/*DecimalFormat formater = new DecimalFormat("##,###,###");
		String totalInterestString = formater.format(finalTotalInterest);
		long totalPayableInterest = Long.parseLong(totalInterestString);*/
		return finalTotalInterest;
	}

	/**
	 * Calculates Total Payment.
	 */
	public long calculateTotalPayment(EmiCalculator calculator) {
		boolean isTimeInYears = calculator.isTimeInYears();
		long time = calculator.getTime();
		double emi = calculator.getEmi();
		
		if(isTimeInYears){
			time = time * 12;
		}
		double payment = time * emi;
		long totalPayment = Math.round(payment * 100)/100;
		return totalPayment;
	}

	

}
