package day07;


import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * 要求用户控制台输入想输入的员工人数（至少5个），然后依序输入员工信息，每行为
 * 一条员工信息，格式如:张三,25,男,5000,2006-03-18
 * 李四,25,男,5000,2006-03-18
 * 王五,25,男,5000,2006-03-18
 * 赵六,25,男,5000,2006-03-18
 * 鬼脚七,25,男,5000,2006-03-18
 * <p>
 * 然后将该对象写入到文件<name>.obj并保存到当前项目根目录中，例如:张三.obj。
 *
 * @author Bonnie
 */
public class Test03 {


    public static void main(String[] args) throws IOException, ParseException {
        Scanner console = new Scanner(System.in);
        System.out.println("请输入员工人数（至少5个）：");
        String regex = "^.{2,},[1-9][0-9]?,[男女],[0-9]{4,},[0-9]{4}-[0-1][0-9]-[0-3][0-9]$";
        int n;
        while (console.hasNext()) {

            n = console.nextInt();
            if (n < 5) {
                System.out.println("请重新输入（至少5个）：");


            } else {
                for (int i = 0; i < n; i++) {


                    System.out.println("请输入员工信息，格式如：张三,25,男,5000,2006-03-18");

                    String str = console.next();

                    if (str.matches(regex)) {
                        String[] ss = str.split(",");

                        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
                        Date date = sf.parse(ss[4]);

                        Emp emp = new Emp(ss[0], Integer.parseInt(ss[1]), ss[2], Integer.parseInt(ss[3]), date);
                        ObjectOutputStream obj = new ObjectOutputStream(new FileOutputStream(ss[0]+".obj"));
                        obj.writeObject(emp);

                        obj.close();
                        System.out.println("录入成功");

                    } else {

                        System.out.println("格式错误。");
                        i--;
                    }


                }
                break;

            }

        }

        System.out.println("录入结束");
    }


}
