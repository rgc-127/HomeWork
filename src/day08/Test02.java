package day08;

import java.io.*;
import java.util.Scanner;

/**
 * 使用异常捕获完成下述操作
 * 将控制台输入的每一行字符串使用缓冲字符输出流PrintWriter
 * 按行以GBK编码写入到文件note.txt中
 * @author Bonnie
 *
 */
public class Test02 {


    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.println("请输入字符串（输入exit结束）：");
        String str = console.nextLine();
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("note.txt")));
            while (!str.equals("exit")){

                pw.println(new String(str.getBytes(),"GBK"));
                str = console.nextLine();

            }



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }finally {
            System.out.println("程序结束。");
            if (pw != null){
                pw.close();

            }
        }

    }




	
}
