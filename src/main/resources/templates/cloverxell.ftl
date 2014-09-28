<!-- 
 Copyright 2014 EsmerilProgramming.
  
 Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 in compliance with the License. You may obtain a copy of the License at
  
 http://www.apache.org/licenses/LICENSE-2.0
  
 Unless required by applicable law or agreed to in writing, software distributed under the License
 is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 or implied. See the License for the specific language governing permissions and limitations under
 the License.
 -->
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
	background-color: #002b36;
}

.form-control:focus {
	border-color: #cccccc;
	-webkit-box-shadow: none;
	box-shadow: none;
}

textarea {
	resize: none;
}

pre {
  background-color: #002b36; 
  color: #657b83;
  border: #002b36;
}

.label-cloverxell {
  background-color: #002b36;
}

.label-black {
  background-color: #000000;
  color: #ffffff;
}

.label-white {
  background-color: #ffffff;
  color: #000000;
}
</style>
<body>
  <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container-fluid">
      <div class="navbar-header">
        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#cloverxell_menu">
          <span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span>
        </button>
      </div>

      <div class="collapse navbar-collapse" id="cloverxell_menu">
        <ul class="nav navbar-nav">
          <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown" style="margin-left: -20px;">File<span class="caret"></span></a>
            <ul class="dropdown-menu" role="menu">
              <li><a href="javascript:void(0);" onclick="cloverxell.newTab();">Open Tab</a></li>
            </ul></li>
          <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">Edit<span class="caret"></span></a>
            <ul class="dropdown-menu" role="menu">
              <li><a href="javascript:void(0);" data-toggle="modal" data-target="#bgModal">BG color</a></li>
              <li><a href="javascript:void(0);" data-toggle="modal" data-target="#fgModal">FG color</a></li>
            </ul></li>
          <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">View<span class="caret"></span></a>
            <ul class="dropdown-menu" role="menu">
              <li><a href="javascript:void(0);" onclick="cloverxell.fontInc();">Size +</a></li>
              <li><a href="javascript:void(0);" onclick="cloverxell.fontDec();">Size -</a></li>
            </ul></li>
          <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">Terminal<span class="caret"></span></a>
            <ul class="dropdown-menu" role="menu">
              <li><a href="javascript:void(0);" onclick="document.getElementById('inputCommand').value='clear';cloverxell.send();">Clear</a></li>
              <li><a href="javascript:void(0);" onclick="document.getElementById('titleForm').style.display='block';">Set Title...</a></li>
            </ul></li>
          <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">Help<span class="caret"></span></a>
            <ul class="dropdown-menu" role="menu">
              <li><a href="https://github.com/EsmerilProgramming/cloverxell" target="_blank">Contents</a></li>
              <li><a href="javascript:void(0);" id="about" data-toggle="modal" data-target="#aboutModal">About</a></li>
            </ul>
          </li>
          <li id="titleForm" style="display:none;">
            <form class="navbar-form navbar-left">
              <div class="form-group">
                <input type="text" id="inputTitle" class="form-control" placeholder="Title...">
              </div>
              <button type="button" onclick="document.title=inputTitle.value;document.getElementById('titleForm').style.display='none';" class="btn btn-default">Ok</button>
            </form>
          </li>
        </ul>

        <ul class="nav navbar-nav navbar-right">
          <li><a href="https://github.com/EsmerilProgramming/cloverxell" target="_blank">Cloverxell</a></li>
        </ul>
      </div>
    </div>
  </nav>

  <div style="padding-left: 10px; width: 98%">
    <form id="commandForm">
      <div class="row" style="background-color: #002b36;">
        <div class="input-group">
          <span id="commandPrompt" class="input-group-addon" style="padding-left: 12px; padding-right: 0; border: #002b36; background-color: #002b36; color: #657b83;">[cloverxell@localhost]$</span> 
          <input type="text" id="inputCommand" class="form-control" style="border: #002b36; background-color: #002b36; color: #657b83;">
        </div>
        <div id="commandResult" style="background-color: #002b36; color: #657b83;"></div>
      </div>
    </form>
  </div>
  
  <div class="modal fade" id="aboutModal" tabindex="-1" role="dialog" aria-labelledby="aboutModalLabel" aria-hidden="true">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">
          <span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
          <h4 class="modal-title" id="aboutModalLabel">About</h4>
        </div>
        <div class="modal-body">
          <pre>
          <code>
          Cloverxell
          
          0.56

          A web terminal to use aesh with cloverX framework
          </code>
          </pre>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
    </div>
  </div>
  
  <div class="modal fade" id="bgModal" tabindex="-1" role="dialog" aria-labelledby="bgModalLabel" aria-hidden="true">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">
          <span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
          <h4 class="modal-title" id="bgModalLabel">Background color</h4>
        </div>
        <div class="modal-body">
          
          <a href="javascript:void(0);"><span class="label label-default">___</span></a>
          <a href="javascript:void(0);"><span class="label label-primary">___</span></a>
          <a href="javascript:void(0);"><span class="label label-success">___</span></a>
          <a href="javascript:void(0);"><span class="label label-info">___</span></a>
          <a href="javascript:void(0);"><span class="label label-warning">___</span></a>
          <a href="javascript:void(0);"><span class="label label-danger">___</span></a>
          <a href="javascript:void(0);"><span class="label label-cloverxell">___</span></a>
          <a href="javascript:void(0);"><span class="label label-black">___</span></a>
          <a href="javascript:void(0);"><span class="label label-white">___</span></a>
          
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
    </div>
  </div>
  
  <div class="modal fade" id="fgModal" tabindex="-1" role="dialog" aria-labelledby="fgModalLabel" aria-hidden="true">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">
          <span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
          <h4 class="modal-title" id="fgModalLabel">Foreground color</h4>
        </div>
        <div class="modal-body">
          
          <a href="javascript:void(0);"><span class="label label-default">___</span></a>
          <a href="javascript:void(0);"><span class="label label-primary">___</span></a>
          <a href="javascript:void(0);"><span class="label label-success">___</span></a>
          <a href="javascript:void(0);"><span class="label label-info">___</span></a>
          <a href="javascript:void(0);"><span class="label label-warning">___</span></a>
          <a href="javascript:void(0);"><span class="label label-danger">___</span></a>
          <a href="javascript:void(0);"><span class="label label-cloverxell">___</span></a>
          <a href="javascript:void(0);"><span class="label label-black">___</span></a>
          <a href="javascript:void(0);"><span class="label label-white">___</span></a>
          
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
    </div>
  </div>

  <script type="text/javascript" src="static/js/jquery-1.11.1.min.js"></script>
  <script type="text/javascript" src="static/js/bootstrap.min.js"></script>
  <script type="text/javascript" src="static/js/app.js"></script>

  <script>
      var ps1 = "[" + window.location.hostname + "@]$";
      $('#commandPrompt').html(ps1);
  </script>
</body>
</html>
