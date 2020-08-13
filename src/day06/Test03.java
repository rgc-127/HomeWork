package day06;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * 要求用户输入一个目录名并使用File在当前目录下创建出来。
 * 若该目录已经存在，则提示用户该目录已经存在。并创建副本，原则与第二题一致。
 * @author Bonnie
 *
 */
public class Test03 {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        System.out.println("请输入一个目录名称:");

        String filename = sc.next();
        mkDirs(filename,0);


    }
    public static void mkDirs(String s,int i) throws IOException {
        File file ;

        if (i != 0) {

            file = new File(s + "_副本" + i );

        } else {
            file = new File(s );
        }


        if (!file.mkdirs()){

            System.out.println("目录已存在");
            i++;
            mkDirs(s, i);
        }else {
            System.out.println("目录" + file.getName() + "创建成功");
        }

    }

}
