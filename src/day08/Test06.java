package day08;

import java.io.*;
import java.net.URISyntaxException;

import java.util.Scanner;

/**
 * 使用异常捕获机制完成下述IO操作
 * 编写程序，要求下面的类实现功能:
 * 添加新员工
 * 要求用户输入一个员工信息，格式如下:
 * jackson,25,男,5000,2008-12-22
 * rgc,25,男,5000,2008-12-22
 * 用户输入后需要做下述验证:
 * 要求用户名长度在1-20个字符之间且必须是英文
 * 年龄在0-100之间的整数
 * 性别只能是:"男"或"女"
 * 当发现用户输入有不符合规定时，提醒用户
 * 相关内容输入不符合要求，并要求重新输入。
 * 都输入正确后，将该员工添加到emp.txt文件
 * 的最后一行。
 *
 * @author Bonnie
 */
public class Test06 {
    public static void main(String[] args) throws URISyntaxException {

        Scanner console = new Scanner(System.in);
        System.out.println("请输入员工信息：");
        String str = console.nextLine();
        String regex = "^[a-zA-Z]{1,20},([1-9][0-9]?|[1][0][0]),[男女],[0-9]{4,},[0-9]{4}-(0[0-9]|1[0-2])-([0-2][0-9]|3[0-1])$";
        while (!str.matches(regex)) {
            System.out.println("输入格式不正确，请重新输入：");
            str = console.nextLine();
        }

        File file = new File(Test06.class.getClassLoader().getResource("day08/emp.txt").toURI());
        try {
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream(file,true)));
            pw.println(str);
            System.out.println("添加成功。");
            pw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }

}
