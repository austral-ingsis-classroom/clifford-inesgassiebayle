package edu.austral.ingsis.clifford.parsers;

import edu.austral.ingsis.clifford.Result;

public interface CommandParser {
  public Result parse(String[] params);
}
