package dev.prmts.common.model.entity;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "contact_person")
@Data
public class ContactPerson {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    private String email;
    @Column(name = "is_deleted")
    private boolean deleted;
}
