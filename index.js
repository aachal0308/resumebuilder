
/*document.addEventListener("DOMContentLoaded", function () {
    const loginForm = document.getElementById("login-form");
    const signupForm = document.getElementById("signup-form");
    const formTitle = document.getElementById("form-title");
    const errorMessage = document.createElement("p");
    errorMessage.id = "errorMessage";
    document.querySelector(".form-box").appendChild(errorMessage);

    const switchToSignup = document.getElementById("switch-to-signup");
    const switchToLogin = document.getElementById("switch-to-login");
    
     // Check if user is already logged in
     if (sessionStorage.getItem("sessionId") && localStorage.getItem("userId")) {
        window.location.href = "dashboard.html"; // Redirect to dashboard if session exists
    }

    // Check if user has already signed up
    /*if (localStorage.getItem("isSignedUp")) {
        loginForm.style.display = "block";
        signupForm.style.display = "none";
        formTitle.textContent = "login";
    }else{
        loginForm.style.display="none";
        signupForm.style.display="block";
        formTitle.textContent="Sign up";
    }

    // Switch to Signup Form
    switchToSignup.addEventListener("click", function (event) {
        event.preventDefault();
        loginForm.style.display = "none";
        signupForm.style.display = "block";
        formTitle.textContent = "Sign Up";
        errorMessage.textContent = ""; // Clear error message
    });

    // Switch to Login Form
    switchToLogin.addEventListener("click", function (event) {
        event.preventDefault();
        signupForm.style.display = "none";
        loginForm.style.display = "block";
        formTitle.textContent = "Login";
        errorMessage.textContent = ""; // Clear error message
    });

    // Form Validation & Signup Request
    signupForm.addEventListener("submit", function (event) {
        event.preventDefault();
        const fullname = signupForm.querySelector("input[name='fullname']").value;
        const email=signupForm.querySelector("input[name='email']").value;
        const userName = signupForm.querySelector("input[name='username']").value;
        const password = signupForm.querySelector("input[type='password']").value;

        if (userName === "" || password === "" || fullname=="" || email=="") {
            errorMessage.textContent = "All fields are required!";
            return;
        }
        
        // check email pattern
        const emailPattern = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;

        if(!emailPattern.test(email)){
            errorMessage.textContent="Enter a valid email address";
            return;
        }

        if (password.length < 4) {
            errorMessage.textContent = "Password must be at least 4 characters!";
            return;
        } 

        // Send signup request to backend
        fetch("http://localhost:8080/signup", {
            method: "POST",
            headers: {"Content-Type": "application/json"},
            body: JSON.stringify({
                user:{
                    id: Date.now().toString(), // Unique ID for user (replace with backend logic if needed)
                    fullName: fullName,
                    email: email,
                    username: userName,
                    password: password

                    }
                    
                })
            })
        .then(response => {
            if (!response.ok) {
                throw new Error("Signup failed! Please try again.");
            }
            return response.json();
        })
        .then(data => {
            console.log("Signup Successful:", data);
            alert("Signup Successful!");

            // Store signup status in localStorage
           // localStorage.setItem("isSignedUp", "true");

            // Store user ID
            localStorage.setItem("userId", data.userId);

            signupForm.reset();
            signupForm.style.display = "none";
            loginForm.style.display = "block"; 
            formTitle.textContent = "Login";
        })
        .catch(error => {
            console.error("Error:", error);
            errorMessage.textContent = "Signup failed. Try again.";
        });
        
    });

    // Form Validation & Login Request
    loginForm.addEventListener("submit", function (event) {
        event.preventDefault();
        const userName = loginForm.querySelector("input[name='username']").value;
        const password = loginForm.querySelector("input[type='password']").value;

        if (userName === "" || password === "") {
            errorMessage.textContent = "All fields are required!";
            return;
        } 

        // Send login request to backend
        // fetch(`http://localhost:8080/login?username=${encodeURIComponent(userName)}&password=${encodeURIComponent(password)}`, {
        //     method: "POST",
        //     headers: {"Content-Type": "application/json"}
        // })
        fetch("http://localhost:8080/login", {
            method: "POST",
            headers: {"Content-Type": "application/json"},
            body: JSON.stringify({
                username: userName,
                password: password
            })
        })
        
            .then(response => {
                if (!response.ok) {
                    throw new Error("Invalid username or password.");
                }
                return response.json();
            })
            .then(data => {
                console.log("Login Successful:", data);
                alert("Login Successful!");

                 // Store session ID and user ID
                sessionStorage.setItem("sessionId", data.sessionId);
                localStorage.setItem("userId", data.userId);


                // Redirect to dashboard or another page after login
                window.location.href = "dashboard.html";
            })
            .catch(error => {
                console.error("Error:", error);
                errorMessage.textContent = "Invalid credentials. Please try again.";
            });
        }
});*/
// document.addEventListener("DOMContentLoaded", function () {
//     const loginForm = document.getElementById("login-form");
//     const signupForm = document.getElementById("signup-form");
//     const formTitle = document.getElementById("form-title");

//     const switchToSignup = document.getElementById("switch-to-signup");
//     const switchToLogin = document.getElementById("switch-to-login");

//     const BASE_URL = "http://localhost:8080"; // Update this if deployed

//     // Switch to Signup Form
//     switchToSignup.addEventListener("click", function (e) {
//         e.preventDefault();
//         loginForm.style.display = "none";
//         signupForm.style.display = "block";
//         formTitle.textContent = "Sign Up";
//     });

//     // Switch to Login Form
//     switchToLogin.addEventListener("click", function (e) {
//         e.preventDefault();
//         signupForm.style.display = "none";
//         loginForm.style.display = "block";
//         formTitle.textContent = "Login";
//     });

