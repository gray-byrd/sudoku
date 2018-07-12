package games.sudoku.configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages = {"games.sudoku.services.game.entities"})
@EnableJpaRepositories(basePackages = {"games.sudoku.services.game.repos"})
@EnableTransactionManagement
public class RepositoryConfiguration {
}
