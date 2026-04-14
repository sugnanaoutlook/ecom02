package com.ecom.ecom02.controller;

import com.ecom.ecom02.dto.OrderRequest;
import com.ecom.ecom02.entity.Order;
import com.ecom.ecom02.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public Order getOrder(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }

    @GetMapping("/customer")
    public List<Order> getOrdersByEmail(@RequestParam String email) {
        return orderService.getOrdersByEmail(email);
    }

    @PostMapping
    public Order createOrder(@RequestBody OrderRequest request) {
        return orderService.createOrder(request);
    }

    @PatchMapping("/{id}/status")
    public Order updateStatus(@PathVariable Long id, @RequestBody Map<String, String> body) {
        Order.OrderStatus status = Order.OrderStatus.valueOf(body.get("status"));
        return orderService.updateOrderStatus(id, status);
    }
}