//     // Handle Signup Form Submission
//     signupForm.addEventListener("submit", async function (e) {
//         e.preventDefault();
//         const formData = new FormData(signupForm);
//         const data = Object.fromEntries(formData.entries());

//         try {
//             const response = await fetch(`${BASE_URL}/signup`, {
//                 method: "POST",
//                 headers: { "Content-Type": "application/json" },
//                 body: JSON.stringify(data),
//             });

//             if (response.ok) {
//                 alert("Signup successful! Please login.");
//                 switchToLogin.click(); // Switch to login form
//             } else {
//                 const error = await response.json();
//                 alert(error.message || "Signup failed.");
//             }
//         } catch (error) {
//             console.error("Error:", error);
//         }
//     });

//     // Handle Login Form Submission
//     loginForm.addEventListener("submit", async function (e) {
//         e.preventDefault();
//         const formData = new FormData(loginForm);
//         const data = Object.fromEntries(formData.entries());

//         try {
//             const response = await fetch(`${BASE_URL}/login`, {
//                 method: "POST",
//                 headers: { "Content-Type": "application/json" },
//                 body: JSON.stringify(data),
//             });

//             if (response.ok) {
//                 const result = await response.json();
//                 alert("Login successful!");
//                 localStorage.setItem("token", result.token); // Store token if required
//                 window.location.href = "dashboard.html"; // Redirect to dashboard
//             } else {
//                 const error = await response.json();
//                 alert(error.message || "Invalid login credentials.");
//             }
//         } catch (error) {
//             console.error("Error:", error);
//         }
//     });
// });
document.addEventListener("DOMContentLoaded", function () {
    const loginForm = document.getElementById("login-form");
    const signupForm = document.getElementById("signup-form");
    const formTitle = document.getElementById("form-title");
    const errorMessage = document.createElement("p");
    errorMessage.id = "errorMessage";
    document.querySelector(".form-box").appendChild(errorMessage);

    const switchToSignup = document.getElementById("switch-to-signup");
    const switchToLogin = document.getElementById("switch-to-login");

    const BASE_URL = "http://localhost:8080"; // Change if necessary

    // Check if user is already logged in
    if (sessionStorage.getItem("sessionId") && localStorage.getItem("userId")) {
        window.location.href = "dashboard.html"; // Redirect if session exists
    }

    // Switch to Signup Form
    switchToSignup.addEventListener("click", function (event) {
        event.preventDefault();
        loginForm.style.display = "none";
        signupForm.style.display = "block";
        formTitle.textContent = "Sign Up";
        errorMessage.textContent = ""; // Clear error message
    });

    // Switch to Login Form
    switchToLogin.addEventListener("click", function (event) {
        event.preventDefault();
        signupForm.style.display = "none";
        loginForm.style.display = "block";
        formTitle.textContent = "Login";
        errorMessage.textContent = ""; // Clear error message
    });

    // Handle Signup Form Submission
    signupForm.addEventListener("submit", async function (event) {
        event.preventDefault();
        const fullname = signupForm.querySelector("input[name='fullname']").value;
        const email = signupForm.querySelector("input[name='email']").value;
        const userName = signupForm.querySelector("input[name='username']").value;
        const password = signupForm.querySelector("input[type='password']").value;

        if (!fullname || !email || !userName || !password) {
            errorMessage.textContent = "All fields are required!";
            return;
        }

        // Corrected email validation regex
        const emailPattern = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
        if (!emailPattern.test(email)) {
            errorMessage.textContent = "Enter a valid email address";
            return;
        }

        if (password.length < 4) {
            errorMessage.textContent = "Password must be at least 4 characters!";
            return;
        }

        try {
            const response = await fetch(`${BASE_URL}/signup`, {
                method: "POST",
                headers: { "Content-Type": "application/json" },
                body: JSON.stringify({
                    user:{
                        id: Date.now().toString(), // Use backend logic for ID generation
                        fullName: fullname,
                        email: email,
                        username: userName,
                        password: password

                    }
                    
                })
            });

            if (!response.ok) throw new Error("Signup failed! Please try again.");

            const data = await response.json();
            console.log("Signup Successful:", data);
            alert("Signup Successful!");

            // Store user ID
            localStorage.setItem("userId", data.userId);

            signupForm.reset();
            signupForm.style.display = "none";
            loginForm.style.display = "block";
            formTitle.textContent = "Login";
        } catch (error) {
            console.error("Error:", error);
            errorMessage.textContent = "Signup failed. Try again.";
        }
    });

    // Handle Login Form Submission
    loginForm.addEventListener("submit", async function (event) {
        event.preventDefault();
        const userName = loginForm.querySelector("input[name='username']").value;
        const password = loginForm.querySelector("input[type='password']").value;

        if (!userName || !password) {
            errorMessage.textContent = "All fields are required!";
            return;
        }

        try {
            const response = await fetch(`${BASE_URL}/login`, {
                method: "POST",
                headers: { "Content-Type": "application/json" },
                body: JSON.stringify({
                    username: userName,
                    password: password
                })
            });

            if (!response.ok) throw new Error("Invalid username or password.");

            const data = await response.json();
            console.log("Login Successful:", data);
            alert("Login Successful!");

            // Store session ID and user ID
            sessionStorage.setItem("sessionId", data.sessionId);
            localStorage.setItem("userId", data.userId);

            // Redirect to dashboard
            window.location.href = "dashboard.html";
        } catch (error) {
            console.error("Error:", error);
            errorMessage.textContent = "Invalid credentials. Please try again.";
        }
    });
});
