package personnages;

public class Ronin extends Humain{
	private int honneur = 1;
		
	public Ronin(String nom,String boissonfav, int honneur, int quantite_argent) {
		super(nom, boissonfav, quantite_argent);
	}
	
	public void donner(Commercant beneficiaire) {
		int argent = (int) (0.10 * getQuantite_argent());
		parler(beneficiaire.getNom() + " prend ces " + argent + " sous.");
		beneficiaire.recevoir(argent);
		setQuantite_argent(getQuantite_argent()-argent);
		honneur+=1;
	}
	
	
}
