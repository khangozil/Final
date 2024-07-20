<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <title>Rau củ tươi G7</title>
        <link rel="icon" type="image/x-icon" href="https://png.pngtree.com/png-clipart/20190705/original/pngtree-vegetable-icon-illustration-png-image_4363827.jpg">

        <link rel="stylesheet" href="css/form.css">
        <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
        <!--<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>-->

        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/popup.css">  <!--  popup-->
    </head>

    <body>
        <section class="container">
            <header>Đăng ký tài khoản</header>
            <form action="register" class="form" onsubmit="return validateForm()">
                <div class="input-box">
                    <label for="fullname">Họ tên</label>
                    <input id="fullname" name="fullname" type="text" value="${fullname}" placeholder="Nhập họ tên của bạn"  />
                    <span id="nameError"></span> 
                </div>

                <div class="input-box">
                    <label>Tài khoản</label>
                    <input id="username" name="username" type="text" value="${username}" placeholder="Nhập tài khoản của bạn"  />
                    <span id="usernameError"></span> 
                </div>

                <div class="input-box">
                    <label>Mật khẩu</label>
                    <input id="password" name="password" type="password" value="${password}" placeholder="Nhập mật khẩu của bạn"  />
                    <span id="passwordError"></span> 
                </div>

                <div class="input-box">
                    <label>Nhập lại mật khẩu</label>
                    <input id="confirm-password" name="repassword" type="password" value="${repassword}" placeholder="Nhập lại mật khẩu của bạn"  />
                    <span id="repasswordError"></span> 
                </div>   

                <div class="column">
                    <div class="input-box">
                        <label>Số điện thoại</label>
                        <input id="phone" name="phone" type="text" value="${phone}" placeholder="Nhập số điện thoại của bạn"  />
                        <span id="phoneError"></span> 
                    </div>
                </div>

                <div class="input-box">
                    <label>Địa chỉ</label>
                    <input id="address" name="address" type="text" value="${address}" placeholder="Nhập địa chỉ của bạn"  />
                    <span id="addressError"></span> 
                </div>

                <div class="input-box">
                    <label>Mail</label>
                    <input id="mail" name="mail" type="text" value="${mail}" placeholder="Nhập mail của bạn"  />
                    <span id="mailError"></span> 
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
                <button class="btn-prime">Đăng ký</button>
            </form>

            <!--popup-->
            <div id="myModal" class="modal" style="display: ${mess ? 'block' : 'none'};">
                <div class="modal-content">
                    <span class="close">&times;</span>
                    <p id="popupMessage" class="text-danger">${mess}</p>
                </div>
            </div>
        </section>


        <script src="js/popup.js"></script>
        <script>
                function validateForm() {
                    var name = document.getElementById("fullname").value;
                    var username = document.getElementById("username").value;
                    var password = document.getElementById("password").value;
                    var repassword = document.getElementById("confirm-password").value;
                    var phone = document.getElementById("phone").value;
                    var mail = document.getElementById("mail").value;
                    var address = document.getElementById("address").value;

                    var nameError = document.getElementById("nameError");
                    var usernameError = document.getElementById("usernameError");
                    var passwordError = document.getElementById("passwordError");
                    var repasswordError = document.getElementById("repasswordError");
                    var phoneError = document.getElementById("phoneError");
                    var mailError = document.getElementById("mailError");
                    var addressError = document.getElementById("addressError");

                    var hasError = false;

                    if (name === "") {
                        nameError.innerText = "Điền vào ô này";
                        hasError = true;
                    } else {
                        nameError.innerText = "";
                    }

                    if (username === "") {
                        usernameError.innerText = "Điền vào ô này";
                        hasError = true;
                    } else {
                        usernameError.innerText = "";
                    }

                    if (password === "") {
                        passwordError.innerText = "Điền vào ô này";
                        hasError = true;
                    } else if (password.length < 6) {
                        passwordError.innerText = "Mật khẩu phải có 6 kí tự trở lên";
                        hasError = true;
                    } else {
                        passwordError.innerText = "";
                    }

                    if (repassword === "") {
                        repasswordError.innerText = "Điền vào ô này";
                        hasError = true;
                    } else if (repassword !== password) {
                        repasswordError.innerText = "Nhập lại mật khẩu không trùng khớp";
                        hasError = true;
                    } else {
                        repasswordError.innerText = "";
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

                    const mailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
                    if (mail === "") {
                        mailError.innerText = "Điền vào ô này";
                        hasError = true;
                    } else if (!mailRegex.test(mail)) {
                        mailError.innerText = "Mail không đúng định dạng";
                        hasError = true;
                    } else {
                        mailError.innerText = "";
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