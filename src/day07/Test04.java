package day07;


import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 读取当前项目根目录下所有后缀为.obj的文件，将这些Emp对象读取出来
 * 并存入到一个List集合中，然后按照员工工资从多到少的顺序依次输出员工信息
 * @author Bonnie
 *
 */
public class Test04 {
    @Test
    public void test() throws IOException, ClassNotFoundException {
        File file = new File(".");

        String[] list = file.list((dir, name) -> name.endsWith(".obj"));

        List<Emp> elist = new ArrayList<>();
        ObjectInputStream bfr;


        for (String s : list) {
            bfr = new ObjectInputStream(new FileInputStream(s));
            Emp emp = (Emp) bfr.readObject();
            elist.add(emp);
            bfr.close();
        }

        elist.sort(Comparator.comparingInt(Emp::getSalary));

        System.out.println(elist);


    }

}
