package dev.subotinov.entity.base;
import jakarta.persistence.*;

import java.time.OffsetDateTime;
@MappedSuperclass
public class BaseEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column (name = "last_update", nullable = false)
    private OffsetDateTime lastUpdate;

    @PreUpdate
    protected void onUpdate() {
        this.lastUpdate = OffsetDateTime.now();
    }
}
