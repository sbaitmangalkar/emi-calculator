package com.emi.service;

import com.emi.model.EmiCalculator;

/**
 * Declares the methods that will be used to compute EMI.
 * 
 * @author Shyam Baitmangalkar | catch.shyambaitmangalkar@gmail.com
 *
 */
public interface EmiComputation {
	/**
	 * 
	 * @param calculator
	 * @return
	 */
	public abstract long calculateEmi(EmiCalculator calculator);
	
	/**
	 * 
	 * @param calculator
	 * @return
	 */
	public abstract long calculateTotalInterestPayable(EmiCalculator calculator);
	
	/**
	 * 
	 * @param calculator
	 * @return
	 */
	public abstract long calculateTotalPayment(EmiCalculator calculator);
}
