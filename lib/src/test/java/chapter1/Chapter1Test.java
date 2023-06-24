package chapter1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
  }

  @Test
  public void test1_3() {
    assertEquals(Chapter1.urlify("http://www.example.com/this has spaces"), "http://www.example.com/this%20has%20spaces");
  }
}
