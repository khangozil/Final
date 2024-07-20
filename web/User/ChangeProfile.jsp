<%@page import="DAO.AccountDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Rau củ tươi G7</title>
        <link rel="icon" type="image/x-icon" href="https://png.pngtree.com/png-clipart/20190705/original/pngtree-vegetable-icon-illustration-png-image_4363827.jpg">

        <link rel="stylesheet" href="../css/form.css">
        <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>

        <style>
            .text-danger{
                margin-top: 10px;
                color: red;
            }
        </style>
    </head>

    <body>
        <section class="container">
            <header>Thay đổi thông tin cá nhân</header>
            <form action="${pageContext.request.contextPath}/changeProfile" method="get" class="form" onsubmit="return validateForm()">
                <div class="input-box">
                    <label >Tài khoản</label>
                    <input value="${username}" placeholder=" ${acc.acc_id}" readonly="" />
                </div>

                <div class="input-box">
                    <label for="fullname">Họ tên</label>
                    <input id="fullname" name="fullname" type="text" value="${fullname}" placeholder=" ${acc.acc_name}"  />
                    <span id="nameError"></span> 
                </div>

                <div class="column">
                    <div class="input-box">
                        <label>Số điện thoại</label>
                        <input id="phone" name="phone" type="text" value="${phone}" placeholder="${acc.phone}"  />
                        <span id="phoneError"></span> 
                    </div>
                </div>

                <div class="input-box">
                    <label>Địa chỉ</label>
                    <input id="address" name="address" type="text" value="${address}" placeholder="${acc.address}"  />
                    <span id="addressError"></span> 
                </div>

                <div class="input-box">
                    <label>Mail</label>
                    <input value="${mail}" placeholder="${acc.mail}" readonly="" />
                </div>

                <div class="gender-box">
                    <h3>Giới tính</h3>
                    <div class="gender-option">
                        <div class="gender">
                            <input type="radio" id="check-male" name="gender" value="Nam" checked />
                            <label for="check-male">Nam</label>
                        </div>

                        <div class="gender">
                            <input type="radio" id="check-female" name="gender" value="Nữ"/>
                            <label for="check-female">Nữ</label>
                        </div>
                    </div>
                </div>
                <button class="btn-prime">Cập nhật</button>      
            </form>

        </section>

        <script>
            function validateForm() {
                var name = document.getElementById("fullname").value;
                var phone = document.getElementById("phone").value;
                var address = document.getElementById("address").value;

                var nameError = document.getElementById("nameError");
                var phoneError = document.getElementById("phoneError");
                var addressError = document.getElementById("addressError");

                var hasError = false;

                if (name === "") {
                    nameError.innerText = "Điền vào ô này";
                    hasError = true;
                } else {
                    nameError.innerText = "";
                }

//                const phoneRegex = /(0[3|5|7|8|9])+([0-9]{8})\b/g;
                const phoneRegex = /0[35789][0-9]{8}\b/g;
                if (phone === "") {
                    phoneError.innerText = "Điền vào ô này";
                    hasError = true;
                } else if (!phoneRegex.test(phone)) {
                    phoneError.innerText = "Số điện thoại không đúng định dạng";
                    hasError = true;
                } else {
                    phoneError.innerText = "";
                }


                if (address === "") {
                    addressError.innerText = "Điền vào ô này";
                    hasError = true;
                } else {
                    addressError.innerText = "";
                }

                return !hasError;
            }
        </script>
    </body>

</html>