package com.santhosh.hibernate.dao;

import java.io.Serializable;

import org.springframework.transaction.annotation.Transactional;
@Transactional
public interface GenericDao <T, PK extends Serializable> {

    /** Persist the newInstance object into database */
    PK create(T newInstance);

    /** Retrieve an object that was previously persisted to the database using
     *   the indicated id as primary key
     */
    T read(PK id);

    /** Save changes made to a persistent object.  */
    void update(T transientObject);

    /** Remove an object from persistent storage in the database */
    void delete(T persistentObject);
    
    void merge(T detachedObject);
}
