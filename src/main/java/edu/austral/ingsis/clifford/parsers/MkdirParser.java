package edu.austral.ingsis.clifford.parsers;

import edu.austral.ingsis.clifford.Result;
import edu.austral.ingsis.clifford.commands.Command;
import edu.austral.ingsis.clifford.commands.Mkdir;

public class MkdirParser implements CommandParser {
  @Override
  public Result parse(String[] params) {
    if (params.length == 1) {
      Command command = new Mkdir(params[0]);
      return new Result(command);
    }
    return new Result("Invalid number of arguments");
  }
}
