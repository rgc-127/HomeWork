package day02;


import java.util.ArrayList;
import java.util.Scanner;

/**
 * 要求用户输入若干员工信息，格式为：
 * name,age,gender,salary;name,age,gender,salary;....
 * 例如:
 * 张三,25,男,5000;李四,26,女,6000;...
 * 然后将每个员工信息解析成Person对象。并存入到一个数组中。
 * 然后循环数组，输出每一个员工信息(输出使用toString返回的字符串)
 *
 * @author Bonnie
 */
public class Test08 {


    static ArrayList<Person> p = new ArrayList<>();

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        System.out.println("请输入员工信息，格式如：张三,25,男,5000;李四,26,女,6000;...");

        String regex = "^(.{2,},[0-9]{2},[男女],[0-9]{4,};)+$";

        String s = console.nextLine();
        Check(s,regex);




    }
    public static void Check(String s,String regex){

        if (s.matches(regex)) {

            String[] s1 = s.split(";");

            for (int i = 0; i < s1.length; i++) {

                String[] s2 = s1[i].split(",");

                Person p1 = new Person(s2[0],Integer.parseInt(s2[1]),s2[2],Integer.parseInt(s2[3]));
                p.add(p1);
            }
            for (int i = 0; i < p.size(); i++) {


                System.out.println(p.get(i).toString());
            }
        }else{
            System.out.println("输入格式有误！");
        }
    }

}
