window.addEventListener('load', function () {
    var modal = document.getElementById("myModal");
    var popupMessage = document.getElementById("popupMessage");
    var span = document.getElementsByClassName("close")[0];

    // Kiểm tra xem có tin nhắn để hiển thị không
    if (popupMessage.innerText.trim() !== "") {
        modal.style.display = "block";

        // Tự động ẩn modal sau 3 giây
        setTimeout(function () {
            modal.style.display = "none";
        }, 3000); // 3000 milliseconds = 3 seconds
    }

    // Khi người dùng nhấp vào <span> (x), đóng modal
    span.onclick = function () {
        modal.style.display = "none";
    }

    // Khi người dùng nhấp bất kỳ đâu bên ngoài modal, đóng nó
    window.onclick = function (event) {
        if (event.target == modal) {
            modal.style.display = "none";
        }
    }
});
