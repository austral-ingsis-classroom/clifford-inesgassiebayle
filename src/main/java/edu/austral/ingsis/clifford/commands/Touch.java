package edu.austral.ingsis.clifford.commands;

import edu.austral.ingsis.clifford.FileSystem;
import edu.austral.ingsis.clifford.composite.Directory;
import edu.austral.ingsis.clifford.composite.File;

public class Touch implements Command {
  private String name;

  public Touch(String name) {
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
    Directory current = fileSystem.getCurrent();
    if (current.contains(name)) {
      return "File already exists.";
    }
    fileSystem.getCurrent().addNode(new File(name, current));
    return "'" + name + "' file created";
  }
}
