package day08;




import java.io.*;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 使用异常捕获机制完成下述读取操作
 * 读取emp.txt文件，并将每个员工信息读取出来，以一个Emp实例保存，然后将
 * 这些Emp实例存入到一个Map集合中。其中key为字符串，是该员工名字，而value
 * 是该Emp实例。
 * 存入后，要求用户输入一个员工的名字,如:张三
 * 若该员工存在则输出该员工所有信息(Emp的toString方法返回的字符串)
 * 输入的员工名若是英文，不要求区分大小写。
 * 若输入的员工名字不存在，则显示"查无此人"
 *
 * @author Bonnie
 */
public class Test04 {
    public static void main(String[] args) throws URISyntaxException {

        File file = new File(Test04.class.getClassLoader().getResource("day08/emp.txt").toURI());
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        Map<String, Emp> eMap = new HashMap();
        BufferedReader bfr;
        try {

            bfr = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(file)
                    )
            );
            //张三,25,男,5000,2006-02-15
            //Emp(String name, int age, String gender, int salary, Date hiredate)
            String str1 ;

            while ((str1 = bfr.readLine()) != null){

                String[] str = str1.split(",");
                Emp emp = new Emp(str[0], Integer.parseInt(str[1]), str[2], Integer.parseInt(str[3]), sf.parse(str[4]));
                eMap.put(str[0], emp);
            }

            bfr.close();





        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Scanner console = new Scanner(System.in);
        System.out.println("请输入员工名字:");
        String name = console.next();
        Set<String> nameSet = eMap.keySet();
        for (String s : nameSet) {

            if (s.equalsIgnoreCase(name)) {
                System.out.println(eMap.get(s));
                name = "已找到";
                break;

            }


        }
        if (!name.equals("已找到")) {
            System.out.println("查无此人");
        }


    }

}
