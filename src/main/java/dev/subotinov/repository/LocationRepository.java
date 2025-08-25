package dev.subotinov.repository;

import dev.subotinov.config.JpaUtil;
import dev.subotinov.entity.location.Address;
import dev.subotinov.entity.location.City;
import dev.subotinov.entity.location.Country;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class LocationRepository {
    public void saveAddress(City city) {
        try (EntityManager em = JpaUtil.getEntityManager()) {
            em.getTransaction().begin();
            Address address = new Address();
            address.setCity(city);
            em.persist(address);
            em.getTransaction().commit();
        }
    }
    public void saveCity(Country country) {
        try (EntityManager em = JpaUtil.getEntityManager()) {
            em.getTransaction().begin();
            City city = new City();
            city.setCountry(country);
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
