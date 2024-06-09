package edu.austral.ingsis.clifford.commands;

import edu.austral.ingsis.clifford.FileSystem;
import edu.austral.ingsis.clifford.composite.Directory;
import edu.austral.ingsis.clifford.composite.Node;

public class Rm implements Command {
  private final boolean isRecursive;
  private final Node node;

  public Rm(boolean isRecursive, Node node) {
    this.isRecursive = isRecursive;
    this.node = node;
  }

  @Override
  public String execute(FileSystem fileSystem) {
    if (node.isDirectory() && !isRecursive) {
      return "rm: cannot remove '" + node.getName() + "': Is a directory";
    } else {
      Directory parent = node.getParent();
      parent.removeNode(node);
      return "'" + node.getName() + "' removed";
    }
  }
}
