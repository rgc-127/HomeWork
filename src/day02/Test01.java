package day02;

import java.util.Scanner;

/**
 * 要求用户输入一个字符串，然后若该字符串是一个整数，则转换为整数后输出乘以10后的结果
 * 若是小数，则转换为一个小数后输出乘以5后的结果，若不是数字则输出"不是数字"
 * 需要使用正则表达式进行判断。
 * @author Bonnie
 *
 */
public class Test01 {

    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);
        System.out.println("请输入一个字符串：");

        String str = console.nextLine();

        String regex = "^[0-9]+$";

        String regex1 = "^[0-9]+\\.[0-9]+$";

        if (str.matches(regex)){

            int a = parseInt(str);
            System.out.println("你输入的是整数，乘以10后得："+a*10);

        }else if (str.matches(regex1)){

            double a = parseDouble(str);
            System.out.println("你输入的是小数，乘以5后得："+a*5);
        }else {
            System.out.println("不是数字");
        }


    }
    public static int parseInt(String str){
        // 最后要生成的数字
        int num = 0;
        // 临时变量，用于计算对应位数的数字
        int flag = 0;
        for (int i = 0; i < str.length(); i++) {
            flag = (str.charAt(i) - 48);
            /*
             * 这里是将对应的数字计算为对应的位，例如百位数字就要用该数字乘以10的2次方
             * 得到
             * 可以用Math的相关方法处理(自行查看API文档)
             */
            for (int n = 0; n < str.length() - 1 - i; n++) {
                flag *= 10;
            }
            num += flag;
        }
        return num;
    }
    public static double parseDouble(String str){
        // 最后要生成的数字
        double num = 0;
        // 临时变量，用于计算对应位数的数字
        double flag = 0;
        int i = str.indexOf(".") ;
        for (int j = 0; j < i; j++) {

            flag = (str.charAt(j) - 48);
            /*
             * 这里是将对应的数字计算为对应的位，例如百位数字就要用该数字乘以10的2次方
             * 得到
             * 可以用Math的相关方法处理(自行查看API文档)
             */
            for (int n = 0; n < i - 1 - j; n++) {
                flag *= 10;
            }
            num += flag;

        }
        for ( i += 1; i < str.length(); i++) {

            flag = (str.charAt(i) - 48);

            for (int n = 0; n < i - str.indexOf("."); n++) {
                flag /= 10;
            }
            num += flag;
        }
        return num;
    }


}
