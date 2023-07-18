document.addEventListener('DOMContentLoaded', function() {
  document.getElementById('loginButton').addEventListener('click', loginUsuario);
});

function loginUsuario(event) {
  event.preventDefault(); // Evita el comportamiento predeterminado de enviar el formulario

  // Obtener los valores de los campos del formulario
  var usuario = document.getElementById('inputMail').value;
  var clave = document.getElementById('inputPassword').value;

  // Crear objeto con los datos del usuario
  var usuarioData = {
    usuario: usuario,
    clave: clave
  };

  // Realizar la petición POST
  fetch('http://localhost:8080/login', {
    method: 'POST',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(usuarioData)
  })
  .then(response => {
    if (response.ok) {
      return response.json();
    } else {
      throw new Error('El usuario no existe');
    }
  })
  .then(data => {
    console.log(data);

    // Guardar el token en el almacenamiento local
    localStorage.setItem('jwtToken', data.jwtToken);
    window.location.href = 'index.html';
   
  })
  .catch(error => {
    console.error(error);
  });
}
