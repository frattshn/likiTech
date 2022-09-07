package co.likitech.jsf.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.primefaces.model.charts.ChartData;
import org.primefaces.model.charts.donut.DonutChartDataSet;
import org.primefaces.model.charts.donut.DonutChartModel;

import co.likitech.jsf.model.HesapTop10Dto;
import co.likitech.jsf.service.PersonelService;

@ManagedBean(name = AnasayfaBean.BEAN_NAME)
@RequestScoped
public class AnasayfaBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1968765768700502540L;

	public static final String BEAN_NAME = "anasayfaBean";

	private BigDecimal toplamTl;
	private BigDecimal toplamUsd;
	private BigDecimal toplamEuro;
	private List<HesapTop10Dto> top10;

	@ManagedProperty(value = "#{" + PersonelService.BEAN_NAME + "}")
	private PersonelService personelService;

	public void setPersonelService(PersonelService personelService) {
		this.personelService = personelService;
	}

	@PostConstruct
	public void init() {
		toplamBakiyeleriGetir();
		createDonutModel();
		top10Getir();
	}

	private void toplamBakiyeleriGetir() {
		this.toplamTl = personelService.toplamBakiye("TL");
		this.toplamUsd = personelService.toplamBakiye("USD");
		this.toplamEuro = personelService.toplamBakiye("EURO");

	}

	private void top10Getir() {
		this.top10 = personelService.top10();
	}

	// Donut

	private DonutChartModel donutModel;

	public void createDonutModel() {
		donutModel = new DonutChartModel();
		ChartData data = new ChartData();

		DonutChartDataSet dataSet = new DonutChartDataSet();
		List<Number> values = new ArrayList<>();
		values.add(toplamTl);
		values.add(toplamUsd);
		values.add(toplamEuro);
		dataSet.setData(values);

		List<String> bgColors = new ArrayList<>();
		bgColors.add("rgb(255, 99, 132)");
		bgColors.add("rgb(54, 162, 235)");
		bgColors.add("rgb(255, 205, 86)");
		dataSet.setBackgroundColor(bgColors);

		data.addChartDataSet(dataSet);
		List<String> labels = new ArrayList<>();
		labels.add("Türk Lirasý");
		labels.add("Dolar");
		labels.add("Euro");
		data.setLabels(labels);

		donutModel.setData(data);
	}

	public BigDecimal getToplamTl() {
		return toplamTl;
	}

	public BigDecimal getToplamUsd() {
		return toplamUsd;
	}

	public BigDecimal getToplamEuro() {
		return toplamEuro;
	}

	public PersonelService getPersonelService() {
		return personelService;
	}

	public void setToplamTl(BigDecimal toplamTl) {
		this.toplamTl = toplamTl;
	}

	public void setToplamUsd(BigDecimal toplamUsd) {
		this.toplamUsd = toplamUsd;
	}

	public void setToplamEuro(BigDecimal toplamEuro) {
		this.toplamEuro = toplamEuro;
	}

	public DonutChartModel getDonutModel() {
		return donutModel;
	}

	public void setDonutModel(DonutChartModel donutModel) {
		this.donutModel = donutModel;
	}

	public List<HesapTop10Dto> getTop10() {
		return top10;
	}

	public void setTop10(List<HesapTop10Dto> top10) {
		this.top10 = top10;
	}

}
