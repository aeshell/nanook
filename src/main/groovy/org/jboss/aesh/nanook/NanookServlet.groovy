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
package org.jboss.aesh.nanook

import groovy.transform.CompileStatic

import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * @author <a href='mailto:00hf11@gmail.com'>Helio Frota</a>
 */
@CompileStatic
@WebServlet(name = 'nanook', urlPatterns = '/nanook')
class NanookServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
    doPost(req, resp)
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
    AeshHandler aesh = getAeshHandler(req)
    aesh.run(req.getParameter('customCommand') ?: req.getParameter('command'))
    
    String result = aesh.getResult()
    result = result.replaceAll('@', ' ')
    result = result + '@' + aesh.getCurrentDirectory()
    resp.writer.write(result)
    aesh.reset()
  }

  private void remove(String commandName, HttpServletRequest req) {
    getAeshHandler(req).remove(commandName)
  }

  private AeshHandler getAeshHandler(HttpServletRequest req) {
    if (!req.session.getAttribute('aesh')) {
      req.session.setAttribute('aesh', new AeshHandler())
    }
    (AeshHandler)req.session.getAttribute('aesh')
  }
}
