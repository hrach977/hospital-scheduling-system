package com.hospital.config;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.hospital.repositories") //add this package along with the repos
public class Configuration {
}
