package org.projet1.java.models;

public class Chanson {
	
	private Integer numChanson;
	private String titreChanson;
	private Integer dureeChanson;
	
	public Chanson(Integer numChanson, String titre, Integer dureeChanson) {
		this.numChanson = numChanson;
		this.titreChanson = titre;
		this.dureeChanson = dureeChanson;

		
	}

	public String getTitre() {
		return titreChanson;
	}

	public void setTitre(String titre) {
		this.titreChanson = titre;
	}

	

	public Integer getDureeChanson() {
		return dureeChanson;
	}

	public void setDureeChanson(Integer dureeChanson) {
		this.dureeChanson = dureeChanson;
	}

	public Integer getNumChanson() {
		return numChanson;
	}

	public void setNumChanson(Integer numChanson) {
		this.numChanson = numChanson;
	}

	
	

}
