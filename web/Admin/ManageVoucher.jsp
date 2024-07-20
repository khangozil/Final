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
        <!--<link rel="stylesheet" href="../css/bootstrap.min.css" type="text/css">-->
        <!--<link rel="stylesheet" href="../css/font-awesome.min.css" type="text/css">-->
        <!--        <link rel="stylesheet" href="../css/elegant-icons.css" type="text/css">
                <link rel="stylesheet" href="../css/nice-select.css" type="text/css">
                <link rel="stylesheet" href="../css/jquery-ui.min.css" type="text/css">
                <link rel="stylesheet" href="../css/owl.carousel.min.css" type="text/css">
                <link rel="stylesheet" href="../css/slicknav.min.css" type="text/css">
                <link rel="stylesheet" href="../css/style.css" type="text/css">-->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/popup.css">  <!--  popup-->

        <style>
            .icon_close{
                font-size: 24px;
                color: #b2b2b2;
                cursor: pointer;
            }
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
            .title{
                font-size: 30px;
                font-weight: 700;
                color: #1c1c1c;
                padding-bottom: 20px;}
            
        </style>
    </head>

    <body>
        <jsp:include page="HeaderAdmin.jsp"></jsp:include>

            <div class="container">
                <h3 class="title">Danh Sách Voucher</h3>
                <div class="row">
                    <span class="text-danger" id="textError"></span> 
                    <div class="col-lg-12">
                        <div class="hero__search__form">
                            <form action="searchVoucher" method="get" onsubmit="return validateForm()">
                                <select name="option">
                                    <option value="1">Code</option>
                                    <option value="2">Tỷ lệ chiết khấu</option>
                                </select>
                                <input type="text" id="textSearch" name="textSearch"  value="${textSearch}" placeholder="Bạn đang tìm gì?">
                            <button type="submit" class="site-btn">Tìm kiếm</button>
                        </form>
                    </div>
                    <div>
                        <a href="Admin/CreateVoucher.jsp" class="button"></span>
                            Tạo mã mới</a>
                    </div>
<!--                    <div style="padding: 30px;"></div>-->
                    <!--<div class="shoping__cart__table">-->
                    <table class="table table-bordered mt-3">
                        <thead>
                            <tr>
                                <th>Voucher ID</th>
                                <th>Voucher Code</th>
                                <th>Tỷ lệ chiết khấu</th>
                                <th>Thao Tác</th>
                            </tr>
                        </thead>    

                        <c:if test="${listV != null}">
                            <c:forEach items="${listV}" var="o">
                                <tbody>
                                    <tr>
                                        <td> ${o.voucher_id}</td>
                                        <td> ${o.voucher_code}</td>
                                        <td>${o.discount_percentage}</td>
                                        <td> <a href="Admin/UpdateVoucher.jsp?voucher_id=${o.voucher_id}" class="button"></span>
                                                Cập nhật</a>                                                                                          
                                        </td>
                                        <td class="shoping__cart__item__close">
                                            <a href="deleteVoucher?voucher_id=${o.voucher_id}">
                                                <span class="icon_close"></span>
                                            </a>
                                        </td>
                                    </tr>
                                </tbody>
                            </c:forEach>
                        </c:if>

                        <c:if test="${vou != null}">
                            <tbody>
                                <tr>
                                    <td> ${vou.voucher_id}</td>

                                    <td> ${vou.voucher_code}</td>

                                    <td>${vou.discount_percentage}</td>
                                    <td> <a href="Admin/UpdateVoucher.jsp?voucher_id=${o.voucher_id}" class="button"></span>
                                            Cập nhật</a>                                                                                          
                                    </td>
                            </tbody>
                        </c:if>
                    </table>
                    <div>
                    </div>
                </div>
            </div>
        </div>

        <c:if test="${messSuccess != null}">
            <!--popup-->
            <div id="myModal" class="modal">
                <div class="modal-content">
                    <span class="close">&times;</span>
                    <p id="popupMessage" class="text-succes">${messSuccess}</p>
                </div>
            </div>
        </c:if>


        <script src="js/popup.js"></script>
        <script>
                                function validateForm() {
                                    var textSearch = document.getElementById("textSearch").value.trim(); // Trim whitespace

                                    var textError = document.getElementById("textError");

                                    var hasError = false;
                                    if (textSearch === "") {
                                        textError.innerText = "Điền vào ô này";
                                        hasError = true;
                                    } else {
                                        textError.innerText = "";
                                    }
                                    return !hasError;
                                }
        </script>
    </body>
</html>