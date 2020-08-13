package day03;

import java.util.ArrayList;
import java.util.Collection;


/**
 * 创建一个集合，存放字符串"one","two"，"three"
 * 然后输出该集合的元素个数。
 * 然后输出该集合是否包含字符串"four"
 * 然后输出集合是否不含有任何元素
 * 然后清空集合
 * 然后输出该集合的元素个数
 * 然后输出集合是否不含有任何元素
 * @author Bonnie
 *
 */
public class Test06 {

    public static void main(String[] args) {

        Collection<String> col = new ArrayList<>();
        col.add("one");
        col.add("two");
        col.add("three");
        System.out.println("元素个数："+col.size());

        System.out.println("包含字符串\"four\":"+col.contains("four"));

        System.out.println("是否不含有任何元素:"+col.isEmpty());
        col.clear();
        System.out.println("元素个数："+col.size());
        System.out.println("是否不含有任何元素:"+col.isEmpty());


    }


}
