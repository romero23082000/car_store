function registro() {
  var elemento = {
    id: $("#id").val(),
    brand: $("#brand").val(),
    model: $("#model").val(),
    category_id: $("#category_id").val()
  }
  // var dataToSend = JSON.stringify(elemento);
  // console.log('data: ' + elemento)
  //JSON= JavaScript Object Notation
  $.post({
    dataType: 'json',
    data: elemento,
    url: "https://g7be2fcfb5932c8-db202109261658.adb.sa-santiago-1.oraclecloudapps.com/ords/admin/car/car",
    type: 'POST',
    success: function (response) {
      console.log(response);
    },
    error: function (jqXHR, textStatus, errorThrown) {

    }
  });
}

function obtenerItems() {
  $.ajax({
    dataType: 'json',
    url: "https://g7be2fcfb5932c8-db202109261658.adb.sa-santiago-1.oraclecloudapps.com/ords/admin/car/car",
    type: 'GET',
    success: function (response) {
      var misItems = response.items;
      for (i = 0; i < misItems.length; i++) {
        $("#miResultado").append("<tr>");
        $("#miResultado").append("<td>" + misItems[i].brand + "</td>");
        $("#miResultado").append("<td>" + misItems[i].model + "</td>");
        $("#miResultado").append("<td>" + misItems[i].category_id + "</td>");
        $("#miResultado").append('<td><button onclick="borrar(' + misItems[i].id + ')">Borrar</button></td>');
        $("#miResultado").append('<td><button onclick="obtenerItemEspecifico(' + misItems[i].id + ')">Cargar</button></td>');
        $("#miResultado").append("</tr>");
      }
    },
    error: function (jqXHR, textStatus, errorThrown) {
    }
  });

}


function borrar(idElemento) {
  var elemento = {
    id: idElemento
  };
  var dataToSend = JSON.stringify(elemento);
  //JSON= JavaScript Object Notation
  $.ajax({
    dataType: 'json',
    data: dataToSend,
    url: "https://g7be2fcfb5932c8-db202109261658.adb.sa-santiago-1.oraclecloudapps.com/ords/admin/car/car",
    type: 'DELETE',
    contentType: 'application/json',
    success: function (response) {
      $("#miResultado").empty();
      obtenerItems();
      console.log("Borrado con exito")
    },
    error: function (jqXHR, textStatus, errorThrown) {
    }
  });
}


function obtenerItemEspecifico(idItem) {
  $.ajax({
    dataType: 'json',
    url: "https://g7be2fcfb5932c8-db202109261658.adb.sa-santiago-1.oraclecloudapps.com/ords/admin/car/car/" + idItem,
    type: 'GET',
    success: function (response) {
      console.log(response);
      var item = response.items[0];
      $("#id").val(item.id);
      $("#brand").val(item.brand);
      $("#model").val(item.model);
      $("#category_id").val(item.category_id);
    },
    error: function (jqXHR, textStatus, errorThrown) {
    }
  });

}

function actualizar() {
  var elemento = {
    id: parseInt($("#id").val()),
    brand: $("#brand").val(),
    model: parseInt($("#model").val()),
    category_id: parseInt($("#category_id").val())
  }
  var dataToSend = JSON.stringify(elemento);
  //JSON= JavaScript Object Notation
  $.ajax({
    dataType: 'json',
    data: dataToSend,
    contentType: 'application/json',
    url: "https://g7be2fcfb5932c8-db202109261658.adb.sa-santiago-1.oraclecloudapps.com/ords/admin/car/car",
    type: 'PUT',
    success: function () {
      // $("#miResultado").empty();
      obtenerItems();
      console.log("Peticion realizada")
    }
    // error: function (jqXHR, textStatus, errorThrown) {
    //   console.log(jqXHR)
    //   console.log(textStatus)
    //   console.log(errorThrown)
    // }
  });

}

// /*<!-- --- --- --- -->
// <!-- Inicio de funcion que me muestra los datos-->*/

