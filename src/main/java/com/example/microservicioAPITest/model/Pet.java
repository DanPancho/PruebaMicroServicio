package com.example.microservicioAPITest.model;

import java.util.List;

import com.example.microservicioAPITest.enums.PetStatusType;

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
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "pet_table")
@Getter
@Setter
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)  //(1 pet -> n category) 1 - n
    @NotNull(message = "Category is required")
    private Category category;

    @Column(name = "name")
    @NotBlank(message = "Name cannot be blank")
    private String name;

    @Column(name = "photo_urls")
    @NotNull(message = "Photo URLs cannot be null")
    private List<String> photoUrls;

    @ManyToMany  //(n pet -> n tag) n - n
    @JoinTable(
        name = "pet_tag",
        joinColumns = @JoinColumn(name = "pet_id"),
        inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private List<Tag> tags;

    @Column(name = "status")
    @NotNull(message = "Status cannot be blank")
    private PetStatusType status;

}
