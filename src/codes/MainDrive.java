package codes;

import java.util.Scanner;

public class MainDrive {

	public static void main(String[] args) {

		// 6개의 숫자 입력받기
		
		Scanner myScanner = new Scanner(System.in);

		int[] myNumbers = new int[6];
		
		for(int i=0; i<6; i++) {
			
			while(true) {
				System.out.print((i+1)+"번째 숫자: ");
				int inputNum =myScanner.nextInt();		
				
				boolean isRangeOk= (1<=inputNum) && (inputNum<=45);
				boolean isDuplOk= true;
				for(int myNum: myNumbers) {
					if(myNum==inputNum) {
						isDuplOk=false;
						break;
					}
				}
				
				if(isRangeOk && isDuplOk) {
					myNumbers[i] =inputNum;
					break;
				}
			}
		}
	}
}