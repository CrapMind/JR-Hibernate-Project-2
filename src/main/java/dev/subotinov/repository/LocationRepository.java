package dev.subotinov.repository;

import dev.subotinov.config.JpaUtil;
import dev.subotinov.entity.location.Address;
import dev.subotinov.entity.location.City;
import dev.subotinov.entity.location.Country;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class LocationRepository {
    public void saveAddress(String address, String district, City city, String phone) {
        try (EntityManager em = JpaUtil.getEntityManager()) {
            em.getTransaction().begin();

            City settedCity = em.find(City.class, city.getId());
            Address newAddress = new Address();
            newAddress.setAddress(address);
            newAddress.setDistrict(district);
            newAddress.setCity(settedCity);
            newAddress.setPhone(phone);
            em.persist(newAddress);
            em.getTransaction().commit();
        }
    }
    public void saveCity(Country country, String cityName) {
        try (EntityManager em = JpaUtil.getEntityManager()) {
            em.getTransaction().begin();
            City city = new City();
            Country settedCountry = em.find(Country.class, country.getId());
            city.setCity(cityName);
            city.setCountry(settedCountry);
            em.persist(city);
            em.getTransaction().commit();
        }
    }
    public Address getAddressById(int id) {
        return JpaUtil.getEntityManager().find(Address.class, id);
    }
    public Country getCountryById(int id) {
        try (EntityManager em = JpaUtil.getEntityManager()) {
            return em.find(Country.class, id);
        }
    }
    public City getCityIdByName(String city) {
        try (EntityManager em = JpaUtil.getEntityManager()) {
            TypedQuery<City> query = em.createQuery("from City c where c.city like :city", City.class);
            query.setParameter("city", city);
            query.setMaxResults(1);
            return query.getSingleResult();
        }
    }
}
