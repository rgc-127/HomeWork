package day04;

import java.util.LinkedList;
import java.util.List;

/**
 * 创建一个List集合并添加元素0-9
 * 然后获取子集[3,4,5,6]
 * 然后将子集元素扩大10倍
 * 然后输出原集合。
 * 之后删除集合中的[7,8,9]
 * @author Bonnie
 *
 */
public class Test04 {

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
        System.out.println(ls);
        List<Integer> ls1 = ls.subList(3,7);  //返回列表中指定的fromIndex （含）和toIndex之间的部分视图。 （如果fromIndex和toIndex相等，返回的列表为空。）返回的列表由此列表支持，因此返回列表中的非结构性更改将反映在此列表中，反之亦然。 返回的列表支持此列表支持的所有可选列表操作。

        System.out.println(ls1);
        for (int i = 0; i < ls1.size(); i++) {
            ls1.set(i, ls1.get(i) * 10);
        }
        System.out.println(ls1);
        System.out.println(ls);

        for (int i = 0; i <3 ; i++) {
            ls.remove(7);
        }

        System.out.println(ls);

        //ls.remove(6);
        //System.out.println(ls1);//因为ls1知识ls列表的一部分视图，实际存在的是同一个表，所以会出现并发异常ConcurrentModificationException
    }



}
