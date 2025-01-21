const container = document.getElementById('container');
const registerBtn = document.getElementById('register');
const loginBtn = document. getElementById('login');

registerBtn.addEventListener('click', () =>{
    container.classList.add("active");

});
loginBtn.addEventListener('click', () =>{
    container.classList.remove("active");

});

document.addEventListener('DOMContentLoaded', function() {
    document.getElementById('signUp').addEventListener('click', function(event) {
        event.preventDefault(); // Evita que el formulario se envíe de forma predeterminada

        window.location.href = 'http://localhost:8080/oauth2/authorization/google';

        /*
        alert("Hola")

        const userName = document.querySelector('input[placeholder="Name"]').value;
        const email = document.querySelector('input[placeholder="Email"]').value;
        const password = document.querySelector('input[placeholder="Password"]').value;

        const data = {
            "user_name": userName,
            "mail": email,
            "password": password,
            "authenticated": false,
            "role": "USER"
        }

        alert("Registrando usuario");

        fetch('http://localhost:8079/auth/register', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(data),
        })
            .then(response => response.json())
            .then(data => {
                console.log('Success:', data);
                // Aquí puedes redirigir al usuario o mostrar un mensaje de éxito
            })
            .catch(error => {
                console.error('Error:', error);
                // Aquí puedes mostrar un mensaje de error al usuario
            });

         */
    });
});