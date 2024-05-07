package com.muslimdev.hostelmanegement.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Getter
@Setter
@SQLDelete(sql = "Update Allotees SET deleted = true WHERE allotees_id = ?")
@Where(clause = "deleted = false")
public class Allotees {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long allotees_id;
    private String alloteeName;
    private String alloteeMobile;
    private String alloteeEmail;
    private String alloteeAdress;
    private String alloteeUserName;
    private String alloteePassword;
    private Boolean deleted = Boolean.FALSE;

}
