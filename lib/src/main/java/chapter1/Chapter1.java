package chapter1;

import java.util.*;

public class Chapter1 {
  public Chapter1() {}

  // emoji, utf-16 safe
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

  // emoji, utf-16 safe
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

  public static boolean isPermutation_1(String one, String two) {
    if (one == null || two == null) {
      throw new IllegalArgumentException("empty input string");
    }
    if (one.length() != two.length()) {
      return false;
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
    TreeMap<Integer, Integer> idx = new TreeMap<>();
    final int length = input.length();
    for (int offset = 0; offset < length; ) {
      final int codepoint = input.codePointAt(offset);
      int count = idx.getOrDefault(codepoint, 0);
      idx.put(codepoint, ++count);
      offset += Character.charCount(codepoint);
    }
    return idx;
  }

  @Deprecated
  public static boolean isPermutation_2(String one, String two) {
    if (one == null || two == null) {
      throw new IllegalArgumentException("empty input string");
    }
    if (one.length() != two.length()) {
      return false;
    }
    int[] codePoints =
        new int
            [Integer
                .MAX_VALUE]; // uses too much memory for all of the codepoints, need sparse array
    for (int offset = 0; offset < one.length(); ) {
      final int codepoint = one.codePointAt(offset);
      codePoints[offset]++;
      offset += Character.charCount(codepoint);
    }
    for (int offset = 0; offset < two.length(); ) {
      final int codepoint = two.codePointAt(offset);
      codePoints[offset]--;
      if (codePoints[offset] < 0) {
        return false;
      }
      offset += Character.charCount(codepoint);
    }
    return true;
  }

  public static String urlify(String url) {
    // canonical way:
    // return URLEncoder.encode(url, StandardCharsets.UTF_8);
    if (url == null) throw new IllegalArgumentException("null input");
    StringBuilder out = new StringBuilder();
    char[] chars = url.toCharArray();
    char space = " ".toCharArray()[0];
    String urlEncodedSpace = "%20";
    for (int i = 0; i < chars.length; i++) {
      char c = chars[i];
      if (c == space) {
        out.append(urlEncodedSpace);
      } else {
        out.append(c);
      }
    }
    return out.toString();
  }

  public static boolean isPalendrome(String str1, String str2) {
    return isPermutation_1(str1.toLowerCase(), str2.toLowerCase());
  }

  public static boolean isOneAway(String str1, String str2) {
    Map<Integer, Integer> oneIdx = index(str1);
    Map<Integer, Integer> twoIdx = index(str2);
    int diff = 0;
    for (Map.Entry<Integer, Integer> e : twoIdx.entrySet()) {
      int key = e.getKey();
      int value = e.getValue();
      Integer oneVal = oneIdx.get(key);
      if (!oneIdx.containsKey(key)) {
        diff++;
      } else if (value != oneVal) {
        diff++;
      }
    }
    return diff < 2;
  }

  static class sIdx {
    char c;
    int n;

    public sIdx(char character, int num) {
      c = character;
      n = num;
    }

    public char[] out() {
      char[] out = new char[2];
      out[0] = c;
      out[1] = Character.forDigit(n, 10);
      return out;
    }

    @Override
    public String toString() {
      return new String(out());
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      sIdx sIdx = (sIdx) o;
      return c == sIdx.c && n == sIdx.n;
    }

    @Override
    public int hashCode() {
      return Objects.hash(c, n);
    }
  }

  public static String compressString(String str) {
    if (str == null) {
      return "";
    }
    List<sIdx> compress = new ArrayList<>(str.length());
    int count = 0;
    char lastchar = '\0';
    char[] chars = str.toCharArray();
    for (int i = 0; i < chars.length; i++) {
      char c = chars[i];
      if (lastchar == c) {
        ++count;
        if (chars.length - 1 == i) {
          compress.add(new sIdx(lastchar, ++count));
        }
      } else if (i > 0 && lastchar != c) {
        compress.add(new sIdx(lastchar, ++count));
        count = 0;
      } else {
        int ii = 5;
      }
      lastchar = c;
    }
    StringBuilder cmp = new StringBuilder();
    for (sIdx s : compress) {
      cmp.append(s.out());
    }
    return cmp.toString();
  }

  public static int[][] rotateMatrix(int[][] image) {
    /*
    123456789
    123456789
    123456789
    123456789
    123456789
    123456789
    123456789
    123456789
    123456789
    123456789
    --
    111111111
    222222222
    333333333
    444444444
    555555555
    666666666
    777777777
    888888888
    999999999
    */
    if (image.length != image[0].length) {
      throw new IllegalArgumentException("not square");
    }

    int[][] rotated = new int[image.length][image.length];
    for (int i = 0; i < image.length; i++) {
      for (int j = 0; j < image.length; j++) {
        rotated[j][i] = image[i][j];
      }
    }

    return rotated;
  }

  public static int[][] zeroMatrix(int[][] matrix) {
    Set<Integer> cols = new TreeSet<>();
    boolean skip = false;
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix.length; j++) {
        if (matrix[i][j] == 0 && !skip) {
          Arrays.fill(matrix[i], 0);
          cols.add(j);
          skip = true;
        }
      }
      skip = false;
    }
    for (int i : cols) {
      for (int j = 0; j < matrix.length; j++) {
        matrix[j][i] = 0;
      }
    }
    return matrix;
  }
}
