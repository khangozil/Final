<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<header class="header">
    <div class="header__top">
        <div class="container">
            <div class="row">
                <div class="col-lg-6 col-md-4">
                    <div class="header__top__left">
                        <ul>
                            <li>Xin chào ${acc.getAcc_name()}!</li>
                            <li>Chào mừng đến với cửa hàng của chúng tôi.</li>
                        </ul>
                    </div>
                </div>
                <div class="col-lg-6 col-md-8">
                    <div class="header__top__right">

                        <!--trên session rỗng thì hiển thị đăng nhập-->
                        <c:if test="${sessionScope.acc == null}">
                            <div class="header__top__right__auth">
                                <a href="Login.jsp"><i class="fa fa-user"></i>Đăng nhập</a>
                            </div>
                        </c:if>

                        <!--session tồn tại account thì hiển thị logout-->
                        <c:if test="${sessionScope.acc != null}">
                            <!--lấy đường dẫn logout-->
                            <div class="header__top__right__auth">
                                <a href="logout"><i class="fa fa-user"></i>Đăng xuất</a>
                            </div>
                        </c:if>
                    </div>
                </div>
            </div>
        </div>
    </div>
</header>
<!-- Header Section End -->