package fr.redacteurlivre.exo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Book {

	private String nomLivre;
	private String author;
	private String edition;
	private List<Page> pages;
	
	public Book(String nomLivre, String author, String edition) {
		this.nomLivre = nomLivre;
		this.author = author;
		this.edition = edition;
		this.pages = new ArrayList<>();
	}
	public void ajouterPage(List<String> lignes) {
		//créer la page puis l'ajouter
		Page nouvellePage = new Page(lignes);
		pages.add(nouvellePage);
	}	
	public void ajouterPage(String contenu) {
		List<String> lignes = Arrays.asList(contenu.split("\n"));
		pages.add(new Page(lignes));
	}	
	public String getName() {
		return nomLivre;
	}

	public String getAuthor() {
		return author;
	}

	public String getEdition() {
		return edition;
	}

	public int getNombrePages() {
		return this.pages.size();
	}
	
	public List<String> getPage(int numeroPage) {
		return pages.get(numeroPage).getLignes();
		
	}
}


