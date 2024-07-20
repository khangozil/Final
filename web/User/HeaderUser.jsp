<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!--header admin-->

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <!--        <meta name="description" content="Ogani Template">
                <meta name="keywords" content="Ogani, unica, creative, html">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <meta http-equiv="X-UA-Compatible" content="ie=edge">-->
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


    <!DOCTYPE html>
    <header class="header">
        <div class="header__top">
            <div class="container">
                <div class="row">
                    <div class="col-lg-6 col-md-4">
                        <div class="header__top__left">
                            <ul>
                                <li>Xin chào ${acc.getAcc_name()}!</li>
                                <li>Chào mừng đến với cửa hàng của chúng tôi.</li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-lg-6 col-md-8">
                        <div class="header__top__right">

                            <!--trên session rỗng thì hiển thị đăng nhập-->
                            <c:if test="${sessionScope.acc == null}">
                                <div class="header__top__right__auth">
                                    <a href="${pageContext.request.contextPath}/Login.jsp"><i class="fa fa-user"></i>Đăng nhập</a>
                                </div>
                            </c:if>

                            <!--session tồn tại account thì hiển thị logout-->
                            <c:if test="${sessionScope.acc != null}">
                                <!--lấy đường dẫn logout-->
                                <div class="header__top__right__auth">
                                    <a href="${pageContext.request.contextPath}/logout"><i class="fa fa-user"></i>Đăng xuất</a>
                                </div>
                            </c:if>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</header>
<!-- Header Section End -->