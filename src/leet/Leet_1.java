package leet;

import java.util.ArrayList;

public class Leet_1 {
    public static void main(String[] args) {
        String[]strs={"flower","flow","flight"}; longestCommonPrefix(strs);
    }

    public static void longestCommonPrefix(String[] strs) {
        String nig="";
        for (int i = 0; i <strs.length-1 ; i++) {
            for (int j = 0; j < strs[i].length(); j++) {
                if(strs[i].charAt(j)==strs[i+1].charAt(j)){nig=nig+strs[i].charAt(j);}
           else {break;} }
        }
        System.out.println(nig); }
}
