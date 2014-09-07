<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="CloverXell, console web">
    <meta name="author" content="helio frota">
    <title>Cloverxell</title>
    <link href="static/css/bootstrap.min.css" rel="stylesheet">
  </head>
  <style>
    body {
      padding-top: 50px;
    }
  </style>
  <body>
    <div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">CloverXell</a>
        </div>
      </div>
    </div>
    <div class="container">
      <div>
        <h1>Run commands from aesh !</h1>
      </div>
      
      <form id="commandForm">
        <div class="row">
          <div class="col-xs-4">
             <input type="text" id="inputCommand" class="form-control">
          </div>
        </div>
      </form>
      
      <div class="panel">
         <textarea id="commandResult" class="form-control" rows="20"></textarea>
      </div>
      
    </div>
    <script type="text/javascript" src="static/js/jquery-1.11.1.min.js"></script>
    <script type="text/javascript" src="static/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="static/js/ansi_up.js"></script>
    <script type="text/javascript" src="static/js/app.js"></script>
  </body>
</html>
