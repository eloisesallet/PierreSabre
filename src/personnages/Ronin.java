package personnages;

public class Ronin extends Humain{
	private int honneur = 1;
		
	public Ronin(String nom,String boissonfav, int honneur, int quantite_argent) {
		super(nom, boissonfav, quantite_argent);
		this.honneur = honneur;
	}
	
	public void donner(Commercant beneficiaire) {
		int argent = (int) (0.10 * getQuantite_argent());
		parler(beneficiaire.getNom() + " prend ces " + argent + " sous.");
		beneficiaire.recevoir(argent);
		setQuantite_argent(getQuantite_argent()-argent);
		honneur+=1;
	}
	
	public void provoquer(Yakuza adversaire) {
		int force = honneur+honneur;
		parler("Je t'ai retrouvé vermine, tu vas payer pour ce que tu as fais à ce pauvre marchand !");
		if (force >= adversaire.getReputation()) {
			parler("Je t'ai eu petit Yakusa !");
			int gain = adversaire.perdre();
			setQuantite_argent(getQuantite_argent() + gain);
			honneur+=1;
		}
		else {
			honneur-=1;
			parler("J'ai perdu contre ce Yakuza, mon honneur et ma bourse en ont pris un coup.");
			adversaire.gagner(getQuantite_argent());
			setQuantite_argent(0);
		}
	}
	
	
}
