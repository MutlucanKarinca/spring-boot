package com.mutlucankarinca.springbootcamp.entity;

import com.mutlucankarinca.springbootcamp.enums.EnumStatus;
import com.mutlucankarinca.springbootcamp.general.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "CUSTOMER")
@Getter
@Setter
public class Customer extends BaseEntity{

    @Id
    @GeneratedValue(generator = "Customer")
    @SequenceGenerator(name ="Customer" ,sequenceName = "CUSTOMER_ID_SEQ")
    private Long id;

    @Column(name = "NAME",length = 100,nullable = false)
    private String name;

    @Column(name = "SURNAME",length = 100,nullable = false)
    private String surname;

    @NotBlank
    @Column(name = "USERNAME",length = 50,nullable = false)
    private String username;

    @NotNull
    @Column(name = "PASSWORD",length = 400,nullable = false)
    private String password;

    @Email
    @Column(name = "EMAIL",length = 50)
    private String email;

    //@Column(name = "BIRTH_DATE")
    //@Temporal(TemporalType.DATE)
    //private Date birthDate;

    @Column(name = "BIRTH_DATE")
    private LocalDate birthDate;

    @Column(name = "STATUS",length = 30)
    @Enumerated(EnumType.STRING)
    private EnumStatus status;


}
