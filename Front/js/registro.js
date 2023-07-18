async function registrarUsuario() {
    try {
      // Obtener los valores de los campos del formulario
      var nombre = document.getElementById('registroNombre').value;
      var email = document.getElementById('registroEmail').value;
      var password = document.getElementById('registroPassword').value;
  
      // Crear objeto con los datos del usuario
      var usuario = {
        nombre: nombre,
        email: email,
        password: password
      };
  
      // Realizar la petición POST
      const response = await fetch('http://localhost:8080/register', {
        method: 'POST',
        headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json'
        },
        body: JSON.stringify(usuario)
      });
  
      if (response.ok) {
        const data = await response.json();
        console.log(data);
        alert("La cuenta fue creada con exito!");
        window.location.href = 'login.html'
      } else {
        throw new Error('Error en la petición POST');
      }
    } catch (error) {
      console.error(error);
    }


  }
  