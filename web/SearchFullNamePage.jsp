<%-- 
    Document   : search_result
    Created on : Jun 20, 2024, 4:36:32 PM
    Author     : Nhatthang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib tagdir="/WEB-INF/tags/" prefix="myTag" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Full Name Page</title>

        <style>
            table {
                width: 100%;
                border-collapse: collapse; /* Gộp các đường viền để không có khoảng cách giữa chúng */
            }
            th, td {
                border: 1px solid black; /* Đặt đường viền cho các ô */
                padding: 8px; /* Khoảng cách giữa nội dung và đường viền */
                text-align: left; /* Căn lề trái cho nội dung */
            }
            th {
                background-color: #f2f2f2; /* Màu nền cho tiêu đề bảng */
            }
        </style>
    </head>
    <body>
        <h1>
            Welcome ${cookie.username.value}
        </h1>
        
        <h1>Search input</h1>
        <form action="DispatcherController">
            <input type="text" id="" name="searchValue" value="${param.searchValue}">
            <button type="submit" name="action" value="SearchFullName">Search</button>
        </form>


        <c:if test="${requestScope.userList != null}">
            <h1>Search Result</h1>
            <table>
                <thead>
                    <tr>
                        <th>No</th>
                        <th>Username</th>
                        <th>Password</th>
                        <th>FirstName</th>
                        <th>LastName</th>
                        <th>Role</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${requestScope.userList}" var="user" varStatus="loopStatus">
                        <tr>
                            <td>${loopStatus.count}</td>
                            <td>${user.username}</td>
                            <td>${user.password}</td>
                            <td>${user.firstName}</td>
                            <td>${user.lastName}</td>
                            <td>${user.role}</td>
                            <td>
                                <form action="DispatcherController" method="POST">
                                    <input type="hidden" name="userId" value="${user.userId}">
                                    <input type="hidden" name="searchValue" value="${param.searchValue}">
                                    <button type="submit" name="action" value="DeleteUser">Delete</button>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:if>
            <h2>My Data Grid</h2>
            <myTag:myDataGrid
    </body>
</html>
