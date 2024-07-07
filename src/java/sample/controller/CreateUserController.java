/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package sample.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sample.model.account.CreateUserError;
import sample.model.user.UserDAO;
import sample.model.user.UserDTO;

/**
 *
 * @author Nhatthang
 */
public class CreateUserController extends HttpServlet {

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
        boolean err = false;
        CreateUserError createUserError = new CreateUserError();
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String cPassword = request.getParameter("cPassword");
        String firstName = request.getParameter("firstName");
        
        UserDTO newUser = new UserDTO(username, password, firstName);

        if (username.trim().length() < 6 || username.trim().length() > 50) {
            createUserError.setUsernameLenErr("Username must be [6 - 50] characters !");
            err = true;
        }
        
        if (password.trim().length() < 6 || password.trim().length() > 50) {
           createUserError.setPasswordLenErr("Password must be [6 - 50] characters !");
           err = true;
        } else if (!password.trim().equals(cPassword.trim())) {
            createUserError.setConfirmNotMatch("Password and confirm does not match !");
            err = true;
        }
        
        if (firstName.trim().length() < 6 || firstName.trim().length() > 50) {
            createUserError.setFirstNameLenErr("FirstName must be [6 - 50] characters !");
            err = true;
        }
        
        String action = "CreateUserPage";
        System.out.println("err: " + err);
        System.out.println("userError: " + createUserError);
        if (err) {
            request.setAttribute("newUser", newUser);
            request.setAttribute("createUserError", createUserError);
        } else {
            UserDAO uDao = new UserDAO(getServletContext());
            try {
                if (uDao.insert(newUser) > 0) {
                    action = "LoginPage";
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(CreateUserController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                createUserError.setUsernameExist(username + " already existed !");
                request.setAttribute("newUser", newUser);
                request.setAttribute("createUserError", createUserError);
            }
        }
        request.getRequestDispatcher("DispatcherController?action=" + action).forward(request, response);
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
