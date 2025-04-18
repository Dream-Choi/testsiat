package com.siat.testsiat.valid.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.siat.testsiat.valid.domain.entity.TodoEntity;

/*
 JPA 지원하는 Repository인터페이스
    - JpaRepository<T, K>
    - CrudRepository
    - PagingAndSortingRepository
    - QueryByExampleExecutor
    - QueryByExample
    - SimpleJpaRepository
    - JpaSpecificationExecutor
    - EntityGraph
    - EntityManagerFactory
    - EntityManager
    - EntityTransaction
    - Repository
 */

@Repository
public interface ValidDao extends JpaRepository<TodoEntity, Integer> {
    

    
}
