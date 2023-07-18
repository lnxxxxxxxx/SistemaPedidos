document.addEventListener("DOMContentLoaded", function () {
    var provinciaSelect = document.getElementById("inputProvincia");
    var localidadSelect = document.getElementById("selectLocalidad");
  
    // Función para actualizar las opciones de localidad según la provincia seleccionada
    function actualizarLocalidades() {
      var provinciaSeleccionada = provinciaSelect.value;
  
      // Deshabilitar el campo de selección de localidad si no se ha seleccionado una provincia
      localidadSelect.disabled = provinciaSeleccionada === "";
  
      // Mostrar todas las opciones de localidad inicialmente
      var localidades = localidadSelect.querySelectorAll("option");
      localidades.forEach(function (localidad) {
        localidad.style.display = "block";
      });
  
      // Ocultar las opciones de localidad que no corresponden a la provincia seleccionada
      if (provinciaSeleccionada === "1") { // Buenos Aires
        var gbaLocalidades = localidadSelect.querySelectorAll(".localidad-buenos-aires-GBA");
        gbaLocalidades.forEach(function (localidad) {
          localidad.style.display = "none";
        });
        var buenosAiresLocalidades = localidadSelect.querySelectorAll(".localidad-buenos-aires");
        buenosAiresLocalidades.forEach(function (localidad) {
          localidad.style.display = "block";
        });
        var saltaLocalidades = localidadSelect.querySelectorAll(".localidad-salta");
        saltaLocalidades.forEach(function (localidad) {
          localidad.style.display = "none";
        });
      } else if (provinciaSeleccionada === "2") { // Buenos Aires GBA
        var gbaLocalidades = localidadSelect.querySelectorAll(".localidad-buenos-aires-GBA");
        gbaLocalidades.forEach(function (localidad) {
          localidad.style.display = "block";
        });
        var buenosAiresLocalidades = localidadSelect.querySelectorAll(".localidad-buenos-aires");
        buenosAiresLocalidades.forEach(function (localidad) {
          localidad.style.display = "none";
        });
        var saltaLocalidades = localidadSelect.querySelectorAll(".localidad-salta");
        saltaLocalidades.forEach(function (localidad) {
          localidad.style.display = "none";
        });
      } else if (provinciaSeleccionada === "3") { // Salta
        var gbaLocalidades = localidadSelect.querySelectorAll(".localidad-buenos-aires-GBA");
        gbaLocalidades.forEach(function (localidad) {
          localidad.style.display = "none";
        });
        var buenosAiresLocalidades = localidadSelect.querySelectorAll(".localidad-buenos-aires");
        buenosAiresLocalidades.forEach(function (localidad) {
          localidad.style.display = "none";
        });
        var saltaLocalidades = localidadSelect.querySelectorAll(".localidad-salta");
        saltaLocalidades.forEach(function (localidad) {
          localidad.style.display = "block";
        });
      }
    }
  
    // Actualizar las opciones de localidad cuando se cambia la provincia seleccionada
    provinciaSelect.addEventListener("change", actualizarLocalidades);
  
    // Inicializar las opciones de localidad al cargar la página
    actualizarLocalidades();
  });
  