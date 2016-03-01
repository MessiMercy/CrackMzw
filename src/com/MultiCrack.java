package com;

import java.io.File;

public class MultiCrack implements Runnable {
	File urlFile;

	public MultiCrack(File url) {
		// TODO 自动生成的构造函数存根
		this.urlFile = url;
	}

	@Override
	public void run() {
		// TODO 自动生成的方法存根
		UnZipApk unz = new UnZipApk();
		unz.AntiApk(urlFile);
		// UnZipApk unz = new UnZipApk();
		EditSmali eds = new EditSmali();
		ZipApk zip = new ZipApk();
		EditManifest emf = new EditManifest();
		// unz.AntiApk();// 解压APK
		String fileName = urlFile.getName();
		String fileDir = fileName.substring(0, fileName.length() - 4);
		emf.fuckingManifest(fileDir + "\\AndroidManifest.xml");
		eds.smaliEdit(fileDir
				+ "\\smali\\com\\muzhiwan\\sdk\\MzwShellActivity.smali");// 编辑该smali使加载下一个页面的延迟降为0
		eds.antiSignCheck(fileDir
				+ "\\smali\\com\\muzhiwan\\sdk\\utils\\Env.smali");// 编辑该smali去除签名验证
		zip.zippo(fileDir);
		File apkNeedSign = new File(fileDir + "\\dist\\" + fileName);
		File nextApk = new File(".", "unsigned_" + fileName);
		apkNeedSign.renameTo(nextApk);
		apkNeedSign.delete();

	}

}
