package my.bsuir.repository;

import my.bsuir.model.OrderEntity;
import my.bsuir.model.PaymentEntity;

import java.util.List;

public interface PaymentEntityDao {

    void create(PaymentEntity payment);

    List<PaymentEntity> readAll();

    void update(PaymentEntity payment);

    void delete(PaymentEntity payment);

}
