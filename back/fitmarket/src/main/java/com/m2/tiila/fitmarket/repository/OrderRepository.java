package com.m2.tiila.fitmarket.repository;

import com.m2.tiila.fitmarket.entity.CommentEntity;
import com.m2.tiila.fitmarket.entity.OrderEntity;
import com.m2.tiila.fitmarket.mapper.CommentMapper;
import com.m2.tiila.fitmarket.mapper.OrderMapper;
import dto.fitmarketapi.*;
import jakarta.inject.Inject;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.*;

import static com.m2.tiila.fitmarket.mapper.OrderMapper.toEntity;

@Component
public class OrderRepository {

    private final static String getInProgressOrder = "SELECT o.id AS order_id, o.date_order, m.id AS user_id, m.firstname AS user_firstname, " +
            "m.lastname AS user_lastname, m.email AS user_email, op.id_product, op.quantity, " +
            "p.id AS product_id, p.title AS product_title, p.price AS product_price, " +
            "p.description AS product_description, p.category AS product_category " +
            "FROM orders o " +
            "JOIN order_product op ON o.id = op.id_order " +
            "JOIN member m ON o.id_user = m.id " +
            "JOIN product p ON op.id_product = p.id " +
            "WHERE o.date_order IS NULL AND m.id = :userId";

    private final static String getOrder = "SELECT o.id AS order_id, o.date_order, m.id AS user_id, m.firstname AS user_firstname, " +
            "m.lastname AS user_lastname, m.email AS user_email, op.id_product, op.quantity, " +
            "p.id AS product_id, p.title AS product_title, p.price AS product_price, " +
            "p.description AS product_description, p.category AS product_category " +
            "FROM orders o " +
            "JOIN order_product op ON o.id = op.id_order " +
            "JOIN member m ON o.id_user = m.id " +
            "JOIN product p ON op.id_product = p.id " +
            "WHERE o.date_order IS NOT NULL AND m.id = :userId";

    private final static String createOrder = "INSERT INTO orders (id_user, date_order) VALUES (:userId, :currentDateTime)";

    private final static String insertQuery = "INSERT INTO order_product (id_order, id_product, quantity) VALUES (:orderId, :productId, :quantity)";

    private final static String updateQuery = "UPDATE order_product SET quantity = :quantity WHERE id_order = :orderId AND id_product = :productId";

    private final static String deleteQuery = "DELETE FROM order_product WHERE id_order = :orderId AND id_product NOT IN (:productIds)";

    private final static String updateDateQuery = "UPDATE orders SET date_order = :date WHERE id = :orderId";

    @Inject
    private NamedParameterJdbcTemplate jdbcTemplate;

    public OrderEntity getOrderInProgressByUserId(Integer idUser) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("userId", idUser);

        List<Order> orders = jdbcTemplate.query(getInProgressOrder, params, (resultSet) -> {
            Map<Integer, Order> orderMap = new HashMap<>();

            while (resultSet.next()) {
                int orderId = resultSet.getInt("order_id");
                Order order = orderMap.computeIfAbsent(orderId, key -> {
                    Order newOrder = new Order();
                    newOrder.setId(orderId);
                    try {
                        newOrder.setDateOrder(resultSet.getString("date_order"));
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }

                    newOrder.setProducts(new ArrayList<>());
                    return newOrder;
                });

                OrderProduct product = new OrderProduct();
                product.setQuantity(resultSet.getInt("quantity"));

                Product productDetails = new Product();
                productDetails.setId(resultSet.getInt("id_product"));
                productDetails.setId(resultSet.getInt("product_id"));
                productDetails.setTitle(resultSet.getString("product_title"));
                productDetails.setPrice(resultSet.getInt("product_price"));
                productDetails.setDescription(resultSet.getString("product_description"));
                productDetails.setCategory(Category.fromValue(resultSet.getString("product_category")));
                product.setProduct(productDetails);

                order.getProducts().add(product);
            }

            return new ArrayList<>(orderMap.values());
        });

        return toEntity(orders.get(0));
    }

    public List<OrderEntity> getOrdersByUserId(Integer idUser) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("userId", idUser);

        List<Order> orders = jdbcTemplate.query(getOrder, params, (resultSet) -> {
            Map<Integer, Order> orderMap = new HashMap<>();

            while (resultSet.next()) {
                int orderId = resultSet.getInt("order_id");
                Order order = orderMap.computeIfAbsent(orderId, key -> {
                    Order newOrder = new Order();
                    newOrder.setId(orderId);
                    try {
                        newOrder.setDateOrder(resultSet.getString("date_order"));
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }

                    newOrder.setProducts(new ArrayList<>());
                    return newOrder;
                });

                OrderProduct product = new OrderProduct();
                product.setQuantity(resultSet.getInt("quantity"));

                Product productDetails = new Product();
                productDetails.setId(resultSet.getInt("id_product"));
                productDetails.setId(resultSet.getInt("product_id"));
                productDetails.setTitle(resultSet.getString("product_title"));
                productDetails.setPrice(resultSet.getInt("product_price"));
                productDetails.setDescription(resultSet.getString("product_description"));
                productDetails.setCategory(Category.fromValue(resultSet.getString("product_category")));
                product.setProduct(productDetails);

                order.getProducts().add(product);
            }

            return new ArrayList<>(orderMap.values());
        });

        return orders.stream().map(OrderMapper::toEntity).toList();
    }

    public Integer createOrder(Integer userId) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("userId", userId);

        jdbcTemplate.update(createOrder, params);

        return jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", new MapSqlParameterSource(), Integer.class);
    }

    public void addOrUpdateOrderProducts(int orderId, OrderProduct orderProduct) {
        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("orderId", orderId)
                .addValue("productId", orderProduct.getProduct().getId())
                .addValue("quantity", orderProduct.getQuantity());

        try {
            jdbcTemplate.update(insertQuery, params);
        } catch (DuplicateKeyException e) {
            // Si une clé dupliquée est détectée, effectuer la mise à jour
            jdbcTemplate.update(updateQuery, params);
        }
    }

    public void removeUnusedOrderProducts(int orderId, List<Integer> productIds) {
      MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("orderId", orderId)
                .addValue("productIds", productIds);

        jdbcTemplate.update(deleteQuery, params);
    }

    public void updateOrderDate(int orderId, String date) {
        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("orderId", orderId)
                .addValue("date", date);

        jdbcTemplate.update(updateDateQuery, params);
    }
}