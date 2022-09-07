package com.infina.likitech.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.infina.likitech.entity.EmailDetay;

import net.bytebuddy.utility.RandomString;

@Service
public class EmailServiceImpl implements EmailService {

	@Autowired
	private JavaMailSender javaMailSender;
	
	@Autowired
	private PersonelService personelService;

	@Value("${spring.mail.username}")
	private String gonderen;

	Random random = new Random();

	@Override
	public String mailGonder(EmailDetay emailDetay) {
		try {
			SimpleMailMessage mailMessage = new SimpleMailMessage();

			String yeniSifre = generateRandomString() + generateRandomInt();
			String mailIcerik = "Şifre sıfırlama işleminiz başarıyla tamamlanmıştır. Yeni şifreniz : " + yeniSifre;

			mailMessage.setFrom(gonderen);
			mailMessage.setTo(emailDetay.getAlici());
			mailMessage.setText(mailIcerik);
			mailMessage.setSubject("Yeni Şifre");

			javaMailSender.send(mailMessage);
			
			personelService.personelSifreGuncelle(emailDetay.getAlici(), yeniSifre);
			
			
			return "Mail gönderildi.";
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return "Mail gönderilemedi.";
		}
	}

	public String generateRandomString() {
		return RandomString.make(5);
	}

	public String generateRandomInt() {
		return String.valueOf(random.nextInt(1000));
	}

}
