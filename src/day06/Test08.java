package day06;

import java.io.*;

/**
 * 创建一个"raf.dat"的文件，并在其中写出一个int的最大值，long的最大值，
 * 然后将其分别读取出来并输出
 *
 * @author Bonnie
 */
public class Test08 {


    public static void main(String[] args) throws IOException {

        PrintWriter pw = new PrintWriter(
                new OutputStreamWriter(
                        new FileOutputStream("raf.dat")
                )
        );

        pw.println(Integer.MAX_VALUE);

        pw.println(Long.MAX_VALUE);

        pw.close();

        BufferedReader bf = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream("raf.dat")
                )
        );

        String str;
        while ((str = bf.readLine()) != null) {

            System.out.println(str);

        }


        bf.close();


    }


}
