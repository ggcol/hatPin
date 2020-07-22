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
	
	
	public Pin(int idPin, String latlng, String title, String body, String ref_img) {
		setIdPin(idPin);
		setLatlng(latlng);
		setTitle(title);
		setBody(body);
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
	
	
	//Questi sono 3 finti override di toString in modo che quando li chiamo in una 
	// stringa mi infili solo il parametro desiderato
	
	/* servono ad ovviare alla differenza tra SQL e HQL, probabilmente studiando meglio HQL non si 
	 * renderebbero necessari perché si potrebbero fare tre query differenti
	 * che estraggono liste di singoli parametri, anzichè liste di "serie di parametri"
	 * 
	 * Li utilizza la classe PinHelper
	 */
	
	//LatLng
	public String LatLngToString() {
		String latlng = getLatlng().toString();
		return latlng;
	}
	
	//Titolo
	public String TitleToString() {
		String title = getTitle().toString();
		return title;
	}
	
	//Corpo
	public String BodyToString() {
		String body = getBody().toString();
		return body;
	}
	
	
	
	
	

	
	

}
