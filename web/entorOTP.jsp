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

        <style>
            .text-danger{
                margin-top: 10px;
                color: red;
            }
            .text-succes{
                margin-top: 20px;
                color: green;
            }

            /*popup*/
            .modal {
                display: none;
                position: fixed;
                z-index: 1; 
                left: 0;
                top: 0;
                width: 100%;
                height: 100%; 
                overflow: auto;
                background-color: rgb(0,0,0); 
                background-color: rgba(0,0,0,0.4); 
                display: flex;
                align-items: center;
                justify-content: center;
            }

            .modal-content {
                background-color: #fefefe;
                margin: auto;
                padding: 20px;
                border: 1px solid #888;
                width: 80%;
                max-width: 400px;
                text-align: center;
            }

            .close {
                color: #aaa;
                float: right;
                font-size: 28px;
                font-weight: bold;
            }

            .close:hover,
            .close:focus {
                color: black;
                text-decoration: none;
                cursor: pointer;
            }
        </style>
    </head>

    <body>
        <section class="container">
            <header>Đặt lại mật khẩu</header>            
            <form action="forgot?action=enterOtp" method="post" class="form" onsubmit="return validateForm()">
                <div class="input-box">
                    <label>Nhập OTP được gửi tới mail</label>
                    <input id="mail" name="otp" type="text" placeholder="Nhập OTP của bạn"  />
                    <span id="mailError"></span> 
                </div>
                <button type="submit" class="btn-prime">Kiểm tra</button>      
            </form>

            <!--popup-->
            <div id="myModal" class="modal" style="display: ${error ? 'block' : 'none'};">
                <div class="modal-content">
                    <span class="close">&times;</span>
                    <p id="popupMessage" class="text-danger">${error}</p>
                </div>
            </div>
        </section>

        <script src="js/popup.js"></script>
        <script>
                function validateForm() {
                    var name = document.getElementById("fullname").value;
                    var username = document.getElementById("username").value;
                    var phone = document.getElementById("phone").value;
                    var mail = document.getElementById("mail").value;
                    var address = document.getElementById("address").value;

                    var nameError = document.getElementById("nameError");
                    var usernameError = document.getElementById("usernameError");
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
                        mailError.innerText = "Email không đúng định dạng";
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