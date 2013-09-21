package beginners;

import java.util.Scanner;

/**
 * Problem Statement: https://www.dropbox.com/s/eauq6ue0l9122ia/Parity.pdf
 * @author ameya
 *
 */
public class Parity {
	
	public static String getEvenOrOdd( int number ){
		
		String numberStr = "";
		int counter = 0;
		while( number != 0 ){
			numberStr = String.valueOf(number);
			if( Integer.parseInt( String.valueOf( numberStr.charAt(numberStr.length()-1)) ) %2 == 1 )
				counter++;
			number = number >> 1;
		}
		
		if( counter % 2 == 0 )
			return "even";
		return "odd";
	}
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner( System.in );
		int cases = in.nextInt();
		
		for( int i = 1; i <= cases; i++ )
			System.out.println("Case " + i + ": " + getEvenOrOdd(in.nextInt()) );
		in.close();
	}

}
