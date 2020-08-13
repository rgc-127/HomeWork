package day06;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * 要求用户输入一个员工信息，格式为：
 * name,age,gender,salary,hiredate
 * 例如:
 * 张三,25,男,5000,2006-02-15
 * 李四,25,男,5000,2006-02-15
 * 王五,25,男,5000,2006-02-15
 * 赵六,25,男,5000,2006-02-15
 * 鬼脚七,25,男,5000,2006-02-15
 * 然后将输入的员工信息解析成Emp对象。
 * 然后将该Emp对象的toString返回的字符串写入到文件中，该文件的
 * 名字为:name.emp,以上面的例子，那么该文件名为:张三.emp
 * 至少运行5次该程序，输入五个员工信息，并生成5个文件。
 *
 * @author Bonnie
 */
public class Test10 {
    public static void main(String[] args) throws ParseException, FileNotFoundException {

        Scanner console = new Scanner(System.in);
        System.out.println("请输入员工信息，输入exit结束：");
        String regex = "^.{2,},[0-9]{2},[男女],[0-9]{4,},[0-9]{4}-[0-1][0-9]-[0-3][0-9]$";

        String str;

        do {
            str = console.next();
            if (str.matches(regex)) {

                String[] ss = str.split(",");

                SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
                Date date = sf.parse(ss[4]);

                Emp emp = new Emp(ss[0], Integer.parseInt(ss[1]), ss[2], Integer.parseInt(ss[3]), date);
                PrintWriter pw = new PrintWriter(
                        new OutputStreamWriter(
                                new FileOutputStream(ss[0]+".emp")
                        )
                );
                pw.println(emp.toString());

                pw.close();
                System.out.println("录入成功");

            } else {
                if (!str.equals("exit")) {
                    System.out.println("格式错误。");
                }
            }


        } while (!str.equals("exit"));

        System.out.println("程序退出。");

    }


}
	

