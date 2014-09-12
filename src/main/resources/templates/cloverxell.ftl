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
    .form-control:focus{
      border-color: #cccccc;
      -webkit-box-shadow: none;
      box-shadow: none;
    }
    .modifiqueiHAHA{
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
        <h4>Just a web wrapper to use aesh with cloverX framework</h4>
        Available commands: Ls, Mkdir, Pwd, Rm, Touch, Cat, Clear, Echo
      </div>
      <hr>
      
      <form id="commandForm">
        <div class="row" style="background-color: #002b36;">
             <div class="input-group">
             <span class="input-group-addon" style="padding: 1px 1px; border-right: #002b36; border-bottom: #002b36; background-color:#002b36; color: #657b83;">[cloverxell@localhost]$</span>
             <input type="text" id="inputCommand" class="form-control" style="border-left: #002b36; border-bottom: #002b36; background-color:#002b36; color: #657b83;">
             </div>
             <textarea id="commandResult" class="form-control" rows="20" style="border-top: #002b36; background-color:#002b36; color: #657b83;"></textarea>
        </div>
      </form>
      <div class="panel">
         
      </div>
      
    </div>
    <script type="text/javascript" src="static/js/jquery-1.11.1.min.js"></script>
    <script type="text/javascript" src="static/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="static/js/ansi_up.js"></script>
    <script type="text/javascript" src="static/js/app.js"></script>
  </body>
</html>
