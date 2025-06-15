package com.example;

/**
 * Problem: Best Time to Buy and Sell Stock
 * 
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * You want to maximize your profit by choosing a single day to buy one stock and choosing 
 * a different day in the future to sell that stock.
 * 
 * Return the maximum profit you can achieve from this transaction. 
 * If you cannot achieve any profit, return 0.
 * 
 * Constraints:
 * - 1 <= prices.length <= 10^5
 * - 0 <= prices[i] <= 10^4
 * - Must buy before sell
 */
public class BestTimeToBuyAndSellStock {
    
    public int maxProfit(int[] prices) {
        int minPriceSoFarIndex = 0;
        int maxProfit = 0;
        for(int i =0; i<prices.length;i++){
            if(prices[i] < prices[minPriceSoFarIndex]){
                minPriceSoFarIndex = i;
            }
            else{
                int todaysProfit = prices[i] - prices[minPriceSoFarIndex];
                if(todaysProfit > maxProfit){
                    maxProfit = todaysProfit;
                }
            }
        }
        return maxProfit;
    }
    
    // Helper method to print array
    public static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(", ");
        }
        System.out.print("]");
    }
    
    public static void main(String[] args) {
        BestTimeToBuyAndSellStock solution = new BestTimeToBuyAndSellStock();
        
        // Test case 1: [7,1,5,3,6,4] - profit possible
        System.out.println("Test case 1:");
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        System.out.print("Input: prices = ");
        printArray(prices1);
        System.out.println();
        
        int result1 = solution.maxProfit(prices1);
        System.out.println("Output: " + result1 + " (Expected: 5)");
        System.out.println("Explanation: Buy at 1, sell at 6, profit = 6-1 = 5");
        System.out.println();
        
        // Test case 2: [7,6,4,3,1] - no profit possible
        System.out.println("Test case 2:");
        int[] prices2 = {7, 6, 4, 3, 1};
        System.out.print("Input: prices = ");
        printArray(prices2);
        System.out.println();
        
        int result2 = solution.maxProfit(prices2);
        System.out.println("Output: " + result2 + " (Expected: 0)");
        System.out.println("Explanation: Prices only go down, no profit possible");
        System.out.println();
        
        // Test case 3: [1,2,3,4,5] - buy low, sell high
        System.out.println("Test case 3:");
        int[] prices3 = {1, 2, 3, 4, 5};
        System.out.print("Input: prices = ");
        printArray(prices3);
        System.out.println();
        
        int result3 = solution.maxProfit(prices3);
        System.out.println("Output: " + result3 + " (Expected: 4)");
        System.out.println("Explanation: Buy at 1, sell at 5, profit = 5-1 = 4");
        System.out.println();
        
        // Test case 4: Single price
        System.out.println("Test case 4:");
        int[] prices4 = {5};
        System.out.print("Input: prices = ");
        printArray(prices4);
        System.out.println();
        
        int result4 = solution.maxProfit(prices4);
        System.out.println("Output: " + result4 + " (Expected: 0)");
        System.out.println("Explanation: Only one day, can't buy and sell");
        System.out.println();
        
        // Test case 5: Two prices
        System.out.println("Test case 5:");
        int[] prices5 = {2, 4};
        System.out.print("Input: prices = ");
        printArray(prices5);
        System.out.println();
        
        int result5 = solution.maxProfit(prices5);
        System.out.println("Output: " + result5 + " (Expected: 2)");
        System.out.println("Explanation: Buy at 2, sell at 4, profit = 4-2 = 2");
    }
}
