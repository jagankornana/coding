package com.leetcode.problems;

public class LongestCommonPrefix {
  public static void main(String[] args) {
    LongestCommonPrefix input = new LongestCommonPrefix();
    System.out.println(input.longestCommonPrefix_1(new String[]{"mango", "mano", "ma"}));
    System.out.println(input.longestCommonPrefix_2(new String[]{"mango", "mano", "ma"}));
  }

  // Vertical scanning
  public String longestCommonPrefix_1(String[] strs) {
    if (strs == null || strs.length == 0) {
      return "";
    }
    for (int i = 0; i < strs[0].length(); i++) {
      char ch = strs[0].charAt(i);
      for (int j = 1; j < strs.length; j++) {
        if (i == strs[j].length() || strs[j].charAt(i) != ch) {
          return strs[j].substring(0, i);
        }
      }
    }
    return strs[0];
  }

  // Horizontal scanning
  public String longestCommonPrefix_2(String[] strs) {
    if (strs.length == 0) return "";
    String prefix = strs[0];
    for (int i = 1; i < strs.length; i++)
      while (strs[i].indexOf(prefix) != 0) {
        prefix = prefix.substring(0, prefix.length() - 1);
        if (prefix.isEmpty()) return "";
      }
    return prefix;
  }
}
