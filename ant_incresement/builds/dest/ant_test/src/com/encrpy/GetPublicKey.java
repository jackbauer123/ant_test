package com.encrpy;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

//@WebServlet("getPublicKey")
public class GetPublicKey extends HttpServlet {
	
	private Object json;

	public Object getJson() {
		return json;
	}

	public void setJson(Object json) {
		this.json = json;
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //一般都会在doGet()方法中调用doPost()方法，或者在doPost()方法中调用doGet()方法
        doPost(request, response);
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PublicKeyMap publicKeyMap = RSAUtils.getPublicKeyMap();
        System.out.println(publicKeyMap);
        setJson(publicKeyMap);
        JSONObject outData = new JSONObject();
        outData.put("exponent", publicKeyMap.getExponent());
        outData.put("modulus", publicKeyMap.getModulus());
        
        response.getWriter().print(outData);
	}
	public void test(){
		
	}
	public void test2(){
		
	}
	
}
