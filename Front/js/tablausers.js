document.addEventListener('DOMContentLoaded', cargarUsuarios);

async function cargarUsuarios() {
  try {
    const jwtToken = localStorage.getItem('jwtToken');
    if (!jwtToken) {
      throw new Error('No se encontró el token');
    }

    const response = await fetch('http://localhost:8080/admin', {
      headers: {
        'Authorization': 'Bearer ' + jwtToken
      }
    });

    if (response.ok) {
      const usuarios = await response.json();
      mostrarUsuariosEnTabla(usuarios);
    } else {
      const mensajeError = 'NO TIENE ACCESO A ESTOS DATOS';
      mostrarError(mensajeError);
    }
  } catch (error) {
    console.error(error);
  }
}

function mostrarUsuariosEnTabla(usuarios) {
  const tbody = document.querySelector('tbody');
  tbody.innerHTML = '';

  usuarios.forEach(function(usuario) {
    const row = document.createElement('tr');
    row.innerHTML = `
      <td>${usuario.id}</td>
      <td>${usuario.nombre}</td>
      <td>${usuario.email}</td>
      <td>${usuario.rol}</td>
    `;
    tbody.appendChild(row);
  });
}

function mostrarError(mensaje) {
  const tbody = document.querySelector('tbody');
  tbody.innerHTML = '';

  const row = document.createElement('tr');
  const errorCell = document.createElement('td');
  errorCell.setAttribute('colspan', '4');
  errorCell.textContent = mensaje;
  row.appendChild(errorCell);
  tbody.appendChild(row);
}
