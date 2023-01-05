package com.example.springboot3.entity.employee;

import jakarta.persistence.*;

/**
 * @BelongsProject: springboot3
 * @BelongsPackage: com.example.springboot3.entity.employee
 * @Author: vergil young
 * @CreateTime: 2023-01-05  19:18
 * @Description: TODO
 */
@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
