package com.example.dto;

import java.util.HashMap;
import java.util.Map;

public class CartDto {
    private Map<ProductDto, Integer> productMap = new HashMap<>();

    public CartDto() {
    }

    public CartDto(Map<ProductDto, Integer> productMap) {
        this.productMap = productMap;
    }

    public Map<ProductDto, Integer> getProductMap() {
        return productMap;
    }

    public void setProductMap(Map<ProductDto, Integer> productMap) {
        this.productMap = productMap;
    }

    public void addProduct(ProductDto productDto) {
        if (productMap.containsKey(productDto)) {
            Integer currentValue = productMap.get(productDto);
            productMap.put(productDto, currentValue + 1);
        } else {
            productMap.put(productDto, 1);
        }
    }

    public void decreaseProduct(ProductDto productDto) {
        if (productMap.containsKey(productDto)) {
            Integer currentValue = productMap.get(productDto);

            if (currentValue > 1) {
                productMap.replace(productDto, currentValue - 1);
            } else {
                productMap.remove(productDto);
            }
        }
    }



    public Double totalPayment() {
        double money = 0;
        for (Map.Entry<ProductDto, Integer> entry : productMap.entrySet()) {
            money += entry.getKey().getPrice() * (double) entry.getValue();
        }
        return money;
    }
}
