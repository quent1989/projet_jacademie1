package org.java.projet1;

import java.util.HashMap;
import java.util.Set;

public class Album {
	
	private Integer codeAlbum;
	
	private String nom;
	
	private Set<Chanson> listeChansons;
	
	public Album(Integer codeAlbum, String nom, Chanson chansons) {
		
	}

	public Integer getCodeAlbum() {
		return codeAlbum;
	}

	public void setCodeAlbum(Integer codeAlbum) {
		this.codeAlbum = codeAlbum;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Set<Chanson> getListeChansons() {
		return listeChansons;
	}

	public void setListeChansons(Set<Chanson> listeChansons) {
		this.listeChansons = listeChansons;
	}
	
	
	
	

}
