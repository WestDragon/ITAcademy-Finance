package by.itacademy.user.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;

import javax.sql.DataSource;

@Configuration
public class UsersStorageConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @ConditionalOnProperty(value = "app.user.storage", havingValue = "MEMORY", matchIfMissing = true)
    public UserDetailsManager memoryUserManager(PasswordEncoder encoder) {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();

        manager.createUser(User.builder()
                .username("user")
                .password(encoder.encode("123"))
                .roles("USER")
                .build());


        manager.createUser(User.builder()
                .username("admin")
                .password(encoder.encode("321"))
                .roles("USER", "ADMIN")
                .build());

        return manager;
    }

    @Bean
    @ConditionalOnProperty(value = "app.user.storage", havingValue = "JDBC")
    public UserDetailsManager jdbcUserManager(DataSource dataSource) {
        return new JdbcUserDetailsManager(dataSource);
    }
}
