package com;

import java.io.File;

public class MultiCrack implements Runnable {
	File urlFile;

	public MultiCrack(File url) {
		// TODO �Զ����ɵĹ��캯�����
		this.urlFile = url;
	}

	@Override
	public void run() {
		// TODO �Զ����ɵķ������
		UnZipApk unz = new UnZipApk();
		unz.AntiApk(urlFile);
		// UnZipApk unz = new UnZipApk();
		EditSmali eds = new EditSmali();
		ZipApk zip = new ZipApk();
		EditManifest emf = new EditManifest();
		// unz.AntiApk();// ��ѹAPK
		String fileName = urlFile.getName();
		String fileDir = fileName.substring(0, fileName.length() - 4);
		emf.fuckingManifest(fileDir + "\\AndroidManifest.xml");
		eds.smaliEdit(fileDir
				+ "\\smali\\com\\muzhiwan\\sdk\\MzwShellActivity.smali");// �༭��smaliʹ������һ��ҳ����ӳٽ�Ϊ0
		eds.antiSignCheck(fileDir
				+ "\\smali\\com\\muzhiwan\\sdk\\utils\\Env.smali");// �༭��smaliȥ��ǩ����֤
		zip.zippo(fileDir);
		File apkNeedSign = new File(fileDir + "\\dist\\" + fileName);
		File nextApk = new File(".", "unsigned_" + fileName);
		apkNeedSign.renameTo(nextApk);
		apkNeedSign.delete();

	}

}
