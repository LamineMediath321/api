package com.lamine.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data /* Annotation de lombok implemente les getters et setters */
@Entity /* Indique que la classe correspond à une table de la bd */
@Table(name = "employees")
public class Employee {

    @Id /** L’attribut id correspond à la clé primaire de la table */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private String mail;

    private String password;

}
