package edu.austral.ingsis.clifford.extras;

import java.util.List;

public class CreationOrder implements OrderStrategy {
  @Override
  public List<String> order(List<String> nodes) {
    return nodes;
  }
}
