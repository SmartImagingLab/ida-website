package com.bjpowernode.ajax.web.action;


import java.io.File;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.sun.javafx.collections.MappingChange.Map;

//此类用于处理登录界面请求

public class LoginAction2 extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		UserMap.setMap();
		Object map = UserMap.getMap();
		PrintWriter out = response.getWriter();
		
		//获取用户名
		String studentid = request.getParameter("StudentId");
		String studentname = request.getParameter("StudentName");
		System.out.println("登录成功！！！");
        
        if(((HashMap) map).containsKey(studentid)){
			if(((HashMap) map).containsValue(studentname)){
				out.print("正确");
				// 将参数放入request域
				request.setAttribute("studentid", studentid);
				request.setAttribute("userName",studentid);
				
				// 获取Session对象
				HttpSession session = request.getSession();
				// 向Session域中写入属性
				session.setAttribute("studentid", studentid);
				session.setAttribute("studentname", studentname);
			}else{
				out.print("姓名错误");
			}
		}
		else{
			out.print("学号错误");
		}
	}

}
