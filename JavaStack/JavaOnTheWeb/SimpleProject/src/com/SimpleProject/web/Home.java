package com.SimpleProject.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Home
 */
@WebServlet("/Home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Home() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        String firstName = request.getParameter("firstname");
        String lastName = request.getParameter("lastname");
        String language = request.getParameter("language");
        String hometown = request.getParameter("hometown");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        if(firstName != null && lastName != null) {
        out.write("<h1>Welcome, " + firstName +" "+ lastName +"</h1><br>");}
        else if(firstName != null && lastName == null) {
        	out.write("<h1>Welcome "+ firstName +" UnKnown </h1><br>");}
        else if(firstName == null && lastName != null) {
            out.write("<h1>Welcome, UnKnown "+ lastName + "</h1><br>");}
        else
            out.write("<h1>Welcome, UnKnown UnKnown </h1><br>");
        
        if(language != null) {
        out.write("<h3>Your Favorite Language is: " + language + "</h3><br>");}
        else
        	out.write("<h3>Your Favorite Language is: UnKnown</h3><br>");
        if (hometown != null) {
        out.write("<h3>Your HomeTown is: " + hometown + "</h3>");}
        else
        	out.write("<h3>Your HomeTown is: UnKnown</h3>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
