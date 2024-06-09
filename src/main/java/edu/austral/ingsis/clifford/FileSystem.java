package edu.austral.ingsis.clifford;

import edu.austral.ingsis.clifford.composite.Directory;
import edu.austral.ingsis.clifford.parsers.CommandParser;

public interface FileSystem {
  String run(String command);

  void setCurrent(Directory current);

  Directory getCurrent();

  Directory getRoot();

  void addCommand(String command, CommandParser parser);
}
