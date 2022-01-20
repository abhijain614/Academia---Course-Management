let login_form = document.getElementById('login-validation');

login_form.addEventListener('submit', async (e) => {
    e.preventDefault();
    e.stopPropagation();
    if (login_form.checkValidity() === true) {
        let response = await fetch('api/employee/login', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json;charset=utf-8'
            },
            body: JSON.stringify({
                email: document.getElementById('email').value,
                // this email must match with column in bean file
            })
        });
        let result = await response;   //response from backend(true or false) is returned to front end
        if(result["status"]===200){
            window.location.href = 'dashboard.html';
        }else{
            document.getElementById("login-alert").style.display = "block";
        }

    }
});