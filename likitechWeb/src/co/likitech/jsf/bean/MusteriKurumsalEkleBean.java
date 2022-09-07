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

import co.likitech.jsf.model.MusteriKurumsalDto;
import co.likitech.jsf.service.PersonelService;

@ManagedBean(name = MusteriKurumsalEkleBean.BEAN_NAME)
@RequestScoped
public class MusteriKurumsalEkleBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8722520697656084411L;

	public static final String BEAN_NAME = "musteriKurumsalEkleBean";

	private Integer musteriID;
	private String musteriKurumAdi;
	private String musteriVergiNumarasi;
	private String musteriVergiMukellefiyeti;
	private String musteriMaili;
	private String musteriTelefonNo;
	private String musteriSehri;
	private String musteriUlkesi;
	private String musteriAdresi;

	private List<MusteriKurumsalDto> musteriKurumsallar;

	@ManagedProperty(value = "#{" + PersonelService.BEAN_NAME + "}")
	private PersonelService personelService;

	public void setPersonelService(PersonelService personelService) {
		this.personelService = personelService;
	}

	public void musteriKurumsalEkle() {
		personelService.musteriKurumsalEkle(new MusteriKurumsalDto(musteriID, musteriKurumAdi, musteriVergiNumarasi,
				musteriVergiMukellefiyeti, musteriMaili, musteriTelefonNo, musteriSehri, musteriUlkesi, musteriAdresi));

		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest origRequest = (HttpServletRequest) context.getExternalContext().getRequest();
		String contextPath = origRequest.getContextPath();

		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect(contextPath + "/co/musteriKurumsalEkle.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void guncelle(MusteriKurumsalDto m) {
		this.personelService.musteriKurumsalGuncelle(m.getMusteriID(), m.getMusteriKurumAdi(),
				m.getMusteriVergiNumarasi(), m.getMusteriVergiMukellefiyeti(), m.getMusteriMaili(),
				m.getMusteriTelefonNo(), m.getMusteriSehri(), m.getMusteriUlkesi(), m.getMusteriAdresi());
		;
	}

	public void musteriKurumsalSil(MusteriKurumsalDto m) {
		this.personelService.musteriKurumsalSil(m);
		musteriKurumsalGetir();
	}

	public void musteriKurumsalGetir() {
		this.musteriKurumsallar = this.personelService.MusteriKurumsalGetir();
	}

	@PostConstruct
	public void init() {
		musteriKurumsalGetir();
		filterBy = new ArrayList<>();
	}

//	FİLTRELEME

	private List<MusteriKurumsalDto> filteredMusteriKurumsal;

	public List<MusteriKurumsalDto> getFilteredMusteriKurumsal() {
		return filteredMusteriKurumsal;
	}

	public void setFilteredMusteriKurumsal(List<MusteriKurumsalDto> filteredMusteriKurumsal) {
		this.filteredMusteriKurumsal = filteredMusteriKurumsal;
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

		MusteriKurumsalDto musteriKurumsal = (MusteriKurumsalDto) value;
		return musteriKurumsal.getMusteriKurumAdi().toLowerCase().contains(filterText)
				|| musteriKurumsal.getMusteriVergiNumarasi().toLowerCase().contains(filterText)
				|| musteriKurumsal.getMusteriVergiMukellefiyeti().toLowerCase().contains(filterText)
				|| musteriKurumsal.getMusteriMaili().toLowerCase().contains(filterText)
				|| musteriKurumsal.getMusteriTelefonNo().toLowerCase().contains(filterText)
				|| musteriKurumsal.getMusteriSehri().toLowerCase().contains(filterText)
				|| musteriKurumsal.getMusteriUlkesi().toLowerCase().contains(filterText)
				|| musteriKurumsal.getMusteriAdresi().toLowerCase().contains(filterText);
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

	public Integer getMusteriID() {
		return musteriID;
	}

	public void setMusteriID(Integer musteriID) {
		this.musteriID = musteriID;
	}

	public String getMusteriKurumAdi() {
		return musteriKurumAdi;
	}

	public void setMusteriKurumAdi(String musteriKurumAdi) {
		this.musteriKurumAdi = musteriKurumAdi;
	}

	public String getMusteriVergiNumarasi() {
		return musteriVergiNumarasi;
	}

	public void setMusteriVergiNumarasi(String musteriVergiNumarasi) {
		this.musteriVergiNumarasi = musteriVergiNumarasi;
	}

	public String getMusteriVergiMukellefiyeti() {
		return musteriVergiMukellefiyeti;
	}

	public void setMusteriVergiMukellefiyeti(String musteriVergiMukellefiyeti) {
		this.musteriVergiMukellefiyeti = musteriVergiMukellefiyeti;
	}

	public String getMusteriMaili() {
		return musteriMaili;
	}

	public void setMusteriMaili(String musteriMaili) {
		this.musteriMaili = musteriMaili;
	}

	public String getMusteriTelefonNo() {
		return musteriTelefonNo;
	}

	public void setMusteriTelefonNo(String musteriTelefonNo) {
		this.musteriTelefonNo = musteriTelefonNo;
	}

	public String getMusteriSehri() {
		return musteriSehri;
	}

	public void setMusteriSehri(String musteriSehri) {
		this.musteriSehri = musteriSehri;
	}

	public String getMusteriUlkesi() {
		return musteriUlkesi;
	}

	public void setMusteriUlkesi(String musteriUlkesi) {
		this.musteriUlkesi = musteriUlkesi;
	}

	public String getMusteriAdresi() {
		return musteriAdresi;
	}

	public void setMusteriAdresi(String musteriAdresi) {
		this.musteriAdresi = musteriAdresi;
	}

	public List<MusteriKurumsalDto> getMusteriKurumsallar() {
		return musteriKurumsallar;
	}

	public void setMusteriKurumsallar(List<MusteriKurumsalDto> musteriKurumsallar) {
		this.musteriKurumsallar = musteriKurumsallar;
	}

}
