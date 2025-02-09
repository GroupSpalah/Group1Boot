package com.homeworks.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
//@FieldDefaults(level = AccessLevel.PRIVATE)
//@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "phones")
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")

public class Author {

    @Id
    @Column(name = "author_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "first_name")
    String firstName;

    @Column(name = "last_name")
    String lastName;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})

    @JoinColumn(name = "FK_Phone_Author")//для исключения конфликта (уже указано в Phone)
    //@EqualsAndHashCode.Exclude
    @JsonManagedReference
    Set<Phone> phones;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE}, mappedBy = "author")
    //@EqualsAndHashCode.Exclude
    @JsonManagedReference
    Address address;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    @JoinColumn(name = "FK_Author_Entity_Email") //было FK_Author_Email
    Email email;

    @Version
    int version;
}
