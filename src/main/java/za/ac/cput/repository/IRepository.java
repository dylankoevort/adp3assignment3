package za.ac.cput.repository;

/**
 *
 * IRepository.java
 * Generic Repository Interface
 * @author Dylan Koevort 218088159
 * 19 July 2021
 *
 */

@Deprecated
public interface IRepository<T, ID> {
    public T create(T t);
    public T read(ID id);
    public T update(T t);
    public boolean delete(ID id);
}
