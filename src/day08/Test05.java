package day08;

import java.io.*;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/**
 * 使用异常捕获机制完成下述读取操作，并在finally中有关闭RandomAccessFile操作。
 * 将emp.dat文件中所有员工解析出来，并创建为若干Emp实例存入一个
 * 集合，然后按照员工入职从晚到早的顺序依次输出员工信息。
 * <p>
 * 该文件560字节，每56个字节为一个员工的信息。
 * 其中:
 * name为字符串，长度为32个字节，编码为:UTF-8
 * age为short,长度为2个字节
 * gender为字符串，长度为10个字节，编码为:UTF-8
 * salary为int,长度为4个字节
 * hiredate为long，长度为8个字节
 * 格式可参考当前包中emp.jpg图
 *
 * @author Bonnie
 */
public class Test05 {

    public static void main(String[] args) throws URISyntaxException {
        //使用类加载器加载当前包中的emp.dat文件
        File file = new File(Test05.class.getClassLoader().getResource("day08/emp.dat").toURI());


        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        List<Emp> list = new ArrayList<>();
        RandomAccessFile rw = null;
        try {
            rw = new RandomAccessFile(file, "rw");
            do {
                byte[] b = new byte[32];
                String name = new String(b, 0, rw.read(b), "UTF-8");

                short age = rw.readShort();

                byte[] b1 = new byte[10];
                String gender = new String(b1, 0, rw.read(b1), "UTF-8");

                int salary = rw.readInt();


                long time = rw.readLong();

                Date hiredate = new Date(time);

                list.add(new Emp(name, age, gender, salary, hiredate));

            } while (rw.getFilePointer() < rw.length());


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                rw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        list.sort(Comparator.comparing(Emp::getHiredate));

        for (Emp e :
                list) {
            System.out.println(e);
        }
    }


}
