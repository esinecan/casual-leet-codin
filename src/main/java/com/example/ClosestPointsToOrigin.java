package com.example;

import java.util.*;

/**
 * Problem: K Closest Points to Origin
 * 
 * Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane
 * and an integer k, return the k closest points to the origin (0, 0).
 * 
 * The distance between two points on the X-Y plane is the Euclidean distance 
 * (i.e., √((x1 - x2)² + (y1 - y2)²)).
 */
public class ClosestPointsToOrigin {
    
    public int[][] kClosest(int[][] points, int k) {
        //assuming valid input
        int[][] minPoints = new int[2][2];
        minPoints[0] = closest(points, k);
        minPoints[1] = closest(points, k);
        return minPoints;
    }    private int[] closest(int[][] points) {
        double minDistance = Double.MAX_VALUE;
        int minPointIndex = -1;
        for(int i = 0; i < points.length; i++){
            // Skip points that have been marked as used
            if(points[i][0] == Integer.MAX_VALUE && points[i][1] == Integer.MAX_VALUE) {
                continue;
            }
            
            double distance = distanceSquared(points[i]);
            if(distance < minDistance){
                minDistance = distance;
                minPointIndex = i;
            }
        }
        
        if(minPointIndex == -1) {
            return new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        }
        
        int[] result = {points[minPointIndex][0], points[minPointIndex][1]};
        // Mark as used by setting to max values
        points[minPointIndex][0] = Integer.MAX_VALUE;
        points[minPointIndex][1] = Integer.MAX_VALUE;
        
        return result;
    }
    
    // Helper method to calculate distance squared (avoid sqrt for performance)
    private double distanceSquared(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
    
    // Helper method to print points
    public static void printPoints(int[][] points) {
        System.out.print("[");
        for (int i = 0; i < points.length; i++) {
            System.out.print("[" + points[i][0] + "," + points[i][1] + "]");
            if (i < points.length - 1) System.out.print(", ");
        }
        System.out.print("]");
    }
    
    public static void main(String[] args) {
        ClosestPointsToOrigin solution = new ClosestPointsToOrigin();
        
        // Test case 1: Basic example
        System.out.println("Test case 1:");
        int[][] points1 = {{1,3}, {-2,2}, {2,1}, {0,1}};
        System.out.print("Input: points = ");
        printPoints(points1);
        System.out.println(", k = 2");
        
        int[][] result1 = solution.kClosest(points1, 2);
        System.out.print("Output: ");
        printPoints(result1);
        System.out.println(" (Expected: [[0,1], [2,1]] or similar)");
        System.out.println();
        
        // Test case 2: All same distance
        System.out.println("Test case 2:");
        int[][] points2 = {{3,3}, {5,-1}, {-2,4}};
        System.out.print("Input: points = ");
        printPoints(points2);
        System.out.println(", k = 1");
        
        int[][] result2 = solution.kClosest(points2, 1);
        System.out.print("Output: ");
        printPoints(result2);
        System.out.println(" (Expected: [[3,3]] - closest to origin)");
        System.out.println();
        
        // Test case 3: Origin point included
        System.out.println("Test case 3:");
        int[][] points3 = {{0,0}, {1,1}, {2,2}};
        System.out.print("Input: points = ");
        printPoints(points3);
        System.out.println(", k = 2");
        
        int[][] result3 = solution.kClosest(points3, 2);
        System.out.print("Output: ");
        printPoints(result3);
        System.out.println(" (Expected: [[0,0], [1,1]])");
    }
}
