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
package org.jboss.aesh.nanook;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jboss.aesh.nanook.util.AeshHandler;

/**
 * @author <a href='mailto:00hf11@gmail.com'>Helio Frota</a>
 */
@WebServlet(name = "nanook", urlPatterns = "/nanook")
public class NanookServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        AeshHandler aesh = getAeshHandler(req);
        
        if (req.getParameter("customCommand") != null) {
            aesh.run(req.getParameter("customCommand"));
        }
        else {
            aesh.run(req.getParameter("command"));
        }

        String result = aesh.getResult();
        result = result.replaceAll("@", " ");
        result = result + "@" + aesh.getCurrentDirectory();
        resp.getWriter().write(result);
        aesh.reset();
    }

    private AeshHandler getAeshHandler(HttpServletRequest req) {
        if (req.getSession().getAttribute("aesh") == null) {
            req.getSession().setAttribute("aesh", new AeshHandler());
        }
        return (AeshHandler) req.getSession().getAttribute("aesh");
    }
}
