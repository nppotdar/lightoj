package beginners;

import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Problem Statement: https://www.dropbox.com/s/vlapha7lctn1fqo/KSatProblem.pdf
 * @author ameya
 *
 */
public class KSatProblem {
	
	static List<int[]> wishesList;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int cases = in.nextInt();

		for( int i = 1; i <= cases; i++ ){
			int n, m, k;
			n = in.nextInt();
			m = in.nextInt();
			k = in.nextInt();
			Hashtable<Integer, Boolean> flag= new Hashtable<Integer, Boolean>();
			for( int o = 1; o <= m ; o++ )
				flag.put(o, false);
			wishesList = new LinkedList<int[]>();
			while( n-- > 0 ){
				int a[] = new int[k];
				for( int j= 1; j <= k; j++ )
					a[j-1] = in.nextInt();
				wishesList.add(a);
			}
			
			int solutionCount = in.nextInt();
			for( int j = 0; j < solutionCount; j++  )
				flag.put(in.nextInt(), true);
			
			boolean isWish = false;
			for( int[] x: wishesList ){
				isWish = false;
				for( int q = 0; q < k; q++ ){
					if( ( x[q] == Math.abs(x[q]) ) == flag.get(Math.abs(x[q])) ){
						isWish = true;
						break;
					}
				}
				if( !isWish ){
					System.out.println("Case " + i + ": No");
					break;
				}
			}
			if( isWish )
				System.out.println("Case " + i + ": Yes" );
		}
		in.close();
		
	}

}
