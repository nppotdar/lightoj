package beginners;

import java.util.Scanner;

/**
 * Problem Statement: https://www.dropbox.com/s/pwzcijbyeytwgr4/DivisionBy3.pdf
 * @author ameya
 *
 */
public class DivisibleBy3 {

	public static int getCount( int m, int n ){
		int counter = 1;
		
		int remainder = m % 3;
		if( remainder == 2 ){
			counter--;
			m--;
		}
		else
		if( remainder == 0 ){
			counter-=2;
			m-=2;
		}
		else
			counter--;
		
		remainder = n % 3;
		
		if( remainder == 2 ){
			counter++;
			n--;
		}
		else
		if( remainder == 0 ){
			counter+=2;
			n-=2;
		}
		
		counter += ( (int)( (n-m)/3 ) )*2;		
		return counter;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int cases = in.nextInt();
		for( int i = 1; i <= cases; i++ ){
			int a = in.nextInt();
			int b = in.nextInt();
			System.out.println( "Case "+ i + ": " + getCount( a, b ) );
		}
		in.close();
	}

}
