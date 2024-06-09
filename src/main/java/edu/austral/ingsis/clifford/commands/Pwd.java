package edu.austral.ingsis.clifford.commands;

import edu.austral.ingsis.clifford.FileSystem;
import edu.austral.ingsis.clifford.composite.Directory;
import edu.austral.ingsis.clifford.composite.Node;

public class Pwd implements Command {
  @Override
  public String execute(FileSystem fileSystem) {
    Directory root = fileSystem.getRoot();
    Node current = fileSystem.getCurrent();
    return root.getPath(current);
  }
}
