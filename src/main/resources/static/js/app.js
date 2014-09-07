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
        var html = ansi_up.ansi_to_html(response);
        html = html.replace(inputCommand.command,'');
        html = html.replace('0G2K','');
        html = html.replace('0G2K','');
        html = html.replace('0Gmand: ','command');
        html = html.replace('\n','');
        $("#commandResult").val(html);
      },
      error : function(xhr, st, err) {
        console.log("Error: " + err);
        console.log("Status: " + st);
        console.dir(xhr);
      }
    });
  }
};

$('#commandForm').submit(function(event) {
  event.preventDefault();
  cloverxell.send();
});
