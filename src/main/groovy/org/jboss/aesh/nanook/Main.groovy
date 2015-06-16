package org.jboss.aesh.nanook

import groovy.transform.CompileStatic

import org.wildfly.swarm.container.Container
import org.wildfly.swarm.container.DefaultWarDeployment
import org.wildfly.swarm.container.WarDeployment

@CompileStatic
class Main {

    static main(String... args) {

        Container container = new Container()
        container.start()

        WarDeployment deployment = new DefaultWarDeployment(container)
        deployment.getArchive().addClass(NanookServlet)
        container.deploy(deployment)
    }
}
