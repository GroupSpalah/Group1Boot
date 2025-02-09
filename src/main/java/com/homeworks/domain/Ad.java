package com.homeworks.domain;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
//@FieldDefaults(level = AccessLevel.PRIVATE)
//@Data//изучить. Возможно использовать альтернативные аннотации
//@SuperBuilder
@Builder
@Accessors(chain = true)
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")

public class Ad {

    @Id
    @Column(name = "ad_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    int id;

    String name;

    @Column(name = "publication_date")
    LocalDate publicationDate;

    String content;

    BigDecimal price;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "FK_Ad_Heading")
    Heading heading;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "FK_Ad_Author")
    Author author;

    @Column(name = "is_active")
    boolean isActive;

    @Version
    int version;

/*    public int getId() {
        return id;
    }*/
}
