package day03;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 * 实现时间的计算: 要求用户输入身份证号，若格式有误，要求其重新输入。然后根据身份证号码输出20岁生日
 * 所在周的周三的日期。
 * 例如:
 * 出生日期:1992-07-15。
 * 20岁生日:2012-07-15
 * 当周的周三为:2012-07-18
 * @author Bonnie
 *
 */
public class Test05 {

    public static void main(String[] args) throws ParseException {

        Scanner console = new Scanner(System.in);
        System.out.println("请输入身份证号:");


        String str = console.nextLine();

        String regex = "^\\d{18}$";//18位数字


        if (str.matches(regex)){
            String birthday = str.substring(6,14);
            System.out.println(birthday);
            SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd");

            Date date = new Date();
            date = sf.parse(birthday);

            SimpleDateFormat sf1 = new SimpleDateFormat("yyyy-MM-dd");

            Calendar cl = Calendar.getInstance();

            cl.setTime(date);

            cl.add(Calendar.YEAR,20);
            date = cl.getTime();

            String ss = sf1.format(date);


            cl.set(Calendar.DAY_OF_WEEK,Calendar.WEDNESDAY);

            date = cl.getTime();

            ss = sf1.format(date);

            System.out.println("20岁生日所在周的周三的日期为："+ss);


        }else {
            System.out.println("格式有误！！");
        }







    }



}
