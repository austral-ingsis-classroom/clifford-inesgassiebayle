package edu.austral.ingsis.clifford.commands;

import edu.austral.ingsis.clifford.FileSystem;
import edu.austral.ingsis.clifford.composite.Directory;
import edu.austral.ingsis.clifford.composite.Node;
import edu.austral.ingsis.clifford.extras.OrderStrategy;
import java.util.ArrayList;
import java.util.List;

public class Ls implements Command {
  private final OrderStrategy orderStrategy;

  public Ls(OrderStrategy orderStrategy) {
    this.orderStrategy = orderStrategy;
  }

  @Override
  public String execute(FileSystem fileSystem) {
    Directory current = fileSystem.getCurrent();
    List<Node> nodes = current.getNodes();
    List<String> names = new ArrayList<>();
    for (Node node : nodes) {
      names.add(node.getName());
    }
    List<String> ordered = orderStrategy.order(names);
    String result = "";
    for (String name : ordered) {
      result += name + " ";
    }
    if (result.isEmpty()) {
      return "";
    }
    return result.substring(0, result.length() - 1);
  }
}
