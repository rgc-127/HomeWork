package day03;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 * 要求用户首先输入员工数量，然后输入相应员工信息，格式为：
 * name,age,gender,salary,hiredate
 * 例如:
 * 张三,25,男,5000,2006-02-15
 * 每一行为一个员工信息，然后将每个员工信息解析成Emp对象。并存入到一个集合中。
 * 在解析成Emp对象后要先查看当前集合是否包含该员工，若包含则提示该用于已存在，
 * 否则才存入集合。
 * 然后输出集合查看每个员工信息.
 * @author Bonnie
 *
 */
public class Test07 {

    public static ArrayList<Emp> p = new ArrayList<>();
    public static void main(String[] args) throws ParseException {

        Scanner console = new Scanner(System.in);
        System.out.println("请输入员工数量：");

        int count =console.nextInt();
//        张三,25,男,5000,2006-02-15
        System.out.println("请输入员工信息：");
        String regex = "^.{2,},[0-9]{2},[男女],[0-9]{4,},[0-9]{4}-[0-1][0-9]-[0-3][0-9]$";

        loop1:for (int i = 0; i < count; i++) {

            String str= console.next();
            if (str.matches(regex)){

                String[] ss = str.split(",");

                SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
                Date date = sf.parse(ss[4]);
                Emp emp = new Emp(ss[0],Integer.parseInt(ss[1]),ss[2],Integer.parseInt(ss[3]),date);

                for (int j = 0; j < p.size(); j++) {

                    if (emp.equals(p.get(j))){
                        System.out.println("用户"+emp.getName()+"已存在。");
                        continue loop1;
                    }

                }
                p.add(emp);

            }else {
                System.out.println("第"+ (i+1) +"行格式错误。");
            }


        }

        for (Emp p1:p) {
            System.out.println(p1);
        }







    }

}
