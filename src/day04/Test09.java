package day04;

import day03.Emp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 * 要求用户输入若干员工信息，格式为：
 * name,age,gender,salary,hiredate;name,age,gender,salary,hiredate;....
 * 例如:
 * 张三,25,男,5000,2006-02-15;李四,26,女,6000,2007-12-24;...
 * 然后将每个员工信息解析成Emp对象。并存入到一个集合中。
 * 然后循环集合，输出每一个员工信息(输出使用toString返回的字符串)
 * 然后输出每个员工的转正仪式日期。
 * 转正仪式日期为:入职3个月的当周周五
 * 
 * @author Bonnie
 *
 */
public class Test09 {
    private static ArrayList<Emp> p = new ArrayList<>();
    public static void main(String[] args) throws ParseException {


        add();
        for (Emp p1: p) {

            System.out.print(p1);
            Calendar cl = Calendar.getInstance();
            cl.setTime(p1.getHiredate());
            cl.add(Calendar.MONTH,3);
            cl.set(Calendar.DAY_OF_WEEK,Calendar.FRIDAY);
            Date date = cl.getTime();
            SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
            System.out.println("转正仪式日期为："+ sf.format(date));
            System.out.println();

        }






    }

    public static void add() throws ParseException {
        Scanner console = new Scanner(System.in);
        System.out.println("请输入员工信息，输入exit结束：");
        String regex = "^.{2,},[0-9]{2},[男女],[0-9]{4,},[0-9]{4}-[0-1][0-9]-[0-3][0-9]$";
        String str;

        loop1:do{
            str = console.next();
            if (str.matches(regex)){

                String[] ss = str.split(",");

                SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
                Date date = sf.parse(ss[4]);
                day03.Emp emp = new Emp(ss[0],Integer.parseInt(ss[1]),ss[2],Integer.parseInt(ss[3]),date);

                for (int j = 0; j < p.size(); j++) {

                    if (emp.equals(p.get(j))){
                        System.out.println("用户"+emp.getName()+"已存在。");

                        continue loop1;
                    }

                }
                p.add(emp);
                System.out.println("添加成功。");
            }else {
                if (!str.equals("exit")) {
                    System.out.println("格式错误。");
                }
            }


        }while (!str.equals("exit"));
    }

}
