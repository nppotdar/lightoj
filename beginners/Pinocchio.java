package beginners;

import java.util.Scanner;

/**
 * Problem Statement: https://www.dropbox.com/s/af4lfc9y94dc3yn/Pinocchio.pdf
 * @author ameya
 *
 */
public class Pinocchio {


	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int cases = in.nextInt();
		
		for( int i = 1; i <= cases; i++ ){
			int number = in.nextInt();
			int prevX = 2;
			int counter = 0;
			while( number-- > 0 ){
				int currX = in.nextInt();
				counter += (int)Math.ceil( ( currX - prevX )/5.0 );
				prevX = currX;
			}
			System.out.println("Case " + i + ": " + counter);
		}
		in.close();
	}

}
