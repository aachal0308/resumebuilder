document.addEventListener("DOMContentLoaded", function () {
    const form = document.querySelector("form");
    const previewBtn = document.querySelector(".preview-btn");
    const progressBar = document.querySelector(".progress-bar");
    
    // Update progress dynamically (change based on steps)
    function updateProgress(percentage) {
        progressBar.style.width = percentage + "%";
        progressBar.textContent = "RESUME COMPLETENESS: " + percentage + "%";
    }
    
    // Preview button functionality
    previewBtn.addEventListener("click", function () {
        let firstName = document.querySelector("input[placeholder='e.g. Saanvi']").value;
        let surname = document.querySelector("input[placeholder='e.g. Patel']").value;
        let city = document.querySelector("input[placeholder='e.g. New Delhi']").value;
        let country = document.querySelector("input[placeholder='e.g. India']").value;
        let phone = document.querySelector("input[placeholder='+91 22 1234 5677']").value;
        let email = document.querySelector("input[placeholder='e.g. saanvipatel@sample.in']").value;

        if (firstName && surname && city && country && phone && email) {
            alert(
                Preview:\n\nName: ${firstName} ${surname}\nCity: ${city}\nCountry: ${country}\nPhone: ${phone}\nEmail: ${email}
            );
        } else {
            alert("Please fill all required fields before previewing.");
        }
    });

    // Form validation before submitting
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
            updateProgress(40); // Move to next step, increase progress
        }
    });
});