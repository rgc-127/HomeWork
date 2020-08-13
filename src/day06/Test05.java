package day06;

import java.io.File;
import java.util.Scanner;

/**
 * 要求用户输入一个文件或目录名，并删除当前目录下的该文件或目录。
 * 可自行手动先在当前项目目录中创建一个要删除的文件或目录，若是目录，还可以
 * 在该目录中继续创建若干级目录和文件。
 *
 * @author Bonnie
 */
public class Test05 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("请输入一个文件或目录名:");

        String fileName = sc.next();

        File file = new File(fileName);
        dleteFile(file);

    }

    public static void dleteFile(File file) {

        if (file.isDirectory()){

            File[] file1 = file.listFiles();
            if (file1 != null) {
                for (File value : file1) {
                    dleteFile(value);
                }
            }
            file.delete();

        }else{
            file.delete();
        }

        System.out.println("删除成功！");

    }
}
