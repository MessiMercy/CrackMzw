package com;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class EditSmali {
	public boolean antiSignCheck(String url) {
		boolean flag = true;
		System.out.println("Editing signcheck!");
		try {
			RandomAccessFile raf = new RandomAccessFile(new File(url), "rw");
			String str = "";
			StringBuilder sbb = new StringBuilder();
			while ((str = raf.readLine()) != null) {
				if (str.contains("if-ne v0, v1,")) {
					sbb.append("    if-eq v0, v1, :cond_0" + "\r\n");
				} else {
					sbb.append(str + "\r\n");
				}

			}
			raf.seek(0);
			String res = new String(sbb.toString().getBytes("iso-8859-1"),
					"utf-8");
			raf.write(res.getBytes("utf-8"));
			// randomAccessFile.close();
			raf.close();
		} catch (FileNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return false;
		}
		System.out.println("edit smali finished!");
		return flag;
	}

	public boolean smaliEdit(String url) {
		boolean flag = true;
		System.out.println("Editing smali!");
		try {
			RandomAccessFile raf = new RandomAccessFile(new File(url), "rw");
			String str = "";
			StringBuilder sbb = new StringBuilder();
			while ((str = raf.readLine()) != null) {
				if (str.contains("const-wide/16")) {
					sbb.append("    const-wide/16 v8, 0x0" + "\r\n");
				} else {

					if (str.contains("addView")) {
						sbb.append("#" + str + "\r\n");
					} else {
						sbb.append(str + "\r\n");
					}
				}

			}
			raf.seek(0);
			String res = new String(sbb.toString().getBytes("iso-8859-1"),
					"utf-8");
			raf.write(res.getBytes("utf-8"));
			// randomAccessFile.close();
			raf.close();
		} catch (FileNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return false;
		}
		System.out.println("edit smali finished!");
		return flag;
	}
}
