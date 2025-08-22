package dev.subotinov.service.imlp;
import dev.subotinov.entity.store.Staff;
import dev.subotinov.entity.store.Store;
import dev.subotinov.repository.StaffRepository;
import dev.subotinov.service.StaffService;

public class StaffServiceImpl implements StaffService {

    private final StaffRepository staffRepository = new StaffRepository();

    @Override
    public Staff getManagerById(int id) {
        return staffRepository.getManagerById(id);
    }

    @Override
    public void saveManager(Store store) {
        staffRepository.saveManager(store);
    }
}
