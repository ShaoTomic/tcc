package br.com.portifolio.controle;

import javax.faces.bean.ManagedBean;

import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LineChartSeries;
import org.primefaces.model.chart.PieChartModel;

@ManagedBean(name="chartBean")
public class ChartBean {
	
	private PieChartModel pieModel = new PieChartModel();
	private CartesianChartModel categoryModel = new CartesianChartModel();
	private CartesianChartModel linearModel = new CartesianChartModel();
	
	public ChartBean(){
		
		this.pieModel.set("São Paulo", 3);
		this.pieModel.set("Santos", 3);
		this.pieModel.set("Palmeiras", 1);
		this.pieModel.set("Corinthians", 1);
		
		ChartSeries serieA = new ChartSeries();
		serieA.setLabel("A");
		
		serieA.set("2004", 10);
		serieA.set("2005", 200);
		serieA.set("2006", 77);
		serieA.set("2007", 13);
		serieA.set("2008", 177);
		
		
		ChartSeries serieB = new ChartSeries();
		serieB.setLabel("B");
		
		serieB.set("2004", 100);
		serieB.set("2005", 95);
		serieB.set("2006", 115);
		serieB.set("2007", 105);
		serieB.set("2008", 111);
		
		categoryModel.addSeries(serieA);
		categoryModel.addSeries(serieB);
		
		LineChartSeries series1 = new LineChartSeries();
		series1.setLabel("1");
		
		series1.set(1, 1);
		series1.set(2, 2);
		series1.set(3, 2);
		series1.set(4, 7);
		series1.set(5, 1);
		
		LineChartSeries series2 = new LineChartSeries();
		series2.setLabel("2");
		
		series2.set(1, 5);
		series2.set(2, 6);
		series2.set(3, 7);
		series2.set(4, 1);
		series2.set(5, 7);
		
		linearModel.addSeries(series1);
		linearModel.addSeries(series2);
		
	}

	public PieChartModel getPieModel() {
		return pieModel;
	}

	public void setPieModel(PieChartModel pieModel) {
		this.pieModel = pieModel;
	}

	public CartesianChartModel getCategoryModel() {
		return categoryModel;
	}

	public void setCategoryModel(CartesianChartModel categoryModel) {
		this.categoryModel = categoryModel;
	}

	public CartesianChartModel getLinearModel() {
		return linearModel;
	}

	public void setLinearModel(CartesianChartModel linearModel) {
		this.linearModel = linearModel;
	}
	
	
	
}
