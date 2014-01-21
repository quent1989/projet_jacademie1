package org.projet1.java.models;

public class Chanson {
	
	private Integer numChanson;	
	private String titre;	
	private Integer dureeChanson;
	private String nomAlbum;

	// Constructeur
	public Chanson() {
		super();
	}
	
	public Chanson(Integer numChanson, String titre, Integer dureeChanson, String nomAlbum) {
		this.numChanson = numChanson;
		this.titre = titre;
		this.dureeChanson = dureeChanson;
		this.nomAlbum = nomAlbum;

		
	}
	
	
	// Getters Setters
	public String getNomAlbum() {
		return nomAlbum;
	}

	public void setNomAlbum(String nomAlbum) {
		this.nomAlbum = nomAlbum;
	}

	public Integer getNumChanson() {
		return numChanson;
	}

	public void setNumChanson(Integer numChanson) {
		this.numChanson = numChanson;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	

	public Integer getDureeChanson() {
		return dureeChanson;
	}

	public void setDureeChanson(Integer dureeChanson) {
		this.dureeChanson = dureeChanson;
	}


	@Override
	public String toString() {
		return "Chanson [numChanson=" + numChanson + ", titre=" + titre
				+ ", dureeChanson=" + dureeChanson + "]";
	}



	
	
	

	
	

}
