package games.sudoku.configuration;

import org.h2.server.web.WebServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfiguration {

    /*
     * H2-DB = http://localhost:8080/console
     * Driver Class = org.h2.Driver
     * JDBC URL	 = jdbc:h2:mem:testdb
     * User Name = sa
     * Password	 = <blank>
     */
    @Bean
    ServletRegistrationBean h2servletRegistration(){
        ServletRegistrationBean registrationBean = new ServletRegistrationBean( new WebServlet());
        registrationBean.addUrlMappings("/console/*");
        return registrationBean;
    }
}
