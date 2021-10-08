/**
 * script de JavaScript para el formulario de la tabla Car
 */

function insertarRegistroCar() {
  var elemento = {
    id: $("#idCar").val(),
    brand: $("#brand").val(),
    model: $("#model").val(),
    category_id: $("#category_id").val()
  }
  var dataTosend = JSON.stringify(elemento);
  // JSON = JavaScript Object Notation
  $.ajax({
    dataType: 'json',
    data: elemento,
    url: 'https://g7be2fcfb5932c8-db202109261658.adb.sa-santiago-1.oraclecloudapps.com/ords/admin/car/car',
    type: 'POST',
    //contentType:'application/json',
    success: function (response) {
      alert("exitoso")
      console.log(response);
    },
    error: function (jqXHR, textStatus, errorThrown) {
    }
  });
}

function obtenerRegistrosCar() {
  $.ajax({
    dataType: 'json',
    url: 'https://g7be2fcfb5932c8-db202109261658.adb.sa-santiago-1.oraclecloudapps.com/ords/admin/car/car',
    type: 'GET',
    success: function (response) {
      var registrosCar = response.items;
      for (i = 0; i < registrosCar.length; i++) {
        $("#registrosCar").append("<tr>");
        $("#registrosCar").append("<td>" + registrosCar[i].id + "</td>");
        $("#registrosCar").append("<td>" + registrosCar[i].brand + "</td>");
        $("#registrosCar").append("<td>" + registrosCar[i].model + "</td>");
        $("#registrosCar").append("<td>" + registrosCar[i].category_id + "</td>");
        $("#registrosCar").append('<td><button class="btn btn-danger" onclick="borrarRegistroCar(' + registrosCar[i].id + ')">DELETE</button>' + '</td>');
        $("#registrosCar").append('<td><button class="btn btn-info" onclick="obtenerRegistroEspecificoCar(' + registrosCar[i].id + ')">GET</button>' + '</td>');
        $("#registrosCar").append("</tr>");
      }
      //$("#miResultado").append(response.items[0].brand,response.items[0].model);
    },
    error: function (jqXHR, textStatus, errorThrown) {
    }
  });
}

function borrarRegistroCar(idElemento) {
  var elemento = {
    id: idElemento
  };
  var dataTosend = JSON.stringify(elemento);
  //JSON = JavaScript Object Notation
  $.ajax({
    dataType: 'json',
    data: dataTosend,
    url: 'https://g7be2fcfb5932c8-db202109261658.adb.sa-santiago-1.oraclecloudapps.com/ords/admin/car/car',
    type: 'DELETE',
    contentType: 'application/json',
    success: function (response) {
      console.log(response);
    },
    error: function (jqXHR, textStatus, errorThrown) {
    }
  });
}

function obtenerRegistroEspecificoCar(idItem) {
  $.ajax({
    dataType: 'json',
    url: 'https://g7be2fcfb5932c8-db202109261658.adb.sa-santiago-1.oraclecloudapps.com/ords/admin/car/car/' + idItem,
    type: 'GET',
    success: function (response) {
      console.log(response);
      var registrosCar = response.items[0];
      $("#idCar").val(registrosCar.id);
      $("#brand").val(registrosCar.brand);
      $("#model").val(registrosCar.model);
      $("#category_id").val(registrosCar.category_id);
    },
    error: function (jqXHR, textStatus, errorThrown) {
    }
  });
}

function actualizarRegistroCar() {

  var elemento = {
    id: $("#idCar").val(),
    brand: $("#brand").val(),
    model: $("#model").val(),
    category_id: $("#category_id").val()
  }

  var dataTosend = JSON.stringify(elemento)
  //JSON = JavaScript Object Notation

  $.ajax({

    dataType: 'json',
    data: dataTosend,
    contentType: 'application/json',
    url: "https://g7be2fcfb5932c8-db202109261658.adb.sa-santiago-1.oraclecloudapps.com/ords/admin/car/car",
    type: 'PUT',
    success: function (response) {
      console.log(response);
    },
    error: function (jqXHR, textStatus, errorThrown) {
    }
  });
}