<%@page import="entity.Voucher"%>
<%@page import="DAO.VoucherDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Rau củ tươi G7</title>
        <link rel="icon" type="image/x-icon" href="https://png.pngtree.com/png-clipart/20190705/original/pngtree-vegetable-icon-illustration-png-image_4363827.jpg">

        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/form.css">
        <!--<link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>-->

        <style>
            .text-danger{
                margin-top: 10px;
                color: red;
            }
        </style>
    </head>

    <body>
        <section class="container">
            <%
                String voucher_id = request.getParameter("voucher_id");
                VoucherDAO dao = new VoucherDAO();
                Voucher voucher = dao.getVoucherByID(voucher_id);
                String voucher_code = voucher.getVoucher_code();
                Float discount_percentage = voucher.getDiscount_percentage();
            %>
            <header>Cập nhật mã giảm giá</header>
            <form action="${pageContext.request.contextPath}/updateVoucher" method="get" class="form" onsubmit="return validateForm()">
                <div class="input-box">
                    <label>Voucher ID</label>
                    <input name="voucher_id"  value="<%= voucher_id%>" readonly />
                </div>

                <div class="input-box">
                    <label>Voucher Code</label>

                    <input name="code"  value="<%= voucher_code%>" readonly />
                </div>

                <div class="column">
                    <div class="input-box">
                        <label>Tỷ lệ chiết khấu</label>
                        <input id="discount_percentage" name="discount_percentage" type="text" value="${discount_percentage}" placeholder="<%= discount_percentage%>"  />
                        <span id="discountError"></span> 
                    </div>
                </div>

                <button class="btn-prime">Cập nhật</button>      
            </form>

        </section>

        <script>
            function validateForm() {
                var discount_percentage = document.getElementById("discount_percentage").value;

                var discountError = document.getElementById("discountError");

                var hasError = false;


                if (discount_percentage === "") {
                    discountError.innerText = "Điền vào ô này";
                    hasError = true;
                } else {
                    var discountValue = parseFloat(discount_percentage);
                    if (isNaN(discountValue)) {
                        discountError.innerText = "Giá trị nhập vào phải là một số";
                        hasError = true;
                    } else if (discountValue <= 0 || discountValue >= 1) {
                        discountError.innerText = "Tỷ lệ chiết khấu phải lớn hơn 0 và nhỏ hơn 1";
                        hasError = true;
                    } else {
                        discountError.innerText = "";
                    }
                }

                return !hasError;
            }
        </script>
    </body>

</html>