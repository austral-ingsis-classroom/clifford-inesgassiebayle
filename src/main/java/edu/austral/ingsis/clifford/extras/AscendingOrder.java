package edu.austral.ingsis.clifford.extras;

import java.util.ArrayList;
import java.util.List;

public class AscendingOrder implements OrderStrategy {
  @Override
  public List<String> order(List<String> nodes) {
    ArrayList<String> orderedNodes = new ArrayList<>(nodes);
    orderedNodes.sort(String::compareTo);
    return orderedNodes;
  }
}
