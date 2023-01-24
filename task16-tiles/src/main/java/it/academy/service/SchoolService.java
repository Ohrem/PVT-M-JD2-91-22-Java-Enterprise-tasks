package it.academy.service;

import it.academy.dao.SchoolDao;
import it.academy.model.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SchoolService {
        @Autowired
        private SchoolDao schoolDao;

        @Transactional
        public void create(School school) {
            schoolDao.create(school);
        }
        @Transactional
        public School getSchoolById(Integer id){

            return schoolDao.getSchoolById(id);
        }
        @Transactional
        public void delete(Integer id){
            schoolDao.delete(id);
        }

    }

