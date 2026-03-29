package com.example.demo.config;

import com.zaxxer.hikari.HikariDataSource;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.github.cdimascio.dotenv.Dotenv;

@Configuration
public class SupabaseDbConfig {

    @Bean
    public DataSource dataSource() {
        // Prefer system environment variables
        String dbUrl = System.getenv("DB_URL");
        String dbUser = System.getenv("DB_USERNAME");
        String dbPassword = System.getenv("DB_PASSWORD");

        // If not set, fallback to dotenv (pass.env)
        if (dbUrl == null || dbUser == null || dbPassword == null) {
            Dotenv dotenv = Dotenv.configure().filename("pass.env").ignoreIfMissing().load();
            if (dbUrl == null) dbUrl = dotenv.get("DB_URL");
            if (dbUser == null) dbUser = dotenv.get("DB_USERNAME");
            if (dbPassword == null) dbPassword = dotenv.get("DB_PASSWORD");
        }

        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl(dbUrl);
        dataSource.setUsername(dbUser);
        dataSource.setPassword(dbPassword);
        dataSource.setDriverClassName("org.postgresql.Driver");
        return dataSource;
    }
}
