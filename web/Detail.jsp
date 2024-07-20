<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="entity.Product" %>
<%
    Product product = (Product) request.getAttribute("product");
%>
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
    </head>

    <body>
        <jsp:include page="Header.jsp"></jsp:include>
            <!--navbar-->
            <div class="container">
                <!--for user-->
            <c:if test="${acc.getIsAdmin() == 0}">
                <div class="row">
                    <div class="col-lg-3">
                        <div class="header__logo">
                            <a href="home"><img src="https://static.ybox.vn/2021/5/3/1621994139101-LOGOTN.PNG" alt=""></a>
                        </div>
                    </div>
                    <div class="col-lg-6">

                        <nav class="header__menu">
                            <ul>
                                <li><a href="${pageContext.request.contextPath}/home">Trang chủ</a></li>
                                <li><a href="${pageContext.request.contextPath}/User/Profile.jsp">Tài khoản</a></li>
                                <li><a href="${pageContext.request.contextPath}/manageOrderUser">Đơn hàng</a></li>
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
                                <li><a href="User/Cart.jsp"><i class="fa fa-shopping-bag"></i> </a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </c:if>
            <!--for admin-->
            <c:if test="${acc.getIsAdmin() == 1}">
                <div class="row">
                    <div class="col-lg-3">
                        <div class="header__logo">
                            <a><img src="https://static.ybox.vn/2021/5/3/1621994139101-LOGOTN.PNG" alt=""></a>
                        </div>
                    </div>
                    <div class="col-lg-9">

                        <nav class="header__menu">
                            <ul>
                                <li><a href="manageProduct">Sản phẩm</a></li>
                                <li><a href="manageAccount">Tài khoản</a></li>
                                <li><a href="manageFeedback">Đánh giá</a></li>
                                <li><a href="manageOrder">Đơn hàng</a></li>                            
                                <li><a href="manageVoucher">Mã giảm giá</a></li>
                            </ul>
                        </nav>
                    </div>
                </div>
            </c:if>
            <c:if test="${acc.getIsAdmin() != 1 && acc.getIsAdmin() != 0}">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-3">
                            <div class="header__logo">
                                <a href="home"><img src="https://static.ybox.vn/2021/5/3/1621994139101-LOGOTN.PNG" alt=""></a>
                            </div>
                        </div>
                        <div class="col-lg-6">
                            <!--guest kh hiển thị navbar-->

                            <nav class="header__menu">
                                <ul>
                                    <li><a href="${pageContext.request.contextPath}/home">Trang chủ</a></li>
                                    <li><a href="${pageContext.request.contextPath}/viewAllFeedback">Xem đánh giá</a>
                                </ul>
                            </nav>
                        </div>
                    </div>
                </div></c:if>
            </div>

            <!-- Product Details Section Begin -->
            <section class="product-details spad">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-6 col-md-6">
                            <div class="product__details__pic">
                                <div class="product__details__pic__item">
                                    <img class="product__details__pic__item--large"
                                         src=${detail.getPro_image()} alt="">
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-6 col-md-6">
                        <div class="product__details__text">
                            <h3>${detail.getPro_name()}</h3>

                            <div class="product__details__price">${detail.getPro_price()} VNĐ</div>



                            <p>${detail.getPro_description()}</p>

                            <!--chỉ hiển thị cho khách hàng-->
                            <c:if test="${acc.getIsAdmin() != 1}">
                                <c:if test="${acc.getIsAdmin() == 0}">
                                    <form action="addToCart" method="post" onsubmit="return validateQuantity()">
                                        <input type="hidden" name="pro_id" value="${detail.getPro_id()}">
                                        <div class="product__details__quantity">
                                            <label for="quantity">Số lượng : </label>
                                            <input class="pro-qty quantity" type="number" name="quantity" id="quantity" value="1" min="1" max="${detail.getPro_quantity()}">
                                            <input class="primary-btn" type="submit" value="Thêm vào giỏ hàng">
                                        </div>
                                        <div id="error-message" style="color: red; margin-top: 10px;"></div>
                                    </form>
                                </c:if>
                                <!--là khách thì phải login-->
                                <c:if test="${acc.getIsAdmin() != 0 && acc.getIsAdmin() != 1}">
                                     <form action="Login.jsp" method="post" onsubmit="return validateQuantity()">
                                        <input type="hidden" name="pro_id" value="${detail.getPro_id()}">
                                        <div class="product__details__quantity">
                                            <label for="quantity">Số lượng : </label>
                                            <input class="pro-qty quantity" type="number" name="quantity" id="quantity" value="1" min="1" max="${detail.getPro_quantity()}">
                                            <input class="primary-btn" type="submit" value="Thêm vào giỏ hàng">
                                        </div>
                                        <div id="error-message" style="color: red; margin-top: 10px;"></div>
                                    </form>
                                </c:if>
                            </c:if>
                            <ul>
                                <li><b>Còn lại</b>${detail.getPro_quantity()} gói<span> </span></li></ul>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- Product Details Section End -->


        <jsp:include page="Footer.jsp"></jsp:include>
            <script>
                function validateQuantity() {
                    const maxQuantity = ${detail.getPro_quantity()};
                    const quantityInput = document.getElementById('quantity');
                    const quantityValue = parseInt(quantityInput.value, 10);
                    const errorMessage = document.getElementById('error-message');

                    if (quantityValue > maxQuantity) {
                        errorMessage.textContent = 'Số lượng vượt quá giới hạn cho phép.';
                        return false; // Prevent form submission
                    } else {
                        errorMessage.textContent = ''; // Clear any previous error message
                    }
                    return true; // Allow form submission
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