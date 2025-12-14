package com.sweetshop.service;

import com.sweetshop.domain.Sweet;

import java.util.ArrayList;
import java.util.List;

public class SweetService {

    private final List<Sweet> sweets = new ArrayList<>();

    public void addSweet(Sweet sweet) {
        sweets.add(sweet);
    }

    public List<Sweet> getAllSweets() {
        return sweets;
    }
    public List<Sweet> searchByName(String name) {
    List<Sweet> result = new ArrayList<>();

    for (Sweet sweet : sweets) {
        if (sweet.getName().toLowerCase().contains(name.toLowerCase())) {
            result.add(sweet);
        }
    }

    return result;
}

}

