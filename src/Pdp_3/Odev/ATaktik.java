package Pdp_3.Odev;
import java.util.Random;

public class ATaktik extends Taktik{
	@Override
	public int TaktikSavas() {
		 Random random = new Random();
		 int x = random.nextInt(1001);
		 int y = random.nextInt(1001);
		 return ((x * 10) + y) * 5 % 1001;
	}
}
