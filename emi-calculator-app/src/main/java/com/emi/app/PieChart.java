package com.emi.app;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.util.Rotation;

/**
 * JFree implementation of a Pie Chart.
 *  
 * @author Shyam Baitmangalkar | catch.shyambaitmangalkar@gmail.com
 *
 */
public class PieChart extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private long totalPayableInterest;
	private double principalAmount;
	
	/**
	 * Public constructor
	 * 
	 * @param totalPayableInterest
	 * @param principalAmount
	 */
	public PieChart(long totalPayableInterest, double principalAmount){
		this.totalPayableInterest = totalPayableInterest;
		this.principalAmount = principalAmount;
	}
	
	/**
	 * Creates a PieDataset. Basically a dataset represents the entities
	 * that are to be considered for plotting the chart.
	 * 
	 * @return PieDataset
	 */
	private PieDataset createDataSet(){
		DefaultPieDataset result = new DefaultPieDataset();
		result.setValue("Total Payable Interest", totalPayableInterest);
		result.setValue("Principal Amount", principalAmount);
		return result;
	}
	
	/**
	 * Creates a 3D pie chart.
	 * 
	 * @param dataSet
	 * @return JFreeChart
	 */
	private JFreeChart createChart(PieDataset dataSet){
		JFreeChart chart = ChartFactory.createPieChart3D(null, dataSet, true, true, false);
		PiePlot3D plot = (PiePlot3D)chart.getPlot();
		plot.setStartAngle(290);
		plot.setDirection(Rotation.CLOCKWISE);
		plot.setForegroundAlpha(0.5f);
		return chart;
	}
	
	/**
	 * Plots the pie chart with given panel size.
	 * 
	 * @return JPanel
	 */
	public JPanel getChartPlot(){
		PieDataset dataSet = createDataSet();
		JFreeChart chart = createChart(dataSet);
		ChartPanel panel = new ChartPanel(chart);
		panel.setSize(500, 500);
		JPanel chartPanel = new JPanel();
		chartPanel.setSize(500, 500);
		/*JLabel chartTitle = new JLabel("Total Payable Interest vs Principal Amount");
		chartTitle.setFont(new Font("Verdana", 1, 12));
		chartPanel.add(chartTitle);*/
		chartPanel.add(panel);
		return chartPanel;
	}

}
