package org.projet1.java.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Album {
	
	private Integer codeAlbum;	
	private String nom;	
	private Collection<String> listeChansons;
	
	//	Constructeur
	public Album(Integer codeAlbum, String nom) {
		this.codeAlbum = codeAlbum;
		this.nom = nom;
		this.listeChansons = new ArrayList<String>();
		
	}
	
	//	Getters Setters
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

	public Collection<String> getListeChansons() {
		return listeChansons;
	}

	public void setListeChansons(Collection<String> listeChansons) {
		this.listeChansons = listeChansons;
	}
	
	public String getChanson() {
		return listeChansons.toString();
	}
	
	public void setChanson (String chanson) {
		listeChansons.add(chanson);
	}
	
	
	
	

}
