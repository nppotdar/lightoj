package beginners;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Problem Statement: https://www.dropbox.com/s/sae2obe0q7u9696/February29.pdf
 * @author ameya
 *
 */
public class February29 {
	
	static String MONTHS[] = new String[]{"January", "February", "March", "April", "May", "June", "July", 
												"August", "September", "October", "November", "December"};
	static ArrayList<String> MONTHS_SET = new ArrayList<String>( Arrays.asList(MONTHS) );
	static int DAYS[] = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}; 

	public static void main(String[] args) {
		int cases = 0;
		Scanner in = new Scanner(System.in);
		cases = Integer.parseInt( in.nextLine() );
		
		for( int i = 1; i <= cases; i++ ){
			System.out.println("Case " + i + ": " + computeAnswer( in.nextLine(), in.nextLine() ) );
		}
		in.close();
	}

	private static String computeAnswer(String startDate, String endDate) {
		String splitStartDate[] = startDate.split("\\s");
		String splitEndDate[] = endDate.split("\\s");
		int startYear = Integer.parseInt(splitStartDate[2]);
		int startMonth = MONTHS_SET.indexOf(splitStartDate[0]);
		int endYear = Integer.parseInt(splitEndDate[2]);
		int endMonth = MONTHS_SET.indexOf(splitEndDate[0]);
		int endDay = Integer.parseInt(splitEndDate[1].replace(",", ""));
		int counter = 0;
		if( (startYear == endYear) && isLeapYear(startYear)){
			if( startMonth <2 && ( (endMonth > 2) || ( endMonth == 1 && endDay == 29 ) ) )
				counter++;
		}else{
			if( isLeapYear(startYear) )
				if( startMonth < 2  )
					counter++;
			if( isLeapYear(endYear) )
				if( endMonth > 2  || ( endMonth == 1 && endDay == 29 ) )
					counter++;
		}
		int years = ( (endYear-1)/4 )*4  - ( (startYear+1)/4 )*4  ;
		for( int i = (startYear/4)*4 + 4; i < (endYear); i+=4 ){
			if( isLeapYear(i) )
				counter++;
		}
		
		return String.valueOf(counter);
	}
	
	private static boolean isLeapYear( int year ){
		if( year % 4 == 0 &&  year %100 !=0)
			return true;
		return false;
	}
	

}
