package day03;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 * 2018-03-25
 * 输入一个生产日期格式"yyyy-MM-dd",再输入一个数字(保质期的天数)。
 * 然后经过计算输出促销日期，促销日期为:该商品过期日前2周的周三
 *
 * @author Bonnie
 */
public class Test04 {
    public static void main(String[] args) throws ParseException {

        Scanner console = new Scanner(System.in);
        System.out.println("请输入一个生产日期，格式如\"yyyy-MM-dd\"：");
        String str = console.nextLine();
        System.out.println("请输入保质期天数：");
        int tian = console.nextInt();


        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        date = sf.parse(str);
        Calendar cl = Calendar.getInstance();
        cl.setTime(date);
        cl.add(Calendar.DAY_OF_YEAR,tian);

        System.out.println("促销日期为:");
        cl.add(Calendar.DAY_OF_YEAR,-7);
        cl.set(Calendar.DAY_OF_WEEK,Calendar.WEDNESDAY);
        date = cl.getTime();
        System.out.println(sf.format(date));

        cl.add(Calendar.DAY_OF_YEAR,-7);
        cl.set(Calendar.DAY_OF_WEEK,Calendar.WEDNESDAY);
        date = cl.getTime();
        System.out.println(sf.format(date));

    }
}
