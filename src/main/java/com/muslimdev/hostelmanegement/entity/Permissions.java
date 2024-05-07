package com.muslimdev.hostelmanegement.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Permissions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long permissionId;
    @ManyToOne
    @JoinColumn(name="perRoleId", nullable=false)
    private Role permissionRoleId;
    private String permissionTitle;
    private String permissionModule;
    private String permissionDescription;

    
}
