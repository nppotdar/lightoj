package beginners;

import java.util.Scanner;

/**
 * Probelm Statement: https://www.dropbox.com/s/m99qr0klrdijcg6/BoiledEggs.pdf
 * @author ameya
 *
 */
public class BoiledEggs {

	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int cases = in.nextInt();
		
		for( int c = 1; c <= cases; c++ ){
			int n = in.nextInt();
			int p = in.nextInt();
			int q = in.nextInt();
			int sum = 0;
			int counter = 0;
			for( int i = 1; i<= n; i++ ){
				int x = in.nextInt();
				if( (i > p) || ( sum + x ) > q )
					continue;
				sum += x;
				counter++;
			}
			System.out.println("Case " + c + ": " + counter);
		}
		in.close();
	}

}
