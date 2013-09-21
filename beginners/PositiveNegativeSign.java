package beginners;

import java.util.Scanner;

/**
 * Problem Statement: https://www.dropbox.com/s/9macqzgq9rfob8p/PositiveNegativeSign.pdf
 * @author ameya
 *
 */
public class PositiveNegativeSign {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int cases = in.nextInt();
		for( int i = 1; i <= cases; i++ )
			System.out.println("Case " + i + ": " + (in.nextLong() * in.nextLong())/2 );
		in.close();
	}

}
