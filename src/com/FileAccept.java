package com;

import java.io.File;
import java.io.FilenameFilter;

public class FileAccept implements FilenameFilter {

	// @Override
	String extendsName;

	public void setName(String s) {
		extendsName = "." + s;
	}

	public boolean accept(File dir, String name) {
		// TODO �Զ����ɵķ������
		return name.endsWith(extendsName);
	}

}
