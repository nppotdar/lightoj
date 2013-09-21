package beginners;

import java.util.Scanner;

/**
 * Problem Statement: https://www.dropbox.com/s/6stshfp63q95xtb/EkkaDokka.pdf
 * @author ameya
 *
 */
public class EkkaDokka {
	
	long n;
	long m;
	
	public EkkaDokka(long w) {
		String binaryForm = Long.toBinaryString(w);
		this.n = w;
		this.m = 1;
		while( binaryForm.charAt(binaryForm.length()-1) == '0' ){	
			this.n = this.n >> 1;
			this.m *= 2;
			binaryForm = Long.toBinaryString(this.n);
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int cases = Integer.parseInt(in.nextLine());
		for( int i = 1; i <= cases; i++ ){
			long w = Long.parseLong(in.nextLine()); 
			EkkaDokka ekkaDokka = new EkkaDokka(w);
			if( ekkaDokka.m == 1 )
				System.out.println("Case " + i + ": " +"Impossible" );
			else
				System.out.println("Case " + i + ": " + ekkaDokka.n + " " + ekkaDokka.m);	
		}
		in.close();
	}

}
