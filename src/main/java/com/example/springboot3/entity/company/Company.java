package com.example.springboot3.entity.company;


import jakarta.persistence.*;

/**
 * @BelongsProject: springboot3
 * @BelongsPackage: com.example.springboot3.entity.company
 * @Author: vergil young
 * @CreateTime: 2023-01-05  19:16
 * @Description: TODO
 */
@Entity
@Table(name = "company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, unique = true)
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
