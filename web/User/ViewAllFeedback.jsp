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
        <!--        <link rel="stylesheet" href="../css/bootstrap.min.css" type="text/css">
                <link rel="stylesheet" href="../css/font-awesome.min.css" type="text/css">
                <link rel="stylesheet" href="../css/elegant-icons.css" type="text/css">
                <link rel="stylesheet" href="../css/nice-select.css" type="text/css">
                <link rel="stylesheet" href="../css/jquery-ui.min.css" type="text/css">
                <link rel="stylesheet" href="../css/owl.carousel.min.css" type="text/css">
                <link rel="stylesheet" href="../css/slicknav.min.css" type="text/css">
               <link rel="stylesheet" href="../css/style.css" type="text/css">-->

        <link rel="stylesheet" href="../css/style.css" type="text/css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/popup.css">  <!--  popup-->

        <style>
            .title{
                font-size: 30px;
                font-weight: 700;
                color: #1c1c1c;
                padding-bottom: 20px;}
            
        </style>
    </head>

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
                                <li><a href="${pageContext.request.contextPath}/home">Trang chủ</a></li>
                                <li><a href="${pageContext.request.contextPath}/viewAllFeedback">Xem đánh giá</a></li>
                            </ul>
                        </nav>
                    </c:if>

                </div>
                <div class="col-lg-3">
                    <div class="header__cart">
                        <ul>
                            <li><a href="User/Cart.jsp"><i class="fa fa-shopping-bag"></i></a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>

        <!-- Shoping Cart Section Begin -->
        <div class="container">
            <div class="row">
                <h3 class="title">Tất Cả Đánh Giá</h3>
                <div class="col-lg-12">
                    <!--<div class="shoping__cart__table">-->
                    <table class="table table-bordered mt-3">
                        <thead>
                            <tr>
                                <th>Tài Khoản</th>
                                <th>Nội Dung</th>
                                <th>Thời Gian</th>
                            </tr>
                        </thead>                              
                        <c:forEach items="${listMF}" var="o">
                            <tbody>
                                <tr>
                                    <td>${o.getAcc_id()}</td>
                                    <td> ${o.getFb_content()}</td>
                                    <td>${o.getFb_date()}</td>
                                </tr>
                            </tbody>
                        </c:forEach>
                    </table>
                </div>
            </div>
        </div>
    </div>
    <div id="myModal" class="modal" style="display: ${messSuccess ? 'block' : 'none'};">
        <div class="modal-content">
            <span class="close">&times;</span>
            <p id="popupMessage" class="text-succes">${messSuccess}</p>
        </div>
    </div>
    <!-- Shoping Cart Section End -->

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