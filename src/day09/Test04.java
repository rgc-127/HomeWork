package day09;

import java.text.SimpleDateFormat;
import java.util.Date;



/**
 * 创建一个线程，每秒输出一次当前系统时间:yyyy-MM-dd HH:mm:ss
 * @author Bonnie
 *
 */
public class Test04 {

    public static void main(String[] args) {

        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Thread t = new Thread(()->{
            while (true){

                Date date = new Date();
                System.out.println(sf.format(date));
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        });

        t.start();



    }
}
