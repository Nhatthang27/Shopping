/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package sample.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Nhatthang
 */
public class DispatcherController extends HttpServlet {

    ServletContext sc = null;

    private String INVALID_PAGE = "InvalidPage.html";

    private String LOGIN_PAGE = "LoginPage.html";
    private String LOGIN_CONTROLLER = "LoginController";

    private String SEARCH_FULLNAME_PAGE = "SearchFullNamePage.jsp";
    private String SEARCH_FULLNAME_CONTROLLER = "SearchFullNameController";

    private String DELETE_USER_CONTROLLER = "DeleteUserController";

    private String NULL_CONTROLLER = "NullController";

    private String BOOKSTORE_PAGE = "BookStorePage.html";

    private String SHOW_CART_PAGE = "ShowCartPage.jsp";

    private String ADD_ITEM_CONTROLLER = "AddItemController";

    private String REMOVE_ITEM_CONTROLLER = "RemoveItemController";
    
    private String CREATE_USER_PAGE = "CreateUserPage.jsp";
    private String CREATE_USER_CONTROLLER = "CreateUserController";

   
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        
        System.out.println("DispatcherController");
        String action = request.getParameter("action");
        System.out.println("action in Dispatcher: " + action);
        String url = INVALID_PAGE;
        try {
            if (action == null) {
                url = NULL_CONTROLLER;
            } else if (action.equals("Login")) {
                url = LOGIN_CONTROLLER;
            } else if (action.equals("LoginPage")) {
                url = LOGIN_PAGE;
            } else if (action.equals("SearchFullName")) {
                url = SEARCH_FULLNAME_CONTROLLER;
            } else if (action.equals("SearchFullNamePage")) {
                url = SEARCH_FULLNAME_PAGE;
            } else if (action.equals("InvalidPage")) {
                url = INVALID_PAGE;
            } else if (action.equals("DeleteUser")) {
                url = DELETE_USER_CONTROLLER;
            } else if (action.equals("BookStorePage")) {
                url = BOOKSTORE_PAGE;
            } else if (action.equals("ShowCartPage")) {
                url = SHOW_CART_PAGE;
            } else if (action.equals("AddItem")) {
                url = ADD_ITEM_CONTROLLER;
            } else if (action.equals("RemoveItem")) {
                url = REMOVE_ITEM_CONTROLLER;
            } else if (action.equals("CreateUserPage")) {
                url = CREATE_USER_PAGE;
            } else if (action.equals("CreateUser")) {
                url = CREATE_USER_CONTROLLER;
            }
        } finally {
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
        }
    }

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
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
