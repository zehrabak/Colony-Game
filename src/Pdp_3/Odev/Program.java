package Pdp_3.Odev;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		 Scanner scanner = new Scanner(System.in);

	        System.out.print("Kolonilerin populasyon sayisini girin (bosluklarla ayrilmis): ");
	        String populasyonlarStr = scanner.nextLine();
	        String[] populasyonlar = populasyonlarStr.split(" ");

	        Koloni[] koloniler = new Koloni[populasyonlar.length];

	        for (int i = 0; i < populasyonlar.length; i++) {
	            int populasyon = Integer.parseInt(populasyonlar[i]);
	            koloniler[i] = new Koloni(populasyon);
	        }
	        Oyun oyun=new Oyun(koloniler);
	        oyun.OyunTurDongusu();
	        scanner.close();
	}

}
