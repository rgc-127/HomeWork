package day05;
/**
 * 要求用户输入若干员工信息，格式为：
 * name,age,gender,salary,hiredate;name,age,gender,salary,hiredate;....
 * 例如:
 * 张三,25,男,5000,2006-02-15;李四,26,女,6000,2007-12-24;...
 * 然后将每个员工信息解析成Emp对象。并存入到一个List集合中。
 * 并对集合排序，然后输出每个员工信息。
 * 
 * 再根据员工的入职时间排序，入职晚的在前，早的在后并
 * 输出每个员工的信息。
 * @author Bonnie
 *
 */


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class Test03 {
    private static List<Emp> p = new ArrayList<Emp>();
    public static void main(String[] args) throws ParseException {

        add();

        Collections.sort(p);
        for (Object p1: p) {

            System.out.println(p1);
        }

        p.sort((o1,o2) -> (o2.getHiredate().compareTo(o1.getHiredate())));
        for (Object p1: p) {

            System.out.println(p1);
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
                Emp emp = new Emp(ss[0],Integer.parseInt(ss[1]),ss[2],Integer.parseInt(ss[3]),date);

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
