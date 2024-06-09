package edu.austral.ingsis.clifford.composite;

public interface Node {
  String getName();

  boolean isDirectory();

  Directory getParent();

  void setParent(Directory parent);
}
