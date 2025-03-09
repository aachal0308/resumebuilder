document.addEventListener("DOMContentLoaded", function () {
    const form = document.querySelector("form");
    const progressBar = document.querySelector(".progress");
    const backButton = document.querySelector(".btn.secondary");
    const nextButton = document.querySelector(".btn.primary"); // Assuming "Next: Finalize" button
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
            updateProgress(90); // Assuming this step brings completion to 90%
            window.location.href = "finalize.html"; // Navigate to Finalize page
        }
    });

    // Back button click event
    backButton.addEventListener("click", function (event) {
        event.preventDefault();
        window.location.href = "skills.html"; // Navigate back to Skills page
    });

    // Auto progress update on page load
    updateProgress(80); // Assuming achievements step = 80%
});
