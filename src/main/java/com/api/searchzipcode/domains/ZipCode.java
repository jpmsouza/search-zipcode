package com.api.searchzipcode.domains;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "ZIP_CODE")
public class ZipCode {

    @Id
    @Column(name = "NUM_POSTAL_CODE")
    private Integer postalCode;

    @Column(name = "STR_STREET")
    private String street;

    @Column(name = "STR_CITY")
    private String city;

    @Column(name = "STR_STATE")
    private String state;

    @Column(name = "STR_NEIGHBORHOOD")
    private String neighborhood;

    @Column(name = "STR_IBGECODE")
    private Integer ibgeCode;
}
