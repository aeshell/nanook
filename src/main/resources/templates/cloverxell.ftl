<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <title>Bdh</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="static/css/bootstrap.min.css" rel="stylesheet">
    <style>
      body { padding-top: 60px; }
      .digit { font-size: 25px; padding: 5px 25px; cursor: move }
      .aBox { width: 270px;height: 50px;margin-top: 50px;padding: 50px; border: 1px dashed blue;display:none; }
    </style>
  </head>
  <body>
    <div class="navbar navbar-inverse navbar-fixed-top">
     <div class="navbar-inner">
       <div class="container-fluid">
         <span class="brand">Score:</span> <span id="score" class="brand">0</span>
       </div>
     </div>
    </div>
    <div class="container">

      <h2>Binary - Decimal - Hexadecimal game</h2>
      <p>(Alpha version only easy mode available.)</p>
        <form>
            <button type="button" class="btn btn-large" onclick="bdh.start()"> Start !</button>

            <div class="row-fluid">
              <div class="span1">
                <br><br>
                <span id="d0" class="badge badge-info digit" draggable="true" ondragstart="drag(event)">0</span><br><br><br>
                <span id="d1" class="badge badge-info digit" draggable="true" ondragstart="drag(event)">1</span><br><br><br>
                <span id="d2" class="badge badge-info digit" draggable="true" ondragstart="drag(event)">2</span><br><br><br>
                <span id="d3" class="badge badge-info digit" draggable="true" ondragstart="drag(event)">3</span><br><br><br>
                <span id="d4" class="badge badge-info digit" draggable="true" ondragstart="drag(event)">4</span><br><br><br>
                <span id="d5" class="badge badge-info digit" draggable="true" ondragstart="drag(event)">5</span><br><br><br>
                <span id="d6" class="badge badge-info digit" draggable="true" ondragstart="drag(event)">6</span><br><br><br>
                <span id="d7" class="badge badge-info digit" draggable="true" ondragstart="drag(event)">7</span><br><br><br>
              </div>
              <div class="span3">
               <br><br><br><br><br><br><br><br>
               <br><br>
               <span id="clokkfake" style="display:none;font-size: 80px;float:left">00:</span><div id="clokk" style="display:none;float:left; font-size: 80px; margin-left: 10px">
               </div>
              </div>
              <div class="span2">
                <br><br>
                <span id="d8" class="badge badge-info digit" draggable="true" ondragstart="drag(event)">8</span><br><br><br>
                <span id="d9" class="badge badge-info digit" draggable="true" ondragstart="drag(event)">9</span><br><br><br>
                <span id="dA" class="badge badge-info digit" draggable="true" ondragstart="drag(event)">A</span><br><br><br>
                <span id="dB" class="badge badge-info digit" draggable="true" ondragstart="drag(event)">B</span><br><br><br>
                <span id="dC" class="badge badge-info digit" draggable="true" ondragstart="drag(event)">C</span><br><br><br>
                <span id="dD" class="badge badge-info digit" draggable="true" ondragstart="drag(event)">D</span><br><br><br>
                <span id="dE" class="badge badge-info digit" draggable="true" ondragstart="drag(event)">E</span><br><br><br>
                <span id="dF" class="badge badge-info digit" draggable="true" ondragstart="drag(event)">F</span><br><br><br>
              </div>

              <div class="span6">
                 <div id="questionLabel" style="display:none;">
                 <h3><span id="valueSorted"></span> from <span id="typeFrom"></span> to <span id="typeTo"></span>:</h3>
                 </div>
                 <div id="answerBox" class="aBox" ondrop="drop(event)" ondragover="allowDrop(event)"></div>

                 <br>
                 <button id="confirmButton" type="button" class="btn btn-large" style="display:none" onclick="bdh.send()">Send</button>

              </div>

            </div>


        </form>

      </div>

    </div>
    <script type="text/javascript" src="static/js/jquery-1.11.1.min.js"></script>
    <script type="text/javascript" src="static/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="static/js/app.js"></script>

    <script>
    function allowDrop(ev) {
        ev.preventDefault();
    }

    function drag(ev) {
        ev.dataTransfer.setData("Text", ev.target.id);
    }

    function drop(ev) {
        ev.preventDefault();
        var data = ev.dataTransfer.getData("Text");
        ev.target.appendChild(document.getElementById(data));
    }

    /*clock*/
    var Timer;
    var TotalSeconds;

    function CreateTimer(TimerID, Time) {
        Timer = document.getElementById(TimerID);
        TotalSeconds = Time;
        UpdateTimer();
        window.setTimeout("Tick()", 1000);
    }

    function Tick() {
        if (TotalSeconds <= 0) {
            bdh.gameOver();
            return;
        }

        TotalSeconds -= 1;
        UpdateTimer();
        window.setTimeout("Tick()", 1000);
    }

    function UpdateTimer() {
        Timer.innerHTML = TotalSeconds;
    }

    </script>
  </body>
</html>
