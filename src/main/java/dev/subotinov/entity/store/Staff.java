package dev.subotinov.entity.store;

import dev.subotinov.entity.base.BaseEntity;
import dev.subotinov.entity.location.Address;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table (schema = "movie")
@Getter @Setter
public class Staff extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "staff_id")
    private Byte id;
    @Column (name = "first_name", length = 45)
    private String firstName;
    @Column (name = "last_name", length = 45)
    private String lastName;
    @OneToOne (fetch = FetchType.LAZY, optional = false)
    @JoinColumn (name = "address_id")
    private Address address;
    @Lob
    @Column (columnDefinition = "BLOB")
    private byte[] picture;
    @Column (length = 50)
    private String email;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn (name = "store_id", nullable = false)
    private Store store;
    @Column (name = "active", columnDefinition = "BIT")
    private Boolean isActive;
    @Column (length = 16, nullable = false)
    private String username;
    @Column (length = 40, nullable = false)
    private String password;

    public Staff() {}
    public Staff(String firstName, String lastName, Address address, String email, String username, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.username = username;
        this.password = password;
    }

}
