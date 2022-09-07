package co.likitech.jsf.bean;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.primefaces.model.FilterMeta;
import org.primefaces.util.LangUtils;

import co.likitech.jsf.model.MusteriBireyselDto;
import co.likitech.jsf.service.PersonelService;

@ManagedBean(name = MusteriBireyselEkleBean.BEAN_NAME)
@ViewScoped
public class MusteriBireyselEkleBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -985261187933078180L;

	public static final String BEAN_NAME = "musteriBireyselEkleBean";

	private Integer musteriID;
	private String musteriAdi;
	private String musteriSoyadi;
	private String musteriVergiNumarasi;
	private String musteriVergiMukellefiyeti;
	private String musteriMaili;
	private String musteriTelefonNo;
	private String musteriSehri;
	private String musteriUyruk;
	private String musteriUlkesi;
	private String musteriAdresi;
	private String musteriTcNoYabanciNo;
	private String musteriBabaAdi;
	private String musteriNufusaKayitliYeri;
	private String musteriDogumYeri;
	private String musteriIkametYeri;
	private Boolean TurkMu;

	private Integer editMusteriNo;
	private String editMusteriAdi;
	private String editMusteriSoyadi;
	private String editMusteriVergiNumarasi;
	private String editMusteriVergiMukellefiyeti;
	private String editMusteriMaili;
	private String editMusteriTelefonNo;
	private String editMusteriSehri;
	private String editMusteriUyruk;
	private String editMusteriUlkesi;
	private String editMusteriAdresi;
	private String editMusteriTcNoYabanciNo;
	private String editMusteriBabaAdi;
	private String editMusteriNufusaKayitliYeri;
	private String editMusteriDogumYeri;
	private String editMusteriIkametYeri;
	private Boolean editTurkMu;

	private List<MusteriBireyselDto> musteriBireyseller;

	@ManagedProperty(value = "#{" + PersonelService.BEAN_NAME + "}")
	private PersonelService personelService;

	public void setPersonelService(PersonelService personelService) {
		this.personelService = personelService;
	}

	public void MusteriBireyselEkle() {
		personelService.musteriBireyselEkle(new MusteriBireyselDto(musteriID, musteriAdi, musteriSoyadi,
				musteriVergiNumarasi, musteriVergiMukellefiyeti, musteriMaili, musteriTelefonNo, musteriSehri,
				musteriUyruk, musteriUlkesi, musteriAdresi, musteriTcNoYabanciNo, musteriBabaAdi,
				musteriNufusaKayitliYeri, musteriDogumYeri, musteriIkametYeri));

		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest origRequest = (HttpServletRequest) context.getExternalContext().getRequest();
		String contextPath = origRequest.getContextPath();

		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect(contextPath + "/co/musteriBireyselEkle.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void guncelle() {

		this.personelService.musteriBireyselGuncelle(this.editMusteriNo, this.editMusteriAdi, this.editMusteriSoyadi,
				this.editMusteriVergiNumarasi, this.editMusteriVergiMukellefiyeti, this.editMusteriMaili,
				this.editMusteriTelefonNo, this.editMusteriSehri, this.editMusteriUyruk, this.editMusteriUlkesi,
				this.editMusteriAdresi, this.editMusteriTcNoYabanciNo, this.editMusteriBabaAdi,
				this.editMusteriNufusaKayitliYeri, this.editMusteriDogumYeri, this.editMusteriIkametYeri);
		;
		
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest origRequest = (HttpServletRequest) context.getExternalContext().getRequest();
		String contextPath = origRequest.getContextPath();

		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect(contextPath + "/co/musteriBireyselEkle.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void musteriBireyselSil(MusteriBireyselDto m) {
		this.personelService.musteriBireyselSil(m);
		musteriBireyselGetir();
	}

	public void musteriBireyselGetir() {
		this.musteriBireyseller = this.personelService.MusteriBireyselGetir();
	}

	public void doldurpanel(MusteriBireyselDto musteri) {
		this.editMusteriNo = musteri.getMusteriID();
		this.editMusteriAdi = musteri.getMusteriAdi();
		this.editMusteriSoyadi = musteri.getMusteriSoyadi();
		this.editMusteriVergiNumarasi = musteri.getMusteriVergiNumarasi();
		this.editMusteriVergiMukellefiyeti = musteri.getMusteriVergiMukellefiyeti();
		this.editMusteriMaili = musteri.getMusteriMaili();
		this.editMusteriTelefonNo = musteri.getMusteriTelefonNo();
		this.editMusteriSehri = musteri.getMusteriSehri();
		this.editMusteriUyruk = musteri.getMusteriUyruk();
		this.editMusteriUlkesi = musteri.getMusteriUlkesi();
		this.editMusteriAdresi = musteri.getMusteriAdresi();
		this.editMusteriTcNoYabanciNo = musteri.getMusteriTcNoYabanciNo();
		this.editMusteriBabaAdi = musteri.getMusteriBabaAdi();
		this.editMusteriNufusaKayitliYeri = musteri.getMusteriNufusaKayitliYeri();
		this.editMusteriDogumYeri = musteri.getMusteriDogumYeri();
		this.editMusteriIkametYeri = musteri.getMusteriIkametYeri();
	}

	@PostConstruct
	public void init() {
		TurkMu = Boolean.TRUE;
		musteriBireyselGetir();
		filterBy = new ArrayList<>();
	}

//	FİLTRELEME

	private List<MusteriBireyselDto> filteredMusteriBireysel;

	public List<MusteriBireyselDto> getFilteredMusteriBireysel() {
		return filteredMusteriBireysel;
	}

	public void setFilteredMusteriBireysel(List<MusteriBireyselDto> filteredMusteriBireysel) {
		this.filteredMusteriBireysel = filteredMusteriBireysel;
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

		MusteriBireyselDto musteriBireysel = (MusteriBireyselDto) value;
		return musteriBireysel.getMusteriAdi().toLowerCase().contains(filterText)
				|| musteriBireysel.getMusteriSoyadi().toLowerCase().contains(filterText)
				|| musteriBireysel.getMusteriUyruk().toLowerCase().contains(filterText)
				|| musteriBireysel.getMusteriTcNoYabanciNo().toLowerCase().contains(filterText)
				|| musteriBireysel.getMusteriDogumYeri().toLowerCase().contains(filterText)
				|| musteriBireysel.getMusteriBabaAdi().toLowerCase().contains(filterText)
				|| musteriBireysel.getMusteriNufusaKayitliYeri().toLowerCase().contains(filterText)
				|| musteriBireysel.getMusteriIkametYeri().toLowerCase().contains(filterText)
				|| musteriBireysel.getMusteriTelefonNo().toLowerCase().contains(filterText)
				|| musteriBireysel.getMusteriMaili().toLowerCase().contains(filterText)
				|| musteriBireysel.getMusteriUlkesi().toLowerCase().contains(filterText)
				|| musteriBireysel.getMusteriSehri().toLowerCase().contains(filterText)
				|| musteriBireysel.getMusteriAdresi().toLowerCase().contains(filterText)
				|| musteriBireysel.getMusteriVergiNumarasi().toLowerCase().contains(filterText)
				|| musteriBireysel.getMusteriVergiMukellefiyeti().toLowerCase().contains(filterText);
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

	public String getMusteriAdi() {
		return musteriAdi;
	}

	public void setMusteriAdi(String musteriAdi) {
		this.musteriAdi = musteriAdi;
	}

	public String getMusteriSoyadi() {
		return musteriSoyadi;
	}

	public void setMusteriSoyadi(String musteriSoyadi) {
		this.musteriSoyadi = musteriSoyadi;
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

	public String getMusteriUyruk() {
		return musteriUyruk;
	}

	public void setMusteriUyruk(String musteriUyruk) {
		this.musteriUyruk = musteriUyruk;
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

	public String getMusteriTcNoYabanciNo() {
		return musteriTcNoYabanciNo;
	}

	public void setMusteriTcNoYabanciNo(String musteriTcNoYabanciNo) {
		this.musteriTcNoYabanciNo = musteriTcNoYabanciNo;
	}

	public String getMusteriBabaAdi() {
		return musteriBabaAdi;
	}

	public void setMusteriBabaAdi(String musteriBabaAdi) {
		this.musteriBabaAdi = musteriBabaAdi;
	}

	public String getMusteriNufusaKayitliYeri() {
		return musteriNufusaKayitliYeri;
	}

	public void setMusteriNufusaKayitliYeri(String musteriNufusaKayitliYeri) {
		this.musteriNufusaKayitliYeri = musteriNufusaKayitliYeri;
	}

	public String getMusteriDogumYeri() {
		return musteriDogumYeri;
	}

	public void setMusteriDogumYeri(String musteriDogumYeri) {
		this.musteriDogumYeri = musteriDogumYeri;
	}

	public String getMusteriIkametYeri() {
		return musteriIkametYeri;
	}

	public void setMusteriIkametYeri(String musteriIkametYeri) {
		this.musteriIkametYeri = musteriIkametYeri;
	}

	public PersonelService getPersonelService() {
		return personelService;
	}

	public List<MusteriBireyselDto> getMusteriBireyseller() {
		return musteriBireyseller;
	}

	public void setMusteriBireyseller(List<MusteriBireyselDto> musteriBireyseller) {
		this.musteriBireyseller = musteriBireyseller;
	}

	public Boolean getTurkMu() {
		return TurkMu;
	}

	public void setTurkMu(Boolean turkMu) {
		TurkMu = turkMu;
	}

	public String getEditMusteriAdi() {
		return editMusteriAdi;
	}

	public String getEditMusteriSoyadi() {
		return editMusteriSoyadi;
	}

	public String getEditMusteriVergiNumarasi() {
		return editMusteriVergiNumarasi;
	}

	public String getEditMusteriVergiMukellefiyeti() {
		return editMusteriVergiMukellefiyeti;
	}

	public String getEditMusteriMaili() {
		return editMusteriMaili;
	}

	public String getEditMusteriTelefonNo() {
		return editMusteriTelefonNo;
	}

	public String getEditMusteriSehri() {
		return editMusteriSehri;
	}

	public String getEditMusteriUyruk() {
		return editMusteriUyruk;
	}

	public String getEditMusteriUlkesi() {
		return editMusteriUlkesi;
	}

	public String getEditMusteriAdresi() {
		return editMusteriAdresi;
	}

	public String getEditMusteriTcNoYabanciNo() {
		return editMusteriTcNoYabanciNo;
	}

	public String getEditMusteriBabaAdi() {
		return editMusteriBabaAdi;
	}

	public String getEditMusteriNufusaKayitliYeri() {
		return editMusteriNufusaKayitliYeri;
	}

	public String getEditMusteriDogumYeri() {
		return editMusteriDogumYeri;
	}

	public String getEditMusteriIkametYeri() {
		return editMusteriIkametYeri;
	}

	public Boolean getEditTurkMu() {
		return editTurkMu;
	}

	public Integer getEditMusteriNo() {
		return editMusteriNo;
	}

	public void setEditMusteriAdi(String editMusteriAdi) {
		this.editMusteriAdi = editMusteriAdi;
	}

	public void setEditMusteriSoyadi(String editMusteriSoyadi) {
		this.editMusteriSoyadi = editMusteriSoyadi;
	}

	public void setEditMusteriVergiNumarasi(String editMusteriVergiNumarasi) {
		this.editMusteriVergiNumarasi = editMusteriVergiNumarasi;
	}

	public void setEditMusteriVergiMukellefiyeti(String editMusteriVergiMukellefiyeti) {
		this.editMusteriVergiMukellefiyeti = editMusteriVergiMukellefiyeti;
	}

	public void setEditMusteriMaili(String editMusteriMaili) {
		this.editMusteriMaili = editMusteriMaili;
	}

	public void setEditMusteriTelefonNo(String editMusteriTelefonNo) {
		this.editMusteriTelefonNo = editMusteriTelefonNo;
	}

	public void setEditMusteriSehri(String editMusteriSehri) {
		this.editMusteriSehri = editMusteriSehri;
	}

	public void setEditMusteriUyruk(String editMusteriUyruk) {
		this.editMusteriUyruk = editMusteriUyruk;
	}

	public void setEditMusteriUlkesi(String editMusteriUlkesi) {
		this.editMusteriUlkesi = editMusteriUlkesi;
	}

	public void setEditMusteriAdresi(String editMusteriAdresi) {
		this.editMusteriAdresi = editMusteriAdresi;
	}

	public void setEditMusteriTcNoYabanciNo(String editMusteriTcNoYabanciNo) {
		this.editMusteriTcNoYabanciNo = editMusteriTcNoYabanciNo;
	}

	public void setEditMusteriBabaAdi(String editMusteriBabaAdi) {
		this.editMusteriBabaAdi = editMusteriBabaAdi;
	}

	public void setEditMusteriNufusaKayitliYeri(String editMusteriNufusaKayitliYeri) {
		this.editMusteriNufusaKayitliYeri = editMusteriNufusaKayitliYeri;
	}

	public void setEditMusteriDogumYeri(String editMusteriDogumYeri) {
		this.editMusteriDogumYeri = editMusteriDogumYeri;
	}

	public void setEditMusteriIkametYeri(String editMusteriIkametYeri) {
		this.editMusteriIkametYeri = editMusteriIkametYeri;
	}

	public void setEditTurkMu(Boolean editTurkMu) {
		this.editTurkMu = editTurkMu;
	}

}
