package personnages;

public class Commercant extends Humain{

	public Commercant(String nom, int quantite_argent) {
		super(nom, "thé", quantite_argent);
	}
	
	public int seFaireExtorquer() {
		parler("J'ai tout perdu ! Le monde est trop injuste...");
		setQuantite_argent(0);
		return getQuantite_argent();
	}
	
	public void recevoir(int argent) {
		parler(argent + " sous ! Je te remercie généreux donateur ! ");
		setQuantite_argent(getQuantite_argent()+argent);
	}

}