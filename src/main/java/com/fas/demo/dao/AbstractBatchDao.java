package com.fas.demo.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public abstract class AbstractBatchDao<T> implements BatchDao {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @PersistenceContext
    protected EntityManager em;

    @Transactional
    public void batchInsert(List list) {
        try {
            for (int i = 0; i < list.size(); i++) {
                em.persist(list.get(i));
                if (i % 100 == 0) {//一次一百条插入
                    em.flush();
                    em.clear();
                }
            }
            logger.info("save to DB success,list is {}", list.toString());
        } catch (Exception e) {
            logger.error("batch insert data failuer.");
            e.printStackTrace();
        }
    }

    @Transactional
    public void batchUpdate(List list) {
        try {
            for (int i = 0; i < list.size(); i++) {
                em.merge(list.get(i));
                if (i % 100 == 0) {
                    em.flush();
                    em.clear();
                }
            }
            logger.info("update data success,list is {}", list.toString());
        } catch (Exception e) {
            logger.error("batch update data failuer.");
            e.printStackTrace();
        }
    }

}
