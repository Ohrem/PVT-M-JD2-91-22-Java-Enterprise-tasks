package ohremchuk.jdbc.task7.dao;

import java.util.List;
import java.util.Optional;

public interface BaseDao<T> {
    List<T> findAll();
    Optional<T> findById(Integer id);
    T save(T t);
    boolean delete(int id);

}
