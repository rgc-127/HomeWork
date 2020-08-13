package day06;

import java.io.*;
import java.util.Scanner;

/**
 * 要求用户输入一个文件名，并复制当前目录中该文件，并取名为"原文件名_copy.后缀名"
 * 定义两个方法分别使用单字节形式复制，以及字节数组形式复制
 * @author Bonnie
 *
 */
public class Test07 {
	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);

		System.out.println("请输入一个文件名：");

		String fileName = Test07.class.getResource(sc.next()).getPath();

		//copy1(fileName);
		copy2(fileName);

	}
	/**
	 * 使用单字节方式复制
	 * @param name 要复制的文件名
	 */
	public static void copy1(String name) throws IOException {
		InputStream is = new FileInputStream(name);

		String[] str = name.split("[.]");

		OutputStream os = new FileOutputStream(str[0]+"_copy."+str[1]);
		int len;
		while ((len = is.read()) != -1){

			os.write(len);
		}



	}
	/**
	 * 使用字节数组形式复制
	 * @param name 要复制的文件名
	 */
	public static void copy2(String name) throws IOException {
		InputStream is = new FileInputStream(name);

		String[] str = name.split("[.]");

		OutputStream os = new FileOutputStream(str[0]+"_copy."+str[1]);
		int len;
		byte[] by = new byte[10];
		while ((len = is.read(by)) != -1){

			os.write(by,0,len);

		}


	}
}
