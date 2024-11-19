package personnages;

public class GrandMere extends Humain{
	
	public GrandMere(String nom, int quantite_argent) {
		super(nom,"tisane",quantite_argent);
	}
	
	@Override
	public void memoriser(Humain humain) {
		if(nbConnaissance <= 5) {
			super.memoriser(humain);
		}
		else {
			parler("Oh ma tête ! Je ne peux plus retenir le nom d'une personne supplémentaire !");
		}
	}
	
	private enum TypeHumain {
		HABITANT("Habitant"),RONIN("Ronin"),COMMERCANT("Commerçant"),SAMOURAI("Samouraï"),YAKUZA("Yakuza"), GRANDMERE("Grand-Mère");

		private String nom;

		private TypeHumain(String nom) {
			this.nom = nom;
		}

		public String toString() {
			return nom;
		}
	}
		
	private String humainHasard() {
		TypeHumain[] types = TypeHumain.values();
		TypeHumain humain = types[(int)(Math.random() * 5)];
		return humain.nom;
	}
	
	public void ragoter() {
		for(int i=0; i<nbConnaissance ; i++) {
			if(memoire[i] instanceof Traitre) {
				parler("Je sais que " + memoire[i].getNom() + " est un traître. Petit chenapan !");
            } else {
                parler("Je crois que " + memoire[i].getNom() + " est un " + humainHasard() + ".");
            }
		}
	}
}
