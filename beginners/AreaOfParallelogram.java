package beginners;

import java.util.Scanner;

/**
 * Problem Statement: https://www.dropbox.com/s/r64zsfjfz90vlyi/AreaOfParallelogram.pdf
 * @author ameya
 *
 */

public class AreaOfParallelogram {
	
	static int dx, dy, area;
	private static void computeAnswer( int ax, int ay, int bx, int by, int cx, int cy ){

		area = (int)Math.abs(Math.round( (bx-ax)*(cy-by) - (cx-bx)*(by-ay) ));
		dx = ax + cx - bx;
		dy = ay + cy - by;
						
	}
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int cases = in.nextInt();
		
		for( int i = 1; i <= cases; i++ ){
			computeAnswer(in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt()
													, in.nextInt(), in.nextInt());
			System.out.println("Case " + i + ": " + dx + " " + dy + " " + area);
		}
		in.close();
	}

}
