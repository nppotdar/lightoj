package beginners;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Problem Statement: https://www.dropbox.com/s/emnd05ceigpb7d5/LargeDivision.pdf
 * @author ameya
 *
 */
public class LargeDivision {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int cases = Integer.parseInt(in.nextLine());
		for( int i = 1; i <= cases; i++ ){
			
			BigInteger x =  new BigInteger( in.next() );
			x = x.abs();
			BigInteger y = new BigInteger( in.next() );
			y = y.abs();
			BigInteger remainder = x.mod(y);
			BigInteger zero = BigInteger.valueOf(0);
			System.out.print("Case " + i + ": ");
			if( remainder.equals(zero) )
				System.out.println("divisible");
			else
				System.out.println("not divisible");
		}
		in.close();
	}

}
