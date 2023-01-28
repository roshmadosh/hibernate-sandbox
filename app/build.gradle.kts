plugins {
    // Apply the application plugin to add support for building a CLI application in Java.
    application
	war
}

repositories {
    // Use Maven Central for resolving dependencies.
    mavenCentral()
}

dependencies {
	val springVersion = "5.3.24"
    // Use JUnit Jupiter for testing.
    testImplementation("org.junit.jupiter:junit-jupiter:5.9.1")
	testImplementation("org.mockito:mockito-junit-jupiter:4.6.1")
	testImplementation("org.springframework:spring-test:$springVersion")

	// for hibernate and entitymanager
	implementation("org.hibernate:hibernate-core:5.4.1.Final")


	implementation("mysql:mysql-connector-java:8.0.31")

	// logging
	implementation("org.slf4j:slf4j-api:2.0.6")
	implementation("ch.qos.logback:logback-classic:1.4.5")

	implementation("org.aspectj:aspectjweaver:1.9.7")

	// spring mvc
	implementation("javax.servlet:javax.servlet-api:4.0.1")
	implementation("org.springframework:spring-webmvc:$springVersion")
	implementation("org.springframework:spring-orm:$springVersion")

	// jackson
	implementation("com.fasterxml.jackson.core:jackson-core:2.13.3")
	implementation("com.fasterxml.jackson.core:jackson-databind:2.13.3")
	implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.13.3")
	// spring data jpa
	implementation("org.springframework.data:spring-data-jpa:2.7.6")

}

application {
    // Define the main class for the application.
    mainClass.set("link.hiroshisprojects.hibernate.App")
}

tasks.named<Test>("test") {
    // Use JUnit Platform for unit tests.
    useJUnitPlatform()
}
tasks.war {
	archiveFileName.set("hibernate.war")
}
tasks.withType<Test> {
    this.testLogging {
        this.showStandardStreams = true
    }
}
