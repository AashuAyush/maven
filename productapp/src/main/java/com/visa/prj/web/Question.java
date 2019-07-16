package com.visa.prj.web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.visa.prj.entity.Product;


@WebServlet("/question")
public class Question extends HttpServlet {
	private static final long serialVersionUID = 1L;

	int life_count = 5;
	char[] answer = {'A','A','S','H','U','T','O','S','H'};
	char[] displayedAnswer = {'*', '*', '*', '*', '*', '*', '*', '*', '*'};
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
			request.setAttribute("display", displayedAnswer); //saving products into products key in request object
			request.setAttribute("lives left", life_count);
			request.getRequestDispatcher("question.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strTry = request.getParameter("character");
		 
		int index =0;
			for(char c : answer) {
				
				if (strTry.charAt(0) == c) {
					displayedAnswer[index] = c;
			}else {
				life_count--;
			}
				index++;
		}
		HttpSession ses = request.getSession(true);
		ses.setAttribute("display", displayedAnswer);
		response.sendRedirect("question.jsp");
		
	}

}
