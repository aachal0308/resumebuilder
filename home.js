document.addEventListener("DOMContentLoaded", function () {
    //  Check login status
    if (!sessionStorage.getItem("sessionId") || !localStorage.getItem("userId")) {
        window.location.href = "index.html";
    }

    // Smooth scrolling for navigation links
    document.querySelectorAll(".nav-links a").forEach(link => {
        link.addEventListener("click", function (event) {
            event.preventDefault();
            const targetId = this.getAttribute("href").substring(1);
            const targetSection = document.getElementById(targetId);
            if (targetSection) {
                window.scrollTo({
                    top: targetSection.offsetTop - 50,
                    behavior: "smooth"
                });
            }
        });
    });

    // Handle "Create My Resume Now" button click (check if button exists)
    const btnPrimary = document.querySelector(".btn-primary");
    if (btnPrimary) {
        btnPrimary.addEventListener("click", function () {
            alert("Redirecting to the Resume Builder...");
            window.location.href = "buildmyresume.html"; // Change this URL if needed
        });
    }

    //  Handle "Build My Resume" button in the nav (check if button exists)
    const btnOutline = document.querySelector(".btn-outline");
    if (btnOutline) {
        btnOutline.addEventListener("click", function () {
            window.location.href = "buildmyresume.html"; // Ensure this file exists
        });
    }

    //  Logout function (remove extra `DOMContentLoaded`)
    const logoutBtn = document.getElementById("logout-btn");
    if (logoutBtn) {
        logoutBtn.addEventListener("click", function () {
            console.log("Logout button clicked!");

            // ✅ Clear session-related data
            localStorage.removeItem("isLoggedIn");
            localStorage.removeItem("sessionId");  // ✅ Match key with storage
            sessionStorage.removeItem("sessionId");  // ✅ Match key with storage

            // ✅ Clear session ID from cookies
            document.cookie = "sessionId=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;";

            // ✅ Redirect to login page
            window.location.href = "index.html";
        });
    }
});
