package day06;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 编写一个程序，将当前目录下所有员工文件进行读取，并解析出所有员工为Emp
 * 对象并存入集合。然后排序该集合，按照员工的年龄排序，年龄大的靠前，年龄小
 * 的靠后。排序完毕后输出结果。
 *
 * @author Bonnie
 */
public class Test11 {

    public static void main(String[] args) throws IOException, ParseException {


        File file = new File(".");

        String[] list = file.list((dir, name) -> name.endsWith(".emp"));

        List<Emp> elist = new ArrayList<>();
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
            SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
            Emp emp = new Emp(str[0], Integer.parseInt(str[1]), str[2], Integer.parseInt(str[3]), sf.parse(str[4]));
            elist.add(emp);
        }

        elist.sort(Comparator.comparing(Emp::getHiredate));

        System.out.println(elist);
    }


}
