package org.jboss.narayana.quickstarts.springboot.jpa;

import org.jboss.narayana.quickstarts.springboot.jpa.domain.entity.Example;
import org.jboss.narayana.quickstarts.springboot.jpa.domain.repository.ExampleRepository;
import org.jboss.narayana.quickstarts.springboot.jpa.service.ExampleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringBootJpaTestApplication.class)
public class SpringBootJpaTestApplicationTests {
	@Autowired
	private ExampleService exampleService;

	@Autowired
	private ExampleRepository exampleRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testCommit() throws Exception {
		exampleService.testCommit();

		final Example example = exampleRepository.findOne(1);
		assertNotNull(example);
	}

	@Test
	public void testRollback() {
		try {
			exampleService.testRollback();
		} catch (RuntimeException e) {
			//This is expected
		}

		final Example example = exampleRepository.findOne(2);
		assertNull(example);
	}
}
