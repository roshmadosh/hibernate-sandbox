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
    // Use JUnit Jupiter for testing.
    testImplementation("org.junit.jupiter:junit-jupiter:5.9.1")

	implementation("org.hibernate:hibernate-core:5.4.1.Final")

	implementation("mysql:mysql-connector-java:8.0.31")

	implementation("org.slf4j:slf4j-api:2.0.6")
	implementation("ch.qos.logback:logback-classic:1.4.5")

}

application {
    // Define the main class for the application.
    mainClass.set("link.hiroshisprojects.hibernate.App")
}

tasks.named<Test>("test") {
    // Use JUnit Platform for unit tests.
    useJUnitPlatform()
}
