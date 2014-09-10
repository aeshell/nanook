package org.esmerilprogramming.cloverxell.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.jboss.aesh.extensions.cat.Cat;
import org.jboss.aesh.extensions.cd.Cd;
import org.jboss.aesh.extensions.clear.Clear;
import org.jboss.aesh.extensions.common.AeshTestCommons;
import org.jboss.aesh.extensions.echo.Echo;
import org.jboss.aesh.extensions.ls.Ls;
import org.jboss.aesh.extensions.mkdir.Mkdir;
import org.jboss.aesh.extensions.pwd.Pwd;
import org.jboss.aesh.extensions.rm.Rm;
import org.jboss.aesh.extensions.touch.Touch;

public class AeshHandler  extends AeshTestCommons{
  
  public AeshHandler() {
    try {
      prepare(Cd.class, Ls.class, Mkdir.class, Pwd.class, Rm.class, Touch.class, Cat.class, Clear.class, Echo.class);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  
  public void pushToOutput(String literalCommand) throws IOException {
    super.pushToOutput(literalCommand);
  }
  
  @Override
  public ByteArrayOutputStream getStream() {
    // TODO Auto-generated method stub
    return super.getStream();
  }

}
