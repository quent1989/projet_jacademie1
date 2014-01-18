package org.projet1.java.models;

public class Artiste {
	
	private Integer codeArtiste;	
	private String nomArtiste;	
	private String nomAlbum;
	
	//	Constructeur
	public Artiste(Integer codeArtiste, String nom, String album) {
		
		this.codeArtiste = codeArtiste;
		this.nomArtiste = nom;
		this.nomAlbum = album;
	}
	
	//	Getters Setters
	public Integer getCodeArtiste() {
		return codeArtiste;
	}

	public void setCodeArtiste(Integer codeArtiste) {
		this.codeArtiste = codeArtiste;
	}

	public String getNom() {
		return nomArtiste;
	}

	public void setNom(String nom) {
		this.nomArtiste = nom;
	}

	public String getAlbum() {
		return nomAlbum;
	}

	public void setAlbum(String album) {
		this.nomAlbum = album;
	}	

}
