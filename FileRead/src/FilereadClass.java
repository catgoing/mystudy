import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FilereadClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//file read
		
		File file = new File("d:\\tmp\\test.txt");
//		File file = new File("d:\\tmp\\newfile.txt");
		//	instance, object
		
		try {
			FileReader fr = new FileReader(file);
			
			//첫 번째 방법, 실제로는 안 쓰는 방법
			
			String str="";
			/*
			int c = fr.read(); // 한 문자씩 읽는다
			while(c != -1) { // -1: 파일의 끝
				 System.out.println((char)c);
				str = str + (char)c;
				c = fr.read();
			}
			System.out.println(str);
			*/
			
			// 두 번째 방법, 문장으로 읽는 방법, 실제로 쓰는 방식
			BufferedReader br = new BufferedReader(fr); // buffer: 저장공간
			
			while( (str = br.readLine()) != null) {	// 파일 끝이 아닐 때까지
				System.out.println(str);
			}
			br.close();  // 파일 닫아주기
			
			
		} catch (Exception e) { // FileNotFoundException으로 적으면 아래 catch문도 같이 써야 함
			System.out.println("파일이 없습니다");
		} 
//		catch (IOException e) {
//			System.out.println("파일을 읽을 수 없습니다");
//			e.printStackTrace();
//		}

	}

}
