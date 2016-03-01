package com;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class EditManifest {
	void fuckingManifest(String url) {
		System.out.println("editing manifest");
		File manifest = new File(url);
		long size = manifest.length();
		try {
			RandomAccessFile raf = new RandomAccessFile(manifest, "rw");
			String temp = "";
			StringBuilder sb = new StringBuilder();
			while ((temp = raf.readLine()) != null) {
				if (temp.contains("NGDS_APPID") || temp.contains("NGDS_APPKEY")) {
					continue;
				}
				sb.append(temp + "\r\n");
			}
			long finalsize = sb.length();
			raf.seek(0);
			raf.write(new String(sb.toString().getBytes("iso8859-1"), "utf-8")
					.getBytes());
			while (finalsize <= size) {// 末尾不足，补齐空格
				raf.write(" ".getBytes());
				finalsize++;
			}
			raf.close();

		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		System.out.println("edit manifest done");
	}
}
