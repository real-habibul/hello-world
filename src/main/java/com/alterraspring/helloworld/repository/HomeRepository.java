package com.alterraspring.helloworld.repository;

import com.alterraspring.helloworld.entity.Home;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HomeRepository extends JpaRepository<Home, Long> {

}
