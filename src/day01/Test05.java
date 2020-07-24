package day01;


import java.util.Scanner;

/**
 * 随机生成一个5位的英文字母验证码(大小写混搭)
 * 然后将该验证码输出给用户，然后要求用户输入该验证码，大小写不限制。
 * 然后判定用户输入的验证码是否有效(无论用户输入大小写，只要字母都正确即可)。
 *
 * @author Bonnie
 */
public class Test05 {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);
        String cre = create();
        System.out.println("请输入验证码（不限大小写）：" + cre);

        String str = console.nextLine();


        if (str.equalsIgnoreCase(cre)) {

            System.out.println("验证码正确。");

        } else {

            System.out.println("你输入的验证码有误。");
        }


    }

    public static String create() {


        StringBuilder s = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            int n = (int) (Math.random() * 2);
            if (n == 0) {
                s.append((char) (Math.random() * 26 + 'a'));
            } else {
                s.append((char) (Math.random() * 26 + 'A'));
            }

        }
        return s.toString();
    }
}
