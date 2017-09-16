package com.mandar.coffeeshop.controllers;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mandar.coffeeshop.domain.Customer;
import com.mandar.coffeeshop.domain.Orders;
import com.mandar.coffeeshop.domain.Product;
import com.mandar.coffeeshop.service.CustomerRepository;
import com.mandar.coffeeshop.service.OrderRepository;
import com.mandar.coffeeshop.service.ProductService;

@Controller
public class OrdersController {

    @Autowired
    private ProductService productService;
    
    @Autowired
    private CustomerRepository customerRepository;
    
    @Autowired
    private OrderRepository orderRepository;

    @RequestMapping(value = "/orders", method = RequestMethod.GET)
    public String productsList(Model model){
        model.addAttribute("products", productService.findAll());
        model.addAttribute("orders", orderRepository.findAll());
        return "orders";
    }

    @RequestMapping(value="/createorder", method = RequestMethod.POST)
    @ResponseBody
    public String saveOrder(@RequestParam String firstName, @RequestParam String lastName, @RequestParam(value="productIds[]") Long[] productIds){

        Customer customer = new Customer();
        customer.setFname(firstName);
        customer.setLname(lastName);
        customerRepository.save(customer);
        Orders order = new Orders();
        order.setCustomer(customerRepository.findOne(customer.getIdc()));
        Set<Product> productSet = new HashSet<Product>();
        for (Long productId:productIds){
            productSet.add(productService.findOne(productId));
        }
        order.setProducts(productSet);
        Double total = 0.0;
        for (Long productId:productIds){
            total = total + (productService.findOne(productId).getPrice().doubleValue());
        }
        order.setTotal(total);
        orderRepository.save(order);

        return order.getIdo().toString();
    }

    @RequestMapping(value = "/removeorder", method = RequestMethod.POST)
    @ResponseBody
    public String removeOrder(@RequestParam Long Id){
        //orderRepository.delete(Id);
        return Id.toString();
    }
}