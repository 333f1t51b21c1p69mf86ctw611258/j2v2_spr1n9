package my.henrik.paging.service;

import my.henrik.paging.domain.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PersonService {

	/**
	 * Finds a "page" of persons
	 * 
	 * @param pageable
	 * @return {@link Page} instance
	 */
	Page<Person> findAllPageable(Pageable pageable);

	/**
	 * Saves collection of persons
	 * 
	 * @param persons
	 * 
	 * @return collection of persons
	 */
	Iterable<Person> save(Iterable<Person> persons);

}
