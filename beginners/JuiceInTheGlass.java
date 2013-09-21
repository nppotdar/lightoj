package beginners;

import java.util.Scanner;

/**
 * Problem Statement: https://www.dropbox.com/s/hyz37rlt13glq6d/JuiceInTheGlass.pdf
 * @author ameya
 *
 */
public class JuiceInTheGlass {

	
	private static double getAnswer( int r1, int r2, int h, int p ){
		double r3 = ( p * ( r1 - r2 )*1.00 )/ h + r2;
		double k = h * r2 * 1.0 /( r1 - r2 );
		double Vr2 = Math.PI * ( r2 * r2 ) * k / 3.0;
		double Vr3 = Math.PI * r3 * r3 * ( p + k ) / 3.0;
		
		return Vr3 - Vr2;
		
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int cases = in.nextInt();
		for( int i = 1 ; i <= cases; i++ )
			System.out.println( "Case " + i + ": "  + getAnswer(in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt()) );
		in.close();
	}

}
