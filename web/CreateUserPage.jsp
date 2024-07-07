<%-- 
    Document   : CreateUserPage
    Created on : Jun 29, 2024, 11:09:11 AM
    Author     : Nhatthang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create User Page</title>
        <style>
            .text-red {
                color: red;
            }
        </style>
    </head>

    <body>
        <h1>Create User Page</h1>
        <form action="DispatcherController">
            <p class="text-red">${requestScope.createUserError.usernameLenErr}</p>
            <p class="text-red">${requestScope.createUserError.usernameExist}</p>
            Username <input type="text" name="username" value="${requestScope.newUser.username}"><br>
            
            <p class="text-red">${requestScope.createUserError.passwordLenErr}</p>
            Password <input type="password" name="password" value="${requestScope.newUser.password}"><br>
            
            <p class="text-red">${requestScope.createUserError.confirmNotMatch}</p>
            Confirm <input type="password" name="cPassword" value=""><br>
            
            <p class="text-red">${requestScope.createUserError.firstNameLenErr}</p>
            First Name <input type="text" name="firstName" value="${requestScope.newUser.firstName}"><br>
            <button type="submit" name="action" value="CreateUser">Sign up</button>
            <a href="DispatcherController?action=LoginPage">
                <button type="button">
                    Cancel
                </button>
            </a>
        </form>
    </body>
</html>
