package fr.redacteurlivre.exo;

import java.util.List;

public class Page {

	//attribut
	private List<String> lignes;
	
	//constructeur
	public Page(List<String> lignes) {
		this.lignes = lignes;
	}

	//m�thode
	public List<String> getLignes() {
		return lignes;
	}
}
