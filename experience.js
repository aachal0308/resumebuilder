document.addEventListener("DOMContentLoaded", function () {
    const form = document.querySelector("form");
    const progressBar = document.querySelector(".progress");
    const backButton = document.querySelector(".btn.secondary");
    const nextButton = document.querySelector(".btn.primary"); // Assuming "Next: Skills" has this class
    const endDate = document.getElementById("endDate");

    // Function to update progress dynamically
    function updateProgress(percentage) {
        progressBar.textContent = "RESUME COMPLETENESS: " + percentage + "%";
    }

    // Validate form fields before submitting
    form.addEventListener("submit", function (event) {
        let requiredFields = form.querySelectorAll("input[required]");
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
            event.preventDefault();
            alert("Please fill in all required fields.");
        } else {
            updateProgress(60); // Move to the next step, increase progress
        }
    });

    // Back button click event
    backButton.addEventListener("click", function (event) {
        event.preventDefault();
        window.location.href = "education.html";
    });

    // Next button click event (Navigate to skills.html)
    nextButton.addEventListener("click", function (event) {
        event.preventDefault();
        window.location.href = "skills.html"; // Ensure this file exists
    });

    // Automatically set "Present" if no End Date is selected
    endDate.addEventListener("blur", function () {
        if (!endDate.value) {
            endDate.placeholder = "Present";
        }
    });

    // Auto progress update on page load (assuming experience is step 3)
    updateProgress(60);
});
