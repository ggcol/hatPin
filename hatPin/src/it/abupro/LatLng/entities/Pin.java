package it.abupro.LatLng.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="pin")
public class Pin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idPin")
	private int idPin;
	@Column(name="latlng")
	private String latlng;
	@Column(name="title")
	private String title;
	@Column(name="body")
	private String body;
	@Column(name="ref_img")
	private String ref_img;
	@Column(name="username")
	private String username;
	
	
	public Pin(int idPin, String latlng, String title, String body, String ref_img, String username) {
		setIdPin(idPin);
		setLatlng(latlng);
		setTitle(title);
		setBody(body);
		setRef_img(ref_img);
		setUsername(username);
		
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getRef_img() {
		return ref_img;
	}

	public void setRef_img(String ref_img) {
		this.ref_img = ref_img;
	}
	
	
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	

}
