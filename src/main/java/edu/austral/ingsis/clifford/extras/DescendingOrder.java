package edu.austral.ingsis.clifford.extras;

import java.util.ArrayList;
import java.util.List;

public class DescendingOrder implements OrderStrategy {

  @Override
  public List<String> order(List<String> nodes) {
    List<String> orderedNodes = new ArrayList<>(nodes);
    orderedNodes.sort((a, b) -> b.compareTo(a));
    return orderedNodes;
  }
}
