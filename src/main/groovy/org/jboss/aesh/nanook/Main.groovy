package org.jboss.aesh.nanook

import groovy.transform.CompileStatic

import org.wildfly.swarm.container.Container
import org.wildfly.swarm.container.DefaultWarDeployment
import org.wildfly.swarm.container.WarDeployment
import org.wildfly.swarm.undertow.StaticDeployment


@CompileStatic
class Main {

    static main(String... args) {

        Container container = new Container()
        WarDeployment deployment = new DefaultWarDeployment(container)
        deployment.staticContent("/")
        deployment.getArchive().addClass(NanookServlet)
        container.start().deploy(deployment)
        
    }
}
