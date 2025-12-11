package com.example.smallcommerce.service;

import com.example.smallcommerce.model.Order;
import com.example.smallcommerce.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Optional<Order> getOrderById(Long id) {
        return orderRepository.findById(id);
    }

    public Order createOrder(Order order) {
        // Calcolo semplice del totale
        double total = order.getProducts().stream().mapToDouble(p -> p.getPrice() * p.getQuantity()).sum();
        order.setTotalPrice(total);
        return orderRepository.save(order);
    }

    public Order updateOrder(Long id, Order orderDetails) {
        Order order = orderRepository.findById(id).orElseThrow();
        order.setUser(orderDetails.getUser());
        order.setProducts(orderDetails.getProducts());
        double total = order.getProducts().stream().mapToDouble(p -> p.getPrice() * p.getQuantity()).sum();
        order.setTotalPrice(total);
        return orderRepository.save(order);
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}