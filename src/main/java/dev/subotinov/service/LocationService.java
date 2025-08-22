package dev.subotinov.service;

import dev.subotinov.entity.location.Address;
import dev.subotinov.entity.location.City;
import dev.subotinov.entity.location.Country;


public interface LocationService {
    public void saveAddress(String address, String district, City city, String phone);
    public void saveCity(Country country, String cityName);
    public Address getAddressById(int id);
    public Country getCountryById(int id);
    public City getCityIdByName(String city);
}
