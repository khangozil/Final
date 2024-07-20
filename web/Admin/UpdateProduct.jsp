<%@page import="entity.Product"%>
<%@page import="DAO.ProductDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Rau củ tươi G7</title>
         <link rel="icon" type="image/x-icon" href="https://png.pngtree.com/png-clipart/20190705/original/pngtree-vegetable-icon-illustration-png-image_4363827.jpg">

        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/form.css">
        <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
         <link rel="stylesheet" href="${pageContext.request.contextPath}/css/popup.css">
        
    </head>

    <body>
         <%
                String pro_id = request.getParameter("pro_id");
                ProductDAO dao = new ProductDAO();
                Product p = dao.getProductByID(pro_id);
                String name = p.getPro_name();
                Double price = p.getPro_price();
                Double quantity = p.getPro_quantity();
                String description = p.getPro_description();
            %>
        <section class="container">
            <header>Tạo sản phẩm</header>
            <form action="${pageContext.request.contextPath}/updateProduct" method="post" class="form" onsubmit="return validateForm()">
                <div class="input-box">
                    <label>ID sản phẩm</label>
                    <input id="id" name="id" type="text" value="<%= pro_id%>" readonly/>
                    <span id="idError"></span>
                </div>

                <div class="input-box">
                    <label>Tên sản phẩm</label>
                    <input id="name" name="name" type="text" value="${name}" placeholder="<%= name%>" />
                    <span id="nameError"></span>
                </div>

                <div class="input-box">
                    <label>Hình ảnh</label>
                    <input id="image" name="image" type="text" value="${image}" placeholder="Nhập link hình ảnh sản phẩm" />
                    <span id="imageError"></span>
                </div>

                <div class="input-box">
                    <label>Thời gian</label>
                    <input id="date" name="date" type="date" value="${date}"/>
                    <span id="dateError"></span>
                </div>

                <div class="input-box">
                    <label>Giá</label>
                    <input id="price" name="price" type="text" value="${price}" placeholder="<%= price%>" />
                    <span id="priceError"></span>
                </div>

                <div class="input-box">
                    <label>Số lượng</label>
                    <input id="quantity" name="quantity" type="text" value="${quantity}" placeholder="<%= quantity%>" />
                    <span id="quantityError"></span>
                </div>

                <div class="input-box">
                    <label>Mô tả</label>
                    <input id="description" name="description" type="text" value="${description}" placeholder="<%= description%>" />
                    <span id="descriptionError"></span>
                </div>

                <div class="check-box">
                    <h3>Loại</h3>
                    <div class="check-option">
                        <div class="check">
                            <input type="radio" name="category" value="1" checked />
                            <label>Rau</label>
                        </div>

                        <div class="check">
                            <input type="radio" name="category" value="2" />
                            <label>Củ</label>
                        </div>
                    </div>
                </div>
                <button class="btn-prime">Cập nhật sản phẩm</button>
            </form>

            <!--popup-->
            <div id="myModal" class="modal" style="display: ${mess ? 'block' : 'none'};">
                <div class="modal-content">
                    <span class="close">&times;</span>
                    <p id="popupMessage" class="${messSuccess ? 'text-success' : 'text-danger'}">${messSuccess ? messSuccess : mess}</p>
                </div>
            </div>
        </section>

        <script src="js/popup.js"></script>
        <script>
                function validateForm() {
                    var id = document.getElementById("id").value;
                    var name = document.getElementById("name").value;
                    var image = document.getElementById("image").value;
                    var date = document.getElementById("date").value;
                    var price = document.getElementById("price").value;
                    var quantity = document.getElementById("quantity").value;
                    var description = document.getElementById("description").value;

                    var idError = document.getElementById("idError");
                    var nameError = document.getElementById("nameError");
                    var imageError = document.getElementById("imageError");
                    var dateError = document.getElementById("dateError");
                    var priceError = document.getElementById("priceError");
                    var quantityError = document.getElementById("quantityError");
                    var descriptionError = document.getElementById("descriptionError");

                    var hasError = false;

                    if (id === "") {
                        idError.innerText = "Điền vào ô này";
                        hasError = true;
                    } else {
                        idError.innerText = "";
                    }

                    if (name === "") {
                        nameError.innerText = "Điền vào ô này";
                        hasError = true;
                    } else {
                        nameError.innerText = "";
                    }

                    if (image === "") {
                        imageError.innerText = "Điền vào ô này";
                        hasError = true;
                    } else {
                        imageError.innerText = "";
                    }

                    if (date === "") {
                        dateError.innerText = "Điền vào ô này";
                        hasError = true;
                    } else {
                        dateError.innerText = "";
                    }

                    if (price === "") {
                        priceError.innerText = "Điền vào ô này";
                        hasError = true;
                    } else if (isNaN(price) || Number(price) <= 0) {
                        priceError.innerText = "Giá trị phải lớn hơn 0";
                        hasError = true;
                    } else {
                        priceError.innerText = "";
                    }

                    if (quantity === "") {
                        quantityError.innerText = "Điền vào ô này";
                        hasError = true;
                    } else if (isNaN(quantity) || Number(quantity) <= 0) {
                        quantityError.innerText = "Giá trị phải lớn hơn 0";
                        hasError = true;
                    } else {
                        quantityError.innerText = "";
                    }

                    if (description === "") {
                        descriptionError.innerText = "Điền vào ô này";
                        hasError = true;
                    } else {
                        descriptionError.innerText = "";
                    }

                    return !hasError;
                }
        </script>
    </body>

</html>