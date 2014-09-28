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

import org.esmerilprogramming.cloverx.annotation.Controller;
import org.esmerilprogramming.cloverx.annotation.Page;
import org.esmerilprogramming.cloverx.http.CloverXRequest;
import org.esmerilprogramming.cloverx.http.CloverXSession;
import org.jboss.logging.Logger;

/**
 * @author <a href="mailto:00hf11@gmail.com">Helio Frota</a>
 */
@Controller
public class CloverxellController {

  private static final Logger LOGGER = Logger.getLogger(CloverxellController.class);

  @Page(value = "", responseTemplate = "cloverxell.ftl")
  public void init() throws Exception {
    LOGGER.info("started.");
  }

  @Page("send")
  public void send(String command, String customCommand, CloverXRequest request) throws Exception {
    AeshHandler aesh = getAeshHandler(request);
    if (customCommand == null) {
      aesh.run(command);
    } else {
      aesh.run(customCommand);
    }
    String result = aesh.getResult() + "@" + aesh.getCurrentDirectory();
    request.getExchange().getResponseSender().send(result);
    aesh.reset();
  }

  @Page("stop")
  public void stop(CloverXRequest request) throws Exception {
    AeshHandler aesh = getAeshHandler(request);
    aesh.stop();
    CloverXSession session = request.getSession();
    session.destroy();
    LOGGER.info("stoped.");
  }

  protected AeshHandler getAeshHandler(CloverXRequest request) {
    CloverXSession session = request.getSession();
    Object attribute = session.getAttribute("aesh");
    if (attribute == null) {
      session.setAttribute("aesh", new AeshHandler());
    }
    return session.getAttribute("aesh", AeshHandler.class);
  }

}
