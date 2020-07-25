package day04;


import java.util.*;

/**
 * 创建一个List集合，并存放10个随机数，然后排序该集合
 * 后输出
 * @author Bonnie
 *
 */
public class Test07 {

    public static void main(String[] args) {

        List<Integer> ls = new ArrayList<>();

        Random ma = new Random();
        for (int i = 0; i < 10; i++) {


            ls.add(ma.nextInt());

        }
        System.out.println(ls);

        ls.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        System.out.println(ls);

        Collections.sort(ls);
        System.out.println(ls);
    }

}
