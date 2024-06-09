package edu.austral.ingsis.clifford.parsers;

import edu.austral.ingsis.clifford.Result;
import edu.austral.ingsis.clifford.commands.Command;
import edu.austral.ingsis.clifford.commands.Ls;
import edu.austral.ingsis.clifford.extras.AscendingOrder;
import edu.austral.ingsis.clifford.extras.CreationOrder;
import edu.austral.ingsis.clifford.extras.DescendingOrder;
import edu.austral.ingsis.clifford.extras.OrderStrategy;

public class LsParser implements CommandParser {
  private OrderStrategy getOrderStrategy(String[] params) {
    if (params.length == 0) {
      return new CreationOrder();
    } else if (params.length == 1) {
      String param = params[0];
      if (param.startsWith("--ord")) {
        String order = param.split("=")[1];
        if (order.equals("asc")) {
          return new AscendingOrder();
        } else if (order.equals("desc")) {
          return new DescendingOrder();
        } else {
          throw new RuntimeException("Invalid order");
        }
      }
    }
    throw new RuntimeException("Invalid parameter");
  }

  @Override
  public Result parse(String[] params) {
    OrderStrategy orderStrategy = getOrderStrategy(params);
    Command command = new Ls(orderStrategy);
    return new Result(command);
  }
}
