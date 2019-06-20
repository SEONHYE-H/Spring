package com.kitri.util;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MoveUrl {
	public static void redirect(HttpServletRequest request, HttpServletResponse response, String path) throws IOException {
		response.sendRedirect(request.getContextPath() + path);	//root는 여기서 다 처리한다!!
	}
	
	public static void forward(HttpServletRequest request, HttpServletResponse response, String path) throws IOException, ServletException {
		RequestDispatcher dispartcher = request.getRequestDispatcher(path);// forward는 내 안에서만 이동가능...?정신좀..
		dispartcher.forward(request, response);
	}
}
