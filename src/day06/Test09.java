package day06;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * 创建一个文件"note.txt",然后通过控制台输入的每一行字符串都按行写入到
 * note.txt中。当输入的字符串为"exit"时退出程序。
 *
 * @author Bonnie
 */
public class Test09 {

    public static void main(String[] args) throws FileNotFoundException {


        PrintWriter pw = new PrintWriter(
                new OutputStreamWriter(
                        new FileOutputStream("note.txt")
                )
        );
        Scanner console = new Scanner(System.in);
        System.out.println("请输入一行字符串，输入exit结束");
        String str = console.nextLine();
        while (!str.equals("exit")) {

            pw.println(str);
            System.out.println("输入成功，请输入下一行，输入exit结束。");
            str = console.nextLine();

        }
        pw.close();
    }


}
