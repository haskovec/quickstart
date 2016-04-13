package org.jboss.narayana.quickstarts.springboot.jpa.service;

import org.jboss.narayana.quickstarts.springboot.jpa.domain.entity.Example;
import org.jboss.narayana.quickstarts.springboot.jpa.domain.repository.ExampleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by jhaskovec on 4/13/16.
 */
@Service
@Transactional
public class ExampleService {
	private static final Logger log = LoggerFactory.getLogger(ExampleService.class);

	private final ExampleRepository exampleRepository;

	@Autowired
	public ExampleService(final ExampleRepository exampleRepository) {
		this.exampleRepository = exampleRepository;
	}

	public void testCommit() throws Exception {
		try {
			log.info("testCommit");

			final Example example = new Example();
			example.setId(1);
			example.setName("Test 1");
			exampleRepository.save(example);

			log.info("testCommit OK");
		} catch (Exception e) {
			log.error("testCommit FAIL with " + e);
			throw e;
		}
	}


	public void testRollback() {
		log.info("test rollback");

		final Example example2 = new Example();
		example2.setId(2);
		example2.setName("Test 2");
		exampleRepository.save(example2);

		throw new RuntimeException("Throw exception in method to see if we rolled back the insert");
	}
}
