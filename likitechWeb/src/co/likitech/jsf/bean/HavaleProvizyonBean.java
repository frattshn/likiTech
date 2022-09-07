package co.likitech.jsf.bean;

import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.primefaces.model.FilterMeta;
import org.primefaces.util.LangUtils;

import co.likitech.jsf.entity.Hesap;
import co.likitech.jsf.model.HesapDto;
import co.likitech.jsf.service.PersonelService;

@ManagedBean(name = HavaleProvizyonBean.BEAN_NAME)
@RequestScoped
public class HavaleProvizyonBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -84374869320280486L;
	public static final String BEAN_NAME = "havaleProvizyonBean";

	private BigDecimal havaleProvizyon;
	private Boolean islem;
	private List<Hesap> hesaplar;
	private Integer secilmisHesapId;
	
	private List<HesapDto> hesapDtolar;

	@ManagedProperty(value = "#{" + PersonelService.BEAN_NAME + "}")
	private PersonelService personelService;

	public void setPersonelService(PersonelService personelService) {
		this.personelService = personelService;
	}

	public void bakiyeGuncelle() {
		if (islem == false) {
			havaleProvizyon = havaleProvizyon.negate();
			this.personelService.hesapGuncelle(secilmisHesapId, havaleProvizyon);

		} else {
			this.personelService.hesapGuncelle(secilmisHesapId, havaleProvizyon);
		}
		
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest origRequest = (HttpServletRequest) context.getExternalContext().getRequest();
		String contextPath = origRequest.getContextPath();

		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect(contextPath + "/co/havaleProvizyon.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@PostConstruct
	public void init() {
		hesaplariGetir();
		hesapDtolariGetir();
	}

	private void hesaplariGetir() {
		this.hesaplar = this.personelService.hesaplariGetir();

	}
	
	public void hesapDtolariGetir() {
		this.hesapDtolar = this.personelService.hesapDtolariGetir();
	}

	public BigDecimal getHavaleProvizyon() {
		return havaleProvizyon;
	}

	public void setHavaleProvizyon(BigDecimal havaleProvizyon) {
		this.havaleProvizyon = havaleProvizyon;
	}

	public Boolean getIslem() {
		return islem;
	}

	public void setIslem(Boolean islem) {
		this.islem = islem;
	}

	public List<Hesap> getHesaplar() {
		return hesaplar;
	}

	public void setHesaplar(List<Hesap> hesaplar) {
		this.hesaplar = hesaplar;
	}

	public Integer getSecilmisHesapId() {
		return secilmisHesapId;
	}

	public void setSecilmisHesapId(Integer secilmisHesapId) {
		this.secilmisHesapId = secilmisHesapId;
	}
	
	public List<HesapDto> getHesapDtolar() {
		return hesapDtolar;
	}

	public void setHesapDtolar(List<HesapDto> hesapDtolar) {
		this.hesapDtolar = hesapDtolar;
	}

//	FİLTRELEME

	private List<HesapDto> filteredHesapDto;

	public List<HesapDto> getFilteredHesapDto() {
		return filteredHesapDto;
	}

	public void setFilteredHesapDto(List<HesapDto> filteredHesapDto) {
		this.filteredHesapDto = filteredHesapDto;
	}

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

		HesapDto HesapDto = (HesapDto) value;
		return HesapDto.getPortfoyNo().toLowerCase().contains(filterText)
				|| HesapDto.getMusteriAdi().toLowerCase().contains(filterText)
				|| HesapDto.getHesapBakiye().toString().toLowerCase().contains(filterText)
				|| HesapDto.getHesapTuru().toLowerCase().contains(filterText);
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
