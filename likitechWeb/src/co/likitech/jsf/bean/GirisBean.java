package co.likitech.jsf.bean;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import co.likitech.jsf.entity.EmailDetay;
import co.likitech.jsf.service.PersonelService;

@ManagedBean(name = GirisBean.BEAN_NAME)
@ViewScoped
public class GirisBean implements Serializable {

	private static final long serialVersionUID = 8618917181390683563L;
	public static final String BEAN_NAME = "girisBean";
	private String personelKullaniciAdi;
	private String personelSifresi;

	private String alici;

	@ManagedProperty(value = "#{" + PersonelService.BEAN_NAME + "}")
	private PersonelService personelService;

	public void setPersonelService(PersonelService personelService) {
		this.personelService = personelService;
	}

	public void giris() {
		Boolean girebilirMi = personelService.giris(this.personelKullaniciAdi, this.personelSifresi);

		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest origRequest = (HttpServletRequest) context.getExternalContext().getRequest();
		String contextPath = origRequest.getContextPath();

		if (girebilirMi) {
			try {
				FacesContext.getCurrentInstance().getExternalContext().redirect(contextPath + "/co/anasayfa.xhtml");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		else if (!girebilirMi) {
			this.personelKullaniciAdi = null;
			this.personelSifresi = null;
			addMessage();
		}

	}

	public void mailGonder() {

		try {
			personelService.emailGonder(new EmailDetay(this.alici));

		} catch (Exception e) {

		}
	}

	public void addMessage() {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_ERROR, "Şifre veya Kullanıcı Adı Yanlış", null));
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

	public String getAlici() {
		return alici;
	}

	public void setAlici(String alici) {
		this.alici = alici;
	}

}
