package com.baldurtech.idCard;

import javax.persistence.*;
import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class IdRepository {
    @PersistenceContext
    EntityManager entityManager;
    
    public void save(IdCard idCard) {
        entityManager.persist(idCard);
    }
    
    public IdCard getById(Long id) {
        return entityManager.createNamedQuery(IdCard.GET_BY_ID, IdCard.class).setParameter("id", id).getSingleResult();
    }

    
}