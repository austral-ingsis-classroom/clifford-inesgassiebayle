package edu.austral.ingsis.clifford;

import edu.austral.ingsis.clifford.commands.Command;

public class Result {
  private Command command;
  private boolean valid;
  private String message;

  public Result(Command command) {
    this.command = command;
    this.valid = true;
  }

  public Result(String message) {
    this.message = message;
    this.valid = false;
  }

  public Command getCommand() {
    return command;
  }

  public boolean isValid() {
    return valid;
  }

  public String getMessage() {
    return message;
  }
}
