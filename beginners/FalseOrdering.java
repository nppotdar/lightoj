package beginners;

import java.util.Scanner;

/**
 * Problem Statement: https://www.dropbox.com/s/dgqm6q1xcglckla/FalseOrdering.pdf
 * @author ameya
 *
 */
public class FalseOrdering {
	
	private static enum CONSTANTS{;
		public static int SIZE_ARRAY = 1000;
	};
	int sortedArray[];
	int factorCount[];
	
	public FalseOrdering(){
		
		sortedArray = new int[CONSTANTS.SIZE_ARRAY+1];
		for( int i = 0; i <= CONSTANTS.SIZE_ARRAY; i++ )
			this.sortedArray[i] = i;
		factorCount = new int[CONSTANTS.SIZE_ARRAY+1];
		
		initFactorCount();
		mergesort( 1, CONSTANTS.SIZE_ARRAY );
		
	}
	
	private void initFactorCount(){
		
		this.factorCount[0] = 0;
		this.factorCount[1] = 1;
		for( int i = 2; i <= CONSTANTS.SIZE_ARRAY; i++ ){
			int factor_count = 2;
			for( int j = 2; j <= Math.sqrt(i); j++ ){
				if( i%j == 0){
					factor_count+=2;
					if( i*1.0/j == j )
						factor_count--;
				}
			}
			this.factorCount[i] = factor_count;
		}
		
	}
	
	private void merge( int low, int mid, int high ){
		
		int left_arr[] = new int[ mid - low +1 ];
		int right_arr[] = new int[ high - mid ];
		
		for( int i = 0; i < left_arr.length; i++ )
			left_arr[i] = this.sortedArray[i+low];
		for( int i = 0; i < right_arr.length; i++ )
			right_arr[i] = this.sortedArray[mid+i+1];		
		
		int i = 0;
		int j = 0;
		
		int left_value = 0; 
		int right_value = 0;
		for( int k = low; k <= high; k++ ){
			
			if( i >= (left_arr.length) ){
				this.sortedArray[k] = right_arr[j++];
				continue;
			}
			else
				left_value = this.factorCount[ left_arr[i] ];
			
			
			if( j >= (right_arr.length) ){
				this.sortedArray[k] = left_arr[i++];
				continue;
			}
			else
				right_value = this.factorCount[ right_arr[j] ];
			


			if( left_value < right_value )
				this.sortedArray[k] = left_arr[i++];
			else
				if( left_value > right_value )
					this.sortedArray[k] = right_arr[j++];
			else
				if( left_arr[i] > right_arr[j] )
					this.sortedArray[k] = left_arr[i++];
				else
					this.sortedArray[k] = right_arr[j++];
				
		}

		
	}
	
	private void mergesort( int low, int high ){
		if( low < high ){
			int mid = low + (high - low)/2;
			mergesort( low, mid );
			mergesort( mid+1, high );
			merge( low, mid, high );
		}

	}
	
	public static void main(String[] args) {
		int cases = 0;
		Scanner in = new Scanner(System.in);
		int n = 0;
		FalseOrdering falseOrdering = new FalseOrdering();

		cases = in.nextInt();
		for( int i = 1; i <= cases; i++ ){
			n = in.nextInt();
			System.out.println("Case " + i + ": " + falseOrdering.sortedArray[n] );
		}
		in.close();
	}

}
