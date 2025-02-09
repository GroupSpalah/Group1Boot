package com.homeworks.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.*;

@Entity
//@FieldDefaults(level = AccessLevel.PRIVATE)
//@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(exclude = "author")
@DiscriminatorValue(value = "address")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")

public class Address extends AbstractEntity {//изменить на другой тип базы(видео 92) адрес и емейл - общее поле id, остальное оставить как было.

/*    @Id
    @Column(name = "address_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;*/ //закомментил для использования strategy @Inheritance(strategy = InheritanceType.SINGLE_TABLE)

    String district;

    String city;

    String street;

    @OneToOne
    @JoinColumn(name = "FK_Address_Author")
    //@EqualsAndHashCode.Exclude
    @JsonBackReference
    Author author;
}