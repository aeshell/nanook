/*
 * Copyright 2014 EsmerilProgramming.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package org.esmerilprogramming.cloverxell.controller;

import io.undertow.server.HttpServerExchange;
import io.undertow.server.handlers.Cookie;
import io.undertow.server.handlers.CookieImpl;

import java.io.IOException;
import java.util.Map;

import org.esmerilprogramming.cloverx.annotation.Controller;
import org.esmerilprogramming.cloverx.annotation.Page;
import org.jboss.aesh.console.Console;
import org.jboss.aesh.console.ConsoleCallback;
import org.jboss.aesh.console.ConsoleOperation;
import org.jboss.aesh.console.Process;
import org.jboss.aesh.console.Prompt;
import org.jboss.aesh.console.command.CommandOperation;
import org.jboss.aesh.console.settings.SettingsBuilder;
import org.jboss.aesh.extensions.cat.Cat;
import org.jboss.aesh.extensions.cd.Cd;
import org.jboss.aesh.extensions.clear.Clear;
import org.jboss.aesh.extensions.common.AeshTestCommons;
import org.jboss.aesh.extensions.echo.Echo;
import org.jboss.aesh.extensions.ls.Ls;
import org.jboss.aesh.extensions.mkdir.Mkdir;
import org.jboss.aesh.extensions.pwd.Pwd;
import org.jboss.aesh.extensions.rm.Rm;
import org.jboss.aesh.extensions.touch.Touch;
import org.jboss.aesh.parser.Parser;
import org.jboss.logging.Logger;

/**
 * @author <a href="mailto:00hf11@gmail.com">Helio Frota</a>
 */
@Controller
public class CloverxellController {

  private static final Logger LOGGER = Logger.getLogger(CloverxellController.class);
  
  private static AeshHandler aesh = new AeshHandler();
  
  @Page(value = "", responseTemplate = "cloverxell.ftl")
  public void init() throws Exception {
    LOGGER.info("started.");
  }
  
  @SuppressWarnings("unchecked")
  @Page("send")
  public void send(String command, HttpServerExchange exchange) throws Exception {
    
    aesh.pushToOutput(command);
    String result = Parser.stripAwayAnsiCodes(aesh.getStream().toString());
    LOGGER.info(result);
    
    exchange.getResponseSender().send(result);
    aesh.getStream().reset();
  }
  
  public static void main(String[] args) {
    final Console console = new Console(new SettingsBuilder().create());
    console.setPrompt(new Prompt("[aesh]$ "));

    console.setConsoleCallback(new ConsoleCallback() {
        @Override
        public int execute(ConsoleOperation output) {
            console.getShell().out().println("======>\"" + output.getBuffer());
            if (output.getBuffer().equals("quit")) {
                console.stop();
            }
            return 0;
        }

        @Override
        public CommandOperation getInput() throws InterruptedException {
          // TODO Auto-generated method stub
          return null;
        }

        @Override
        public void setProcess(Process arg0) {
          // TODO Auto-generated method stub
          
        }
    });
    console.start();
  }

}
