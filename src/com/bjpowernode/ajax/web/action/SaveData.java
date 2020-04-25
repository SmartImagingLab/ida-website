package com.bjpowernode.ajax.web.action;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SaveData extends HttpServlet {
	public static final String FILE_NAME = "Output.txt";//要创建的文件名
    //public static final String FILE_PATH = "f:/OrderSplit/";//文件指定存放的路径
	public static final String FILE_PATH = "C:\\Users\\418\\Desktop\\标记平台结果\\";

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		//获取用户名
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String num_path = request.getParameter("NumPath");
		
		System.out.println(username);
		String filename = num_path + ".txt";
		//String jsondata = request.getParameter("wewant");
		//链接数据库验证用户名是否存在
		FileOutputStream outFile = null;

        try {
        	String PATH = FILE_PATH + username + "\\";
            SaveDataFile.creatFile(PATH, filename);
            outFile = new FileOutputStream(PATH + filename);
     	   	outFile.write(password.getBytes());
     		//关闭流资源
     	   	outFile.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                outFile.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
	}

}
