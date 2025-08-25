package dev.subotinov.service;

import dev.subotinov.entity.location.Address;
import dev.subotinov.entity.location.City;
import dev.subotinov.entity.location.Country;


public interface LocationService {
    public void saveAddress(City city);
    public void saveCity(Country country);
    public Address getAddressById(int id);
    public Country getCountryById(int id);
    public City getCityIdByName(String city);
}
