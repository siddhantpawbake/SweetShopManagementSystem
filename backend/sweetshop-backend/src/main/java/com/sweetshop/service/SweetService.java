package com.sweetshop.service;

import com.sweetshop.domain.Sweet;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SweetService {

    private final List<Sweet> sweets = new ArrayList<>();

    public void addSweet(Sweet sweet) {
        sweets.add(sweet);
    }

    public List<Sweet> getAllSweets() {
        return new ArrayList<>(sweets);
    }

    public List<Sweet> searchByName(String name) {
        return sweets.stream()
                .filter(s -> s.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Sweet> searchByCategory(String category) {
        return sweets.stream()
                .filter(s -> s.getCategory().equalsIgnoreCase(category))
                .collect(Collectors.toList());
    }

    public List<Sweet> searchByPriceRange(double min, double max) {
        return sweets.stream()
                .filter(s -> s.getPrice() >= min && s.getPrice() <= max)
                .collect(Collectors.toList());
    }
}
