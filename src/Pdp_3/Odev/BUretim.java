package Pdp_3.Odev;
import java.util.Random;

public class BUretim extends Uretim {

	@Override
	public int Uret() {
    	Random random = new Random();
    	int x = random.nextInt(11);
        int y = random.nextInt(11);
        int z = random.nextInt(11);
        return ((x + y * z) % 10)+1;
	}
}
