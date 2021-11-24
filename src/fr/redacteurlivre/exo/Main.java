package fr.redacteurlivre.exo;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;

public class Main {

	public static void main(String[] args) {

		//variable livre
		Book livreGraven = new Book("Les bases de la programmation", "Graven", "nevarg");
		
		//créer une instance de pdfReader pour lire le fichier pdf
		try {
			PdfReader pdf = new PdfReader("livre.pdf");
			
//			//récupérer le nombre de pages en pdf
//			int nbrPages = pdf.getNumberOfPages();
//			
			//Lire le contenu du pdf grace à une boucle
			
			for(int i=1; i<= pdf.getNumberOfPages(); i++) {
				
				livreGraven.ajouterPage(PdfTextExtractor.getTextFromPage(pdf, i));
//				//On affiche TOUT le pdf et on pense à fermer le pdf à la fin avec pdf.close();
//				//Extraire le contenu de la page à l'aide de PdfTextExtractor
//				String content = PdfTextExtractor.getTextFromPage(pdf, i);
//				//Afficher le contenu de la page en console
//				System.out.println("Contenu de la page: " + content);
			}
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//proposer à l'utilisateur d'entrer un mot
		Scanner scan = new Scanner(System.in);
		String mot = scan.next();
		AtomicInteger compteurMots = new AtomicInteger();
		
		System.out.println("Mot à trouver: "+mot);
		
//		//version classique pour afficher la page et trouver le mot
//		for(String ligne : livreGraven.getPage(1)) {
//			if(ligne.contains(mot)) {
//				System.out.println(ligne);
//			}
//		}
		
		//afficher la page 1 et la parcourir pour trouver le mot choisi en version Lambda
//		livreGraven.getPage(1)
//		.stream()
//		.filter(ligne-> ligne.contains(mot))
//		.forEach(ligne-> System.out.println(ligne));
//		
		//Afficher le nombre de mots présent dans chacun des fichiers
		livreGraven.getPage(2)
		.stream() //récupère tout le flux, le contenu pour le filtrer avec filter() après
		.filter(ligne-> ligne.contains(mot))
		.forEach(ligneavecmot-> {
			compteurMots.getAndIncrement();
		});
		
		//afficher le nombre de mots
		System.out.println("Le mot "+ mot+" est présent "+compteurMots+ " fois.");
		scan.close();
	}
}
