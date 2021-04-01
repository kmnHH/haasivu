package fi.haa.haasivu.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Vieras { 
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String etunimi; 
	private String sukunimi; 
	private String osallistuminen; 
	private String ruokavalio; 
	
	
	public Vieras(Long id, String etunimi, String sukunimi, String osallistuminen, String ruokavalio) {
		super();
		this.id = id;
		this.etunimi = etunimi;
		this.sukunimi = sukunimi;
		this.osallistuminen = osallistuminen;
		this.ruokavalio = ruokavalio;
	}  
	
	public Vieras() {}

	
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

	public String getRuokavalio() {
		return ruokavalio;
	}

	public void setRuokavalio(String ruokavalio) {
		this.ruokavalio = ruokavalio;
	}

	@Override
	public String toString() {
		return "Vieras [id=" + id + ", etunimi=" + etunimi + ", sukunimi=" + sukunimi + ", osallistuminen="
				+ osallistuminen + ", ruokavalio=" + ruokavalio + "]";
	}  
	
	
	
	

}
