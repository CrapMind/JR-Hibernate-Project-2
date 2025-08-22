package dev.subotinov.service.imlp;
import dev.subotinov.entity.location.Address;
import dev.subotinov.entity.location.City;
import dev.subotinov.entity.location.Country;
import dev.subotinov.repository.LocationRepository;
import dev.subotinov.service.LocationService;

public class LocationServiceImpl implements LocationService {

    private final LocationRepository locationRepository = new LocationRepository();

    @Override
    public void saveAddress(String address, String district, City city, String phone) {
        locationRepository.saveAddress(address, district, city, phone);
    }

    @Override
    public void saveCity(Country country, String cityName) {
        locationRepository.saveCity(country, cityName);
    }

    @Override
    public Address getAddressById(int id) {
        return locationRepository.getAddressById(id);
    }

    @Override
    public Country getCountryById(int id) {
        return locationRepository.getCountryById(id);
    }

    @Override
    public City getCityIdByName(String city) {
        return locationRepository.getCityIdByName(city);
    }
}
