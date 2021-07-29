package za.ac.cput.service;

/**
 *
 * IService.java
 * Generic Service Interface
 * @author Dylan Koevort 218088159
 * 27 July 2021
 *
 */

public interface IService <T, ID> {
    T create(T t);
    T read(ID id);
    T update(T t);
    boolean delete(ID id);
}
