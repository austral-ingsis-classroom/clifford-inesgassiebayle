package edu.austral.ingsis.clifford.parsers;

import edu.austral.ingsis.clifford.Result;
import edu.austral.ingsis.clifford.commands.Command;
import edu.austral.ingsis.clifford.commands.Touch;

public class TouchParser implements CommandParser {
  @Override
  public Result parse(String[] params) {
    if (params.length == 1) {
      Command command = new Touch(params[0]);
      return new Result(command);
    }
    return new Result("Invalid touch command");
  }
}
