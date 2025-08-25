package dev.subotinov.entity.base;
import jakarta.persistence.*;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.LocalDateTime;

@MappedSuperclass
public class BaseEntity {

    @Column (name = "last_update")
    @UpdateTimestamp
    private LocalDateTime lastUpdate;
/*
    @PreUpdate
    protected void onUpdate() {
        this.lastUpdate = LocalDateTime.now();
    }*/
}
