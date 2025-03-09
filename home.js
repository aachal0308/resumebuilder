document.addEventListener("DOMContentLoaded", function () {
    // Check login status
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

    // Handle "Create My Resume Now" button click
    document.querySelector(".btn-primary").addEventListener("click", function () {
        alert("Redirecting to the Resume Builder...");
        window.location.href = "buildmyresume.html"; // Change this URL if needed
    });

    // Handle "Build My Resume" button in the nav
    document.querySelector(".btn-outline").addEventListener("click", function () {
        window.location.href = "buildmyresume.html"; // Ensure this file exists
    });

    // Logout function
    document.getElementById("logout-btn")?.addEventListener("click", function () {
        localStorage.removeItem("isLoggedIn");
        window.location.href = "index.html";
    });
});