package dev.subotinov.entity;

import dev.subotinov.entity.base.BaseEntity;
import dev.subotinov.entity.location.Address;
import jakarta.persistence.*;

@Entity
@Table (schema = "movie")
public class Staff extends BaseEntity {
    @Column (name = "first_name", length = 45)
    private String firstName;
    @Column (name = "last_name", length = 45)
    private String lastName;
    @OneToOne (fetch = FetchType.LAZY, optional = false)
    @JoinColumn (name = "address_id")
    private Address address;
    @Lob
    @Column
    private byte[] picture;
    @Column (length = 50)
    private String email;
    @OneToOne(mappedBy = "manager", fetch = FetchType.LAZY)
    @JoinColumn (name = "store_id")
    private Store store;
    @Column
    private boolean active = true;
    @Column (length = 16)
    private String username;
    @Column (length = 40)
    private String password;
}
