package com.gauav.CampusPlus.repository;

import com.gauav.CampusPlus.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

 public interface DepartmentRepository extends JpaRepository<Department,Long> {

  boolean existsById(String name);
  boolean existsByNameAndIdNot(String name , Long id);



}
