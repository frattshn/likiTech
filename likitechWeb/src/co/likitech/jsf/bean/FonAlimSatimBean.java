package co.likitech.jsf.bean;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import co.likitech.jsf.entity.Fon;
import co.likitech.jsf.model.AlimSatimDto;
import co.likitech.jsf.model.HesapDto;
import co.likitech.jsf.service.PersonelService;

@ManagedBean(name = FonAlimSatimBean.BEAN_NAME)
@ViewScoped
public class FonAlimSatimBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8965132724587624749L;

	public static final String BEAN_NAME = "fonAlimSatimBean";

	private Boolean alSat;

	private Integer fonSayisi;

	private List<Fon> fonlar;
	private Integer secilenFonID;

	private AlimSatimDto alimSatimDto;

	private List<HesapDto> hesapDtolar;
	private HesapDto hesapDto;
	private HesapDto secilenHesapDto;

	private Integer secilenHesapID;

	@ManagedProperty(value = "#{" + PersonelService.BEAN_NAME + "}")
	private PersonelService personelService;

	public void doldurpanel(HesapDto hesapDto) {
		this.secilenHesapID = hesapDto.getHesapID();
	}

	public void setPersonelService(PersonelService personelService) {
		this.personelService = personelService;
	}

	public void fonlariGetir() {
		this.fonlar = this.personelService.fonlariGetir();
	}

	public void hesapDtolariGetir() {
		this.hesapDtolar = this.personelService.hesapDtolariGetir();
	}

	public void alSatKaydet() {
		personelService
				.fonAlimSatim(new AlimSatimDto(this.secilenHesapID, this.alSat, this.secilenFonID, this.fonSayisi));

		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest origRequest = (HttpServletRequest) context.getExternalContext().getRequest();
		String contextPath = origRequest.getContextPath();

		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect(contextPath + "/co/fonAlimSatim.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@PostConstruct
	public void init() {
		fonlariGetir();
		hesapDtolariGetir();
	}

	public Boolean getAlSat() {
		return alSat;
	}

	public Integer getFonSayisi() {
		return fonSayisi;
	}

	public List<Fon> getFonlar() {
		return fonlar;
	}

	public Integer getSecilenFonID() {
		return secilenFonID;
	}

	public AlimSatimDto getAlimSatimDto() {
		return alimSatimDto;
	}

	public List<HesapDto> getHesapDtolar() {
		return hesapDtolar;
	}

	public HesapDto getSecilenHesapDto() {
		return secilenHesapDto;
	}

	public void setAlSat(Boolean alSat) {
		this.alSat = alSat;
	}

	public void setFonSayisi(Integer fonSayisi) {
		this.fonSayisi = fonSayisi;
	}

	public void setFonlar(List<Fon> fonlar) {
		this.fonlar = fonlar;
	}

	public void setSecilenFonID(Integer secilenFonID) {
		this.secilenFonID = secilenFonID;
	}

	public void setAlimSatimDto(AlimSatimDto alimSatimDto) {
		this.alimSatimDto = alimSatimDto;
	}

	public void setHesapDtolar(List<HesapDto> hesapDtolar) {
		this.hesapDtolar = hesapDtolar;
	}

	public void setSecilenHesapDto(HesapDto secilenHesapDto) {
		this.secilenHesapDto = secilenHesapDto;
	}

	public Integer getSecilenHesapID() {
		return secilenHesapID;
	}

	public void setSecilenHesapID(Integer secilenHesapID) {
		this.secilenHesapID = secilenHesapID;
	}

	public HesapDto getHesapDto() {
		return hesapDto;
	}

	public void setHesapDto(HesapDto hesapDto) {
		this.hesapDto = hesapDto;
	}

}
