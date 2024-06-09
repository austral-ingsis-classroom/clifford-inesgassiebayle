package edu.austral.ingsis.clifford.composite;

import java.util.ArrayList;
import java.util.List;

public class Directory implements Node {
  private List<Node> nodes;
  private final String name;
  private Directory parent;

  public Directory(String name) {
    this.name = name;
    this.nodes = new ArrayList<>();
  }

  private Directory(List<Node> nodes, String name) {
    this.nodes = nodes;
    this.name = name;
  }

  public List<Node> getNodes() {
    return nodes;
  }

  public void addNode(Node node) {
    nodes.add(node);
  }

  public void removeNode(Node node) {
    if (!nodes.contains(node)) {
      throw new IllegalArgumentException("Node not found");
    }
    nodes.remove(node);
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public boolean isDirectory() {
    return true;
  }

  public String getPath(Node node) {
    return findNodePathRecursively(node.getName(), getNodes(), "");
  }

  @Override
  public Directory getParent() {
    return parent;
  }

  @Override
  public void setParent(Directory parent) {
    this.parent = parent;
  }

  public boolean contains(String name) {
    for (Node node : nodes) {
      if (node.getName().equals(name)) {
        return true;
      }
    }
    return false;
  }

  public Node getNode(String name) {
    for (Node node : nodes) {
      if (node.getName().equals(name)) {
        return node;
      }
    }
    return null;
  }

  private String findNodePathRecursively(String name, List<Node> nodes, String path) {
    for (Node node : nodes) {
      if (node.getName().equals(name)) {
        return path + "/" + node.getName();
      }
      if (node.isDirectory()) {
        Directory directory = (Directory) node;
        String result =
            findNodePathRecursively(name, directory.getNodes(), path + "/" + node.getName());
        if (result != "Node not found") {
          return result;
        }
      }
    }
    return "Node not found";
  }
}
