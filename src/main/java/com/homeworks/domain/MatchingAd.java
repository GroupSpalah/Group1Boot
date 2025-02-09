package com.homeworks.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
//@FieldDefaults(level = AccessLevel.PRIVATE)
//@Data//изучить
//@SuperBuilder

@Builder
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Matching_ad")//поменять в запросе
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")

public class MatchingAd {

    @Id
    @Column(name = "mad_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @ManyToOne
    @JoinColumn(name = "FK_Mad_Author")
    Author author;

    @ManyToOne
    @JoinColumn(name = "FK_Mad_Heading")
    Heading heading;

    @Column(name = "price_from")
    BigDecimal priceFrom;

    @Column(name = "price_to")
    BigDecimal priceTo;

    String subject;

    @Version
    int version;
}
