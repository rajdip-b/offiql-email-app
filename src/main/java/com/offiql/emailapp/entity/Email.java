package com.offiql.emailapp.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "emails")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Email {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fromEmail;
    private String toEmail;
    private String subject;
    private String body;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Email email = (Email) o;
        return id != null && Objects.equals(id, email.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

}
