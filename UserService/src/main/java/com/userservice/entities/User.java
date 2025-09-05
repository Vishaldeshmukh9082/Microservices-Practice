package com.userservice.entities;

import java.util.List;

import org.springframework.web.bind.annotation.BindParam;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="usertable")
public class User {

    @Id
    @Column(name = "id")
    private String uId;
    private String name;
    private String email;

    @Transient
    private List<Rating> ratings;

}
