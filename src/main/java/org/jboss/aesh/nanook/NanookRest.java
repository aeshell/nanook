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

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author Yoshimasa Tanabe
 */
@Path("/")
public class NanookRest {

    @Path("/history")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<PojoCommand> history() throws IOException {

        List<PojoCommand> pojoCommandList = new ArrayList<>();

        try (Stream<String> lines = Files.lines(Paths.get(System.getProperty("user.home"), ".aesh_history"))) {
            lines.forEach(line -> pojoCommandList.add(new PojoCommand(line)));
        } catch (NoSuchFileException ignore) {}

        return pojoCommandList;
    }

    @Path("/log")
    @GET
    public String log() {
        return "NOT_IMPLEMENTED";
    }

}
