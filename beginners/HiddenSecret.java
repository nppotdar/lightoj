package beginners;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Problem Statement: https://www.dropbox.com/s/h7380eijhzo9blo/HiddenSecret.pdf
 * @author ameya
 *
 */
public class HiddenSecret {


	public static void main(String[] args) {
		int cases = 0;
		
		Scanner in = new Scanner(System.in);
		cases = Integer.parseInt(in.nextLine());
		for( int i = 1; i <= cases; i++ )
			System.out.println("Case " + i + ": " + getAnswer(in.nextLine(), in.nextLine()));
		in.close();
	}

	private static String getAnswer(String string1, String string2) {
		string1 = string1.toLowerCase();
		string2 = string2.toLowerCase();
		
		string1 = string1.replaceAll(" ", "");
		string2 = string2.replaceAll(" ", "");
		
		char s1[] = string1.toCharArray();
		char s2[] = string2.toCharArray();
		
		Arrays.sort(s1);
		Arrays.sort(s2);
		
		int minLength = Math.min(s1.length, s2.length);
		int i = 0;
		boolean isIn = true;
		for(i = 0; i< minLength; i++ )
			if( s1[i] != s2[i] )
				isIn = false;
		if( isIn )
			return "Yes";
		return "No";
	}

}
