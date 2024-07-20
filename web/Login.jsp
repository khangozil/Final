<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Rau củ tươi G7</title>
        <link rel="icon" type="image/x-icon" href="https://png.pngtree.com/png-clipart/20190705/original/pngtree-vegetable-icon-illustration-png-image_4363827.jpg">

        <link rel="stylesheet" href="css/login.css">
        <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/popup.css">  <!--  popup-->

    </head>

    <body>
        <section class="container">
            <header>Đăng nhập</header>
            <form action="login" method="post" class="form" onsubmit="return validateForm()">
                <div class="input-box">
                    <label>Tài khoản</label>
                    <input type="text" id="username" name="username" value="${username}" placeholder="Nhập tài khoản" class="form-control"/>
                    <span id="userError"></span> 
                </div>

                <div class="input-box">
                    <label>Mật khẩu</label>
                    <input type="password" id="password" name="password" value="${password}" placeholder="Nhập mật khẩu" class="form-control"/>
                    <span id="passError"></span> 
                </div>

                <div class="remember-forgot">
                    <!--<label><input type="checkbox"> Remember me</label>-->
                    <a href="ForgotPassword.jsp">Bạn quên mật khẩu?</a>
                </div>

                <button type="submit" class="btn-prime">Đăng nhập</button>

                <div class="register-link">
                    <p>Đăng ký tài khoản mới <a href="Register.jsp">tại đây</a></p>   
                </div>
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
                    var username = document.getElementById("username").value;
                    var password = document.getElementById("password").value;

                    var userError = document.getElementById("userError");
                    var passError = document.getElementById("passError");

                    var hasError = false;
                    if (username === "") {
                        userError.innerText = "Điền vào ô này";
                        hasError = true;
                    } else {
                        userError.innerText = "";
                    }

                    if (password === "") {
                        passError.innerText = "Điền vào ô này";
                        hasError = true;
                    } else {
                        if (password.length < 6) {
                            passError.innerText = "Mật khẩu phải có 6 kí tự trở lên";
                            hasError = true;
                        } else {
                            passError.innerText = "";
                        }
                    }
                    return !hasError;
                }
        </script>
    </body>
</html>