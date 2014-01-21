package org.projet1.java.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Album {
	
	private Integer codeAlbum;	
	private String nomAlbum;	
	private Collection<Chanson> listeChansons;
	
	//	Constructeur
	public Album() {
		super();
	}
	
	public Album(Integer codeAlbum, String nomAlbum, Collection<Chanson> listeChansons) {
		this.codeAlbum = codeAlbum;
		this.nomAlbum = nomAlbum;
		this.listeChansons = new ArrayList<Chanson>();
		
	}
	
	//	Getters Setters
	public Integer getCodeAlbum() {
		return codeAlbum;
	}

	public void setCodeAlbum(Integer codeAlbum) {
		this.codeAlbum = codeAlbum;
	}

	public String getNomAlbum() {
		return nomAlbum;
	}

	public void setNomAlbum(String nomAlbum) {
		this.nomAlbum = nomAlbum;
	}

	public Collection<Chanson> getListeChansons() {
		return listeChansons;
	}

	public void setListeChansons(Collection<Chanson> listeChansons) {
		this.listeChansons = listeChansons;
	}

	@Override
	public String toString() {
		return "Album [codeAlbum=" + codeAlbum + ", nomAlbum=" + nomAlbum
				+ ", listeChansons=" + listeChansons + "]";
	}


	

	

}
