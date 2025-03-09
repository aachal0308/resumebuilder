document.addEventListener("DOMContentLoaded", function () {
    const form = document.querySelector("form");
    const progressBar = document.querySelector(".progress");
    const backButton = document.querySelector(".btn.secondary");

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
            updateProgress(40); // Move to the next step, increase progress
        }
    });

    // Back button click event
    backButton.addEventListener("click", function (event) {
        event.preventDefault();
        window.location.href = "buildmyresume.html";
    });

    // Auto progress update on page load (assuming education is step 2)
    updateProgress(40);
});
