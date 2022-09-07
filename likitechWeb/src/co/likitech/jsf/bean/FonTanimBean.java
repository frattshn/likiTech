package co.likitech.jsf.bean;

import java.io.IOException;
import java.io.Serializable;
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

import co.likitech.jsf.entity.Fon;
import co.likitech.jsf.service.PersonelService;

@ManagedBean(name = FonTanimBean.BEAN_NAME)
@RequestScoped
public class FonTanimBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6588379389646717394L;

	public static final String BEAN_NAME = "fonTanimBean";

	private Integer fonID;
	private String fonAdi;
	private String fonTuru;
	private String fonKodu;
	private String isinKodu;

	private List<Fon> fonlar;

	@ManagedProperty(value = "#{" + PersonelService.BEAN_NAME + "}")
	private PersonelService personelService;

	public void setPersonelService(PersonelService personelService) {
		this.personelService = personelService;
	}

	public void fonEkle() {
		personelService.fonTanim(new Fon(fonID, fonAdi, fonTuru, fonKodu, isinKodu));

		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest origRequest = (HttpServletRequest) context.getExternalContext().getRequest();
		String contextPath = origRequest.getContextPath();

		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect(contextPath + "/co/fonTanim.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void guncelle(Fon f) {
		this.personelService.fonGuncelle(f.getFonID(), f.getFonAdi(), f.getFonTuru(), f.getFonKodu(), f.getIsinKodu());
	}

	public void fonSil(Fon f) {
		this.personelService.fonSil(f);
		fonlariGetir();
	}

	public void fonlariGetir() {
		this.fonlar = this.personelService.fonlariGetir();
	}

	@PostConstruct
	public void init() {
		fonlariGetir();
		filterBy = new ArrayList<>();

	}

	public Integer getFonID() {
		return fonID;
	}

	public void setFonID(Integer fonID) {
		this.fonID = fonID;
	}

	public String getFonAdi() {
		return fonAdi;
	}

	public void setFonAdi(String fonAdi) {
		this.fonAdi = fonAdi;
	}

	public String getFonTuru() {
		return fonTuru;
	}

	public void setFonTuru(String fonTuru) {
		this.fonTuru = fonTuru;
	}

	public String getFonKodu() {
		return fonKodu;
	}

	public void setFonKodu(String fonKodu) {
		this.fonKodu = fonKodu;
	}

	public String getIsinKodu() {
		return isinKodu;
	}

	public void setIsinKodu(String isinKodu) {
		this.isinKodu = isinKodu;
	}

	public List<Fon> getFonlar() {
		return fonlar;
	}

	public void setFonlar(List<Fon> fonlar) {
		this.fonlar = fonlar;
	}

//	FÝLTRELEME

	private List<Fon> filteredFon;

	public List<Fon> getFilteredFon() {
		return filteredFon;
	}

	public void setFilteredFon(List<Fon> filteredFon) {
		this.filteredFon = filteredFon;
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

		Fon fon = (Fon) value;
		return fon.getFonAdi().toLowerCase().contains(filterText) || fon.getFonKodu().toLowerCase().contains(filterText)
				|| fon.getFonTuru().toLowerCase().contains(filterText)
				|| fon.getIsinKodu().toLowerCase().contains(filterText);
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
