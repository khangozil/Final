<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

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
        <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
        <link rel="stylesheet" href="css/font-awesome.min.css" type="text/css">
        <link rel="stylesheet" href="css/elegant-icons.css" type="text/css">
        <link rel="stylesheet" href="css/nice-select.css" type="text/css">
        <link rel="stylesheet" href="css/jquery-ui.min.css" type="text/css">
        <link rel="stylesheet" href="css/owl.carousel.min.css" type="text/css">
        <link rel="stylesheet" href="css/slicknav.min.css" type="text/css">
        <link rel="stylesheet" href="css/style.css" type="text/css">
        <style>
            .img_cart{
                width: auto;
                max-height: 70px;
            }
            .title{
                font-size: 30px;
                font-weight: 700;
                color: #1c1c1c;
                padding-bottom: 20px;}
            
            .button {
                font-size: 14px;
                color: #ffffff;
                /*font-weight: 300;*/
                text-transform: uppercase;
                display: inline-block;
                padding: 13px 30px 12px;
                background: #7fad39;
                border-radius: 30px;
            }
            .link{
                color: grey;
            }
        </style>
    </head>

    <body>
        <jsp:include page="../User/HeaderUser.jsp"></jsp:include>
            <div class="container">
                <div class="row">
                    <div class="col-lg-3">
                        <div class="header__logo">
                            <a href="home"><img src="https://static.ybox.vn/2021/5/3/1621994139101-LOGOTN.PNG" alt=""></a>
                        </div>
                    </div>
                    <div class="col-lg-6">
                        <!--guest kh hiển thị navbar-->
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

        <div class="container">
            <h3 class="title">Quản Lý Đơn Hàng</h3>
            <table class="table table-bordered mt-3">
                <thead>
                    <tr>
                        <th>Mã Đơn Hàng</th>
                        <th>Tổng Giá</th>
                        <th>Ngày Đặt</th>
                        <th>Mã Giảm Giá</th>
                        <th>Chi Tiết</th>
                        <th>Đánh Giá</th>
                    </tr>
                </thead>
                <c:forEach var="order" items="${orders}">
                    <tbody>
                        <tr>
                            <td>${order.order_id}</td>
                            <td>${order.total_price}</td>
                            <td>${order.order_date}</td>
                            <td>${order.voucher_id}</td>
                            <td>
                                <a href="viewOrderDetails?order_id=${order.order_id}" class="link">Xem Chi Tiết</a>
                            </td>
                            <td>
                                <a href="User/GiveFeedback.jsp" class="link" >Đánh giá</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>

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
