package com.example.lab10.model.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ServletCliente", value = "/inicio")
public class ServletCliente extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher vista;
        String action = request.getParameter("action")==null? "inicio":request.getParameter("action");

        switch (action){
            case "inicio":

                vista = request.getRequestDispatcher("cliente.jsp");
                vista.forward(request, response);

        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
