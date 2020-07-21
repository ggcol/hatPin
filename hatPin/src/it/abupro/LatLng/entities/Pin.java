package it.abupro.LatLng.entities;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import org.hibernate.Session;

import it.abupro.LatLng.connection.HibCon;


@Entity
@Table(name="pin")
public class Pin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idPin")
	private int idPin;
	@Column(name="latlng")
	private String latlng;
	@Column(name="titolo")
	private String titolo;
	@Column(name="corpo")
	private String corpo;
	@Column(name="ref_img")
	private String ref_img;
	
	
	public Pin(int idPin, String latlng, String titolo, String corpo, String ref_img) {
		setIdPin(idPin);
		setLatlng(latlng);
		setTitolo(titolo);
		setCorpo(corpo);
		setRef_img(ref_img);
		
	}
	
	public Pin() {}

	public int getIdPin() {
		return idPin;
	}

	public void setIdPin(int idPin) {
		this.idPin = idPin;
	}

	public String getLatlng() {
		return latlng;
	}

	public void setLatlng(String latlng) {
		this.latlng = latlng;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getCorpo() {
		return corpo;
	}

	public void setCorpo(String corpo) {
		this.corpo = corpo;
	}

	public String getRef_img() {
		return ref_img;
	}

	public void setRef_img(String ref_img) {
		this.ref_img = ref_img;
	}
	
	public void newEntry(Pin l) {
	HibCon hC = new HibCon();
	try (Session s = hC.getSessionFactory().openSession()) {
		s.beginTransaction();
		s.save(l);
		s.getTransaction().commit();
	}
	}
	
	public String LatLngToString() {
		String latlng = getLatlng().toString();
		return latlng;
	}
	
	public String TitoloToString() {
		String titolo = getTitolo().toString();
		return titolo;
	}
	
	public String CorpoToString() {
		String corpo = getCorpo().toString();
		return corpo;
	}
	
	
	
	
	

	
	

}
