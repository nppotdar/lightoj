package beginners;

import java.util.Scanner;

/**
 * Problem Statement: https://www.dropbox.com/s/ni9s84ama1oluj7/PalindromeNumbers.pdf
 * @author ameya
 *
 */
public class PalindromeNumbers {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int cases = in.nextInt();
		
		for( int i = 1; i <= cases; i++ ){	
			String input = String.valueOf(in.nextInt());
			int j;
			for( j = 0; j <= ( input.length() )/2; j++ ){
				if( input.charAt(j) != input.charAt(input.length()- j - 1 ) )
					break;
			}
			if( j <= ( input.length() )/2  )
				System.out.println("Case " + i + ": " +  "No");
			else
				System.out.println("Case " + i + ": " +  "Yes");
		}
		in.close();
	}
}
