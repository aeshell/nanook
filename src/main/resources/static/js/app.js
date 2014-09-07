var cloverxell = {
  send : function() {
    var inputCommand = new Object();
    inputCommand.command = $("#inputCommand").val(); 
    $.ajax({
      url : "app/send",
      data : inputCommand,
      type : "POST",
      dataType : "html",
      success : function(response) {
        $("#commandResult").val(response);
        console.log(response);
      },
      error : function(xhr, st, err) {
        console.log("Error: " + err);
        console.log("Status: " + st);
        console.dir(xhr);
      }
    });
  }
};
