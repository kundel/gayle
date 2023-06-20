package chapter1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Chapter1Test {
    @Test
    public void test1_1() {
        assertTrue(Chapter1.isUnique_1("你好，世界！"));
        assertFalse(Chapter1.isUnique_1("你好，世界世界！"));
        assertTrue(Chapter1.isUnique_2("你好，世界！"));
        assertFalse(Chapter1.isUnique_2("你好，世界世界！"));
    }

    @Test
    public void test1_2() {
        assertTrue(Chapter1.isPermutation("abcded", "dedcab"));
        assertFalse(Chapter1.isPermutation("dddde", "eeeed"));
    }
}
