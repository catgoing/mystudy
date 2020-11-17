package dao;

import java.util.Arrays;
import java.util.Scanner;

import student.Student;

public class Studentdao {
	Scanner sc = new Scanner(System.in);
	
	
	Student stuarr[] = null;
	private int membernum;
	
	
	public Studentdao(int count) {
		stuarr = new Student[count];
		membernum=0;
		
		stuarr[0] = new Student(1,"홍길동",100,90,80);
		stuarr[1] = new Student(2,"이동국",200,80,70);
		stuarr[2] = new Student(3,"강호동",300,70,60);
	}
	
	// CRUD
	// 추가, 삭제, 검색, 수정
	public void insert() {
		System.out.print("number: ");
		int number = sc.nextInt();
		System.out.print("name: ");
		String name = sc.next();
		
		System.out.print("lang: ");
		int lang = sc.nextInt();
		System.out.print("math: ");
		int math = sc.nextInt();
		System.out.print("eng: ");
		int eng = sc.nextInt();
		
		
		
		
		stuarr[membernum] = new Student(number, name, lang, math, eng);
		membernum++;
	}
	
	
	
	public void delete() {
		System.out.print("삭제할 이름?: ");
		String name = sc.next();
		
		int index = -1;
		for (int i = 0; i < stuarr.length; i++) {
			if(stuarr[i] != null) {
				if(name.equals(stuarr[i].getName())) {
					index = i;
					break;
				}
			}
		}
		if(index != -1) {
			stuarr[index].setNumber(0);
			stuarr[index].setName("");
			stuarr[index].setLang(0);
			stuarr[index].setMath(0);
			stuarr[index].setEng(0);
			System.out.println("데이터를 삭제하였습니다");
		}else {
			System.out.println("데이터를 찾을 수 없습니다");
		}
	}
	public void select() {
		
	}
	
	public void update() {
		
	}
	
	public void allprint() {
		for (int i = 0; i < stuarr.length; i++) {
			if(stuarr[i] != null && stuarr[i].getName().equals("")) { // 빈값 입력 방지를 위해
				System.out.println(stuarr[i].toString());
			}
		}
	}
	
	public void sorting() {
		/*	배열복사방법
		 	int array[] = {1,2,3};
		 	int clone[] = array.clone();
		 */
		
		Student arrstudent[] = new Student(stuarr.length);
		for (int i = 0; i < stuarr.length; i++) {
			if(stuarr != null) {
				arrstudent[i] = new Student();
				arrstudent[i].setNumber(stuarr[i].getNumber());
				arrstudent[i].setName(stuarr[i].getName());
				arrstudent[i].setLang(stuarr[i].getLang());
				arrstudent[i].setMath(stuarr[i].getMath());
				arrstudent[i].setEng(stuarr[i].getEng());
			}
		}
		
//		for (int i = 0; i < arrstudent.length; i++) {
//			student s = arrstudent[i];
//		}
		
		sortProc(arrstudent);
		System.out.println("영어점수의 순위: ");
		for (Student s : arrstudent) {
			if(s != null) {
			System.out.println(s.toString());
			}
		}
//		arrstudent[0].setName("정수동");
//		System.out.println(stuarr[0].getName());
//		System.out.println(arrstudent[0].getName());
	}
	
	public void sortProc(Student arr[]) {
		for (int i = 0; i < arr.length-1; i++) {
			for (int j = i+1; j < arr.length; j++) {
				if(arr[i].getEng()<arr[j].getEng()) {
					swap(arr, i, j);
				}
			}
		}
		
	}
	
	public void swap(Student arr[], int i, int j) {
		Student temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		
	}

}
