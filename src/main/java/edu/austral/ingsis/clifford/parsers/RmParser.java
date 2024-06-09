package edu.austral.ingsis.clifford.parsers;

import edu.austral.ingsis.clifford.FileSystem;
import edu.austral.ingsis.clifford.Result;
import edu.austral.ingsis.clifford.commands.Command;
import edu.austral.ingsis.clifford.commands.Rm;
import edu.austral.ingsis.clifford.composite.Directory;

public class RmParser implements CommandParser {
  private final FileSystem fileSystem;

  public RmParser(FileSystem fileSystem) {
    this.fileSystem = fileSystem;
  }

  @Override
  public Result parse(String[] params) {
    boolean isRecursive = true;
    if (params.length == 0) {
      return new Result(
          "cannot remove '" + fileSystem.getCurrent().getName() + "', is a directory");
    }
    if (params.length == 1) {
      String name = params[0];
      Directory current = fileSystem.getCurrent();
      if (current.contains(name)) {
        Command command = new Rm(!isRecursive, current.getNode(name));
        return new Result(command);
      }
      return new Result("File not found");
    } else if (params.length == 2) {
      String recursive = params[0];
      if (recursive.equals("--recursive")) {
        String name = params[1];
        Directory current = fileSystem.getCurrent();
        if (current.contains(name)) {
          Command command = new Rm(isRecursive, current.getNode(name));
          return new Result(command);
        }
        return new Result("File not found");
      }
      return new Result("Invalid argument");
    }
    return new Result("Invalid number of arguments");
  }
}
