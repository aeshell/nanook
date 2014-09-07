package org.esmerilprogramming.cloverxell.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.PosixFilePermissions;

import org.jboss.aesh.console.AeshConsole;
import org.jboss.aesh.console.AeshConsoleBuilder;
import org.jboss.aesh.console.AeshContext;
import org.jboss.aesh.console.Config;
import org.jboss.aesh.console.command.Command;
import org.jboss.aesh.console.command.registry.AeshCommandRegistryBuilder;
import org.jboss.aesh.console.command.registry.CommandRegistry;
import org.jboss.aesh.console.settings.Settings;
import org.jboss.aesh.console.settings.SettingsBuilder;
import org.jboss.aesh.terminal.TestTerminal;

public class AeshIO {

  private PipedOutputStream pos;
  private PipedInputStream pis;
  private ByteArrayOutputStream stream;
  private Settings settings;
  private AeshConsole aeshConsole;
  private CommandRegistry registry;

  private FileAttribute fileAttribute = PosixFilePermissions.asFileAttribute(PosixFilePermissions
      .fromString("rwxrwxrwx"));

  public AeshIO() {
    pos = new PipedOutputStream();
    try {
      pis = new PipedInputStream(pos);
    } catch (IOException e) {
      e.printStackTrace();
    }
    stream = new ByteArrayOutputStream();

    this.settings =
        new SettingsBuilder().terminal(new TestTerminal()).inputStream(pis)
            .outputStream(new PrintStream(stream)).logging(true).create();
  }

  public void prepare(Class<? extends Command>... commands) throws IOException {

    registry = new AeshCommandRegistryBuilder().commands(commands).create();

    AeshConsoleBuilder consoleBuilder =
        new AeshConsoleBuilder().settings(settings).commandRegistry(registry);

    aeshConsole = consoleBuilder.create();
    aeshConsole.start();
    getStream().flush();
  }

  protected void finish() {
    smallPause();
    System.out.println("Got out: " + getStream().toString());
    aeshConsole.stop();
  }

  protected PipedOutputStream getPipedOutputStream() {
    return pos;
  }

  protected ByteArrayOutputStream getStream() {
    return stream;
  }

  protected void smallPause() {
    try {
      Thread.sleep(100);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  protected void pushToOutput(String literalCommand) throws IOException {
    getPipedOutputStream().write((literalCommand).getBytes());
    getPipedOutputStream().write(Config.getLineSeparator().getBytes());
    getPipedOutputStream().flush();
    smallPause();
  }

  protected void output(String literalCommand) throws IOException {
    getPipedOutputStream().write((literalCommand).getBytes());
    smallPause();
  }

  protected AeshContext getAeshContext() {
    return aeshConsole.getAeshContext();
  }

  protected Path createTempDirectory() throws IOException {
    final Path tmp;
    if (Config.isOSPOSIXCompatible()) {
      tmp = Files.createTempDirectory("temp", fileAttribute);
    } else {
      tmp = Files.createTempDirectory("temp");
    }
    return tmp;
  }

  public String pushToShellAndBuffer(String command) throws IOException {
    getPipedOutputStream().write((command).getBytes());
    getPipedOutputStream().write(Config.getLineSeparator().getBytes());
    getPipedOutputStream().flush();
    smallPause();
    return getStream().toString();
  }

}
