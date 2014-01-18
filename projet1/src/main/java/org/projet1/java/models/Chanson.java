package org.projet1.java.models;

public class Chanson {
	
	private String titre;
	
	private Integer duree;
	
	private Integer numero;
	
	public Chanson(String titre, Integer duree, Integer numero) {
		this.titre = titre;
		this.duree = duree;
		this.numero = numero;
		
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public Integer getDuree() {
		return duree;
	}

	public void setDuree(Integer duree) {
		this.duree = duree;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	
	

}
