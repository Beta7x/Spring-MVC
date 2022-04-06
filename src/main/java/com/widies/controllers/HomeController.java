package com.widies.controllers;

import com.widies.controllers.entity.Product;
import com.widies.controllers.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class HomeController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public String welcome(Model model) {
        String message = "Welcome to Spring MVC dengan menggunakan Template Thymeleaf";
        model.addAttribute("msg", message);
        model.addAttribute("products", productService.findAll());
        return "index";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("product", new Product());
        return "add";
    }

    @PostMapping("/save")
    public String save(Product product, Model model) {
        // System.out.println(product.getName());
        productService.addProduct(product);

        // String message = "Welcome to Spring MVC dengan menggunakan Template Thymeleaf";
        // model.addAttribute("msg", message);
        // model.addAttribute("products", productService.findAll());
        // return "index";
        return "redirect:/";
    }

}