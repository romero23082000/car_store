function registroClient() {
  var elemento = {
    id: $("#idClient").val(),
    name: $("#name").val(),
    email: $("#email").val(),
    age: $("#age").val()
  }

  var dataTosend = JSON.stringify(elemento);
  // JSON = JavaScript Object Notation

  $.ajax({

    dataType: 'json',
    data: elemento,
    url: 'https://g7be2fcfb5932c8-db202109261658.adb.sa-santiago-1.oraclecloudapps.com/ords/admin/client/client',
    type: 'POST',
    //contentType:'application/json',
    success: function (response) {

      console.log(response);
    },

    error: function (jqXHR, textStatus, errorThrown) {

    }


  });

}

function obtenerItemsClient() {

  $.ajax({

    dataType: 'json',
    url: 'https://g7be2fcfb5932c8-db202109261658.adb.sa-santiago-1.oraclecloudapps.com/ords/admin/client/client',
    type: 'GET',

    success: function (response) {

      var registrosClient = response.items;

      for (i = 0; i < registrosClient.length; i++) {

        $("#registrosClient").append("<tr>");
        $("#registrosClient").append("<td>" + registrosClient[i].id + "</td>");
        $("#registrosClient").append("<td>" + registrosClient[i].name + "</td>");
        $("#registrosClient").append("<td>" + registrosClient[i].email + "</td>");
        $("#registrosClient").append("<td>" + registrosClient[i].age + "</td>");
        $("#registrosClient").append('<td> <button class="btn btn-danger" onclick="borrarRegistroClient(' + registrosClient[i].id + ')">DELETE</button>' + '</td>');
        $("#registrosClient").append('<td> <button class="btn btn-info" onclick="obtenerRegistroEspecificoClient(' + registrosClient[i].id + ')">GET</button>' + '</td>');
        $("#registrosClient").append("</tr>");

      }
    },

    error: function (jqXHR, textStatus, errorThrown) {

    }

  });

}

function borrarRegistroClient(idElemento) {

  var elemento = {
    id: idElemento
  }

  var dataToSend = JSON.stringify(elemento);
  //JSON = JavaScript Object Notation

  $.ajax({

    dataType: 'json',
    data: dataToSend,
    url: 'https://g7be2fcfb5932c8-db202109261658.adb.sa-santiago-1.oraclecloudapps.com/ords/admin/client/client',
    type: 'DELETE',
    contentType: 'application/json',

    success: function (response) {
      console.log(response);
    },

    error: function (jqXHR, textStatus, errorThrown) {

    }
  });


}

function obtenerRegistroEspecificoClient(idRegistro) {

  $.ajax({

    dataType: 'json',
    url: 'https://g7be2fcfb5932c8-db202109261658.adb.sa-santiago-1.oraclecloudapps.com/ords/admin/client/client/' + idRegistro,
    type: 'GET',

    success: function (response) {
      console.log(response);

      var registrosClient = response.items[0];

      $("#idClient").val(registrosClient.id);
      $("#name").val(registrosClient.name);
      $("#email").val(registrosClient.email);
      $("#age").val(registrosClient.age);

    },

    error: function (jqXHR, textStatus, errorThrown) {

    }
  });
}

function actualizarClient() {

  var elemento = {
    id: $("#idClient").val(),
    name: $("#name").val(),
    email: $("#email").val(),
    age: $("#age").val()
  }
  var dataTosend = JSON.stringify(elemento)
  //JSON = JavaScript Object Notation

  $.ajax({

    dataType: 'json',
    data: dataTosend,
    contentType: 'application/json',
    url: 'https://g7be2fcfb5932c8-db202109261658.adb.sa-santiago-1.oraclecloudapps.com/ords/admin/client/client',
    type: 'PUT',
    success: function (response) {
      console.log(response);
    },

    error: function (jqXHR, textStatus, errorThrown) {

    }



  });
}



