package beginners;

import java.util.Scanner;

/**
 * Problem Statement: https://www.dropbox.com/s/zibkblg9ena29wg/Bishops.pdf
 * @author ameya
 *
 */
public class Bishops {

	private static String getNumberOfMoves(int r1, int c1,int r2, int c2) {
		if( (r1+c1)%2 != (r2+c2)%2 )
			return "impossible";
		if( ( (r1-c1) == (r2-c2) ) || ((r1+c1) == (r2+c2)) ) 
			return "1";
		return "2";
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int cases = in.nextInt();
		
		for( int i = 1; i <= cases; i++ )
			System.out.println("Case " + i + ": " + getNumberOfMoves(in.nextInt(), in.nextInt(),in.nextInt(),in.nextInt()) );

		in.close();
	}


}
