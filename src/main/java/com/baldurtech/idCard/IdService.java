package com.baldurtech.idCard;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class IdService {
    IdRepository idRepository;
    
    @Autowired
    public IdService(IdRepository idRepository) {
        this.idRepository = idRepository;
    }
    
    public void save(IdCard idCard) {
        idRepository.save(idCard);
    }
    
    public IdCard getById(Long id) {
        return idRepository.getById(id);
    }
}