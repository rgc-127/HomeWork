package day06;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 通过File输出当前项目目录下的文件"myfile.txt"的名字，大小，最后修改时间。
 * 最后修改时间格式如:2017-06-30 14:22:16
 *
 * @author Bonnie
 */
public class Test01 {

    public static void main(String[] args) {

        File file = new File("myfile.txt");

        System.out.println("名字" + file.getName());


        System.out.println("大小" + file.length());

        Date date = new Date(file.lastModified());
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str = sf.format(date);
        System.out.println("最后修改时间："+str);
    }


}
