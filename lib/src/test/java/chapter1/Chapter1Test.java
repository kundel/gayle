package chapter1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Chapter1Test {
    @Test
    public void test1_1() {
        Assertions.assertTrue(Chapter1.isUnique("你好，世界！"));
        Assertions.assertFalse(Chapter1.isUnique("你好，世界世界！"));
    }
}
