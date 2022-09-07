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

import co.likitech.jsf.entity.Personel;
import co.likitech.jsf.service.PersonelService;

@ManagedBean(name = PersonelEkleBean.BEAN_NAME)
@RequestScoped
public class PersonelEkleBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 134963442693523262L;

	public static final String BEAN_NAME = "personelEkleBean";

	private Integer personelID;
	private String personelAdi;
	private String personelSoyadi;
	private String personelKullaniciAdi;
	private String personelSifresi;
	private String personelMaili;

	private List<Personel> personeller;

	@ManagedProperty(value = "#{" + PersonelService.BEAN_NAME + "}")
	private PersonelService personelService;

	public void setPersonelService(PersonelService personelService) {
		this.personelService = personelService;
	}

	public void personelEkle() {
		personelService.personelEkle(new Personel(personelID, personelAdi, personelSoyadi, personelKullaniciAdi,
				personelSifresi, personelMaili));
		
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest origRequest = (HttpServletRequest) context.getExternalContext().getRequest();
		String contextPath = origRequest.getContextPath();

		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect(contextPath + "/co/personelEkle.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void guncelle(Personel p) {
		this.personelService.personelGuncelle(p.getPersonelID(), p.getPersonelAdi(), p.getPersonelSoyadi(),
				p.getPersonelKullaniciAdi(), p.getPersonelSifresi(), p.getPersonelMaili());
	}

	public void personelSil(Personel p) {
		this.personelService.personelSil(p);
		personelleriGetir();
	}

	public void personelleriGetir() {
		this.personeller = this.personelService.personelleriGetir();
	}

	@PostConstruct
	public void init() {
		personelleriGetir();
		filterBy = new ArrayList<>();

	}

	public Integer getPersonelID() {
		return personelID;
	}

	public void setPersonelID(Integer personelID) {
		this.personelID = personelID;
	}

	public String getPersonelAdi() {
		return personelAdi;
	}

	public void setPersonelAdi(String personelAdi) {
		this.personelAdi = personelAdi;
	}

	public String getPersonelSoyadi() {
		return personelSoyadi;
	}

	public void setPersonelSoyadi(String personelSoyadi) {
		this.personelSoyadi = personelSoyadi;
	}

	public String getPersonelKullaniciAdi() {
		return personelKullaniciAdi;
	}

	public void setPersonelKullaniciAdi(String personelKullaniciAdi) {
		this.personelKullaniciAdi = personelKullaniciAdi;
	}

	public String getPersonelSifresi() {
		return personelSifresi;
	}

	public void setPersonelSifresi(String personelSifresi) {
		this.personelSifresi = personelSifresi;
	}

	public String getPersonelMaili() {
		return personelMaili;
	}

	public void setPersonelMaili(String personelMaili) {
		this.personelMaili = personelMaili;
	}

	public List<Personel> getPersoneller() {
		return personeller;
	}

	public void setPersoneller(List<Personel> personeller) {
		this.personeller = personeller;
	}

//	FÝLTRELEME

	private List<Personel> filteredPersonel;

	public List<Personel> getFilteredPersonel() {
		return filteredPersonel;
	}

	public void setFilteredPersonel(List<Personel> filteredPersonel) {
		this.filteredPersonel = filteredPersonel;
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

		Personel personel = (Personel) value;
		return personel.getPersonelAdi().toLowerCase().contains(filterText)
				|| personel.getPersonelSoyadi().toLowerCase().contains(filterText)
				|| personel.getPersonelKullaniciAdi().toLowerCase().contains(filterText)
				|| personel.getPersonelMaili().toLowerCase().contains(filterText);
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
