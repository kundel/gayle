package chapter1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.stream.IntStream;
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
  }

  @Test
  public void test1_3() {
    assertEquals(
        Chapter1.urlify("http://www.example.com/this has spaces"),
        "http://www.example.com/this%20has%20spaces");
  }

  @Test
  public void test1_4() {
    assertTrue(Chapter1.isPalendrome("Tact Coa", "taco cat"));
    assertTrue(Chapter1.isPalendrome("Tact Coa", "atco cta"));
  }

  @Test
  public void test1_5() {
    assertTrue(Chapter1.isOneAway("pale", "ple"));
    assertTrue(Chapter1.isOneAway("pales", "pale"));
    assertTrue(Chapter1.isOneAway("pale", "bale"));
    assertFalse(Chapter1.isOneAway("pale", "bake"));
  }

  @Test
  public void test1_6() {
    assertEquals(Chapter1.compressString("aabcccccaaa"), "a2b1c5a3");
  }

  @Test
  public void test1_7() {
    int[][] image = {
      IntStream.range(1, 10).toArray(),
      IntStream.range(1, 10).toArray(),
      IntStream.range(1, 10).toArray(),
      IntStream.range(1, 10).toArray(),
      IntStream.range(1, 10).toArray(),
      IntStream.range(1, 10).toArray(),
      IntStream.range(1, 10).toArray(),
      IntStream.range(1, 10).toArray(),
      IntStream.range(1, 10).toArray()
    };
    int[][] expected = {
      IntStream.of(1, 1, 1, 1, 1, 1, 1, 1, 1).toArray(),
      IntStream.of(2, 2, 2, 2, 2, 2, 2, 2, 2).toArray(),
      IntStream.of(3, 3, 3, 3, 3, 3, 3, 3, 3).toArray(),
      IntStream.of(4, 4, 4, 4, 4, 4, 4, 4, 4).toArray(),
      IntStream.of(5, 5, 5, 5, 5, 5, 5, 5, 5).toArray(),
      IntStream.of(6, 6, 6, 6, 6, 6, 6, 6, 6).toArray(),
      IntStream.of(7, 7, 7, 7, 7, 7, 7, 7, 7).toArray(),
      IntStream.of(8, 8, 8, 8, 8, 8, 8, 8, 8).toArray(),
      IntStream.of(9, 9, 9, 9, 9, 9, 9, 9, 9).toArray(),
    };
    assertTrue(Arrays.deepEquals(Chapter1.rotateMatrix(image), expected));
  }

  @Test
  public void test1_8() {
    int[][] input = {
      IntStream.of(1, 0, 1, 1, 1, 1, 1, 1, 1).toArray(),
      IntStream.of(2, 2, 2, 2, 2, 2, 2, 2, 2).toArray(),
      IntStream.of(3, 3, 3, 0, 3, 3, 3, 3, 3).toArray(),
      IntStream.of(4, 4, 4, 4, 4, 4, 4, 4, 4).toArray(),
      IntStream.of(5, 5, 5, 5, 5, 0, 5, 5, 5).toArray(),
      IntStream.of(6, 6, 6, 6, 6, 6, 6, 6, 6).toArray(),
      IntStream.of(7, 7, 7, 7, 7, 7, 7, 0, 7).toArray(),
      IntStream.of(8, 8, 8, 8, 8, 8, 8, 8, 8).toArray(),
      IntStream.of(9, 9, 9, 9, 9, 9, 9, 9, 0).toArray(),
    };
    int[][] expected = {
      IntStream.of(0, 0, 0, 0, 0, 0, 0, 0, 0).toArray(),
      IntStream.of(2, 0, 2, 0, 2, 0, 2, 0, 0).toArray(),
      IntStream.of(0, 0, 0, 0, 0, 0, 0, 0, 0).toArray(),
      IntStream.of(4, 0, 4, 0, 4, 0, 4, 0, 0).toArray(),
      IntStream.of(0, 0, 0, 0, 0, 0, 0, 0, 0).toArray(),
      IntStream.of(6, 0, 6, 0, 6, 0, 6, 0, 0).toArray(),
      IntStream.of(0, 0, 0, 0, 0, 0, 0, 0, 0).toArray(),
      IntStream.of(8, 0, 8, 0, 8, 0, 8, 0, 0).toArray(),
      IntStream.of(0, 0, 0, 0, 0, 0, 0, 0, 0).toArray(),
    };
    int[][] output = Chapter1.zeroMatrix(input);
    assertTrue(Arrays.deepEquals(output, expected));
  }
}
