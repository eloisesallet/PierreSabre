package personnages;

public class Traitre extends Samourai{
	private int niveauTraitrise = 0;
	
	public Traitre(String seigneur,String nom,String boissonfav, int quantite_argent) {
		super(seigneur, nom, boissonfav, quantite_argent);
	}
	
	@Override
	public void direBonjour() {
		super.direBonjour();
		parler("Mais je suis un traître et mon niveau de traîtrise est : " + niveauTraitrise + ". Chut !");
	}
	
	public void ranconner(Commercant commercant) {
		if(niveauTraitrise < 3) {
			int argentCommercant = commercant.getQuantite_argent();
			int argentRanconner = argentCommercant*2/10;
			commercant.perdreArgent(argentRanconner);
			gagnerArgent(argentRanconner);
			niveauTraitrise+=1;
			parler("Si tu veux ma protection contre les Yakuzas, il va falloir payer ! Donne moi " 
			+ argentRanconner + " sous ou gare à toi ! ");
			commercant.parler("Tout de suite grand " + getNom());
		}
		else {
			parler("Mince je ne peux plus rançonner personne sinon un samouraï risque de me démasquer !");
		}
	}
	
	public void faireLeGentil() {
		if(nbConnaissance < 1) {
			parler("Je ne peux faire ami ami avec personne car je ne connais personne ! Snif");
		}
		else {
			Humain ami = memoire[(int)(Math.random() * nbConnaissance)];
			int don = getQuantite_argent()*1/20;
			String nomAmi = ami.getNom();
			parler("Il faut absolument remonter ma cote de confiance. Je vais faire ami ami avec "
					+ nomAmi);
			parler("Bonjour l'ami ! Je voudrait vous aider en vous donnant " + don + " sous");
			ami.gagnerArgent(don);
			perdreArgent(don);
			String nom = getNom();
			ami.parler("Merci "+ nom + ". Vous êtes quelqu'un de bien");
			if(niveauTraitrise > 1) {
				niveauTraitrise --;
			}
		}
	}
}
