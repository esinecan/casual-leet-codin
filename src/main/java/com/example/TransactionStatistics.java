package com.example;

import java.util.LinkedHashMap;

/**
 * Problem: Transaction Statistics with Sliding Window
 * 
 * Implement a service that records transactions and returns real-time statistics 
 * over a sliding window of the last 60 seconds.
 * 
 * Constraints:
 * - Time complexity of addTransaction and getStatistics should be O(1)
 * - Memory usage should be constant, i.e., not dependent on number of transactions
 * - Handle out-of-order transactions within the 60-second window
 * - Existence of at least one transaction is guaranteed for every 1 second interval.
 */

class Statistics {
    double sum;
    double avg;
    double max;
    double min;
    long count;
    
    public Statistics(double sum, double avg, double max, double min, long count) {
        this.sum = sum;
        this.avg = avg;
        this.max = max;
        this.min = min;
        this.count = count;
    }
    
    @Override
    public String toString() {
        return String.format("Statistics{sum=%.2f, avg=%.2f, max=%.2f, min=%.2f, count=%d}", 
                           sum, avg, max, min, count);
    }
}

public class TransactionStatistics {
    private final int MAX_SIZE = 60;
    private final LinkedHashMap<Long, Statistics> statsMap = new LinkedHashMap<>(MAX_SIZE, 0.75f, true);
    
    public void addTransaction(double amount, long timestamp) {
        long timestampSeconds = timestamp / 1000;
        long nowSeconds = System.currentTimeMillis() / 1000;
        long bucketKey = nowSeconds - timestampSeconds;

        if (bucketKey < 0 || bucketKey >= MAX_SIZE) {
            return; // Ignore transactions outside the last 60 seconds
        }

        statsMap.compute(bucketKey, (key, stats) -> {
            if (stats == null) {
                return new Statistics(amount, amount, amount, amount, 1);
            } else {
                double newSum = stats.sum + amount;
                long newCount = stats.count + 1;
                return new Statistics(newSum, newSum / newCount, Math.max(stats.max, amount), Math.min(stats.min, amount), newCount);
            }
        });

        if (statsMap.size() > MAX_SIZE) {
            statsMap.remove(statsMap.keySet().iterator().next()); // Remove the oldest entry (lowest key value)
        }

        //O(1) retained like a badass.
    }
      public Statistics getStatistics() {
        if (statsMap.isEmpty()) {
            return new Statistics(0, 0, 0, 0, 0);
        }
        
        double totalSum = 0, totalMax = Double.MIN_VALUE, totalMin = Double.MAX_VALUE;
        long totalCount = 0;

        //We botched the O(1) requirement with the loop here but it's the best I can do.
        for (Statistics stats : statsMap.values()) {
            totalSum += stats.sum;
            totalCount += stats.count;
            totalMax = Math.max(totalMax, stats.max);
            totalMin = Math.min(totalMin, stats.min);
        }

        return new Statistics(totalSum, totalCount > 0 ? totalSum / totalCount : 0, totalMax, totalMin, totalCount);
    }
    
    public static void main(String[] args) {
        TransactionStatistics service = new TransactionStatistics();
        long now = System.currentTimeMillis();
        
        System.out.println("=== Transaction Statistics Test ===");
        System.out.println();
        
        // Test case 1: Add some transactions
        System.out.println("Test case 1: Adding transactions");
        service.addTransaction(12.3, now - 5000);  // 5 seconds ago
        service.addTransaction(5.0, now - 1000);   // 1 second ago
        service.addTransaction(8.7, now - 3000);   // 3 seconds ago (out of order)
        
        Statistics stats1 = service.getStatistics();
        System.out.println("Current stats: " + stats1);
        System.out.println("Expected: sum=26.0, avg=8.67, max=12.3, min=5.0, count=3");
        System.out.println();
        
        // Test case 2: Add transaction at current time
        System.out.println("Test case 2: Adding current transaction");
        service.addTransaction(15.5, now);
        
        Statistics stats2 = service.getStatistics();
        System.out.println("Updated stats: " + stats2);
        System.out.println("Expected: sum=41.5, avg=10.38, max=15.5, min=5.0, count=4");
        System.out.println();
        
        // Test case 3: Add old transaction (should be ignored)
        System.out.println("Test case 3: Adding expired transaction");
        service.addTransaction(100.0, now - 65000);  // 65 seconds ago - should be ignored
        
        Statistics stats3 = service.getStatistics();
        System.out.println("Stats after expired transaction: " + stats3);
        System.out.println("Expected: same as before (expired transaction ignored)");
        System.out.println();
        
        // Test case 4: Empty statistics
        System.out.println("Test case 4: Empty statistics");
        TransactionStatistics emptyService = new TransactionStatistics();
        Statistics emptyStats = emptyService.getStatistics();
        System.out.println("Empty stats: " + emptyStats);
        System.out.println("Expected: all zeros");
        System.out.println();
        
        // Test case 5: Single transaction
        System.out.println("Test case 5: Single transaction");
        TransactionStatistics singleService = new TransactionStatistics();
        singleService.addTransaction(42.5, now - 1000);
        Statistics singleStats = singleService.getStatistics();
        System.out.println("Single transaction stats: " + singleStats);
        System.out.println("Expected: sum=42.5, avg=42.5, max=42.5, min=42.5, count=1");
    }
}
