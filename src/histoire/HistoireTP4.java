package histoire;
import personnages.Commercant;
import personnages.Humain;
import personnages.Ronin;
import personnages.Yakuza;

public class HistoireTP4 {

	
	public static void main(String[] args) {
		Humain prof = new Humain("Prof", "kombucha", 54);
		prof.direBonjour();
		prof.acheter("une boisson", 12);
		prof.boire();
		prof.acheter("un jeu", 2);
		prof.acheter("un kimono", 50);
		
		System.out.println('\n');
		
		Commercant marco = new Commercant("Marco",20);
		marco.direBonjour();
		marco.seFaireExtorquer();
		marco.recevoir(15);
		marco.boire();
		
		System.out.println('\n');
		
		Yakuza yaku = new Yakuza("Yaku Le Noir", "whisky", "Warsong", 30);
		yaku.direBonjour();
		yaku.extorquer(marco);
		
		System.out.println('\n');
		
		Ronin roro = new Ronin("Roro", "shochu",60);
		roro.direBonjour();
		roro.donner(marco);
		
		System.out.println('\n');
		roro.provoquer(yaku);
		
		
	}
}
