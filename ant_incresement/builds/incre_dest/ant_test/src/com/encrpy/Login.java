package com.encrpy;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/login")
public class Login  extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		         //一般都会在doGet()方法中调用doPost()方法，或者在doPost()方法中调用doGet()方法
		         doPost(request, response);
		     }
	
	
	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String password = request.getParameter("test");
		 String pwd  = RSAUtils.decryptStringByJs(password);
         System.out.println("pqssswddd===="+pwd);
		 
	 }
	 
	 public void testddd(){
		 
	 }
	 
	 public void testddd2(){
		 
	 }
}	
