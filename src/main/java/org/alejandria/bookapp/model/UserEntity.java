package org.alejandria.bookapp.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "users")
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

    public UserEntity(Long id_user, String firstName, String lastName, String lastName2, String email, String telephone, String password) {
        this.idUser = id_user;
        this.firstName = firstName;
        this.lastName = lastName;
        this.lastName2 = lastName2;
        this.email = email;
        this.telephone = telephone;
        this.password = password;

    }


    public UserEntity() {

    }

    public String getLastName2() {
        return lastName2;
    }

    public void setLastName2(String lastName2) {
        this.lastName2 = lastName2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long id_user) {
        this.idUser = id_user;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id_user=" + idUser +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", lastName2='" + lastName2 + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", telephone='" + telephone + '\'' +
                '}';
    }
}
