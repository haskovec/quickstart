package org.jboss.narayana.quickstarts.springboot.jpa.domain.repository;

import org.jboss.narayana.quickstarts.springboot.jpa.domain.entity.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Id;

/**
 * Created by jhaskovec on 4/13/16.
 */
@Repository
public interface ExampleRepository extends JpaRepository<Example, Integer> {

}
