package day01;
/**
 * 1:输出字符串"HelloWorld"的字符串长度
 * 2:输出"HelloWorld"中"o"的位置
 * 3:输出"HelloWorld"中从下标5出开始第一次出现"o"的位置
 * 4:截取"HelloWorld"中的"Hello"并输出
 * 5:截取"HelloWorld"中的"World"并输出
 * 6:将字符串"  Hello   "中两边的空白去除后输出
 * 7:输出"HelloWorld"中第6个字符"W"
 * 8:输出"HelloWorld"是否是以"h"开头和"ld"结尾的。
 * 9:将"HelloWorld"分别转换为全大写和全小写并输出。
 * @author Bonnie
 *
 */
public class Test01 {
	public static void main(String[] args) {
		String str = "HelloWorld";
		//以下自行调用test2,test3...等方法。
		test1(str);
		test2(str);
		test3(str);
		test4(str);
		test5(str);

		String s ="  Hello   ";
		test6(s);
		test7(str);
		test8(str);
		test9(str);



	}

	public static void test1(String str){
		// 1:输出字符串"HelloWorld"的字符串长度
		System.out.println("1、字符串长度:"+ str.length());
	}
	public static void test2(String str){
		//2:输出"HelloWorld"中"o"的位置
		System.out.println("2、\"o\"的位置:"+str.indexOf("o"));

	}
	public static void test3(String str){
		//3:输出"HelloWorld"中从下标5出开始第一次出现"o"的位置
		System.out.println("3、从下标5出开始第一次出现\"o\"的位置:"+str.indexOf("o",5));

	}
	public static void test4(String str){
		//4:截取"HelloWorld"中的"Hello"并输出
		System.out.println("4、截取\"HelloWorld\"中的\"Hello\"并输出:"+str.substring(0,5));

	}
	public static void test5(String str){
		//5:截取"HelloWorld"中的"World"并输出
		System.out.println("5、截取\"HelloWorld\"中的\"World\"并输出:"+str.substring(5));

	}
	public static void test6(String str){
		//6:将字符串"  Hello   "中两边的空白去除后输出
		System.out.println("6:将字符串\"  Hello   \"中两边的空白去除后输出:"+str.trim());

	}
	public static void test7(String str){
		//7:输出"HelloWorld"中第6个字符"W"
		System.out.println("7:输出\"HelloWorld\"中第6个字符\"W\":"+str.charAt(5));

	}
	public static void test8(String str){
		//8:输出"HelloWorld"是否是以"h"开头和"ld"结尾的。
		System.out.println("8:输出\"HelloWorld\"是否是以\"h\"开头和\"ld\"结尾的："+(str.startsWith("h") && str.endsWith("ld")));

	}
	public static void test9(String str){
		//9:将"HelloWorld"分别转换为全大写和全小写并输出。
		System.out.println("9:将\"HelloWorld\"分别转换为全大写和全小写并输出。");
		System.out.println("大写：" + str.toUpperCase());
		System.out.println("小写：" + str.toLowerCase());

	}




}
