package day07;

import java.io.*;
import java.util.Scanner;

/**
 * 要求用户输入一个文件，该文件应当是Test07程序生成的文件，然后将该文件中所有字符读取
 * 出来，并以UTF-8编码写入到另一个文件中，实现文件转码工作，该文件取名格式:原文件名_utf.txt。
 *
 * @author Bonnie
 */
public class Test07 {

    public static void main(String[] args) throws IOException {
        Scanner console = new Scanner(System.in);
        System.out.println("请输入一个文件名：");
        String name = console.next();
        Reader r = new InputStreamReader(new FileInputStream(name + ".txt"));
        Writer w = new OutputStreamWriter(new FileOutputStream(name + "_utf.txt", true));




        int len = 0;
        char[] cha = new char[10];
        while( (len = r.read(cha,0,len)) != -1){

            String ss = new String(cha);

            w.write(new String(ss.getBytes(),"UTF-8"));

        }
        w.close();
        r.close();
        System.out.println("程序结束");
    }

}
