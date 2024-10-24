package personnages;

public class Humain {
	private String nom;
	private String boissonfav;
	private int quantite_argent;
	
	
	public String getNom() {
		return nom;
	}

	public int getQuantite_argent() {
		return quantite_argent;
	}
	
	public void setQuantite_argent(int quantite_argent) {
		this.quantite_argent = quantite_argent;
	}

	public Humain(String nom, String boissonfav, int quantite_argent) {
		this.nom = nom;
		this.boissonfav = boissonfav;
		this.setQuantite_argent(quantite_argent);
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + "» ");
	}
	
	private String prendreParole() {
		return "(" + nom + ") - ";
		}
	
	public void direBonjour() {
		parler("Bonjour ! Je m'appelle " + nom + " et j'aime boire du " + boissonfav );
	}
	
	public void boire() {
		parler("Mmmmmmm, un bon verre de " + boissonfav + " ! GLOUPS ! ");
	}
	
	private void gagnerArgent(int gain) {
		setQuantite_argent(getQuantite_argent() + gain);
	}
	
	private void perdreArgent(int perte) {
		setQuantite_argent(getQuantite_argent() - perte);
	}
	
	public void acheter(String bien, int prix) {
		if (getQuantite_argent() - prix < 0) {  
			parler("Je n'ai plus que " + getQuantite_argent() + 
					" sous en poche. Je ne peux même pas m'offrir " + bien + " à "
					+ prix + " sous ");
		}
		else {
			parler("J'ai " + getQuantite_argent() + " en poche. Je vais pouvoir m'offrir "
					+ bien + " à " + prix + " sous ");
			perdreArgent(prix);
		}
		
	}

}
