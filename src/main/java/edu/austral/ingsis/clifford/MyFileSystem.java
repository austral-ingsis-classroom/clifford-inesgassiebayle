package edu.austral.ingsis.clifford;

import edu.austral.ingsis.clifford.composite.Directory;
import edu.austral.ingsis.clifford.parsers.CommandParser;
import java.util.HashMap;
import java.util.Map;

public class MyFileSystem implements FileSystem {
  private Directory current;
  private Directory root;
  private Map<String, CommandParser> commands;

  public MyFileSystem() {
    this.root = new Directory("/");
    this.current = root;
    commands = new HashMap<>();
  }

  public void addCommand(String command, CommandParser parser) {
    commands.put(command, parser);
  }

  @Override
  public String run(String command) {
    String[] commandParts = command.split(" ");
    String commandName = commandParts[0];
    String[] args = getParams(commandParts);
    if (commands.containsKey(commandName)) {
      CommandParser parser = commands.get(commandName);
      Result executable = parser.parse(args);
      if (executable.isValid()) {
        return executable.getCommand().execute(this);
      }
      return executable.getMessage();
    }
    return "Command not found";
  }

  private static String[] getParams(String[] commandParts) {
    String[] args = new String[commandParts.length - 1];
    System.arraycopy(commandParts, 1, args, 0, args.length);
    return args;
  }

  @Override
  public void setCurrent(Directory current) {
    this.current = current;
  }

  @Override
  public Directory getCurrent() {
    return current;
  }

  @Override
  public Directory getRoot() {
    return root;
  }
}
