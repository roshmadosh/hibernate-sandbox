package link.hiroshisprojects.hibernate;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories
public class JpaConfig {
	private static final Logger LOGGER = LoggerFactory.getLogger(JpaConfig.class);

	@Bean
	public EntityManagerFactory entityManagerFactory() {
		return Persistence.createEntityManagerFactory("MyPersistenceUnit");
	}


	@Bean
	public PlatformTransactionManager transactionManager() {
		 return new JpaTransactionManager(entityManagerFactory());
	}


}
