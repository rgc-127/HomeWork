package day07;

import org.junit.Test;

import java.io.*;
import java.util.Scanner;

/**
 * 记事本功能，首先要求用户输入一个文件名，并将该文件创建出来，
 * 然后通过控制台输入的每一行字符串都按行写入到该文件中，并
 * 使用GBK编码保存。当输入的字符串为"exit"时退出程序。
 * @author Bonnie
 *
 */
public class Test06 {

    public static void main(String[] args) throws IOException {
        Scanner console = new Scanner(System.in);
        System.out.println("请输入一个文件名：");
        String name = console.next();
        Writer w = new OutputStreamWriter(new FileOutputStream(name+".txt",true));
        System.out.println("请输入数据，输入exit结束。");
        String xx = new String(console.next().getBytes(),"GBK");
        while (!xx.equals("exit")){

            w.write(xx);
            xx = new String(console.next().getBytes(),"GBK");

        }

        w.close();
        System.out.println("程序结束");
    }

}
