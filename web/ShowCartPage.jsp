<%-- 
    Document   : ShowCartPage
    Created on : Jun 27, 2024, 4:58:46 PM
    Author     : Nhatthang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cart Page</title>
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
        <c:set var="items" value="${sessionScope.cart.items}"/>
        <form action="DispatcherController">
            <c:if test="${items == null}">
                <h1>No book in your cart</h1>
                <button type="submit" name="action" value="BookStorePage">Back to book store</button>
            </c:if>
            <c:if test="${items != null}">
                <h1>Cart</h1>
                <table>
                    <thead>
                        <tr>
                            <th>No</th>
                            <th>title</th>
                            <th>Quantity</th>
                            <th>Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${items}" var="item" varStatus="loopStatus">
                            <tr>
                                <td>${loopStatus.count}</td>
                                <td>${item.key}</td>
                                <td>${item.value}</td>
                                <td>
                                    <input type="checkbox" name="rmItemName" value="${item.key}">
                                </td>
                            </tr>
                        </c:forEach>
                        <tr>
                            <td colspan="3">
                                <button type="submit" name="action" value="BookStorePage">Back to book store</button>
                            </td>
                            <td>
                                <button type="submit" name="action" value="RemoveItem">Remove</button>
                            </td>
                        </tr>

                    </tbody>
                </table>
            </c:if>
        </form>
    </body>
</html>
