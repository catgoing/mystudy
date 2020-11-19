package main;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Calendarmainclass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 	Calendar
		 	
		 */
		
//		Calendar cal = new GregorianCalendar();
//		=
		Calendar cal = Calendar.getInstance();
		
		// 날짜
		
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) +1;	//	0~11로 설정된 값이라 +1
		int day = cal.get(Calendar.DATE);
		
		System.out.println(year + "년 " + month + "월 " + day + "일 ");
		
		
		//날짜 설정
		cal.set(Calendar.YEAR, 2021);
		cal.set(Calendar.MONTH, 4-1); 	// calendar.month에서 1~12를 출력하기 위해 +1 해줬으니/ 4월을 나타내기 위해서는 4 -1을 해줘야 함
		cal.set(Calendar.DATE, 13);
		
		year = cal.get(Calendar.YEAR);
		month = cal.get(Calendar.MONTH) +1;	//	0~11로 설정된 값이라 +1
		day = cal.get(Calendar.DATE);
		
		System.out.println(year + "년 " + month + "월 " + day + "일 ");
		
		// 요일
		int weekday = cal.get(Calendar.DAY_OF_WEEK);	// 1~7, 일~토
		System.out.println(weekday);
		
		switch(weekday) {
			
			case 1:
				System.out.println("일요일입니다");
				break;
			case 2:
				System.out.println("월요일입니다");
				break;
			case 3:
				System.out.println("화요일입니다");
				break;
			}
		
		
		cal.set(Calendar.YEAR, 2020);
		cal.set(Calendar.MONTH, 10-1);
		
		// 지정한 달의 마지막 날 28 29 30 31
		int lastday = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		System.out.println(lastday);
		
		// 달력 만들기
		cal.set(Calendar.DATE, 1); 	// 1일로 세팅하는 함수
		
		// 달력의 위쪽 빈칸 채우기
		weekday = cal.get(Calendar.DAY_OF_WEEK);
		int upspace = (weekday -1) %7;
		
		System.out.println("위쪽 빈칸의 수: " + upspace);
		
		// 그 달의 마지막 날짜
		lastday = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		System.out.println("lastday = " + lastday);
		
		// 밑의 빈칸
		cal.set(Calendar.DATE, lastday);
		weekday = cal.get(Calendar.DAY_OF_WEEK);
		
		int downspace = 7 - weekday;
		System.out.println("아래쪽 빈칸의 수: " + downspace);
		
		// 달력 출력
		year=2021;
		month=1;
		
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month -1 );
		cal.set(Calendar.DATE, 1);
		
		int startday = cal.get(Calendar.DAY_OF_WEEK);
		int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		int date =1;
		
		System.out.println(year + "년 " + month + "월 ");
		System.out.println("===================================================");
		
		String week_day="일월화수목금토";
		
		for (int i = 0; i < week_day.length(); i++) {
			char c = week_day.charAt(i);
			System.out.print(c + "\t");
		}
			System.out.println();
		System.out.println("===================================================");
		
		// 위쪽 빈칸
		for (int i =1; i < startday; i++) {
			System.out.print("*" + "\t");
		}
		// 날짜
		for (int i = 0; i < lastDay; i++) {
			System.out.print(date+"\t");
			if((date+startday-1)%7==0) {
				System.out.println("\n");
			}
		
			date++;
		}
		
		// 아래쪽 빈칸
		for (int i = 0; i < (7-(startday + lastDay-1) % 7); i++) {
			System.out.print("*" + "\t");
		}
		System.out.println();
		System.out.println("===================================================");
		
		
	}

}
