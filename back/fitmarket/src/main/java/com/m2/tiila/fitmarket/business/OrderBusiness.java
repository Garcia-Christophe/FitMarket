package com.m2.tiila.fitmarket.business;

import com.m2.tiila.fitmarket.entity.OrderEntity;
import com.m2.tiila.fitmarket.mapper.OrderMapper;
import com.m2.tiila.fitmarket.repository.OrderRepository;
import dto.fitmarketapi.Order;
import dto.fitmarketapi.OrderProduct;
import jakarta.inject.Inject;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.m2.tiila.fitmarket.mapper.OrderMapper.toDto;


@Component
public class OrderBusiness {
    @Inject
    private OrderRepository orderRepository;


    public Order getOrderInProgressByUserId(Integer idUser) {
        OrderEntity orderEntity = orderRepository.getOrderInProgressByUserId(idUser);

        return toDto(orderEntity);
    }

    public List<Order> getOrdersByUserId(Integer idUser) {
        List<OrderEntity> ordersEntities = orderRepository.getOrdersByUserId(idUser);
        return ordersEntities.stream().map(OrderMapper::toDto).toList();
    }

    public void updateOrder(Integer userId, OrderEntity orderEntity) {
        int orderId = getOrCreateCurrentOrder(userId);

        addOrUpdateOrderProducts(orderId, orderEntity.getProducts());

        removeUnusedOrderProducts(orderId, orderEntity.getProducts());

        if(orderEntity.getDateOrder()!=null){
            orderRepository.updateOrderDate(orderId, orderEntity.getDateOrder());
        }
    }

    private int getOrCreateCurrentOrder(Integer userId) {
        OrderEntity orderEntity = orderRepository.getOrderInProgressByUserId(userId);

        if (orderEntity!=null) {
            // La commande en cours existe déjà
            return orderEntity.getId();
        }
        return orderRepository.createOrder(userId);
    }

    private void addOrUpdateOrderProducts(int orderId, List<OrderProduct> orderProducts) {
        for (OrderProduct orderProduct : orderProducts) {
            orderRepository.addOrUpdateOrderProducts(orderId, orderProduct);
        }
    }

    private void removeUnusedOrderProducts(int orderId, List<OrderProduct> updatedOrderProducts) {
       List<Integer> productIds = extractProductIds(updatedOrderProducts);
       orderRepository.removeUnusedOrderProducts(orderId,productIds);
    }

    private List<Integer> extractProductIds(List<OrderProduct> orderProducts) {
        return orderProducts.stream()
                .map(orderProduct -> orderProduct.getProduct().getId())
                .toList();
    }
}
