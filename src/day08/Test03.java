package day08;

import org.junit.Test;

import java.io.*;

/**
 * 使用异常捕获机制完成下述读取操作。
 * 使用缓冲流读取note.txt文件，并将每行字符串输出到控制台上
 * @author Bonnie
 *
 */
public class Test03 {

    @Test
    public void test(){
        BufferedReader bf = null;
        try {
            bf = new BufferedReader(new InputStreamReader(new FileInputStream("note.txt")));
            String str;
            while ((str = bf.readLine()) != null){


                System.out.println(str);


            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                bf.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
	
}
