package beginners;

import java.util.Scanner;

/**
 * Problem Statement: https://www.dropbox.com/s/yu5meoirqf1h9z0/UnluckyBird.pdf
 * @author ameya
 *
 */
public class UnluckyBird {

	public static void displayAnswer( double v1, double v2, double v3, double a1, double a2 ){
		double x = v1 * v1/( 2*a1 );
		double y = v2 * v2/( 2*a2 );
		
		double dBird = v3 * (Math.max(v1/a1, v2/a2));
		double d = x + y;
		
		System.out.println( d + " " + dBird);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int cases = in.nextInt();
		
		for(int i = 1; i<= cases; i++ ){
			System.out.print("Case " + i + ": " );
			displayAnswer(in.nextDouble(), in.nextDouble(), in.nextDouble()
										, in.nextDouble(), in.nextDouble());
		}
		in.close();
	}

}
