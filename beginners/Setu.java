package beginners;

import java.util.Scanner;

/**
 * Problem Statement: https://www.dropbox.com/s/yq2lm9zjpgw6mf4/Setu.pdf
 * @author ameya
 *
 */
public class Setu {
	static int amount = 0;

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int cases = Integer.parseInt(in.nextLine());
		int operations = 0;
		for(int i = 1; i <= cases; i++ ){
			amount=0;
			operations = Integer.parseInt(in.nextLine());
			System.out.println("Case " + i + ":");
			while(operations-- > 0){
				String input = in.nextLine();
				if(input.equals("report"))
					System.out.println(amount);
				else
					amount+= Integer.parseInt( input.split(" ")[1] );
			}
		}
		in.close();
	}

}
