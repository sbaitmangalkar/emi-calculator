package com.emi.app;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.util.Rotation;

public class PieChart extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private long totalPayableInterest;
	private double principalAmount;
	
	public PieChart(long totalPayableInterest, double principalAmount){
		this.totalPayableInterest = totalPayableInterest;
		this.principalAmount = principalAmount;
	}
	
	private PieDataset createDataSet(){
		DefaultPieDataset result = new DefaultPieDataset();
		result.setValue("Total Payable Interest", totalPayableInterest);
		result.setValue("Principal Amount", principalAmount);
		return result;
	}
	
	private JFreeChart createChart(PieDataset dataSet){
		JFreeChart chart = ChartFactory.createPieChart3D(null, dataSet, true, true, false);
		PiePlot3D plot = (PiePlot3D)chart.getPlot();
		plot.setStartAngle(290);
		plot.setDirection(Rotation.CLOCKWISE);
		plot.setForegroundAlpha(0.5f);
		return chart;
	}
	
	public JPanel getChartPlot(){
		PieDataset dataSet = createDataSet();
		JFreeChart chart = createChart(dataSet);
		ChartPanel panel = new ChartPanel(chart);
		panel.setSize(500, 500);
		JPanel chartPanel = new JPanel();
		chartPanel.setSize(500, 500);
		//JLabel chartTitle = new JLabel("Total Payable Interest vs Principal Amount");
		//chartTitle.setFont(new Font("Verdana", 1, 12));
		//chartPanel.add(chartTitle);
		chartPanel.add(panel);
		return chartPanel;
	}

}
