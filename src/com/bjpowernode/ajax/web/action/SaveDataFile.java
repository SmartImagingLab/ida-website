package com.bjpowernode.ajax.web.action;

import java.io.File;
import java.io.IOException;

public class SaveDataFile {
    
	public static void creatFile(String filePath, String fileName) {
        File folder = new File(filePath);
        //文件夹路径不存在
        if (!folder.exists() && !folder.isDirectory()) {
            System.out.println("文件夹路径不存在，创建路径:" + filePath);
            folder.mkdirs();
        } else {
            System.out.println("文件夹路径存在:" + filePath);
        }

        // 如果文件不存在就创建
        File file = new File(filePath + fileName);
        if (!file.exists()) {
            System.out.println("文件不存在，创建文件:" + filePath + fileName);
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("文件已存在，文件为:" + filePath + fileName);
        }
    }


}
