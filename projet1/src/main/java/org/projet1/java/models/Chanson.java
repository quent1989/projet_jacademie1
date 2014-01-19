package org.projet1.java.models;

public class Chanson {
	
	private String titre;	
	private Integer dureeChanson;	
	private Integer numChanson;
	
	public Chanson(Integer numChanson, String titre, Integer dureeChanson) {
		this.numChanson = numChanson;
		this.titre = titre;
		this.dureeChanson = dureeChanson;

		
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

	public Integer getNumChanson() {
		return numChanson;
	}

	public void setNumChanson(Integer numChanson) {
		this.numChanson = numChanson;
	}

	
	

}
