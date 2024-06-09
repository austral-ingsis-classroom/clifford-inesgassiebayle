package edu.austral.ingsis.clifford.parsers;

import edu.austral.ingsis.clifford.Result;
import edu.austral.ingsis.clifford.commands.Command;
import edu.austral.ingsis.clifford.commands.Pwd;

public class PwdParser implements CommandParser {
  @Override
  public Result parse(String[] params) {
    if (params.length == 0) {
      Command command = new Pwd();
      return new Result(command);
    } else {
      return new Result("Invalid number of arguments");
    }
  }
}
