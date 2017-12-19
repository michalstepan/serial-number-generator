package com.stepan.serialnumbergenerator;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.PersistenceContext;

@Service
public class SerialNumberService {

    @PersistenceContext
    private EntityManager em;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public String generateNextItem(int year, String sellPlace) {
        SerialNumberLoader serialNumberLoader = em.find(SerialNumberLoader.class,
                new SerialNumberId(year, sellPlace),
                LockModeType.PESSIMISTIC_WRITE);
        if (serialNumberLoader == null){
            serialNumberLoader = SerialNumberLoader.generateNew(year, sellPlace);
            em.persist(serialNumberLoader);
        }

        return serialNumberLoader.generateNext();
    }
}
