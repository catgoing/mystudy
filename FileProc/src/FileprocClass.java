import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileprocClass {

	public static void main(String[] args) throws Exception  {
		// TODO Auto-generated method stub
		
		String str = "ㄴ", str2 = "ㄷ";
//		str2 = "file";
//		
//		String str1 = str + ".txt";
////		System.out.println(str1);
		ctf(str);
		
//		fwrite();
		
		
		
//		ctf(str);

	}

	
	// 파일 생성	-> 파일명
	
	static void ctf(String str) {
		Scanner sc = new Scanner(System.in);
		System.out.print("파일명 입력: ");
		str = sc.next();
		str = "d:/tmp/" + str+ ".txt" ;
		File file = new File(str);
		
		try {
			file.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	// 파일 쓰기	-> input
	static void fwrite(String str) throws Exception {
		FileWriter aa = new FileWriter(str);
		aa.write("안녕" + "\n");
		aa.close();
	}
	
	
	
	
	
	// 파일 읽기	-> output
	
	// 파일의 모든 데이터를 String[]로
	
	// 파일 추가쓰기

}
