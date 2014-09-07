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

import org.esmerilprogramming.cloverx.annotation.Controller;
import org.esmerilprogramming.cloverx.annotation.Page;
import org.jboss.aesh.extensions.common.AeshTestCommons;
import org.jboss.aesh.extensions.ls.Ls;
import org.jboss.logging.Logger;

/**
 * @author <a href="mailto:00hf11@gmail.com">Helio Frota</a>
 */
@Controller
public class CloverxellController extends AeshTestCommons {

  private static final Logger LOGGER = Logger.getLogger(CloverxellController.class);

  @Page(value = "", responseTemplate = "cloverxell.ftl")
  public void init() throws Exception {
    LOGGER.info("started.");
  }

  @SuppressWarnings("unchecked")
  @Page("send")
  public void send(String command, HttpServerExchange exchange) throws Exception {
    prepare(Ls.class);
    pushToOutput(command);
    exchange.getResponseSender().send(getStream().toString());
  }

}
