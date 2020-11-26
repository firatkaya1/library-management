package com.kayafirat.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "publisher")
@AllArgsConstructor
@NoArgsConstructor
public class Publisher {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long publisherId;

    @NotNull
    @Column
    private String publisherName;

    @NotNull
    @Column
    private String publisherInfo;

    @JsonIgnoreProperties("book")
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "publisher",orphanRemoval = true)
    private Set<Book> book = new HashSet<>();



}
