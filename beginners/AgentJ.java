package beginners;

import java.util.Scanner;

/**
 * Problem Statement: https://www.dropbox.com/s/2dnj93kr4t1238j/AgentJ.pdf
 * @author ameya
 *
 */
public class AgentJ {

	public static double computeAnswer( double r1, double r2, double r3 ){
		double triangleArea = Math.sqrt((r1+r2+r3)*(r2)*(r1)*(r3));
		double cosAlpha =  ( (r1+r3)*(r1+r3) + (r1+r2)*(r1+r2) - (r2+r3)*(r2+r3) )/( 2 * (r1+r3) * (r1+r2) ) ;
		double cosBeta = ( (r2+r3)*(r2+r3) + (r1+r2)*(r1+r2) - (r1+r3)*(r1+r3) )/( 2 * (r2+r3) * (r1+r2) ) ;
		
		double alpha = Math.acos( cosAlpha );
		double beta = Math.acos(cosBeta);
		double gamma = Math.acos(0.0) * 2 - (alpha + beta);
		
		double areaOfArcs = (r1*r1*alpha/2) + (r2*r2*beta/2)+ (r3*r3*gamma/2);
		return Math.abs(triangleArea - areaOfArcs);
	}
	
	public static void main(String[] args) {
		int cases = 0;
		
		Scanner in = new Scanner(System.in);
		cases = in.nextInt();
		for( int i = 1; i <= cases; i++ )
			System.out.format("Case %d: %.10f\n", i,computeAnswer(in.nextDouble(), in.nextDouble(), in.nextDouble()) );
		in.close();
	}

}
