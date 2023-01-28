# Sandbox for Hibernate ORM

Until I containerize, `build.sql` script can be run to initialize MySQL database.  

Using JPA interface with Hibernate implementation (although I use a hibernate-specific implementation in my app runner, but this can be ignored).  

`META-INF/persistence.xml` contains JPA configuration properties. Exposed username and password are from the build script `build.sql`.  

The configuration is registered in `JpaConfig.java` using `Persistence` static method, along with the transaction manager. This along with 
`@EnableJpaRepositories` annotation is my configuration for Spring Data JPA.  

- 🤕 : Some inner beans registered by Spring Data JPA depend on your `EntityManagerFactory` and `PlatformTransactionManager` beans and call them 
using the methods `entityManagerFactory()` and `platformTransactionManager()`. If you used different method names when registering these beans, you 
will get an error.  

The integration tests use a separate `ecommerceTest` database with a `ecommercetestadmin` user. The test initialize script is `test-init.sql`.  

- 🤕 : I needed to register my logging aspect in the servletContext and after the WebMvc configuration for my joinpoints to work.  


