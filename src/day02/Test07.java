package day02;

import java.util.Scanner;

/**
 * 输入一个数学计算表达式，如:1+2
 * 然后输出计算后的结果:1+2=3
 * 这里计算表达式只计算一次即可，可以使用加减乘除任意一个,可以进行小数运算。
 * @author Bonnie
 *
 */
public class Test07 {

    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        System.out.println("请输入一个表达式：");

        String str = console.nextLine();

        String regex = "^[0-9]+(.[0-9]+)?[-+*/][0-9]+(.[0-9]+)?$";

        calculate(str,regex);


    }


    public static void calculate( String str,String regex){

        String rs = "[-+*/]";

        double sum = 0;
        double m = 0, n = 0;

        if (str.matches(regex)) {

            String[] str1 = str.split(rs);
            if (str1[0].contains("\\.")) {
                m = Double.parseDouble(str1[0]);
            } else {
                m = Integer.parseInt(str1[0]);
            }
            if (str1[1].contains("\\.")) {
                n = Double.parseDouble(str1[1]);
            } else {
                n = Integer.parseInt(str1[1]);
            }
            switch (str.charAt(str1[0].length())) {
                case '+':
                    sum = m + n;
                    break;
                case '-':
                    sum = m - n;
                    break;
                case '*':
                    sum = m * n;
                    break;
                case '/':
                    sum = m / n;
                    break;
                default:
                    System.out.println("你输入的运算符有误！");

            }
            System.out.println("计算结果为：" + str1[0] + str.charAt(str1[0].length()) + str1[1] + " = " + sum);
        } else {
            System.out.println("格式有误：");
        }

    }
}
