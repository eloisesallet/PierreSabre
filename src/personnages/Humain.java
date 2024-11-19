package personnages;

public class Humain {
	private int MAX = 30;
	private String nom;
	private String boissonfav;
	private int quantite_argent;
	protected int nbConnaissance = 0;
	protected Humain[] memoire = new Humain[MAX];
	
	
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
		System.out.println(prendreParole() + texte + ". ");
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
	
	public void gagnerArgent(int gain) {
		setQuantite_argent(getQuantite_argent() + gain);
	}
	
	public void perdreArgent(int perte) {
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
	
	public void faireConnaissanceAvec(Humain autreHumain) {
		direBonjour();
		repondre(autreHumain);
		memoriser(autreHumain);
		autreHumain.memoriser(this);
	}
	
	protected void memoriser(Humain humain) {
		if(nbConnaissance == MAX) {
			for(int i=0; i<nbConnaissance-1 ; i++) {
				memoire[i]=memoire[i+1];
			}
			memoire[nbConnaissance-1]=humain;
		}
		else {
			memoire[nbConnaissance]=humain;
			nbConnaissance+=1;
		}
	}
	
	private void repondre(Humain humain) {
		humain.direBonjour();
	}
	
	public void listerConnaissances() {
		System.out.print(prendreParole() + "Je connais beaucoup de monde dont : ");
		for (int i=0 ; i<nbConnaissance; i++) {
			if(memoire[i]!=null) {
				if (i == nbConnaissance - 1) {
                    System.out.print(memoire[i].getNom());
                } else {
                    System.out.print(memoire[i].getNom() + ", ");
                }
            }
		}
		System.out.println();
	}

}
