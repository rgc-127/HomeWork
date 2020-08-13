package day07;

import java.io.*;

/**
 * 使用缓冲流复制myfile.txt文件为myfile_cp2.txt
 * @author Bonnie
 *
 */
public class Test02 {
    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream("myfile.txt")
                )
        );

        PrintWriter pw = new PrintWriter(
                new OutputStreamWriter(
                        new FileOutputStream("myfile_cp2.txt")
                )
        );
        String str;
        while ((str = bfr.readLine()) != null){
            pw.println(str);
        }
        pw.close();
        bfr.close();

    }

}
