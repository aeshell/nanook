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

import org.jboss.aesh.nanook.pojo.Command;
import org.jboss.aesh.nanook.pojo.Log;
import org.jboss.aesh.nanook.util.AeshHandler;
import org.wildfly.swarm.container.Container;
import org.wildfly.swarm.jaxrs.JAXRSDeployment;
import org.wildfly.swarm.logging.LoggingFraction;
import org.wildfly.swarm.undertow.WarDeployment;

/**
 * @author <a href='mailto:00hf11@gmail.com'>Helio Frota</a>
 */
public class Main {

    private static final String LOG_LEVEL = System.getProperty("nanook.log.level", "DEBUG");

    public static void main(String... args) throws Exception {

        // container configuration.
        Container container = new Container();
        
        // logging config.
        container.subsystem(new LoggingFraction()
                .defaultColorFormatter()
                .formatter("TSV", "%d{yyyy-MM-dd HH:mm:ss,SSS}\t%-5p\t[%c] (%t) %s%e%n")
                .consoleHandler(LOG_LEVEL, "COLOR_PATTERN")
                .fileHandler("FILE", "nanook.log", LOG_LEVEL, "TSV")
                .rootLogger(LOG_LEVEL, "CONSOLE", "FILE"));

        // war configuration.
        WarDeployment war = new JAXRSDeployment(container);
        war.staticContent("/");
        war.getArchive().addClass(AeshHandler.class);
        war.getArchive().addClass(Command.class);
        war.getArchive().addClass(Log.class);
        war.getArchive().addClass(NanookEJBTimer.class);
        war.getArchive().addClass(NanookRest.class);
        war.getArchive().addClass(NanookServlet.class);
        container.start().deploy(war);
    }
}
