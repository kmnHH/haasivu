package fi.haa.haasivu.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class EiVieras { 
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String etunimi; 
	private String sukunimi; 
	private String osallistuminen; 
	
	// Luodaan entity tyyppinen luokkaolio EiVieras, jolle annetaan tarvittavat attribuutit sekä getterit ja setterit
	public EiVieras(Long id, String etunimi, String sukunimi, String osallistuminen) {
			super();
			this.id = id;
			this.etunimi = etunimi;
			this.sukunimi = sukunimi;
			this.osallistuminen = osallistuminen;
			
	}  
		
	public EiVieras() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEtunimi() {
		return etunimi;
	}

	public void setEtunimi(String etunimi) {
		this.etunimi = etunimi;
	}

	public String getSukunimi() {
		return sukunimi;
	}

	public void setSukunimi(String sukunimi) {
		this.sukunimi = sukunimi;
	}

	public String getOsallistuminen() {
		return osallistuminen;
	}

	public void setOsallistuminen(String osallistuminen) {
		this.osallistuminen = osallistuminen;
	}

	@Override
	public String toString() {
		return "EiVieras [id=" + id + ", etunimi=" + etunimi + ", sukunimi=" + sukunimi + ", osallistuminen="
				+ osallistuminen + "]";
	} 
		


}
