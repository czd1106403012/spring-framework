package com.istudy.dada;

class Solution {

    public static void main(String[] args) {

//        int[] arr = {2,4,1};   // 2
        int[] arr = {7,1,5,3,6,4};  // 5
//        int[] arr = {7,6,4,3,1};  // 0
//        int[] arr = {2,4,1,5};  // 4
        System.out.println(new Solution().maxProfit(arr));
    }

    public int maxProfit(int[] prices) {

        if (prices == null || prices.length == 0) {
            return 0;
        }
        int min = prices[0],max = prices[0];
        int minIndex = 0, maxIndex = 0;
        int result = 0;

        for (int i = 1; i < prices.length; ++i) {

            if (prices[i] > max) {
                max = prices[i];
                maxIndex = i;
                result = max - min;
            } else if (prices[i] < min) {
                min = prices[i];
                minIndex = i;
            }
        }

//        System.out.println(minIndex + " " + min);
//        System.out.println(maxIndex + " " + max);
//        if (minIndex > maxIndex) {
//            return 0;
//        } else {
//            return max-min;
//        }
        return result;
    }
}