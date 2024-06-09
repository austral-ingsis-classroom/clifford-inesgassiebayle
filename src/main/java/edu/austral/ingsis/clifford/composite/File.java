package edu.austral.ingsis.clifford.composite;

public class File implements Node {
  private final String name;
  private Directory parent;

  public File(String name, Directory directory) {
    this.name = name;
    this.parent = directory;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public boolean isDirectory() {
    return false;
  }

  @Override
  public Directory getParent() {
    return parent;
  }

  @Override
  public void setParent(Directory parent) {
    this.parent = parent;
  }
}
