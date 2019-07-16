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

@WebServlet("/QuestionServlet")
public class QuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public QuestionServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession ses = request.getSession();
		if (ses !=null) {
			ses.invalidate();
		}
		response.sendRedirect("index.html");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		char guess = (request.getParameter("character_guess")).charAt(0);

		int life_count = 5;
		char[] answer = {'A','A','S','H','U','T','O','S','H'};
		char[] displayedAnswer = {'*', '*', '*', '*', '*', '*', '*', '*', '*'};
		//validate
		
		HttpSession ses = request.getSession(true);
		ses.setAttribute("display",displayedAnswer );
		ses.setAttribute("answer", answer);
		ses.setAttribute("lives", life_count);
		ses.setAttribute("guessedChar", guess);
		response.sendRedirect("question.jsp");
	}

}
