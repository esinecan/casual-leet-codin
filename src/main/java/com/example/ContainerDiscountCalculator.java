package com.example;

import java.util.*;

/**
 * Supply Chain Container Pricing and Discount Calculator
 * 
 * Calculate which discount option saves a customer more money on their container order.
 */

enum ContainerType {
    CONTAINER_20_FEET("20 Feet Container"),
    CONTAINER_40_FEET("40 Feet Container");
    
    private final String displayName;
    
    ContainerType(String displayName) {
        this.displayName = displayName;
    }
    
    public String getDisplayName() {
        return displayName;
    }
}

class ContainerOrder {
    private ContainerType type;
    private int quantity;
    private boolean useBiofuel;
    
    public ContainerOrder(ContainerType type, int quantity, boolean useBiofuel) {
        this.type = type;
        this.quantity = quantity;
        this.useBiofuel = useBiofuel;
    }
    
    // Getters
    public ContainerType getType() { return type; }
    public int getQuantity() { return quantity; }
    public boolean isUseBiofuel() { return useBiofuel; }
}

class PriceList {
    private Map<ContainerType, Double> prices;
    
    public PriceList() {
        this.prices = new HashMap<>();
    }
    
    public void setPrice(ContainerType type, double price) {
        prices.put(type, price);
    }
    
    public double getPrice(ContainerType type) {
        return prices.getOrDefault(type, 0.0);
    }
}

enum DiscountType {
    SAVE_ENVIRONMENT("Save the Environment Discount"),
    BUY_2_GET_1_FREE("Buy 2, Get 1 Free Discount");
    
    private final String displayName;
    
    DiscountType(String displayName) {
        this.displayName = displayName;
    }
    
    public String getDisplayName() {
        return displayName;
    }
}

public class ContainerDiscountCalculator {
    
    private static final double BIOFUEL_EXTRA_COST = 5.0;
    private static final double ENVIRONMENT_DISCOUNT_RATE = 0.01; // 1%
      public DiscountType calculateBestDiscount(PriceList priceList, List<ContainerOrder> orders) {
        double environmentSavings = calculateEnvironmentDiscount(priceList, orders);
        double buy2Get1FreeSavings = calculateBuy2Get1FreeDiscount(priceList, orders);
        
        if (environmentSavings > buy2Get1FreeSavings) {
            return DiscountType.SAVE_ENVIRONMENT;
        } else if (buy2Get1FreeSavings > environmentSavings) {
            return DiscountType.BUY_2_GET_1_FREE;
        } else {
            return environmentSavings > 0 ? DiscountType.SAVE_ENVIRONMENT : null;
        }
    }
    
    private double calculateBaseOrderTotal(PriceList priceList, List<ContainerOrder> orders) {
        double total = 0.0;
        for (ContainerOrder order : orders) {
            double basePrice = priceList.getPrice(order.getType()) * order.getQuantity();
            double biofuelExtra = order.isUseBiofuel() ? BIOFUEL_EXTRA_COST * order.getQuantity() : 0.0;
            total += basePrice + biofuelExtra;
        }
        return total;
    }
    
    private double calculateEnvironmentDiscount(PriceList priceList, List<ContainerOrder> orders) {
        // Check if any container uses biofuel
        boolean hasBiofuel = orders.stream().anyMatch(ContainerOrder::isUseBiofuel);
        
        if (!hasBiofuel) {
            return 0.0; // No discount applicable
        }
        
        double totalCost = calculateBaseOrderTotal(priceList, orders);
        return totalCost * ENVIRONMENT_DISCOUNT_RATE; // 1% savings
    }
    
    private double calculateBuy2Get1FreeDiscount(PriceList priceList, List<ContainerOrder> orders) {
        // Count total 40' containers
        int total40FeetContainers = orders.stream()
            .filter(order -> order.getType() == ContainerType.CONTAINER_40_FEET)
            .mapToInt(ContainerOrder::getQuantity)
            .sum();
        
        // For every 2x 40' containers, get 1x 20' container free
        int free20FeetContainers = total40FeetContainers / 2;
        
        if (free20FeetContainers == 0) {
            return 0.0; // No discount applicable
        }
        
        // Savings = price of free 20' containers
        double price20Feet = priceList.getPrice(ContainerType.CONTAINER_20_FEET);
        return free20FeetContainers * price20Feet;
    }
    
    public static void main(String[] args) {
        ContainerDiscountCalculator calculator = new ContainerDiscountCalculator();
        
        // Test case from example
        System.out.println("=== Container Discount Calculator Test ===");
        System.out.println();
        
        // Setup HappyShipper price list
        PriceList happyShipperPrices = new PriceList();
        happyShipperPrices.setPrice(ContainerType.CONTAINER_20_FEET, 5000.0);
        happyShipperPrices.setPrice(ContainerType.CONTAINER_40_FEET, 9000.0);
        
        // Setup HappyShipper order
        List<ContainerOrder> happyShipperOrder = Arrays.asList(
            new ContainerOrder(ContainerType.CONTAINER_20_FEET, 2, false),        // 2x 20' regular
            new ContainerOrder(ContainerType.CONTAINER_20_FEET, 3, true),         // 3x 20' with biofuel
            new ContainerOrder(ContainerType.CONTAINER_40_FEET, 7, false)         // 7x 40' regular
        );
        
        System.out.println("Customer: HappyShipper");
        System.out.println("Price List:");
        System.out.println("- 20 Feet Container: $" + happyShipperPrices.getPrice(ContainerType.CONTAINER_20_FEET));
        System.out.println("- 40 Feet Container: $" + happyShipperPrices.getPrice(ContainerType.CONTAINER_40_FEET));
        System.out.println();
        
        System.out.println("Order:");
        System.out.println("- 20 Feet Container: 2 units (regular)");
        System.out.println("- 20 Feet Container: 3 units (with biofuel +$5 each)");
        System.out.println("- 40 Feet Container: 7 units (regular)");
        System.out.println();
        
        DiscountType bestDiscount = calculator.calculateBestDiscount(happyShipperPrices, happyShipperOrder);
        
        if (bestDiscount != null) {
            System.out.println("Best discount for customer: " + bestDiscount.getDisplayName());
        } else {
            System.out.println("No discount provides savings for this order");
        }
    }
}
