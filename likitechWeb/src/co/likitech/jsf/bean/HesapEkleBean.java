package co.likitech.jsf.bean;

import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.primefaces.model.FilterMeta;
import org.primefaces.util.LangUtils;

import co.likitech.jsf.entity.Hesap;
import co.likitech.jsf.model.MusteriBireyselDto;
import co.likitech.jsf.model.MusteriKurumsalDto;
import co.likitech.jsf.service.PersonelService;

@ManagedBean(name = HesapEkleBean.BEAN_NAME)
@RequestScoped
public class HesapEkleBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7570888103177171835L;

	public static final String BEAN_NAME = "hesapEkleBean";

	private Integer hesapID;
	private Integer musteriID;
	private String hesapTuru;
	private Double hesapBakiye;
	private String portfoyNo;
	private Date hesapAcilisTarihi;
	private String BireyselKurumsalMi;

	private List<MusteriKurumsalDto> musteriKurumsallar;
	private List<MusteriBireyselDto> musteriBireyseller;

	private Integer secilmisKurumsalMusteriId;
	private Integer secilmisBireyselMusteriId;

	@ManagedProperty(value = "#{" + PersonelService.BEAN_NAME + "}")
	private PersonelService personelService;

	public void setPersonelService(PersonelService personelService) {
		this.personelService = personelService;
	}

	public void hesapBireyselEkle() {
		Hesap h = new Hesap(hesapID, secilmisBireyselMusteriId, this.hesapTuru, this.portfoyNo,
				new Date(new java.util.Date().getTime()), new BigDecimal(0));
		personelService.hesapEkle(h);
		
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest origRequest = (HttpServletRequest) context.getExternalContext().getRequest();
		String contextPath = origRequest.getContextPath();

		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect(contextPath + "/co/hesapBireyselEkle.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void hesapKurumsalEkle() {
		Hesap h = new Hesap(hesapID, secilmisKurumsalMusteriId, this.hesapTuru, this.portfoyNo,
				new Date(new java.util.Date().getTime()), new BigDecimal(0));
		personelService.hesapEkle(h);
		
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest origRequest = (HttpServletRequest) context.getExternalContext().getRequest();
		String contextPath = origRequest.getContextPath();

		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect(contextPath + "/co/hesapKurumsalEkle.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void musteriKurumsalGetir() {
		this.musteriKurumsallar = this.personelService.MusteriKurumsalGetir();
	}

	public void musteriBireyselGetir() {
		this.musteriBireyseller = this.personelService.MusteriBireyselGetir();
	}

	@PostConstruct
	public void init() {
		musteriKurumsalGetir();
		musteriBireyselGetir();
		filterBy = new ArrayList<>();

	}

	public Integer getHesapID() {
		return hesapID;
	}

	public void setHesapID(Integer hesapID) {
		this.hesapID = hesapID;
	}

	public Integer getMusteriID() {
		return musteriID;
	}

	public void setMusteriID(Integer musteriID) {
		this.musteriID = musteriID;
	}

	public String getHesapTuru() {
		return hesapTuru;
	}

	public void setHesapTuru(String hesapTuru) {
		this.hesapTuru = hesapTuru;
	}

	public Double getHesapBakiye() {
		return hesapBakiye;
	}

	public void setHesapBakiye(Double hesapBakiye) {
		this.hesapBakiye = hesapBakiye;
	}

	public String getPortfoyNo() {
		return portfoyNo;
	}

	public void setPortfoyNo(String portfoyNo) {
		this.portfoyNo = portfoyNo;
	}

	public Date getHesapAcilisTarihi() {
		return hesapAcilisTarihi;
	}

	public void setHesapAcilisTarihi(Date hesapAcilisTarihi) {
		this.hesapAcilisTarihi = hesapAcilisTarihi;
	}

	public List<MusteriKurumsalDto> getMusteriKurumsallar() {
		return musteriKurumsallar;
	}

	public void setMusteriKurumsallar(List<MusteriKurumsalDto> musteriKurumsallar) {
		this.musteriKurumsallar = musteriKurumsallar;
	}

	public List<MusteriBireyselDto> getMusteriBireyseller() {
		return musteriBireyseller;
	}

	public void setMusteriBireyseller(List<MusteriBireyselDto> musteriBireyseller) {
		this.musteriBireyseller = musteriBireyseller;
	}

	public PersonelService getPersonelService() {
		return personelService;

	}

	private List<MusteriKurumsalDto> filteredMusteriKurumsal;

	public List<MusteriKurumsalDto> getFilteredMusteriKurumsal() {
		return filteredMusteriKurumsal;
	}

	public void setFilteredMusteriKurumsal(List<MusteriKurumsalDto> filteredMusteriKurumsal) {
		this.filteredMusteriKurumsal = filteredMusteriKurumsal;
	}

	public Integer getSecilmisKurumsalMusteriId() {
		return secilmisKurumsalMusteriId;
	}

	public void setSecilmisKurumsalMusteriId(Integer secilmisKurumsalMusteriId) {
		this.secilmisKurumsalMusteriId = secilmisKurumsalMusteriId;
	}

	public Integer getSecilmisBireyselMusteriId() {
		return secilmisBireyselMusteriId;
	}

	public void setSecilmisBireyselMusteriId(Integer secilmisBireyselMusteriId) {
		this.secilmisBireyselMusteriId = secilmisBireyselMusteriId;
	}

	public String getBireyselKurumsalMi() {
		return BireyselKurumsalMi;
	}

	public void setBireyselKurumsalMi(String bireyselKurumsalMi) {
		BireyselKurumsalMi = bireyselKurumsalMi;
	}

//	FiLTRELEME

	public List<FilterMeta> getFilterBy() {
		return filterBy;
	}

	public void setFilterBy(List<FilterMeta> filterBy) {
		this.filterBy = filterBy;
	}

	private List<FilterMeta> filterBy;
	private boolean globalFilterOnly;

	public boolean globalFilterFunction(Object value, Object filter, Locale locale) {
		String filterText = (filter == null) ? null : filter.toString().trim().toLowerCase();
		if (LangUtils.isBlank(filterText)) {
			return true;
		}
		int filterInt = getInteger(filterText);

		MusteriKurumsalDto fon = (MusteriKurumsalDto) value;
		return fon.getMusteriKurumAdi().toLowerCase().contains(filterText)
				|| fon.getMusteriVergiNumarasi().toLowerCase().contains(filterText)
				|| fon.getMusteriVergiMukellefiyeti().toLowerCase().contains(filterText)
				|| fon.getMusteriMaili().toLowerCase().contains(filterText)
				|| fon.getMusteriTelefonNo().toLowerCase().contains(filterText)
				|| fon.getMusteriSehri().toLowerCase().contains(filterText)
				|| fon.getMusteriUlkesi().toLowerCase().contains(filterText)
				|| fon.getMusteriAdresi().toLowerCase().contains(filterText);
	}

	private int getInteger(String string) {
		try {
			return Integer.parseInt(string);
		} catch (NumberFormatException ex) {
			return 0;
		}
	}

	public void toggleGlobalFilter() {
		setGlobalFilterOnly(!isGlobalFilterOnly());
	}

	public boolean isGlobalFilterOnly() {
		return globalFilterOnly;
	}

	public void setGlobalFilterOnly(boolean globalFilterOnly) {
		this.globalFilterOnly = globalFilterOnly;
	}

}
