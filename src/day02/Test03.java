package day02;
/**
 * 输入一个IP地址，然后将4段数字分别输出
 * @author Bonnie
 *
 */
public class Test03 {
    public static void main(String[] args) {

        String str = "192.168.106.99";

        String regex = "[.]";
//        String regex = "\\.";

        String[] str1 = str.split(regex);

        for (int i = 0; i < str1.length; i++) {
            System.out.println(str1[i]);
        }




    }


}
