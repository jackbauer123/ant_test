package com.yuan.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintStream;

public class ExportIncrementFiles {
	private static void export(String configPath, String baseDir, String destDir) throws Exception {
		String srcFile = baseDir +File.separatorChar+ configPath;
		String desFile = destDir +File.separatorChar+ configPath;
		int lastIndex = desFile.lastIndexOf("/");
		String desPath = desFile.substring(0, lastIndex);
		
		File srcF = new File(srcFile);
		if (srcF.exists()) {
			File desF = new File(desFile);
			File desP = new File(desPath);
			if (!(desP.exists())) {
				desP.mkdirs();
			}
			System.out.println(srcFile);
			FileInputStream fis = new FileInputStream(srcF);
			FileOutputStream fos = new FileOutputStream(desF);

			byte[] buf = new byte[1024];
			int len = 0;
			while ((len = fis.read(buf)) != -1) {
				fos.write(buf, 0, len);
			}
			fos.flush();
			fos.close();
			fis.close();
		}
	}

	public static void main(String[] args) {
		
		if (args.length > 0)
			if ((args.length == 1) && ("help".equals(args[0]))) {
				System.out.println("args[0] is Export Increment Files content path");
				System.out.println("args[1] is Export Increment Files target path");
				System.out.println("args[2] is Increment Files Export loaction");
			} else {
				String configPath = args[0];
				String baseDir = args[1];
				String destDir = args[2];
				try {
					BufferedReader br = new BufferedReader(new FileReader(configPath));
					String s = null;
					while ((s = br.readLine()) != null) {
						s = s.trim();
						String str = destDir +File.separatorChar+ s;
						if (!(destDir.equals(str))) {
							export(s, baseDir, destDir);
						}
					}
					br.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
	}
}