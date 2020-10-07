package com.bridgelabz.velocityapp.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bridgelabz.velocityapp.model.User;

@WebServlet(value = "/velocity-service")
public class ApplicationContoller extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
            // simulate a database query
            List<User> users = new ArrayList<User>();
            for (int i = 0; i < 5; i++) {
                User user = new User("name "+i, "Address "+i);
                users.add(user);
            }
            // set values
            request.setAttribute("users", users);
 
            // get UI
            RequestDispatcher requestDispatcher =  request.getRequestDispatcher("index.vm");
            requestDispatcher.forward(request, response);
        } catch(Exception ex){
        	ex.printStackTrace();
        }
	}
}
