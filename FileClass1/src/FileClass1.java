import java.io.File;
import java.io.IOException;

public class FileClass1 {

	public static void main(String[] args) { //throws Exception  -> { 전에 이걸 추가하면 try, catch 없이도 사용 가능
		// TODO Auto-generated method stub
		
		/*
			source code -> 알고리즘
			
			file: 저장매체 = database
				    데이터 저장, 불러오기
			
			*.dll: dynamic link library(동적파일)
			*.lib: library(정적파일)
			*.jar: java library 
			
		 */
		
		// 파일 목록
//		File fdir = new File("c:\\");
		
		/*
		String filelist[] = fdir.list();
		
		for (int i = 0; i < filelist.length; i++) {
			System.out.println(filelist[i]);
		}
		*/
		
		// 파일? 폴더? 그외?
		/*
		File fdir = new File("c:\\");
		File filelist[] = fdir.listFiles();
		
		for (int i = 0; i < filelist.length; i++) {
			if(filelist[i].isFile()) {	//파일
				System.out.println("파일 " + filelist[i].getName());
			} else if(filelist[i].isDirectory()) {	//폴더
				System.out.println("폴더 " + filelist[i].getName());
			} else {	//기타
				System.out.println("기타 " + filelist[i].getName());
			}
		}
		*/
		
		//파일 생성
		String filestr = "d:\\tmp\\newfile.txt";
		File newfile = new File(filestr);
		
		try {
			if(newfile.createNewFile()) {
				System.out.println("파일 생성 성공");
			}
			else {
				System.out.println("파일 생성 실패");
			}
		} catch (IOException e) {
			e.printStackTrace();
			}
		
		// 파일 존재
			if(newfile.exists()) {
				System.out.println("파일이 존재합니다");
			}else {
				System.out.println("파일이 존재하지 않습니다");
			}
			
		/*
		// 파일 삭제
		if(newfile.delete()) {
			System.out.println("파일을 삭제하였습니다");
		}else {
			System.out.println("파일을 삭제하지 못하였습니다");
		}
		*/
			
		// 읽기 가능 여부
		if(newfile.canRead()) {
			System.out.println("파일을 읽을 수 있습니다");
		}else {
			System.out.println("파일을 읽을 수 없습니다");
		}
		
		// 읽기 전용, 쓰기 가능으로 만들기
//		newfile.setReadOnly();
//		newfile.setWritable(true);
		
		
		// 쓰기 가능 여부
		if(newfile.canWrite()) {
			System.out.println("파일 쓰기가 가능합니다");
		}else {
			System.out.println("파일 쓰기가 불가능합니다");
		}
		
			
	}

}
