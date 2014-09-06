package org.esmerilprogramming.cloverxell;

import org.esmerilprogramming.cloverx.server.CloverX;
import org.esmerilprogramming.cloverx.server.ConfigurationBuilder;

/**
 * @author <a href="mailto:00hf11@gmail.com">Helio Frota</a>
 */
public class AppMain {

  public static void main(String[] args) {

    new CloverX(new ConfigurationBuilder()
    .withHost("127.0.0.1")
    .withAppContext("app")
    .build());

  }

}
