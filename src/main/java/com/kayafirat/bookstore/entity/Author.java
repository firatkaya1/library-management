package com.kayafirat.bookstore.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@Entity
@Table(name = "author")
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long authorId;

    @NotNull
    @Column
    private String authorName;

    @NotNull
    @Column
    private String authorInfo;

    @JsonIgnoreProperties("book")
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "author",orphanRemoval = true)
    private Set<Book> book = new HashSet<>();


}
