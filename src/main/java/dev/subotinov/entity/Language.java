package dev.subotinov.entity;

import dev.subotinov.entity.base.BaseEntity;
import jakarta.persistence.*;

@Entity
@Table (schema = "movie")
public class Language extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "language_id")
    private Byte id;
    @Column (length = 20)
    private String name;
}
