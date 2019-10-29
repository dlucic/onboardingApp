package com.davorin.onboarding.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.SSLContext;
import javax.sql.DataSource;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

@Configuration
public class BeanConfig {

    @Value("${spring.datasource.url}")
    private String dbUrl;

    private static final Logger logger = LoggerFactory.getLogger(BeanConfig.class);

    @Bean
    public DataSource h2DataSource() {
        logger.info("Initializing H2 datasource");
        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
        EmbeddedDatabase db = builder
                .setType(EmbeddedDatabaseType.H2) //.H2 or .DERBY
                .addScript("schema.sql")
                .addScript("data.sql")
                .build();
        return db;
    }

//    @Bean
//    public DataSource postgresDataSource() {
//        HikariConfig config = new HikariConfig();
//        config.setJdbcUrl(dbUrl);
//        return new HikariDataSource(config);
//    }

    @Bean
    public JdbcTemplate jdbcTemplate(){ return new JdbcTemplate(this.h2DataSource()); }

//    @Bean
//    public RestTemplate restTemplate() throws NoSuchAlgorithmException, KeyManagementException {
//        SSLContext context = null;
//        context = SSLContext.getInstance("TLSv1.2");
//        context.init(null, null, null);
//        CloseableHttpClient httpClient = HttpClientBuilder.create().setSSLContext(context).build();
//        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory(httpClient);
//        RestTemplate restTemplate = new RestTemplate(factory);
//        return restTemplate;
//    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}