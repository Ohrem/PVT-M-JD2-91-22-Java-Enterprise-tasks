package my.bsuir.repository;

import my.bsuir.model.OrderEntity;

import java.util.List;

public interface OrderEntityDao {

    void create(OrderEntity order);

    List<OrderEntity> readAll();

    void update(OrderEntity order);

    void delete(OrderEntity order);
}
