package com.muslimdev.hostelmanegement.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.util.Date;

@Entity
@Getter
@Setter
@SQLDelete(sql = "Update Users SET deleted = true WHERE id = ?")
@Where(clause = "deleted = false")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    private Long id;
    @ManyToOne
    @JoinColumn(nullable=false)
    private Role userRoleId;
    private String userName;
    private String userEmail;
    private Date userDob;
    private String userAdress;
    private Boolean deleted = Boolean.FALSE;

}
