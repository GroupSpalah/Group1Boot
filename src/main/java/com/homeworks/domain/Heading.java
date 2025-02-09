package com.homeworks.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;

@Entity
//@FieldDefaults(level = AccessLevel.PRIVATE)
//@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")

public class Heading {

    @Id
    @Column(name = "heading_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String name;

    @Version
    int version;
}
