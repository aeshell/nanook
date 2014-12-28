/*
 * JBoss, Home of Professional Open Source Copyright 2014 Red Hat Inc. and/or its affiliates and
 * other contributors as indicated by the @authors tag. All rights reserved. See the copyright.txt
 * in the distribution for a full listing of individual contributors.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0 Unless required by applicable law or agreed to in
 * writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific
 * language governing permissions and limitations under the License.
 */
var cloverxell = {
  send : function(customCommand) {
    var inputCommand = new Object();
    inputCommand.command = $("#inputCommand").val();
    if (customCommand) {
      inputCommand.customCommand = customCommand; 
    }
    $("#inputCommand").val("");
    $.ajax({
      url : $(location).attr("href") + "/send",
      data : inputCommand,
      type : "POST",
      dataType : "html",
      success : function(response) {
        var html = response;
        var ps1 = "[" + window.location.hostname + "@" + html.split("@", 2)[1]
            + "]$";
        $("#commandPrompt").html(ps1);

        html = html.replace(inputCommand.command, '');
        html = html.replace("\n", "");
        html = html.split("@", 1);

        var resultEscaped = $("<div/>").text(html).html();
        $("#codeCommandResult").html("\r" + resultEscaped).text();
      },
      error : function(xhr, st, err) {
        console.log("Error: " + err);
        console.log("Status: " + st);
        console.dir(xhr);
      }
    });
  },
  stop : function() {
    $.ajax({
      url : $(location).attr("href") + "/stop"
    });
  },
  newTab : function() {
    window.open($(location).attr("href"), "_blank").focus();
  },
  fontInc : function() {
    var currentSize = parseInt($(".form-control").css("font-size")) + 2;
    if (currentSize <= 18) {
      $(".input-group-addon").css("font-size", currentSize + "px");
      $(".form-control").css("font-size", currentSize + "px");
      $(".command-result").css("font-size", currentSize + "px");
    }
  },
  fontDec : function() {
    var currentSize = parseInt($(".form-control").css("font-size")) - 2;
    if (currentSize >= 10) {
      $(".form-control").css("font-size", currentSize + "px");
      $(".input-group-addon").css("font-size", currentSize + "px");
      $(".command-result").css("font-size", currentSize + "px");
    }
  },
  setBgColor : function(c) {
    $(".form-control").css("backgroundColor", c);
    $(".input-group-addon").css("backgroundColor", c);
    $(".pre-command-result").css("backgroundColor", c);
    $(".command-result").css("backgroundColor", c);
    $(".input-group").css("backgroundColor", c);
    $("body").css("backgroundColor", c);
  },
  setFgColor : function(c) {
    $(".form-control").css("color", c);
    $(".input-group-addon").css("color", c);
    $(".pre-command-result").css("color", c);
    $(".command-result").css("color", c);
  }
};

$("#commandForm").submit(function(event) {
  event.preventDefault();
  cloverxell.send();
});

$("body").on("keydown", "#inputCommand", function(e) {
  if (e.which == 9) {
    e.preventDefault();
    cloverxell.send("\t");
  } 
});

$("#inputTitle").keypress(function(event) {
  if (event.which == 13) {
	var value = $("#inputTitle").val();
	event.preventDefault();
	$(document).prop('title', value);
	$("#titleForm").css("display","none")
  }
});

$(document).ready(function(){
	$("#inputCommand").focus();
	cloverxell.send("\n");
});
