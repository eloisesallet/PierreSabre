package personnages;

public class Yakuza extends Humain{
	private String clan;
	private int reputation = 0;
	
	
	public Yakuza(String nom,String boissonfav, String clan, int reputation, int quantite_argent) {
		super(nom, boissonfav, quantite_argent);
	}
	
	public void extorquer(Commercant victime) {
		parler("Tiens, tiens, ne serait-ce pas un faible marchand qui passe par là ? ");
		parler(victime.getNom() + ", si tu tiens à la vie donne moi ta bourse ! ");
		int argent = victime.getQuantite_argent();
		setQuantite_argent(getQuantite_argent()+argent);
		victime.seFaireExtorquer();
		parler("J'ai piqué les " + argent + " sous de " 
		+ victime.getNom() + " ce qui me fait " + getQuantite_argent() 
		+ " sous dans ma poche. Hi ! Hi !");
		reputation += 1;
	}
}
