package day06;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 编写一个程序，将当前目录下所有的员工文件进行读取，并解析出所有员工为Emp
 * 对象并存入Map。其中key为该员工的名字，value为该员工的emp对象。
 * 然后，要求用户输入一个员工名字，若该员工存在，则输出该员工的名字，年龄，工资，以及入职20周年的纪念日当周的周六的日期。
 * 即:输入名字"张三"
 * 若该员工存在，则输出如下格式:
 * 张三,25,5000,2006-02-14
 * 入职20周年纪念日派对日期: 2026-02-14  （注:若入职日期为:2006-02-14）
 * 若该员工不存在，则输出:"查无此人"
 * @author Bonnie
 *
 */
public class Test12 {
    public static void main(String[] args) throws IOException, ParseException {

        File file = new File(".");

        String[] list = file.list((dir, name) -> name.endsWith(".emp"));
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        Map<String,Emp> eMap = new HashMap();
        BufferedReader bfr;
        for (String s : list) {
            bfr = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(s)
                    )
            );
            //张三,25,男,5000,2006-02-15
            //Emp(String name, int age, String gender, int salary, Date hiredate)
            String[] str = bfr.readLine().split(",");
            bfr.close();

            Emp emp = new Emp(str[0], Integer.parseInt(str[1]), str[2], Integer.parseInt(str[3]), sf.parse(str[4]));
            eMap.put(str[0],emp);
        }

        Scanner console = new Scanner(System.in);
        System.out.println("请输入员工名字");
        String name = console.next();
        Set<String> nameSet = eMap.keySet();
        for (String s : nameSet){

            if (s.equals(name)){
                System.out.println(eMap.get(s));
                System.out.print("入职20周年纪念日派对日期:");
                Calendar ca = Calendar.getInstance();
                ca.setTime(eMap.get(s).getHiredate());
                ca.add(Calendar.YEAR,20);
                ca.set(Calendar.DAY_OF_WEEK,Calendar.SATURDAY);
                System.out.println(sf.format(ca.getTime()));
                name = "已找到";


            }


        }
        if ( !name.equals("已找到")){
            System.out.println("查无此人");
        }
    }
}
