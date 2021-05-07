package com.example.demo.algorithm;

import java.util.HashMap;
import java.util.Map;

public class MaxSubString {
    public static void main(String[] args) {

        System.out.println(        Math.max(1,2));
        String str ="sadasda";
        System.out.println(str.charAt(2));

        System.out.println(lengthOfLongestSubstring("sad3rfsfsdf"));
    }

    public static int lengthOfLongestSubstring(String s) {
//        StringBuffer str = new StringBuffer();
//        Map<Character,Integer> map = new HashMap<>();
//         ;int end =0; int  max =0;
//            for(int i=0,start =0;i<s.length();i++){
//                char  c= s.charAt(i);
//                if(map.containsKey(c)){
//                    start=Math.max(map.get(c),start);//开始的下标
//                }
//                max= Math.max(i-start+1,max);
//                map.put(s.charAt(i),end+1);
//            }
//            return   max;


        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int end = 0, start = 0; end < n; end++) {
            char alpha = s.charAt(end);
            if (map.containsKey(alpha)) {
                start = Math.max(map.get(alpha), start);
            }
            ans = Math.max(ans, end - start + 1);
            map.put(s.charAt(end), end + 1);
        }
        return ans;




    }
}
