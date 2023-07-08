package com.codegym.ClimaxStoreSpring.entity.user;

import com.fasterxml.jackson.databind.DatabindException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "user_name", nullable = false, unique = true)
    private String userName;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "phone_number", nullable = false, unique = true)
    private String phoneNumber;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "is_deleted")
    private Boolean isDeleted;

    @Column(name = "created_date")
    private Date createdDate;

    @ManyToOne(targetEntity = Role.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id", referencedColumnName = "role_id")
    private Role role;

    @OneToOne(targetEntity = UserDetail.class, fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "userDetail")
    @JoinColumn(name = "user_detail_id", referencedColumnName = "user_detail_id")
    private UserDetail userDetail;

    @OneToOne(targetEntity = Address.class, fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "address")
    @JoinColumn(name = "address_id", referencedColumnName = "address_id")
    private Address address;
}
