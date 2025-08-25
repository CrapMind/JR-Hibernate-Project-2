package dev.subotinov.entity;

import dev.subotinov.entity.base.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table (schema = "movie")
public class Language extends BaseEntity {
    @Column (length = 20)
    private String name;
}
