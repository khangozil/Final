<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/popup.css">  <!--  popup-->

        <style>
            .img{
                font-size: 18px;
                color: #1c1c1c;
                font-weight: 700;
                width: 150px;
            }
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
            <!-- Shoping Cart Section Begin -->
            <div class="container">
                <div class="row">
                    <h3 class="title">Danh Sách Sản Phẩm</h3>
                    <div class="col-lg-12">
                        <div class="hero__search__form">
                            <form action="searchProduct" method="post" onsubmit="return validateForm()">
                                <!--<div class="hero__search__categories">-->
                                <select name="cate_id">
                                    <option value="0">Tất cả</option> 
                                <c:forEach items="${listCate}" var="o">
                                    <option value="${o.cate_id}"> ${o.cate_name}</option>
                                </c:forEach>                                      
                            </select>
                            <!--</div>-->
                            <input type="text" id="textSearch" name="textSearch" value="${textSearch}" placeholder="Bạn đang tìm gì?">
                            <button type="submit" class="site-btn">Tìm kiếm</button>                                
                        </form>
                    </div>       
                    <div>
                        <a href="Admin/CreateProduct.jsp" class="button"></span>
                            Tạo sản phẩm</a>                           
                    </div>
                    <div style="padding: 8px;"></div>
                    <!--<div class="shoping__cart__table">-->
                    <table class="table table-bordered mt-3">
                        <thead>
                            <tr>
                                <!--                                <th class="col-2">Sản Phẩm</th>
                                                                <th class="col-1">Ảnh</th>
                                                                <th class="col-1">Giá</th>
                                                                <th class="col-2">Số Lượng</th>
                                                                <th class="col-2">Thời gian</th>
                                                                <th class="col-2">Mô Tả</th>
                                                                <th class="col-1">Loại</th>
                                                                <th class="col-1">Thao Tác</th>-->
                                <th class="col-2">Sản Phẩm</th>
                                <th class="col-1">Ảnh</th>
                                <th>Giá</th>
                                <th>Số Lượng</th>
                                <th>Thời gian</th>
                                <th class="col-2">Mô Tả</th>
                                <th>Loại</th>
                                <th>Thao Tác</th>
                                <th></th>
                            </tr>
                        </thead> 

                        <c:forEach items="${listP}" var="o">
                            <tbody>
                                <tr>
                                    <td >${o.pro_name}</td>
                                    <td class="img"> 
                                        <a>  <img src="${o.pro_image}"> </a></td>
                                    <td>${o.pro_price} VNĐ</td>
                                    <td>${o.pro_quantity} gói</td>
                                    <td>${o.pro_date}</td>
                                    <td>
                                        ${o.pro_description}
                                    <td>
                                        <c:choose>
                                            <c:when test="${o.cate_id == 1}">
                                                Rau</h5
                                            </c:when>
                                            <c:when test="${o.cate_id == 2}">
                                                Củ
                                            </c:when>
                                            <c:otherwise>
                                                Khác
                                            </c:otherwise>
                                        </c:choose>
                                    </td>
                                    <td class="centered-cell"> <a href="Admin/UpdateProduct.jsp?pro_id=${o.pro_id}" class="button"></span>
                                            Cập nhật</a>                                                                                          
                                    </td>
                                    <td class="shoping__cart__item__close">
                                        <a href="deleteProduct?pro_id=${o.pro_id}">
                                            <span class="icon_close"></span>
                                        </a>
                                    </td>                                        
                                </tr>                                        
                            </tbody>
                        </c:forEach>  

                    </table>       
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
    </body>
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

</html>

