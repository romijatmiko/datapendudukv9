package com.romijatmiko.Studentproject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty(message = "Nama is required")
    @NotNull(message = "Nama can not be null!!")
    @Column(nullable = false, name = "nama")
    private String nama;

    @NotEmpty(message = "nik name is required")
    @NotNull(message = "nik can not be null!!")
    @Column(nullable = false, name = "nik")
    private String nik;

    @NotEmpty(message = "no_hp name is required")
    @NotNull(message = "no_hp can not be null!!")
    @Column(nullable = false, name = "no_hp")
    private String no_hp;

    @NotEmpty(message = "email is required")
    @Email
    @Column(nullable = false, name = "email", unique = true)
    private String email;

    @NotEmpty(message = "Pendidikan is required")
    @Column(nullable = false)
    private String pendidikan;

    @NotEmpty(message = "Alamat is required")
    @Column(nullable = false)
    private String alamat;
}


