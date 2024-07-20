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
        <link rel="stylesheet" href="../css/bootstrap.min.css" type="text/css">
        <link rel="stylesheet" href="../css/font-awesome.min.css" type="text/css">
        <link rel="stylesheet" href="../css/elegant-icons.css" type="text/css">
        <link rel="stylesheet" href="../css/nice-select.css" type="text/css">
        <link rel="stylesheet" href="../css/jquery-ui.min.css" type="text/css">
        <link rel="stylesheet" href="../css/owl.carousel.min.css" type="text/css">
        <link rel="stylesheet" href="../css/slicknav.min.css" type="text/css">
        <link rel="stylesheet" href="../css/style.css" type="text/css">

        <style>
            .button {
                font-size: 14px;
                color: #ffffff;
                /*font-weight: 300;*/
                text-transform: uppercase;
                display: inline-block;
                padding: 13px 30px 12px;
                background: #7fad39;
                border-radius: 30px;
                border: none; /* This removes any border */
            }

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
                    </div>
                </div>
            </div>
        </div>

        <!-- Checkout Section Begin -->
        <section class="checkout spad">
            <div class="container">
                <div class="checkout__form">
                    <h4>Cập nhật đánh giá của bạn</h4>
                    <!--<p class="text-danger">${mess}</p>-->
                    <form action="${pageContext.request.contextPath}/updateFeedback" method="post">
                        <div class="row">
                            <div class="col-lg-8 col-md-6">
                                <div class="checkout__input">
                                    <a> Nội dung</a>
                                    <input  type="text" name="content"  value="${fb.fb_content}" required="">
                                    <a> Thời gian đánh giá</a>
                                    <input  type="text" name="date" value="${fb.fb_date}" readonly="">
                                    <a> ID </a>
                                    <input  type="text" name="fid"  value="${fb.fb_id}" readonly="">
                                </div>
                            </div>
                        </div>
                        <div>
                            <button type="submit" class="button">Cập nhật</button>
                        </div>
                    </form>
                </div>
            </div>
        </section>
        <!-- Checkout Section End -->

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