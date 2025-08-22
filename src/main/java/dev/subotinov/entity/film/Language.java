package dev.subotinov.entity.film;

import dev.subotinov.entity.base.BaseEntity;
import jakarta.persistence.*;

@Entity
@Table (schema = "movie")
public class Language extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "language_id")
    private Byte id;
    @Column (length = 20, columnDefinition = "char")
    private String name;
}
