package beginners;

import java.util.Scanner;

/**
 * Problem Statement: https://www.dropbox.com/s/4jpn1nf0x7je5as/IPChecking.pdf
 * @author ameya
 *
 */
public class IPChecking {


	public static void main(String[] args) {
		int cases = 0;
		
		Scanner in = new Scanner(System.in);
		cases = Integer.parseInt(in.nextLine());
		for(int i = 1; i<=cases; i++)
			System.out.println("Case " + i + ": " + getAnswer(in.nextLine(), in.nextLine()) );
		in.close();
	}

	private static String getAnswer(String decimalString, String binaryString) {
		
		decimalString = decimalString.replaceAll("\\.", "");
		String splitBinaryString[] = binaryString.split("\\.");
		StringBuilder stringBuilder = new StringBuilder("");
		for(String singleBinaryString: splitBinaryString )
			stringBuilder.append(Integer.parseInt(singleBinaryString, 2));
		if( stringBuilder.toString().equals(decimalString) )
			return "Yes";
		return "No";
	}

}
