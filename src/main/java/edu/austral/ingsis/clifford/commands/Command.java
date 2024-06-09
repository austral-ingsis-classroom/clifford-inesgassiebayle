package edu.austral.ingsis.clifford.commands;

import edu.austral.ingsis.clifford.FileSystem;

public interface Command {
  String execute(FileSystem fileSystem);
}
