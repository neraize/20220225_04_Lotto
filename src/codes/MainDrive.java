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
		
		// 당첨번호
		int[] winNumbers= new int[6];
		
		for(int i=0; i<winNumbers.length; i++) {
			while(true) {
				// Math.random()   => 0<=랜덤값<1
				// cf) Random 클래스를 활용해도 됨
				int randomNum = (int)(Math.random()*45+1);
				
				boolean isDuplOk = true;
				
				for(int num: winNumbers) {
					
					if(num==randomNum) {
						isDuplOk=false;
						break;
					}
				}
				
				if(isDuplOk) {
					winNumbers[i]=randomNum;
					break;
				}
			}
		}
		
		
		// 임시 당첨 번호 선정 -> 당첨 등수 로직 테스트용
//		winNumbers[0]=10;
//		winNumbers[1]=11;
//		winNumbers[2]=20;
//		winNumbers[3]=21;
//		winNumbers[4]=30;
//		winNumbers[5]=31;
		
		// 랜덤으로 만들어진 당첨번호들을  -> 작은수~ 큰수로 정리
		for(int i=0; i<winNumbers.length; i++) {
			for(int j=0; j<winNumbers.length-1; j++) {
				if(winNumbers[j] > winNumbers[j+1]) {
					int backUp = winNumbers[j];
					winNumbers[j] = winNumbers[j+1];
					winNumbers[j+1] = backUp;
				}
			}
		}
		
		// 정리된 당첨번호 확인
		for(int num: winNumbers) {
			System.out.print(num+" ");
		}
		
		int correctCount =0;
		
		for(int myNum: myNumbers) {
			for(int winNum: winNumbers) {
				if(myNum==winNum) {
					correctCount++;
				}
			}
		}
		
		if(correctCount==6) {
			System.out.println("1등");
		}
		else if(correctCount==5) {
			//보너스번호 로직 추가 필요
			System.out.println("임시 3등");
		}
		else if(correctCount==4) {
			System.out.println("임시 4등");
		}
		else if(correctCount==3) {
			System.out.println("임시 5등");
		}
		else {
			System.out.println("낙첨");
		}
	}
}