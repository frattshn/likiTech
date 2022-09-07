package co.likitech.jsf.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import co.likitech.jsf.entity.Fon;
import co.likitech.jsf.entity.FonFiyat;
import co.likitech.jsf.service.PersonelService;

@ManagedBean(name = FonFiyatBean.BEAN_NAME)
@RequestScoped
public class FonFiyatBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4056387429425401577L;

	public static final String BEAN_NAME = "fonFiyatBean";

	private Integer fonFiyatID;
	private BigDecimal fonFiyat;
	private Date fonTarih;
	

	private List<Fon> fonlar;
	private Integer secilenFonID;

	@ManagedProperty(value = "#{" + PersonelService.BEAN_NAME + "}")
	private PersonelService personelService;

	public void setPersonelService(PersonelService personelService) {
		this.personelService = personelService;
	}

	public void fonFiyatEkle() {
		this.personelService.fonFiyatEkle(new FonFiyat(fonFiyatID, secilenFonID, fonFiyat, new java.sql.Date(fonTarih.getTime())));
	}

	public void fonlariGetir() {
		this.fonlar = this.personelService.fonlariGetir();
	}

	@PostConstruct
	public void init() {
		fonlariGetir();
	}

	public Integer getFonFiyatID() {
		return fonFiyatID;
	}

	public BigDecimal getFonFiyat() {
		return fonFiyat;
	}

	public Date getFonTarih() {
		return fonTarih;
	}

	public List<Fon> getFonlar() {
		return fonlar;
	}

	public Integer getSecilenFonID() {
		return secilenFonID;
	}

	public PersonelService getPersonelService() {
		return personelService;
	}

	public void setFonFiyatID(Integer fonFiyatID) {
		this.fonFiyatID = fonFiyatID;
	}

	public void setFonFiyat(BigDecimal fonFiyat) {
		this.fonFiyat = fonFiyat;
	}

	public void setFonTarih(Date fonTarih) {
		this.fonTarih = fonTarih;
	}

	public void setFonlar(List<Fon> fonlar) {
		this.fonlar = fonlar;
	}

	public void setSecilenFonID(Integer secilenFonID) {
		this.secilenFonID = secilenFonID;
	}

}