// //metodo que habilita los CORS  a true para poder mostrar los datos
// var elemento = {
//   id: $("#miId").val(),
//   name: $("#name").val(),
//   description: $("#description").val(),
//   price: $("#price").val()
// }
// var dataToSend = JSON.stringify(elemento);
// function traerInformacion() {
//   $.ajax({
//     url: "https://g7be2fcfb5932c8-db202109261658.adb.sa-santiago-1.oraclecloudapps.com/ords/admin/car1/car1",
//     type: "GET", //tipo de consulta
//     dataType: "JSON", //tipo de dato 
//     success: function (respuesta) {
//       console.log(respuesta);
//       pintarRespuesta(respuesta.items)
//       // ciclo que recorre los items que devuelve la peticion GET
//       // for (i = 0; i < respuesta.items.length; i++) {
//       //   //$("#resultado").append(respuesta.items[i].id + "<br>");
//       // }
//     }
//   });
// }

// /*<!-- Fin de  funcion que me muestra los datos--- -->
// <!-- --- --- --- -->*/

// /*<!-- --- --- --- -->
// <!-- Inicio de guardar informacion POST-->*/
// function guardarInfo() {
//   var myData = {
//     id: $("#id").val(),
//     brand: $("#brand").val(),
//     model: $("#model").val(),
//     category_id: $("#category_id").val(),
//   };
//   var dataToSend = JSON.stringify(myData);
//   $.ajax({
//     url: "https://g7be2fcfb5932c8-db202109261658.adb.sa-santiago-1.oraclecloudapps.com/ords/admin/car1/car1",
//     type: "POST", //tipo de consulta
//     data: myData,
//     dataType: 'JSON', //tipo de dato
//     // contentType: 'application/json',
//     success: function (response) {
//       traerInformacion();
//       console.log("Guardado exitosamente" + response)
//     }, error: function (jqXHR, textStatus, errorThrown) {
//       console.log(textStatus)
//       console.log(errorThrown)
//     }
//   })
// }
// /*<!-- Fin de  guardar informacion POST--- -->
// <!-- --- --- --- -->*/

// /*<!-- --- --- --- -->
// <!-- Inicio de actualizar datos PUT-->*/
// function actualizarInfo() {
//   let myData = {
//     id: $("#id").val(),
//     brand: $("#brand").val(),
//     model: $("#model").val(),
//     category_id: $("#category_id").val(),
//   };
//   let dataToSend = JSON.stringify(myData);
//   $.ajax({
//     url: "https://g7be2fcfb5932c8-db202109261658.adb.sa-santiago-1.oraclecloudapps.com/ords/admin/car1/car1",
//     type: "PUT", //tipo de consulta
//     data: dataToSend,
//     dataType: "JSON", //tipo de dato
//     contentType: "application/json",
//     success: function () {
//       $("#resultado").empty();
//       $("#id").val("");
//       $("#brand").val("");
//       $("#model").val("");
//       $("#category_id").val("");
//       traerInformacion();
//       alert("Peticion realizada")
//     }
//   });
// }
// /*<!-- Fin de  actualizar datos--- -->
// <!-- --- --- --- -->*/



// /*<!-- --- --- --- -->
// <!-- Inicio de pintar respuestas-->*/
// function pintarRespuesta(items) {
//   //definicion de la etiqueta table
//   let mitablero = "<table>";
//   for (i = 0; i < items.length; i++) {
//     mitablero += "<tr>";
//     mitablero += "<td>" + items[i].id + "</td>";
//     mitablero += "<td>" + items[i].brand + "</td>";
//     mitablero += "<td>" + items[i].model + "</td>";
//     mitablero += "<td>" + items[i].category_id + "</td>";
//     mitablero += "<td> <button onclick='borrarElemento(" + items[i].id + ")'>Borrar</button>";
//     mitablero += "</tr>";
//   }
//   mitablero += "</table>";
//   $("#resultado").append(mitablero)
// }
// /*<!-- Fin de  pintar respuestas--- -->
// <!-- --- --- --- -->*/



// function borrarElemento(idElemento) {
//   let myData = {
//     id: idElemento
//   };
//   let dataToSend = JSON.stringify(myData);
//   $.ajax({
//     url: "https://g7be2fcfb5932c8-db202109261658.adb.sa-santiago-1.oraclecloudapps.com/ords/admin/car1/car1",
//     type: "DELETE", //tipo de consulta
//     data: dataToSend,
//     dataType: "JSON", //tipo de dato
//     contentType: "application/JSON",
//     success: function (respuesta) {
//       $("#resultado").empty();
//       traerInformacion();
//       alert("Borrado con exito")
//     }
//   });
// }