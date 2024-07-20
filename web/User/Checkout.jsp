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
        .text-succes{
            color: green
        }
        .text-danger{
            margin: 20px;
            color: red;
        }

        /*popup*/
        .modal {
            display: none;
            position: fixed;
            z-index: 1; 
            left: 0;
            top: 0;
            width: 100%;
            height: 100%; 
            overflow: auto;
            background-color: rgb(0,0,0); 
            background-color: rgba(0,0,0,0.4); 
            display: flex;
            align-items: center;
            justify-content: center;
        }

        .modal-content {
            background-color: #fefefe;
            margin: auto;
            padding: 20px;
            border: 1px solid #888;
            width: 80%;
            max-width: 400px;
            text-align: center;
        }

        .close {
            color: #aaa;
            float: right;
            font-size: 28px;
            font-weight: bold;
        }

        .close:hover,
        .close:focus {
            color: black;
            text-decoration: none;
            cursor: pointer;
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

                </div>
                <div class="col-lg-3">
                    <div class="header__cart">
                        <ul>
                            <li><a href="Cart.jsp"><i class="fa fa-shopping-bag"></i></a></li>
                        </ul>
                        <!--<div class="header__cart__price">item: <span>$150.00</span></div>-->
                    </div>
                </div>
            </div>
        </div>

        <!-- Shoping Cart Section Begin -->
        <section class="shoping-cart spad">
            <div class="container">
                <div class="row">
                    <h3 class="title">Xác Nhận Đơn Hàng</h3>
                    <div class="col-lg-12">
                        <div class="shoping__cart__table">
                            <table border="1">
                                <thead>
                                    <tr>
                                        <th>Tên Sản Phẩm</th>
                                        <th>Hình Ảnh</th>
                                        <th>Số Lượng</th>
                                        <th>Giá </th>
                                        <th>Tổng Giá</th>
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
                                        <td><%= product.getPro_price()%></td>
                                        <td><%= item.getQuantity() * product.getPro_price()%></td>

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
                    </div>
                    <div class="col-lg-6">
<!--                        <div class="shoping__checkout">
                            <form action="processCheckout" method="post">
                                <label for="name"> Tên :</label>
                                <input type="text" id="name" name="name" required><br>

                                <label for="address"> Địa chỉ </label>
                                <input type="text" id="address" name="address" required><br>


                                <label for="phone"> Số điện thoại </label>
                                <input type="text" id="phone" name="phone" required><br>
                            </form>
                        </div>-->
                    </div>
                    <div class="col-lg-6">
                        <div class="shoping__checkout">
                            <h5>Thanh Toán</h5>
                            <ul>
                                <li>Tổng tiền<span><%= cart.getTotalPrice()%></span></li>
                                <li>Đã giảm giá<span><%= cart.getTotalfinal()%></span></li>
                            </ul>
                            <form action="../check-out" method="GET">
                                <input type="submit" value="Xác Nhận Đặt Hàng" class="primary-btn"> 
                            </form>
                        </div>
                    </div>
                </div>
            </div>

        </section>
        <!-- Shoping Cart Section End -->

        <!-- Footer Section End -->

        <!-- Js Plugins -->
        <script src="js/popup.js"></script>
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