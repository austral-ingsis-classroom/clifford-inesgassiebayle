package edu.austral.ingsis.clifford.parsers;

import edu.austral.ingsis.clifford.FileSystem;
import edu.austral.ingsis.clifford.Result;
import edu.austral.ingsis.clifford.commands.Cd;
import edu.austral.ingsis.clifford.commands.Command;
import edu.austral.ingsis.clifford.composite.Directory;
import edu.austral.ingsis.clifford.composite.Node;

public class CdParser implements CommandParser {
  private final FileSystem fileSystem;

  public CdParser(FileSystem fileSystem) {
    this.fileSystem = fileSystem;
  }

  @Override
  public Result parse(String[] params) {
    if (params.length == 0) {
      return null;
    }
    if (params.length == 1) {
      String param = params[0];
      if (param.equals("..")) {
        return moveToParent();
      }
      if (param.equals(".")) {
        return stayInPlace();
      }
      return checkPath(param);
    }
    return new Result("Invalid parameter");
  }

  private Result checkPath(String param) {
    String[] pathArray = param.split("/");
    if (param.startsWith("/")) {
      return checkValidPath(pathArray, fileSystem.getRoot());
    } else {
      return checkValidPath(pathArray, fileSystem.getCurrent());
    }
  }

  private Result checkValidPath(String[] pathArray, Directory directory) {
    for (String name : pathArray) {
      if (directory.contains(name)) {
        Node node = directory.getNode(name);
        if (!node.isDirectory()) {
          return new Result("Not a directory");
        }
        directory = (Directory) node;
      } else {
        return new Result("'" + name + "' directory does not exist");
      }
    }
    Command command = new Cd(directory);
    return new Result(command);
  }

  private Result stayInPlace() {
    Command command = new Cd(fileSystem.getCurrent());
    return new Result(command);
  }

  private Result moveToParent() {
    Directory directory = fileSystem.getCurrent();
    if (fileSystem.getRoot().equals(directory)) {
      Command command = new Cd(directory);
      return new Result(command);
    }
    Command command = new Cd(directory.getParent());
    return new Result(command);
  }
}
