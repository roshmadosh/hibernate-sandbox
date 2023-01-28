package link.hiroshisprojects.hibernate.config;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = { "link.hiroshisprojects.hibernate.models" })
public class JpaConfig {

	@Bean
	public EntityManagerFactory entityManagerFactory() {
		return Persistence.createEntityManagerFactory("MyPersistenceUnit");
	}


	@Bean
	public PlatformTransactionManager transactionManager() {
		 return new JpaTransactionManager(entityManagerFactory());
	}


}
