package Lab4;

import java.io.IOException;

public class main {

	public static void main(String[] args) throws IOException {
		String sciezkaTeacup = "src/Lab4/teacup.txt";
		String sciezkaTeacupOut = "src/Lab4/teacup_new.txt";
		
		String sciezkaSpoon = "src/Lab4/spoon.txt";
		String sciezkaSpoonOut = "src/Lab4/spoon_new.txt";
		
		String sciezkaTeapot = "src/Lab4/czaj.txt";
		String sciezkaTeapotOut = "src/Lab4/czajnik_new.txt";
		
		platBeziere.formBeziera(sciezkaTeacup, sciezkaTeacupOut, 26);
		platBeziere.formBeziera(sciezkaSpoon, sciezkaSpoonOut, 16);
		platBeziere.formBeziera(sciezkaTeapot, sciezkaTeapotOut, 32);
	}

}
