package com;

import java.io.File;

public class Mian {
	// 目前在解析xml方面还有问题
	public static void main(String[] args) {
		FileAccept fa = new FileAccept();
		fa.setName("apk");
		File rootDir = new File(".");
		// System.out.println(rootDir.getAbsolutePath());
		File[] apkList = rootDir.listFiles(fa);
		// System.out.println(apkList.length);
		// if (apkList.length != 1) {//用于手动控制多重解锁
		// System.out.println("进入批量模式吗,是即为1，否为0");
		// Scanner sc = new Scanner(System.in);
		// if (sc.nextInt() != 1) {
		// System.out.println("删除其他的再来");
		// sc.close();
		// return;
		// }
		// sc.close();
		// }
		// Stack<String> stack = new Stack<>();
		for (int i = 0; i < apkList.length; i++) {
			File file = apkList[i];
			Thread thread = new Thread(new MultiCrack(file));
			thread.start();
		}
		// for (int i = 0; i < apkList.length; i++) {
		// File file = apkList[i];
		// new MultiCrack(file).run();
		// }
		// TODO 自动生成的方法存根

	}
}
