package com;

import java.io.File;

public class Mian {
	// Ŀǰ�ڽ���xml���滹������
	public static void main(String[] args) {
		FileAccept fa = new FileAccept();
		fa.setName("apk");
		File rootDir = new File(".");
		// System.out.println(rootDir.getAbsolutePath());
		File[] apkList = rootDir.listFiles(fa);
		// System.out.println(apkList.length);
		// if (apkList.length != 1) {//�����ֶ����ƶ��ؽ���
		// System.out.println("��������ģʽ��,�Ǽ�Ϊ1����Ϊ0");
		// Scanner sc = new Scanner(System.in);
		// if (sc.nextInt() != 1) {
		// System.out.println("ɾ������������");
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
		// TODO �Զ����ɵķ������

	}
}
