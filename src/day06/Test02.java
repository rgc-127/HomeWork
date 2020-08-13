package day06;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * 要求用户输入一个文件名并使用File在当前目录下创建出来。
 * 若该文件已经存在，则提示用户该文件已经存在。并创建该文件副本：
 * 例如:用户输入"test.txt".若该文件已存在，提示用户存在后，创建名为：test_副本1.txt 的文件
 * 若该文件也存在了，则创建名为:test_副本2.txt 的文件，以此类推
 *
 * @author Bonnie
 */
public class Test02 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个文件名：");

        String str = sc.next();

        String[] ss = str.split("[.]");
        creatFile(ss[0], ss[1], 0);


    }

    public static void creatFile(String s, String s1, int i) throws IOException {
        File file;
        if (i != 0) {

            file = new File(s + "_副本" + i + "." + s1);
        } else {
            file = new File(s + "." + s1);
        }


        if (!file.createNewFile()) {

            System.out.println("文件" + file.getName() + "已存在");
            i++;
            creatFile(s, s1, i);

        } else {
            System.out.println("文件" + file.getName() + "创建成功");
        }

    }
}
