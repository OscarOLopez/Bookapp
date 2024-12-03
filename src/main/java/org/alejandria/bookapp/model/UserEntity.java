package org.alejandria.bookapp.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_User")

    private Long idUser;

    @Column(name = "first_Name",length = 45,nullable = false)

    private String firstName;

    @Column(name = "last_Name",length = 45,nullable = false)

    private String lastName;

    @Column(name = "last_Name2",length = 45)

    private String lastName2;

    @Column(name = "email",length = 100,nullable = false,unique = true)

    private String email;

    @Column(name = "password",length = 100,nullable = false)
    private String password;

    @Column(name = "telephone",length = 15)
    private String telephone;

    @OneToMany(mappedBy = "user")
    private List<OrderEntity> orders;



}
