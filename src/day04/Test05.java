package day04;


import java.util.LinkedList;
import java.util.List;

/**
 * 创建一个List集合，并添加元素0-9
 * 将集合转换为一个Integer数组并输出数组每一个元素
 * @author Bonnie
 *
 */
public class Test05 {
    public static void main(String[] args) {

        List<Integer> ls = new LinkedList<>();

        ls.add(0);
        ls.add(1);
        ls.add(2);
        ls.add(3);
        ls.add(4);
        ls.add(5);
        ls.add(6);
        ls.add(7);
        ls.add(8);
        ls.add(9);

        Integer[] ii = ls.toArray(new Integer [3]);

        for (int i : ii) {
            System.out.println(i);
        }



    }



}
