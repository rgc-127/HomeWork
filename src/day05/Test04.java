package day05;

import java.util.*;

/**
 *创建一个Map，保存某个学生的成绩:
 *在控制台输入该学生成绩，格式:
 *科目:成绩;科目:成绩;...
 *例如:  
 *语文:99;数学:98;英语:97;物理:96;化学:95
 *然后输出物理的成绩。
 *然后将化学的成绩设置为96
 *然后删除英语这一项。
 *然后遍历该Map分别按照遍历key，Entry，value
 *的形式输出该Map信息。
 * @author Bonnie
 *
 */ 
public class Test04 {

    public static void main(String[] args) {

        Map<String,String> m = new TreeMap<>();

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入学生成绩，格式: 科目:成绩;科目:成绩;...");

        String str = sc.nextLine();

        String[] str1 = str.split(";");

        for (int i = 0; i < str1.length; i++) {

            String[] str2 = str1[i].split(":");

            m.put(str2[0],str2[1]);

        }

        System.out.println("物理"+m.get("物理"));

        m.put("化学","96");

        m.remove("英语");

        Set<String> strs = m.keySet();
        for (String s:strs) {


            System.out.println(m.get(s));
        }

        Set<Map.Entry<String, String>> entries = m.entrySet();
        for (Map.Entry<String, String> n  :entries) {


            System.out.println(n);
        }

        Collection<String> v = m.values();
        for (String a:v) {
            System.out.println(a);
        }



    }

}
