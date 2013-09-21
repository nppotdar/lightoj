package beginners;

import java.util.Scanner;

/**
 * Problem Statement: https://www.dropbox.com/s/dvpof5nb0bzro9t/MinimumArcDistance.pdf
 * @author ameya
 *
 */
public class MinimumArcDistance {


	public static void main(String[] args) {

		int cases = 0;
		
		Scanner in = new Scanner(System.in);
		cases = in.nextInt();
		for(int i = 1; i <= cases; i++ ){
			System.out.println("Case " + i + ": " + getAnswer(in.nextInt(), in.nextInt()
															 ,in.nextInt(), in.nextInt()
															 ,in.nextInt(), in.nextInt()) );
		}
		in.close();
		
	}

	private static String getAnswer(int ox, int oy, int ax,
									int ay, int bx, int by) {
		double ab = Math.sqrt( (ax-bx)*(ax-bx) + (ay-by)*(ay-by));
		double radius = Math.sqrt((ox-bx)*(ox-bx) + (oy-by)*(oy-by));
		return String.valueOf( radius * Math.acos( 1 - (ab*ab)/( 2*(radius)*(radius) )) );
	}

}
