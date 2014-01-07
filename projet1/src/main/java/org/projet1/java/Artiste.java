package org.projet1.java;

public class Artiste {
	
	private Integer codeArtiste;
	
	private String nom;
	
	private Album album;
	
	public Artiste(Integer codeArtiste, String nom, Album album) {
		
		this.codeArtiste = codeArtiste;
		this.nom = nom;
		this.album = album;
	}

	public Integer getCodeArtiste() {
		return codeArtiste;
	}

	public void setCodeArtiste(Integer codeArtiste) {
		this.codeArtiste = codeArtiste;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}
	
	
	
	

}
