package beginners;

import java.util.Scanner;

/**
 * Problem Statement: https://www.dropbox.com/s/b0wpcwi1bbxy6rv/IntersectionOfCubes.pdf
 * @author ameya
 *
 */
public class IntersectionOfCubes {

	static int x1,y1,z1,x2,y2,z2;
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int cases = in.nextInt();
		int number_cubes = 0;

		
		long intersectionVolume = 0L; 
		for( int i = 1; i <= cases; i++ ){
			number_cubes = in.nextInt();
			x1=y1=z1=1;
			x2=y2=z2=1000;
			
			while( number_cubes-- > 0){
				intersectionVolume = getIntersectionVolume(in.nextInt(),in.nextInt(),in.nextInt(),in.nextInt(),in.nextInt(),in.nextInt());
			}
			System.out.println("Case " + i + ": " + intersectionVolume );
		}
		in.close();
	}

	private static long getIntersectionVolume(int x3, int y3, int z3, int x4,
			int y4, int z4) {
		
		if(  ( ( ( x3 > x2 ) && ( x3 > x1 ) ) || ( ( x1 > x4) && ( x1 > x3 ) ) )  
		  || ( ( ( y3 > y2 ) && ( y3 > y1 ) ) || ( ( y1 > y4) && ( y1 > y3 ) ) )  
		  || ( ( ( z3 > z2 ) && ( z3 > z1 ) ) || ( ( z1 > z4) && ( z1 > z3 ) ) ) )
			return 0;
		
		int fx1, fy1, fz1, fx2, fy2,fz2;

		fx1 = Math.max(x1, x3);
		fx2 = Math.min(x2, x4);
		fy1 = Math.max(y1, y3);
		fy2 = Math.min(y2, y4);
		fz1 = Math.max(z1, z3);
		fz2 = Math.min(z2, z4);
		
		x1 = fx1;
		y1 = fy1;
		z1 = fz1;
		x2 = fx2;
		y2 = fy2;
		z2 = fz2;
		return Math.abs( (x1-x2)*(y1-y2)*(z1-z2) );
	}

}
