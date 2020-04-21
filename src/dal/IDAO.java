package dal;

import java.util.Collection;

public interface IDAO<ID, T> {
	
	void create(T object);
	void update(T object);
	void deleteById(ID id);
	void delete(T object);
	T findById(ID id);
	Collection<T> findAll();
}
