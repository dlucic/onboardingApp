package com.davorin.onboarding.config;

import com.zaxxer.hikari.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.web.client.RestTemplate;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfig {

    @Value("${spring.datasource.url}")
    private String dbUrl;

    private static final Logger logger = LoggerFactory.getLogger(DatabaseConfig.class);

//    @Bean
//    public DataSource h2DataSource() {
//        logger.info("Initializing H2 datasource");
//        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
//        EmbeddedDatabase db = builder
//                .setType(EmbeddedDatabaseType.H2) //.H2 or .DERBY
//                .addScript("schema.sql")
//                .addScript("data.sql")
//                .build();
//        return db;
//    }

    @Bean
    public DataSource postgresDataSource() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(dbUrl);
        return new HikariDataSource(config);
    }

    @Bean
    public JdbcTemplate jdbcTemplate(){ return new JdbcTemplate(this.postgresDataSource()); }
}