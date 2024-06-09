package edu.austral.ingsis.clifford.commands;

import edu.austral.ingsis.clifford.FileSystem;
import edu.austral.ingsis.clifford.composite.Directory;

public class Mkdir implements Command {
  private final String name;

  public Mkdir(String name) {
    this.name = name;
  }

  @Override
  public String execute(FileSystem fileSystem) {
    if (name.contains("/")) {
      return "Cannot create file with / in the name.";
    }
    if (name.contains(" ")) {
      return "Cannot create file with spaces in the name.";
    }
    Directory directory = new Directory(name);
    fileSystem.getCurrent().addNode(directory);
    directory.setParent(fileSystem.getCurrent());
    return "'" + name + "' directory created";
  }
}
