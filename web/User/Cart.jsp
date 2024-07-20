<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="entity.CartItem" %>
<%@ page import="entity.Cart" %>
<%@ page import="entity.Product" %>

<!DOCTYPE html>
<html lang="zxx">

    <head>
        <meta charset="UTF-8">
        <meta name="description" content="Ogani Template">
        <meta name="keywords" content="Ogani, unica, creative, html">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Rau củ tươi G7</title>
        <link rel="icon" type="image/x-icon" href="https://png.pngtree.com/png-clipart/20190705/original/pngtree-vegetable-icon-illustration-png-image_4363827.jpg">


        <!-- Google Font -->
        <link href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap" rel="stylesheet">

        <!-- Css Styles -->
        <link rel="stylesheet" href="../css/bootstrap.min.css" type="text/css">
        <link rel="stylesheet" href="../css/font-awesome.min.css" type="text/css">
        <link rel="stylesheet" href="../css/elegant-icons.css" type="text/css">
        <link rel="stylesheet" href="../css/nice-select.css" type="text/css">
        <link rel="stylesheet" href="../css/jquery-ui.min.css" type="text/css">
        <link rel="stylesheet" href="../css/owl.carousel.min.css" type="text/css">
        <link rel="stylesheet" href="../css/slicknav.min.css" type="text/css">
        <link rel="stylesheet" href="../css/style.css" type="text/css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/popup.css">  <!--  popup-->
    </head>

    <%
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            session.setAttribute("cart", cart);
        }
    %>

    <style>
        .img_cart{
            width: auto;
            max-height: 70px;
        }
         .green-button {
            background-color: #7fad39; /* Background color */
            border: none; /* Remove border */
            color : #b2b2b208;
            padding: 10px 20px; /* Padding for the button */
            text-align: center; /* Center the text */
            text-decoration: none; /* Remove underline */
            display: inline-block; /* Inline block element */
            font-size: 20px; /* Font size */
            margin: 4px 2px; /* Margin */
            cursor: pointer; /* Pointer cursor on hover */
            border-radius: 5px; /* Rounded corners */
        }

        .green-button:hover {
            background-color: darkgreen; /* Darker green on hover */
        }
         .title{
                font-size: 30px;
                font-weight: 700;
                color: #1c1c1c;
                padding-bottom: 20px;}
            
    </style>

    <body>
        <jsp:include page="HeaderUser.jsp"></jsp:include>

            <!--navbar-->
            <div class="container">
                <div class="row">
                    <div class="col-lg-3">
                        <div class="header__logo">
                            <a href="${pageContext.request.contextPath}/home"><img src="https://static.ybox.vn/2021/5/3/1621994139101-LOGOTN.PNG" alt=""></a>
                    </div>
                </div>
                <div class="col-lg-6">
                    <c:if test="${acc.getIsAdmin() == 0}">
                        <nav class="header__menu">
                            <ul>
                                <li><a href="${pageContext.request.contextPath}/home">Trang chủ</a></li>
                                <li><a href="${pageContext.request.contextPath}/User/Profile.jsp">Tài khoản</a></li>
                                <li><a href="${pageContext.request.contextPath}/manageOrderUser">Đơn hàng</a>  
                                <li><a href="${pageContext.request.contextPath}/viewAllFeedback">Xem Đánh giá</a>
                                    <ul class="header__menu__dropdown">
                                        <li><a href="${pageContext.request.contextPath}/viewFeedback">Xem đánh giá của tôi</a></li>
                                    </ul>
                                </li>
                                </li>
                            </ul>
                        </nav>
                    </c:if>    
                    <c:if test="${acc.getIsAdmin() != 1 && acc.getIsAdmin() != 0}">
                        <nav class="header__menu">
                            <ul>
                                <li><a href="${pageContext.request.contextPath}/viewAllFeedback">Xem đánh giá</a></ul></nav>
                            </c:if>
                </div>
                <div class="col-lg-3">
                    <div class="header__cart">
                        <ul>
                            <li><a href="${pageContext.request.contextPath}/User/Cart.jsp"><i class="fa fa-shopping-bag"></i></a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <!-- Shoping Cart Section Begin -->
        <section class="shoping-cart spad">
            <div class="container">
                <div class="row">
                    <h3 class="title">Giỏ Hàng</h3>
                    <div class="col-lg-12">
                        <div class="shoping__cart__table">
                            <table border="1">
                                <thead>
                                    <tr>
                                        <th>Tên Sản Phẩm</th>
                                        <th>Hình Ảnh</th>
                                        <th>Số Lượng</th>
                                        <th>Giá </th>
                                        <th>Tổng Liá</th>
                                        <th>Thao Tác</th>
                                    </tr>
                                    <%  List<CartItem> items = cart.getItems();
                                        for (CartItem item : items) {
                                            Product product = item.getProduct();
                                    %>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td><%= product.getPro_name()%></td>
                                        <td><img class="img_cart"
                                                 src=<%= product.getPro_image()%> alt=""></td>
                                        <td><%= item.getQuantity()%> gói</td>
                                        <td><%= product.getPro_price()%> VNĐ</td>
                                        <td><%= item.getQuantity() * product.getPro_price()%> VNĐ</td>
                                        <td>
                                            <form action="<c:url value='/QuantityUpdateServlet' />" method="post" style="display:inline;">
                                                <input type="hidden" name="pro_id" value="<%= product.getPro_id()%>">
                                                <input type="hidden" name="action" value="increase">
                                                <input type="submit" value="+">
                                            </form>
                                            <form action="<c:url value='/QuantityUpdateServlet' />" method="post" style="display:inline;">
                                                <input type="hidden" name="pro_id" value="<%= product.getPro_id()%>">
                                                <input type="hidden" name="action" value="decrease">
                                                <input type="submit" value="-" <%= item.getQuantity() <= 1 ? "disabled" : ""%>>
                                            </form>
                                            <form action="<c:url value='/QuantityUpdateServlet' />" method="post" style="display:inline;">
                                                <input type="hidden" name="pro_id" value="<%= product.getPro_id()%>">
                                                <input type="hidden" name="action" value="update">
                                                <input type="text" name="quantity" value="<%= item.getQuantity()%>" min="1" style="width: 50px;">
                                                <input type="submit" value="Cập nhật">
                                            </form>
                                            <form action="<c:url value='/RemoveItemServlet' />" method="post" style="display:inline;">
                                                <input type="hidden" name="pro_id" value="<%= product.getPro_id()%>">
                                                <input type="submit" value="x">
                                            </form>
                                        </td>
                                    </tr>
                                    <%
                                        }
                                    %>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-12">
                        <div class="shoping__cart__btns">
                            <a href="<c:url value='/home' />" class="primary-btn cart-btn">Tiếp Tục Mua Hàng</a>

                        </div>
                    </div>
                    <div class="col-lg-6">
                        <div class="shoping__continue">
                            <div class="shoping__discount">
                                <h5>Nhập mã giảm giá</h5>
                                <form action="<c:url value='/applyVoucher' />" method="post" onsubmit="return validateForm()">
                                    <input id="voucherCode" type="text" name="voucherCode" value="${voucherCode}" placeholder="Nhập voucher">
                                    <input class="green-button" type="submit" value="Xác nhận voucher">
                                    <span id="voucherError" class="text-danger"></span>
                                </form>
                            </div>
                        </div>
                        <h6 class="text-danger">${mess}</h6>
                    </div>
                    <div class="col-lg-6">
                        <div class="shoping__checkout">
                            <h5>Thanh Toán</h5>
                            <ul>
                                <li>Tổng tiền<span><%= cart.getTotalPrice()%> VNĐ</span></li>
                                <li>Đã giảm giá<span><%= cart.getTotalfinal()%> VNĐ</span></li>
                            </ul>

                            <c:if test="${acc.getIsAdmin() != 0 && acc.getIsAdmin() !=1}">
                                <a href="../Login.jsp" class="primary-btn">Đặt Hàng</a>
                            </c:if>
                            <c:if test="${acc.getIsAdmin() == 0}">
                                <a href="${pageContext.request.contextPath}/User/Checkout.jsp" class="primary-btn">Đặt Hàng</a>
                            </c:if>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- Shoping Cart Section End -->
   <!--popup-->
            <div id="myModal" class="modal" style="display: ${messSuccess ? 'block' : 'none'};">
                <div class="modal-content">
                    <span class="close">&times;</span>
                    <p id="popupMessage" class="text-succes">${messSuccess}</p>
                </div>
            </div>

    </div>-->
    <script src="js/popup.js"></script>

    <script>
                                    function validateForm() {
                                        var voucherCode = document.getElementById("voucherCode").value;
                                        var voucherError = document.getElementById("voucherError");
                                        var hasError = false;

                                        if (voucherCode === "") {
                                            voucherError.innerText = "Điền vào ô này";
                                            hasError = true;
                                        } else {
                                            voucherError.innerText = "";
                                        }

                                        return !hasError;
                                    }
    </script>    


    <!-- Js Plugins -->
    <script src="js/jquery-3.3.1.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/jquery.nice-select.min.js"></script>
    <script src="js/jquery-ui.min.js"></script>
    <script src="js/jquery.slicknav.js"></script>
    <script src="js/mixitup.min.js"></script>
    <script src="js/owl.carousel.min.js"></script>
    <script src="js/main.js"></script>
</body>
</html>