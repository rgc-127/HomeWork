package day06;

import java.io.File;


/**
 * 获取并输出当前目录下所有文件的名字
 * @author Bonnie
 *
 */
public class Test06 {
    public static void main(String[] args) {

        File file = new File(Test04.class.getResource(".").getPath());

        File[] str = file.listFiles(File::isFile);

        for (File f:str) {

            System.out.println(f.getName());

        }
    }

}
