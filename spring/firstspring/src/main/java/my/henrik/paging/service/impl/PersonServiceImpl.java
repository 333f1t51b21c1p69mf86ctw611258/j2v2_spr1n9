package my.henrik.paging.service.impl;

import my.henrik.paging.domain.Person;
import my.henrik.paging.repository.PersonRepository;
import my.henrik.paging.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonServiceImpl implements PersonService {

	private PersonRepository personRepository;

	@Autowired
	public PersonServiceImpl(PersonRepository personRepository) {

		this.personRepository = personRepository;
	}

	@Transactional
	@Override
	public Page<Person> findAllPageable(Pageable pageable) {

		return personRepository.findAll(pageable);
	}

	@Transactional
	@Override
	public Iterable<Person> save(Iterable<Person> persons) {
		return personRepository.save(persons);
	}

}
