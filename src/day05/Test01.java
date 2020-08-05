package day05;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 创建一个队列，存入Integer类型元素1,2,3,4,5
 * 然后遍历队列并输出每个元素
 * @author Bonnie
 *
 */
public class Test01 {

    public static void main(String[] args) {
        Queue<Integer> qq = new LinkedList<>();
        qq.offer(1);
        qq.offer(2);
        qq.offer(3);
        qq.offer(4);
        qq.offer(5);
        for (int i :qq) {
            System.out.println(i);
        }


    }

}
