package beginners;

import java.util.Scanner;

/**
 * Problem Statement: https://www.dropbox.com/s/dlw2beoew6kjdqg/SumOfFactorials.pdf
 * @author ameya
 *
 */
public class SumOfFactorials {
	static long factorial_values[];
	
	private static void computeFactorialValues(){
		factorial_values = new long[21];
		factorial_values[0] = 1;
		int i;
		for( i = 1; i < 21; i++ )
			factorial_values[i] = factorial_values[i-1] * i;
	}
	

	private static String getSumString(long n ) {
		String str = "";
		for( int i = factorial_values.length-1 ; i >= 0; i-- ){
			if( factorial_values[i] <= n ){
				str = i + "!+" + str;
				n-=factorial_values[i];
			if( n == 0 )return str.substring(0, str.length()-1);
			}
		}

		return "impossible";
	}	
	
	public static void main(String[] args) {
		computeFactorialValues();
		
		Scanner in = new Scanner(System.in);
		int cases = in.nextInt();
		for( int i = 1; i <= cases; i++ )
			System.out.println( "Case " + i + ": " + getSumString(in.nextLong() ) );
		in.close();
	}

}
