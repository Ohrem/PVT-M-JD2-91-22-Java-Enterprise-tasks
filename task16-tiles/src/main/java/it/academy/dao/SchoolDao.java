package it.academy.dao;
import it.academy.model.School;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolDao {


        void create(School school);

        School getSchoolById(Integer id);

        void delete(Integer id);
    }

