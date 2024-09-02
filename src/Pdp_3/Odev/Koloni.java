package Pdp_3.Odev;
import java.util.ArrayList;
import java.util.Random;

public class Koloni {
	private int yemekStogu;
	private int populasyon;
	private char sembol;
	private int kazanma;
	private int kaybetme;
	
	
	
	public Koloni(int populasyon) {
		kazanma=0;
		kaybetme=0;
		
		this.populasyon=populasyon;
		yemekStogu=populasyon*populasyon;
		 Random random = new Random();
	        int lowerBound = 33; // Sembollerin başlangıç değeri
	        int upperBound = 126; // Sembollerin bitiş değeri

	        int randomValue;
	        do {
	            randomValue = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
	            sembol = (char) randomValue;
	        } while (Character.isLetter(sembol) || Character.isDigit(sembol));
	        
		/* Random random = new Random();
		
		sembol=(char) (random.nextInt(93) + 33); */
	}
	public void uretimYap(AUretim uretim) {
        int uretilenMiktar = uretim.Uret();
        yemekStogu += uretilenMiktar;
	}
	public void uretimYap(BUretim uretim) {
        int uretilenMiktar = uretim.Uret();
        yemekStogu += uretilenMiktar;
    }
	public int Savas(ATaktik taktik) {
		int guc=taktik.TaktikSavas();
		return guc;
	}
	public int Savas(BTaktik taktik) {
		int guc=taktik.TaktikSavas();
		return guc;
	}
    public int getYemekStogu() {
        return yemekStogu;
    }
    public void setYemekStogu(int yemekStogu) {
    	this.yemekStogu=yemekStogu;
    }
    public int getPopulasyon() {
        return populasyon;
    }
    public void setPopulasyon(int populasyon) {
    	this.populasyon=populasyon;
    } 
    public char getSembol() {
    	return sembol;
    }
    public int getKazanma() {
    	return kazanma;
    }
    public int setKazanma() {
    	return kazanma++;
    }
    public int getKaybetme() {
    	return kaybetme;
    }
    public int setKaybetme() {
    	return kaybetme++;
    }
    public void tukendi(ArrayList<Koloni> tukenenKoloniler) {
        this.populasyon = 0;
        this.yemekStogu = 0;
        this.kazanma = 0;
        this.kaybetme = 0;
        tukenenKoloniler.add(this);
    }

    public String getPopulasyonAsString() {
        if (populasyon <= 0) {
            return "--";
        } else {
            return String.valueOf(populasyon);
        }
    }

    public String getYemekStoguAsString() {
        if (yemekStogu <= 0) {
            return "--";
        } else {
            return String.valueOf(yemekStogu);
        }
    }

    public String getKazanmaAsString() {
        if (kazanma <= 0) {
            return "--";
        } else {
            return String.valueOf(kazanma);
        }
    }

    public String getKaybetmeAsString() {
        if (kaybetme <= 0) {
            return "--";
        } else {
            return String.valueOf(kaybetme);
        }
    }
}
