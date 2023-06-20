package chapter1;

import java.util.HashMap;

public class Chapter1 {
  public Chapter1() {}

  public static boolean isUnique(String input) {
    boolean hasDupe = false;
    HashMap<Integer, Integer> map = new HashMap<>();
    if (input == null) {
      throw new IllegalArgumentException("empty input string");
    }
    final int length = input.length();
    for (int offset = 0; offset < length; ) {
      final int codepoint = input.codePointAt(offset);
      int count = map.getOrDefault(codepoint, 0);
      if (count > 0) {
        hasDupe = true;
      }
      map.put(codepoint, ++count);
      offset += Character.charCount(codepoint);
    }
    return !hasDupe;
  }
}
