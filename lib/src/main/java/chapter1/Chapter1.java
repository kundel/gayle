package chapter1;

import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

public class Chapter1 {
  public Chapter1() {}

  public static boolean isUnique_1(String input) {
    if (input == null) {
      throw new IllegalArgumentException("empty input string");
    }
    boolean hasDupe = false;
    HashMap<Integer, Integer> map = new HashMap<>();
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

  public static boolean isUnique_2(String input) {
    if (input == null) {
      throw new IllegalArgumentException("empty input string");
    }
    boolean hasDupe = false;
    BitSet bitSet = new BitSet(32);
    final int length = input.length();
    for (int offset = 0; offset < length; ) {
      final int codepoint = input.codePointAt(offset);
      if (bitSet.get(codepoint)) hasDupe = true;
      bitSet.set(codepoint);
      offset += Character.charCount(codepoint);
    }
    return !hasDupe;
  }

  public static boolean isPermutation(String one, String two) {
    if (one == null || two == null) {
      throw new IllegalArgumentException("empty input string");
    }
    Map<Integer, Integer> oneIdx = index(one);
    Map<Integer, Integer> twoIdx = index(two);
    for (Map.Entry<Integer, Integer> e : twoIdx.entrySet()) {
      int key = e.getKey();
      int value = e.getValue();
      if (!oneIdx.containsKey(key) || !oneIdx.get(key).equals(value)) {
        return false;
      }
    }
    return true;
  }

  private static Map<Integer, Integer> index(String input) {
    HashMap<Integer, Integer> idx = new HashMap<>();
    final int length = input.length();
    for (int offset = 0; offset < length; ) {
      final int codepoint = input.codePointAt(offset);
      int count = idx.getOrDefault(codepoint, 0);
      idx.put(codepoint, ++count);
      offset += Character.charCount(codepoint);
    }
    return idx;
  }
}
