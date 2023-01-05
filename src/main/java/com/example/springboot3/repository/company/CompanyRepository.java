package com.example.springboot3.repository.company;

import com.example.springboot3.entity.company.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

/**
 * @BelongsProject: springboot3
 * @BelongsPackage: com.example.springboot3.repository.company
 * @Author: vergil young
 * @CreateTime: 2023-01-05  19:20
 * @Description: TODO
 */
public interface CompanyRepository extends JpaRepository<Company, Integer> {
}
