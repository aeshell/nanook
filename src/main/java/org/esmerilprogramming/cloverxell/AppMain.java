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
package org.esmerilprogramming.cloverxell;

import java.util.ArrayList;
import java.util.List;

import org.esmerilprogramming.cloverx.server.CloverX;
import org.esmerilprogramming.cloverx.server.ConfigurationBuilder;

/**
 * @author <a href="mailto:00hf11@gmail.com">Helio Frota</a>
 */
public class AppMain {

  private static final String HELP = "usage: java -jar -h 192.168.1.1 -p 8080 -c app";

  public static void main(String[] args) {

    ConfigurationBuilder cb = new ConfigurationBuilder();
    cb.withHost("0.0.0.0");
    cb.withAppContext("app");

    List<String> options = new ArrayList<>();
    for (String o : args) {
      options.add(o);
    }

    if (options.contains("help")) {
      System.out.println(HELP);
      return;
    }

    if (options.size() % 2 != 0) {
      System.out.println(HELP);
      return;
    }

    if (options.contains("-h")) {
      String host = options.get(options.indexOf("-h") + 1);
      if (!host.trim().isEmpty()) {
        cb.withHost(host);
      }
    }

    if (options.contains("-p")) {
      String port = options.get(options.indexOf("-p") + 1);
      if (!port.trim().isEmpty()) {
        for (char c : port.toCharArray()) {
          if (!Character.isDigit(c)) {
            return;
          }
        }
        cb.withPort(Integer.parseInt(port));
      }
    }

    if (options.contains("-c")) {
      String context = options.get(options.indexOf("-c") + 1);
      if (!context.trim().isEmpty()) {
        cb.withAppContext(context);
      }
    }

    new CloverX(cb.build());

  }
}
