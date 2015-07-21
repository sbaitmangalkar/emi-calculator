package com.emi.model;

/**
 * Model that represents EMI calculator template.
 * 
 * @author Shyam Baitmangalkar | catch.shyamBaitmangalkar@gmail.com
 *
 */
public class EmiCalculator {
	private long time;
	private double principalAmount;
	private double rateOfInterest;
	private double emi;
	private boolean isTimeInYears;
	
	/**
	 * 
	 * @return
	 */
	public long getTime() {
		return time;
	}
	/**
	 * 
	 * @param time
	 */
	public void setTime(long time) {
		this.time = time;
	}
	/**
	 * 
	 * @return
	 */
	public double getPrincipalAmount() {
		return principalAmount;
	}
	/**
	 * 
	 * @param principalAmount
	 */
	public void setPrincipalAmount(double principalAmount) {
		this.principalAmount = principalAmount;
	}
	/**
	 * 
	 * @return
	 */
	public double getRateOfInterest() {
		return rateOfInterest;
	}
	/**
	 * 
	 * @param rateOfInterest
	 */
	public void setRateOfInterest(double rateOfInterest) {
		this.rateOfInterest = rateOfInterest;
	}
	/**
	 * 
	 * @return
	 */
	public boolean isTimeInYears() {
		return isTimeInYears;
	}
	/**
	 * 
	 * @param isTimeInYears
	 */
	public void setTimeInYears(boolean isTimeInYears) {
		this.isTimeInYears = isTimeInYears;
	}
	
	/**
	 * 
	 * @return
	 */
	public double getEmi() {
		return emi;
	}
	
	/**
	 * 
	 * @param emi
	 */
	public void setEmi(double emi) {
		this.emi = emi;
	}
	
	
}
