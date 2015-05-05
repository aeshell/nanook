/*
 * JBoss, Home of Professional Open Source Copyright 2014 Red Hat Inc. and/or its affiliates and
 * other contributors as indicated by the @authors tag. All rights reserved. See the copyright.txt
 * in the distribution for a full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the 'License') you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0 Unless required by applicable law or agreed to in
 * writing, software distributed under the License is distributed on an 'AS IS' BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific
 * language governing permissions and limitations under the License.
 */
package org.jboss.aesh.nanook.controller

import org.esmerilprogramming.overtown.annotation.Controller
import org.esmerilprogramming.overtown.annotation.Page
import org.esmerilprogramming.overtown.http.OvertownRequest
import org.esmerilprogramming.overtown.http.OvertownSession

/**
 * @author <a href='mailto:00hf11@gmail.com'>Helio Frota</a>
 */
@Controller
class NanookController {

  @Page(value = '', responseTemplate = 'nanook.ftl')
  void init() throws Exception {

  }

  @Page('send')
  void send(String command, String customCommand, OvertownRequest request) throws Exception {
    AeshHandler aesh = getAeshHandler(request)
    if (customCommand == null) {
      aesh.run(command)
    } else {
      aesh.run(customCommand)
    }

    String result = aesh.getResult()
    result = result.replaceAll('@', ' ')
    result = result + '@' + aesh.getCurrentDirectory()
    request.getExchange().getResponseSender().send(result)
    aesh.reset()
  }

  @Page('remove')
  void remove(String commandName, OvertownRequest request) {
    getAeshHandler(request).remove(commandName)
  }

  protected AeshHandler getAeshHandler(OvertownRequest request) {
    OvertownSession session = request.getSession()
    if (session.getAttribute('aesh') == null) {
      session.setAttribute('aesh', new AeshHandler())
    }
    session.getAttribute('aesh', AeshHandler)
  }

}
