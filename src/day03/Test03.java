package day03;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 * 输入某人生日，格式为"yyyy-MM-dd"，输出到现在为止经过了多少周。
 * @author Bonnie
 *
 */
public class Test03 {
    public static void main(String[] args) throws ParseException {


        Scanner console = new Scanner(System.in);
        System.out.println("请输入生日，格式为\"yyyy-MM-dd\"：");

        String s = console.nextLine();

        Date date = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        date = sf.parse(s);

        long time = date.getTime();
        long timenow = System.currentTimeMillis();

        long weektime = (timenow - time) /(7L*24*60*60*1000);


        System.out.println("到现在为止经过了"+weektime+"周。");

    }

}
