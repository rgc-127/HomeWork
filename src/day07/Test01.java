package day07;

import java.io.*;

/**
 * 使用文件流复制myfile.txt文件为myfile_cp.txt
 * @author Bonnie
 *
 */
public class Test01 {
    public static void main(String[] args) throws IOException {

        InputStream is = new FileInputStream("myfile.txt");

        OutputStream os = new FileOutputStream("myfile_cp.txt");

        int len;
        byte[] b = new byte[10];
        while ((len = is.read(b)) != -1 ){

            os.write(b);

        }
        os.close();
        is.close();

    }
}