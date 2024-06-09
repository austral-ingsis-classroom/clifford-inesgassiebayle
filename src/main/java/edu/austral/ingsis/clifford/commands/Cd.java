package edu.austral.ingsis.clifford.commands;

import edu.austral.ingsis.clifford.FileSystem;
import edu.austral.ingsis.clifford.composite.Directory;
import edu.austral.ingsis.clifford.composite.Node;

public class Cd implements Command {
  private final Node node;

  public Cd(Node node) {
    this.node = node;
  }

  @Override
  public String execute(FileSystem fileSystem) {
    if (node.isDirectory()) {
      fileSystem.setCurrent((Directory) node);
      return "moved to directory " + "'" + node.getName() + "'";
    } else {
      return "Cannot cd into a file.";
    }
  }
}
