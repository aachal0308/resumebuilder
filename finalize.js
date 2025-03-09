document.addEventListener("DOMContentLoaded", function () {
    const templateButtons = document.querySelectorAll(".template-btn");
    const selectedTemplateText = document.getElementById("selectedTemplate");
    const resumePreview = document.getElementById("resumePreview");
    const downloadBtn = document.getElementById("downloadBtn");

    // Add click event listeners to template buttons
    templateButtons.forEach(button => {
        button.addEventListener("click", function () {
            // Remove the 'selected' class from all buttons
            templateButtons.forEach(btn => btn.classList.remove("selected"));

            // Add 'selected' class to the clicked button
            this.classList.add("selected");

            // Get the selected template file path
            const selectedTemplate = this.getAttribute("data-template");

            // Update the selected template text
            selectedTemplateText.innerText = selectedTemplate.replace(".html", "").replace("-", " ");

            // Load the selected template into the iframe preview
            resumePreview.src = selectedTemplate;

            // Enable the "Download PDF" button
            downloadBtn.disabled = false;
        });
    });

    // Back Button Functionality
    document.getElementById("backBtn").addEventListener("click", function () {
        window.history.back();
    });

    // Download PDF Functionality
    document.getElementById("downloadBtn").addEventListener("click", function () {
        // Convert iframe content to PDF
        const iframe = document.getElementById("resumePreview");
        const iframeDoc = iframe.contentDocument || iframe.contentWindow.document;

        html2pdf(iframeDoc.body);
    });
});
