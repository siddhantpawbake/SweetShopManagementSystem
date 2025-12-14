package com.sweetshop.controller;

import com.sweetshop.domain.Sweet;
import com.sweetshop.service.SweetService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sweets")
public class SweetController {

    private final SweetService sweetService;

    public SweetController(SweetService sweetService) {
        this.sweetService = sweetService;
    }
    
    // 1️⃣ Add a sweet
    @PostMapping
public Sweet addSweet(@RequestBody Sweet sweet) {
    return sweetService.addSweet(sweet);
}

    // 2️⃣ Get all sweets
    @GetMapping
    public List<Sweet> getAllSweets() {
        return sweetService.getAllSweets();
    }

    // 3️⃣ Search by name
    @GetMapping("/search/name")
    public List<Sweet> searchByName(@RequestParam String name) {
        return sweetService.searchByName(name);
    }

    // 4️⃣ Search by category
    @GetMapping("/search/category")
    public List<Sweet> searchByCategory(@RequestParam String category) {
        return sweetService.searchByCategory(category);
    }

    // 5️⃣ Search by price range
    @GetMapping("/search/price")
    public List<Sweet> searchByPriceRange(
            @RequestParam double min,
            @RequestParam double max
    ) {
        return sweetService.searchByPriceRange(min, max);
    }
}
