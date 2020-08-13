package day08;

import org.junit.Test;

import java.io.*;

/**
 * 对myfile.txt文件进行复制操作，要求使用异常捕获
 * 机制对流的异常进行捕获和处理，finally中
 * 要将流关闭
 *
 * @author Bonnie
 */
public class Test01 {
    @Test
    public void copy() {
        BufferedReader r = null;
        BufferedWriter w = null;
        try {
            r = new BufferedReader(new InputStreamReader(new FileInputStream("myfile.txt")));
            w = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("myfile_copy.txt")));

            String str ;
            while ((str = r.readLine()) != null){
                w.write(str);
                w.write("\n");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                if (r != null){
                    r.close();
                }
                if (r != null){
                    w.close();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        }


    }

}
