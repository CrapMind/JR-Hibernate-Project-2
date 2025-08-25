package dev.subotinov.entity.base;
import jakarta.persistence.*;
import lombok.Data;

import java.time.OffsetDateTime;
@MappedSuperclass
public class BaseEntity {

    @Column (name = "last_update")
    private OffsetDateTime lastUpdate = OffsetDateTime.now();

    @PreUpdate
    protected void onUpdate() {
        this.lastUpdate = OffsetDateTime.now();
    }
}
