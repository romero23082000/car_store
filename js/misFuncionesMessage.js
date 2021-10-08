function registroMessage() {
  var elemento = {
    id: $("#idMessage").val(),
    messagetext: $("#messagetext").val(),

  }

  var dataTosend = JSON.stringify(elemento);
  // JSON = JavaScript Object Notation

  $.ajax({

    dataType: 'json',
    data: elemento,
    url: 'https://g7be2fcfb5932c8-db202109261658.adb.sa-santiago-1.oraclecloudapps.com/ords/admin/message/message',
    type: 'POST',
    //contentType:'application/json',
    success: function (response) {

      console.log(response);
    },

    error: function (jqXHR, textStatus, errorThrown) {

    }


  });

}

function obtenerItemsMessage() {

  $.ajax({

    dataType: 'json',
    url: 'https://g7be2fcfb5932c8-db202109261658.adb.sa-santiago-1.oraclecloudapps.com/ords/admin/message/message',
    type: 'GET',

    success: function (response) {

      var registrosMessage = response.items;

      for (i = 0; i < registrosMessage.length; i++) {

        $("#registrosMessage").append("<tr>");
        $("#registrosMessage").append("<td>" + registrosMessage[i].id + "</td>");
        $("#registrosMessage").append("<td>" + registrosMessage[i].messagetext + "</td>");
        $("#registrosMessage").append('<td> <button class="btn btn-danger" onclick="borrarMessage(' + registrosMessage[i].id + ')">DELETE</button>' + '</td>');
        $("#registrosMessage").append('<td> <button class="btn btn-info" onclick="obtenerRegistroEspecificoMessage(' + registrosMessage[i].id + ')">GET</button>' + '</td>');
        $("#registrosMessage").append("</tr>");

      }
    },

    error: function (jqXHR, textStatus, errorThrown) {

    }

  });

}

function borrarMessage(idElemento) {

  var elemento = {
    id: idElemento
  }

  var dataToSend = JSON.stringify(elemento);
  //JSON = JavaScript Object Notation

  $.ajax({

    dataType: 'json',
    data: dataToSend,
    url: 'https://g7be2fcfb5932c8-db202109261658.adb.sa-santiago-1.oraclecloudapps.com/ords/admin/message/message',
    type: 'DELETE',
    contentType: 'application/json',

    success: function (response) {
      console.log(response);
    },

    error: function (jqXHR, textStatus, errorThrown) {

    }
  });


}

function obtenerRegistroEspecificoMessage(idRegistro) {

  $.ajax({

    dataType: 'json',
    url: 'https://g7be2fcfb5932c8-db202109261658.adb.sa-santiago-1.oraclecloudapps.com/ords/admin/message/message/' + idRegistro,
    type: 'GET',

    success: function (response) {
      console.log(response);

      var registrosMessage = response.items[0];

      $("#idMessage").val(registrosMessage.id);
      $("#messagetext").val(registrosMessage.messagetext);


    },

    error: function (jqXHR, textStatus, errorThrown) {

    }
  });
}

function actualizarMessage() {

  var elemento = {
    id: $("#idMessage").val(),
    messagetext: $("#messagetext").val(),

  }
  var dataTosend = JSON.stringify(elemento)
  //JSON = JavaScript Object Notation

  $.ajax({
    dataType: 'json',
    data: dataTosend,
    contentType: 'application/json',
    url: 'https://g7be2fcfb5932c8-db202109261658.adb.sa-santiago-1.oraclecloudapps.com/ords/admin/message/message',
    type: 'PUT',
    success: function (response) {
      console.log(response);
    },
    error: function (jqXHR, textStatus, errorThrown) {

    }



  });
}



