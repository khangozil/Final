<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Footer Section</title>
    <link rel="stylesheet" href="css/style.css"> <!-- Đảm bảo rằng tệp CSS của bạn được đặt đúng -->
</head>
<body>
<!-- Footer Section Begin -->
<footer class="footer spad">
    <div class="container">
        <div class="row">
            <div class="col-lg-4 col-md-6 col-sm-6">
               <div class="footer__widget">
                     <h6>Thông tin</h6>
                    <div class="footer__about__logo">
                    </div>
                    <ul>
                        <li>Địa chỉ: Đại học FPT Cần Thơ, Cái Răng, Cần Thơ</li>
                        <li>Điện thoại: +84 68.68.68.68.68</li>
                        <li>Email: g7fpt@gmail.com</li>
                        <c:if test="${voucher != null}">
                        <li>Voucher here: ${voucher.voucher_code} </li>
                        </c:if>
                    </ul>
                </div>
            </div>
            <div class="col-lg-4 col-md-6 col-sm-6 offset-lg-1">
                <div class="footer__widget">
                    <h6>Liên Kết Hữu Ích</h6>
                    <ul>
                        <li><a href="#">Giới Thiệu</a></li>
                        <li><a href="#">Sản Phẩm</a></li>
                        <li><a href="#">Cách Thức Đặt Hàng</a></li>
                        <li><a href="#">Chính Sách Bảo Mật</a></li>
                        <li><a href="#">Hướng Dẫn Thanh Toán</a></li>
                        <li><a href="#">Liên Hệ</a></li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-12">
                <div class="footer__copyright">
                    <div class="footer__copyright__text">
                        <p>
                            Bản quyền &copy;<script>document.write(new Date().getFullYear());</script> Tất cả các quyền được bảo lưu | Được thiết kế bởi <a href="https://fpt.edu.vn" target="_blank">Nhóm Sinh Viên FPT Cần Thơ</a>
                        </p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</footer>
<!-- Footer Section End -->
</body>
</html>
