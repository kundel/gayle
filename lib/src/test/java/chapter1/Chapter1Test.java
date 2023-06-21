package chapter1;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class Chapter1Test {
  @Test
  public void test1_1() {
    assertTrue(Chapter1.isUnique_1("你好，世界！"));
    assertFalse(Chapter1.isUnique_1("你好，世界世界！"));
    assertTrue(Chapter1.isUnique_1("\uD83E\uDD2F")); // 🤯
    assertFalse(Chapter1.isUnique_1("\uD83E\uDD2F\uD83E\uDD2F")); // 🤯🤯
    assertFalse(Chapter1.isUnique_1("hello"));
    assertFalse(Chapter1.isUnique_1("thequickbrownfoxjumpedoverthelazydog"));
    assertTrue(Chapter1.isUnique_2("你好，世界！"));
    assertFalse(Chapter1.isUnique_2("你好，世界世界！"));
    assertTrue(Chapter1.isUnique_2("\uD83E\uDD2F")); // 🤯
    assertFalse(Chapter1.isUnique_2("\uD83E\uDD2F\uD83E\uDD2F")); // 🤯🤯
    assertFalse(Chapter1.isUnique_2("hello"));
    assertFalse(Chapter1.isUnique_2("thequickbrownfoxjumpedoverthelazydog"));
  }

  @Test
  public void test1_2() {
    assertTrue(Chapter1.isPermutation_1("abcded", "dedcab"));
    assertFalse(Chapter1.isPermutation_1("dddde", "eeeed"));

    assertTrue(Chapter1.isPermutation_2("abcded", "dedcab"));
    assertFalse(Chapter1.isPermutation_2("dddde", "eeeed"));
  }
}
