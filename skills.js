document.addEventListener("DOMContentLoaded", function () {
    const form = document.querySelector("form");
    const progressBar = document.querySelector(".progress");
    const backButton = document.querySelector(".btn.secondary");
    const nextButton = document.querySelector(".btn.primary"); // Assuming "Next: Achievements" button
    const requiredFields = document.querySelectorAll("input[required]");

    // Function to update progress dynamically
    function updateProgress(percentage) {
        progressBar.textContent = "RESUME COMPLETENESS: " + percentage + "%";
    }

    // Validate form fields before proceeding
    nextButton.addEventListener("click", function (event) {
        event.preventDefault(); // Prevent default form submission

        let allFilled = true;

        requiredFields.forEach(input => {
            if (!input.value.trim()) {
                allFilled = false;
                input.style.border = "2px solid red";
            } else {
                input.style.border = "1px solid #ccc";
            }
        });

        if (!allFilled) {
            alert("Please fill in all required fields.");
        } else {
            updateProgress(80); // Assuming this step brings completion to 80%
            window.location.href = "achievements.html"; // Navigate to Achievements page
        }
    });

    // Back button click event
    backButton.addEventListener("click", function (event) {
        event.preventDefault();
        window.location.href = "experience.html"; // Navigate back to Experience page
    });

    // Auto progress update on page load
    updateProgress(70); // Assuming skills step = 70%
});
