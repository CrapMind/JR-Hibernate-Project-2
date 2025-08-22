package dev.subotinov.service;
import dev.subotinov.entity.store.Staff;
import dev.subotinov.entity.store.Store;

public interface StaffService {
    Staff getManagerById(int id);
    void saveManager(Store store);
}
