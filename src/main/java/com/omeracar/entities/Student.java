package com.omeracar.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "student")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "first_name" , nullable = false )
    private String firstName;

    @Column(name = "last_name" , nullable = false)
    private String lastName;

	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "birth_date" ,nullable = true)
    private Date birthOfDate;

}
