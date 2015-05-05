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

import org.esmerilprogramming.overtown.server.Overtown
import org.esmerilprogramming.overtown.server.ConfigurationBuilder

/**
 * @author <a href='mailto:00hf11@gmail.com'>Helio Frota</a>
 */
class AppMain {

  private static final String HELP = 'usage: java -jar -h 192.168.1.1 -p 8080 -c app'

  static main(String... args) {

    ConfigurationBuilder cb = new ConfigurationBuilder()
    cb.withHost('0.0.0.0')
    cb.withAppContext('app')
    cb.withPackageToScan('org.jboss.aesh.nanook')

    List<String> options = new ArrayList<>()
    for (String o : args) {
      options.add(o)
    }

    if (options.contains('help')) {
      println(HELP)
      return
    }

    if (options.size() % 2 != 0) {
      println(HELP)
      return
    }

    if (options.contains('-h')) {
      String host = options.get(options.indexOf('-h') + 1)
      if (!host.trim().isEmpty()) {
        cb.withHost(host)
      }
    }

    if (options.contains('-p')) {
      String port = options.get(options.indexOf('-p') + 1)
      if (!port.trim().isEmpty()) {
        for (char c : port.toCharArray()) {
          if (!Character.isDigit(c)) {
            return
          }
        }
        cb.withPort(Integer.parseInt(port))
      }
    }

    if (options.contains('-c')) {
      String context = options.get(options.indexOf('-c') + 1)
      if (!context.trim().isEmpty()) {
        cb.withAppContext(context)
      }
    }

    new Overtown(cb.build())
  }
}
