package Pdp_3.Odev;

import java.util.Random;

public class BTaktik extends Taktik {
	@Override
	public int TaktikSavas() {
		Random random = new Random();
		int x = random.nextInt(1001);
		int y = random.nextInt(1001);
		int z = random.nextInt(1001);
	    return (x + y * z) % 1000;
	}
	
}
