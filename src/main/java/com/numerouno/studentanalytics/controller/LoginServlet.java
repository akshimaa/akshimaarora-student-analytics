/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.numerouno.studentanalytics.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * LoginServlet is used to login to the application
 *
 * @author madan
 */
public class LoginServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request the user to login their facebook id
     * @param response servlet response responds by logging in using this id as
     * credential
     * @throws ServletException is thrown if a servlet-specific error occurs
     * @throws IOException is thrown if an I/O error occurs during the execution
     * of the code
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accessToken = request.getParameter("fbToken");
        String userID = request.getParameter("fbUser");
        HttpSession session = request.getSession();
        session.setAttribute("accessToken", accessToken);
        session.setAttribute("userID", userID);
        response.sendRedirect(request.getContextPath() + "/index");
        Logger log = Logger.getLogger(LoginServlet.class.getName());
        log.info("Request dispatched! ".concat(accessToken));
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet requests for the login information of the user to
     * allow it to sign using facebook
     * @param response servlet response responds by logging in using the
     * credentials performed by the user
     * @throws ServletException is thrown if a servlet-specific error occurs
     * during the execution of the code
     * @throws IOException is thrown if an I/O error occurs during the execution
     * of the code
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request is processes the user inputted data
     * @param response servlet responds by processing the request of servlet and
     * logging in
     * @throws ServletException is thrown if a servlet-specific error occurs
     * @throws IOException is thrown if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
