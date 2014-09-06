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
import org.jboss.aesh.console.AeshConsoleBuilder;
import org.jboss.aesh.console.Prompt;
import org.jboss.aesh.console.command.registry.AeshCommandRegistryBuilder;
import org.jboss.aesh.console.settings.SettingsBuilder;
import org.jboss.aesh.extensions.cat.Cat;
import org.jboss.aesh.extensions.cd.Cd;
import org.jboss.aesh.extensions.clear.Clear;
import org.jboss.aesh.extensions.echo.Echo;
import org.jboss.aesh.extensions.harlem.aesh.Harlem;
import org.jboss.aesh.extensions.less.aesh.Less;
import org.jboss.aesh.extensions.ls.Ls;
import org.jboss.aesh.extensions.matrix.Matrix;
import org.jboss.aesh.extensions.mkdir.Mkdir;
import org.jboss.aesh.extensions.more.aesh.More;
import org.jboss.aesh.extensions.pwd.Pwd;
import org.jboss.aesh.extensions.rm.Rm;
import org.jboss.aesh.extensions.touch.Touch;
import org.jboss.logging.Logger;

/**
 * @author <a href="mailto:00hf11@gmail.com">Helio Frota</a>
 */
@Controller
public class CloverxellController {

  private static final Logger LOGGER = Logger.getLogger(CloverxellController.class);

  @SuppressWarnings("unchecked")
  @Page(value = "", responseTemplate = "cloverxell.ftl")
  public void init() {
    
    LOGGER.info("starting aesh...");
    SettingsBuilder sb = new SettingsBuilder();
    AeshCommandRegistryBuilder acrb = new AeshCommandRegistryBuilder();
    // files
    acrb.commands(Cd.class, Ls.class, Mkdir.class, Pwd.class, Rm.class, Touch.class);
    // screen
    acrb.commands(Cat.class, Clear.class, Echo.class, Less.class, More.class);
    // crazy
    acrb.commands(Harlem.class, Matrix.class);

    AeshConsoleBuilder acb = new AeshConsoleBuilder();
    acb.commandRegistry(acrb.create());
    acb.settings(sb.create());
    acb.prompt(new Prompt("[scalaesh@~]$ "));
    acb.create().start();
    
    LOGGER.info("done.");
  }
}
