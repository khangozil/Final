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
        <section class="container">
            <header>Tạo mã giảm giá</header>
            <form action="${pageContext.request.contextPath}/createVoucher" method="post" class="form" onsubmit="return validateForm()">
                <div class="input-box">
                    <label>Voucher Code</label>
                    <input id="code" name="code" type="text" value="${code}" placeholder="Nhập code mới"/>
                    <span id="codeError"></span> 
                </div>

                <div class="column">
                    <div class="input-box">
                        <label>Tỷ lệ chiết khấu</label>
                        <input id="discount_percentage" name="discount_percentage" type="text" value="${discount_percentage}" placeholder="Nhập tỷ lệ chiết khấu"  />
                        <span id="discountError"></span> 
                    </div>
                </div>

                <button class="btn-prime">Tạo</button>      
            </form>

            <!--popup-->
            <div id="myModal" class="modal" style="display: ${mess ? 'block' : 'none'};">
                <div class="modal-content">
                    <span class="close">&times;</span>
                    <p id="popupMessage" class="${messSuccess ? 'text-success' : 'text-danger'}">${messSuccess ? messSuccess : messSuccess}</p>
                </div>
            </div>
        </section>

        <script src="../js/popup.js"></script>
        <script>
                function validateForm() {
                    var code = document.getElementById("code").value;
                    var discount_percentage = document.getElementById("discount_percentage").value;

                    var codeError = document.getElementById("codeError");
                    var discountError = document.getElementById("discountError");

                    var hasError = false;

                    if (code === "") {
                        codeError.innerText = "Điền vào ô này";
                        hasError = true;
                    } else if (!/^[a-zA-Z]/.test(code)) {
                        // Kiểm tra xem chuỗi code có bắt đầu bằng một chữ cái hay không
                        codeError.innerText = "Code phải bắt đầu bằng một chữ cái";
                        hasError = true;
                    } else if (code.length <= 5) {
                        // Kiểm tra xem độ dài của code có lớn hơn 6 hay không
                        codeError.innerText = "Code phải có độ dài 6 ký tự trở lên";
                        hasError = true;
                    } else {
                        codeError.innerText = "";
                    }


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