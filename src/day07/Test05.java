package day07;

import org.junit.Test;

import java.io.*;

/**
 * 使用字符流复制当前程序的源文件到当前项目根目录下。
 * @author Bonnie
 *
 */
public class Test05 {


    @Test
    public void test() throws IOException {

        String path = Test05.class.getResource("Test05.class").getPath();
        Reader ir = new InputStreamReader(new FileInputStream(path));
        Writer w = new OutputStreamWriter(new FileOutputStream("Test05.class"));
        int len = 0;
        char[] cha = new char[10];
       while( (len = ir.read(cha,0,len)) != -1){

           w.write(cha);

       }







    }

}
