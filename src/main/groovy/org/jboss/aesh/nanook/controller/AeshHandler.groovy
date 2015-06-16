///*
// * JBoss, Home of Professional Open Source Copyright 2014 Red Hat Inc. and/or its affiliates and
// * other contributors as indicated by the @authors tag. All rights reserved. See the copyright.txt
// * in the distribution for a full listing of individual contributors.
// *
// * Licensed under the Apache License, Version 2.0 (the "License") you may not use this file except
// * in compliance with the License. You may obtain a copy of the License at
// * http://www.apache.org/licenses/LICENSE-2.0 Unless required by applicable law or agreed to in
// * writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
// * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific
// * language governing permissions and limitations under the License.
// */
//package org.jboss.aesh.nanook.controller
//
//import org.jboss.aesh.console.AeshConsole
//import org.jboss.aesh.console.AeshConsoleBuilder
//import org.jboss.aesh.console.Config
//import org.jboss.aesh.console.command.Command
//import org.jboss.aesh.console.command.registry.AeshCommandRegistryBuilder
//import org.jboss.aesh.console.command.registry.CommandRegistry
//import org.jboss.aesh.console.command.registry.MutableCommandRegistry
//import org.jboss.aesh.console.settings.Settings
//import org.jboss.aesh.console.settings.SettingsBuilder
//import org.jboss.aesh.extensions.cat.Cat
//import org.jboss.aesh.extensions.cd.Cd
//import org.jboss.aesh.extensions.clear.Clear
//import org.jboss.aesh.extensions.echo.Echo
//import org.jboss.aesh.extensions.exit.Exit
//import org.jboss.aesh.extensions.ls.Ls
//import org.jboss.aesh.extensions.mkdir.Mkdir
//import org.jboss.aesh.extensions.pwd.Pwd
//import org.jboss.aesh.extensions.rm.Rm
////import org.jboss.aesh.extensions.mv.Mv
//import org.jboss.aesh.extensions.touch.Touch
//import org.jboss.aesh.parser.Parser
//
///**
// * @author Efraim Gentil
// * @author <a href="mailto:00hf11@gmail.com">Helio Frota</a>
// */
//public class AeshHandler {
//
//  private PipedOutputStream pos
//  private PipedInputStream pis
//  private ByteArrayOutputStream stream
//  private Settings settings
//  private AeshConsole aeshConsole
//  private CommandRegistry registry
//  private boolean debugMode
//
//  AeshHandler(boolean debugMode) {
//
//    this.debugMode = debugMode
//    pos = new PipedOutputStream()
//    try {
//      pis = new PipedInputStream(pos)
//    } catch (IOException e) {
//      e.printStackTrace()
//    }
//    stream = new ByteArrayOutputStream()
//
//    settings =
//      new SettingsBuilder().inputStream(pis)
//      .outputStreamError(new PrintStream(stream))
//      .outputStream(new PrintStream(stream))
//      .create()
//
//    try {
//      add(Cd, Ls, Mkdir, Pwd, Rm, /*Mv*/, Touch, Cat, Clear, Echo, Exit)
//    } catch (IOException e) {
//      e.printStackTrace()
//    }
//
//  }
//
//  AeshHandler() {
//    this(false)
//  }
//
//  /**
//   * Resets the stream.
//   */
//  void reset() {
//    getStream().reset()
//  }
//
//  /**
//   * Gets the result of the command.
//   *
//   * @return String
//   */
//  String getResult() {
//    String result = Parser.stripAwayAnsiCodes(getStream().toString())
//    if (debugMode) {
//      println result
//    }
//    result
//  }
//
//  /**
//   * Runs the desired command.
//   *
//   * @param command String
//   * @throws IOException exception
//   */
//  void run(String command) throws IOException {
//    getPos().write((command).getBytes())
//    getPos().write(Config.getLineSeparator().getBytes())
//    getPos().flush()
//    pause()
//  }
//
//  private void pause() {
//    sleep(200)
//  }
//
//  private void add(Class<? extends Command>... commands) throws IOException {
//
//    registry = new AeshCommandRegistryBuilder().commands(commands).create()
//
//    AeshConsoleBuilder consoleBuilder =
//        new AeshConsoleBuilder().settings(settings).commandRegistry(registry)
//
//    aeshConsole = consoleBuilder.create()
//    aeshConsole.start()
//    getStream().flush()
//  }
//
//  void remove(String commandName) {
//    MutableCommandRegistry mutableRegistry = (MutableCommandRegistry) registry
//    mutableRegistry.removeCommand(commandName)
//  }
//
//  PipedOutputStream getPos() {
//    pos
//  }
//
//  ByteArrayOutputStream getStream() {
//    stream
//  }
//
//  /**
//   * Gets all registered commands.
//   *
//   * @return Set<String>
//   */
//  Set<String> getRegisteredCommands() {
//    registry.getAllCommandNames()
//  }
//
//  /**
//   * Gets the current working directory.
//   *
//   * @return String
//   */
//  String getCurrentDirectory() {
//    aeshConsole.getAeshContext().getCurrentWorkingDirectory().getName()
//  }
//
//  /**
//   * Stops the aesh console.
//   */
//  void stop() {
//    aeshConsole.stop()
//  }
//
//}
