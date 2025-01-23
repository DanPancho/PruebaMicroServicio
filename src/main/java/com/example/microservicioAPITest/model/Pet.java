package com.example.microservicioAPITest.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "pet")
@Getter
@Setter
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)  //(1 pet -> n category) 1 - n
    private Category category;

    @Column(name = "name")
    private String name;

    @Column(name = "photo_urls")
    private List<String> photoUrls;

    @ManyToMany  //(n pet -> n tag) n - n
    @JoinTable(
        name = "pet_tag",
        joinColumns = @JoinColumn(name = "pet_id"),
        inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private List<Tag> tags;

    @Column(name = "status")
    private String status;

}
